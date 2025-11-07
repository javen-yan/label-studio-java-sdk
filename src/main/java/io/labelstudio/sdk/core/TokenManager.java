package io.labelstudio.sdk.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.labelstudio.sdk.client.UsersClient;
import io.labelstudio.sdk.models.TokenRefreshResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Manages JWT tokens, handling refresh token and access token logic.
 */
public class TokenManager {
    
    private static final Logger logger = LoggerFactory.getLogger(TokenManager.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    private final String baseUrl;
    private final UsersClient usersClient;
    private final ReentrantLock refreshLock = new ReentrantLock();
    
    // Token state
    private String refreshToken;
    private String accessToken;
    private Date accessTokenExpiration;
    private boolean useLegacyToken;
    private volatile boolean isRefreshing = false;
    
    public TokenManager(String baseUrl, String apiKey, UsersClient usersClient) {
        this.baseUrl = baseUrl;
        this.usersClient = usersClient;
        this.refreshToken = apiKey;
        
        // Check if it's a JWT token (don't raise exception on expired during init)
        this.useLegacyToken = !isValidJwtToken(apiKey, false);
        
        if (!useLegacyToken) {
            // It's a JWT token, check if it's a refresh token
            String tokenType = getTokenType(apiKey);
            if ("refresh".equals(tokenType)) {
                // It's a refresh token, we need to get access token
                this.refreshToken = apiKey;
                this.accessToken = null;
                logger.debug("Detected refresh token, will fetch access token on first request");
            } else {
                // It's already an access token
                this.accessToken = apiKey;
                this.accessTokenExpiration = getTokenExpiration(apiKey);
                logger.debug("Using provided access token");
            }
        } else {
            logger.debug("Using legacy token (non-JWT)");
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Date getAccessTokenExpiration() {
        return accessTokenExpiration;
    }
    
    /**
     * Gets the current access token, refreshing if necessary.
     * 
     * @return the access token to use for API requests
     */
    public String getAccessToken() {
        // Legacy tokens: just return the API key directly
        if (useLegacyToken) {
            return refreshToken;
        }
        
        // JWT tokens: handle refresh if needed
        if (accessToken == null || isTokenExpired(accessToken)) {
            // Prevent infinite recursion: if already refreshing, return refresh token
            if (isRefreshing) {
                logger.debug("Already refreshing token, returning refresh token to avoid recursion");
                return refreshToken;
            }
            
            refreshLock.lock();
            try {
                // Check again after acquiring lock
                if (accessToken == null || isTokenExpired(accessToken)) {
                    isRefreshing = true;
                    try {
                        logger.debug("Access token expired or missing, refreshing...");
                        TokenRefreshResponse response = usersClient.refreshToken(refreshToken);
                        accessToken = response.getAccess();
                        accessTokenExpiration = getTokenExpiration(accessToken);
                        
                        // Update refresh token if provided
                        if (response.getRefresh() != null) {
                            refreshToken = response.getRefresh();
                        }
                        
                        logger.debug("Access token refreshed successfully");
                    } finally {
                        isRefreshing = false;
                    }
                }
            } finally {
                refreshLock.unlock();
            }
        }
        
        return accessToken;
    }
    
    /**
     * Gets the refresh token directly (for use in refresh requests).
     * 
     * @return the refresh token
     */
    public String getRefreshToken() {
        return refreshToken;
    }
    
    /**
     * Checks if a token is a valid JWT token.
     * 
     * @param token the token to check
     * @param raiseIfExpired if true, throw exception if token is expired
     * @return true if token is a valid JWT
     */
    private boolean isValidJwtToken(String token, boolean raiseIfExpired) {
        try {
            JsonNode payload = parseJwtPayload(token);
            
            // Check expiration
            if (payload.has("exp")) {
                long exp = payload.get("exp").asLong();
                Date expiration = new Date(exp * 1000);
                
                if (expiration.before(new Date())) {
                    if (raiseIfExpired) {
                        throw new ApiError("API key has expired. Please obtain a new refresh token.", 401, "{\"detail\":\"API key has expired. Please obtain a new refresh token.\"}");
                    }
                    return false;
                }
            } else {
                if (raiseIfExpired) {
                    throw new ApiError("API key does not have an expiration set, and is not valid. Please obtain a new refresh token.", 401, "{\"detail\":\"API key does not have an expiration set, and is not valid. Please obtain a new refresh token.\"}");
                }
                return false;
            }
            
            return true;
        } catch (Exception e) {
            // Not a JWT token
            return false;
        }
    }
    
    /**
     * Gets the token type from JWT payload.
     * 
     * @param token the JWT token
     * @return the token type ("refresh" or "access"), or null if not found
     */
    private String getTokenType(String token) {
        try {
            JsonNode payload = parseJwtPayload(token);
            if (payload.has("token_type")) {
                return payload.get("token_type").asText();
            }
        } catch (Exception e) {
            logger.debug("Failed to get token type: {}", e.getMessage());
        }
        return null;
    }
    
    /**
     * Gets the expiration date from JWT token.
     * 
     * @param token the JWT token
     * @return the expiration date, or null if not available
     */
    private Date getTokenExpiration(String token) {
        try {
            JsonNode payload = parseJwtPayload(token);
            if (payload.has("exp")) {
                long exp = payload.get("exp").asLong();
                return new Date(exp * 1000);
            }
        } catch (Exception e) {
            logger.debug("Failed to get token expiration: {}", e.getMessage());
        }
        return null;
    }
    
    /**
     * Checks if a token is expired.
     * 
     * @param token the token to check
     * @return true if token is expired
     */
    private boolean isTokenExpired(String token) {
        Date exp = getTokenExpiration(token);
        if (exp == null) {
            return true; // Consider expired if no expiration set
        }
        return exp.before(new Date());
    }
    
    /**
     * Parses JWT token payload without signature verification.
     * 
     * @param token the JWT token
     * @return the JSON payload
     * @throws RuntimeException if parsing fails
     */
    private JsonNode parseJwtPayload(String token) {
        // Split token into parts
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid JWT token format");
        }
        
        // Decode payload (second part)
        // Add padding if needed
        String payloadBase64 = parts[1];
        int padding = (4 - payloadBase64.length() % 4) % 4;
        for (int i = 0; i < padding; i++) {
            payloadBase64 += "=";
        }
        
        byte[] decoded = java.util.Base64.getDecoder().decode(payloadBase64);
        String payload = new String(decoded, StandardCharsets.UTF_8);
        
        try {
            return objectMapper.readTree(payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse JWT token payload", e);
        }
    }
}

