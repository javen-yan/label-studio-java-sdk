package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.models.UserSimple;
import java.util.Map;
import java.util.HashMap;
import io.labelstudio.sdk.models.LoginResponse;

/**
 * Client for managing Label Studio users.
 */
public class UsersClient {
    
    private final HttpClient httpClient;
    
    public UsersClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Gets information about the current user.
     * 
     * @return the current user information
     */
    public UserSimple whoami() {
        return httpClient.get("/api/current-user/whoami", UserSimple.class);
    }
    
    /**
     * Gets a user by ID.
     * 
     * @param id the user ID
     * @return the user
     */
    public UserSimple get(int id) {
        return httpClient.get("/api/users/" + id + "/", UserSimple.class);
    }

    /**
     * Logs in a user.
     * 
     * @param email the email
     * @param password the password
     * @return the login response
     */
    public LoginResponse login(String email, String password) {
        Map<String, Object> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        return httpClient.post("/api/login", body, LoginResponse.class);
    }
    
    /**
     * Refreshes an access token using a refresh token.
     * 
     * @param refreshToken the refresh token
     * @return the token refresh response containing new access and refresh tokens
     */
    public io.labelstudio.sdk.models.TokenRefreshResponse refreshToken(String refreshToken) {
        Map<String, Object> body = new HashMap<>();
        body.put("refresh", refreshToken);
        
        return httpClient.post("/api/token/refresh/", body, io.labelstudio.sdk.models.TokenRefreshResponse.class);
    }
}