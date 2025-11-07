package io.labelstudio.sdk.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * HTTP client wrapper for making API requests.
 */
public class HttpClient {
    
    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;
    private final String baseUrl;
    private final Map<String, String> defaultHeaders;
    private TokenManager tokenManager;
    
    /**
     * Constructs a new HTTP client.
     * 
     * @param baseUrl the base URL for all requests
     * @param defaultHeaders default headers to include in all requests
     * @param timeout request timeout in seconds
     */
    public HttpClient(String baseUrl, Map<String, String> defaultHeaders, Duration timeout) {
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        this.defaultHeaders = defaultHeaders;
        
        // Create an interceptor to ensure headers are properly set
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder();
                
                // Check if this is a token refresh request - if so, use refresh token directly
                String url = originalRequest.url().toString();
                boolean isRefreshRequest = url.contains("/api/token/refresh/");
                
                // Get access token from token manager if available
                String accessToken = null;
                if (tokenManager != null && !isRefreshRequest) {
                    try {
                        accessToken = tokenManager.getAccessToken();
                    } catch (Exception e) {
                        logger.warn("Failed to get access token from token manager: {}", e.getMessage());
                    }
                } else if (tokenManager != null && isRefreshRequest) {
                    // For refresh requests, use refresh token directly to avoid recursion
                    accessToken = tokenManager.getRefreshToken();
                    logger.debug("Interceptor: Using refresh token for token refresh request");
                }
                
                // Set Authorization header
                if (accessToken != null) {
                    String authValue = "Bearer " + accessToken;
                    requestBuilder.removeHeader("Authorization");
                    requestBuilder.addHeader("Authorization", authValue);
                    String masked = authValue.length() > 30 ? authValue.substring(0, 30) + "..." : authValue;
                    logger.debug("Interceptor: Setting Authorization header from token manager: {} (length: {})", 
                        masked, authValue.length());
                } else if (defaultHeaders != null) {
                    // Fall back to default headers if no token manager
                    for (Map.Entry<String, String> entry : defaultHeaders.entrySet()) {
                        String headerName = entry.getKey();
                        String headerValue = entry.getValue();
                        // Remove existing header and add new one
                        requestBuilder.removeHeader(headerName);
                        requestBuilder.addHeader(headerName, headerValue);
                        
                        // Log Authorization header
                        if ("Authorization".equals(headerName)) {
                            String masked = headerValue != null && headerValue.length() > 30 
                                ? headerValue.substring(0, 30) + "..." 
                                : headerValue;
                            logger.debug("Interceptor: Setting Authorization header from default: {} (length: {})", 
                                masked, headerValue != null ? headerValue.length() : 0);
                        }
                    }
                }
                
                // Add other default headers (non-Authorization)
                if (defaultHeaders != null) {
                    for (Map.Entry<String, String> entry : defaultHeaders.entrySet()) {
                        if (!"Authorization".equals(entry.getKey())) {
                            requestBuilder.removeHeader(entry.getKey());
                            requestBuilder.addHeader(entry.getKey(), entry.getValue());
                        }
                    }
                }
                
                Request newRequest = requestBuilder.build();
                // Log final request headers
                Headers headers = newRequest.headers();
                String authHeader = headers.get("Authorization");
                if (authHeader != null) {
                    logger.debug("Interceptor: Final Authorization header present (length: {})", authHeader.length());
                }
                
                return chain.proceed(newRequest);
            }
        };
        
        this.client = new OkHttpClient.Builder()
                .connectTimeout(timeout)
                .readTimeout(timeout)
                .writeTimeout(timeout)
                .addInterceptor(headerInterceptor)
                .build();
                
        this.objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
    }
    
    /**
     * Sets the token manager for dynamic token management.
     * 
     * @param tokenManager the token manager
     */
    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }
    
    /**
     * Makes a GET request.
     * 
     * @param path the API path
     * @param responseType the response type
     * @return the response
     * @throws ApiError if the request fails
     */
    public <T> T get(String path, Class<T> responseType) throws ApiError {
        return execute(buildRequest("GET", path, null), responseType);
    }
    
    /**
     * Makes a GET request with JavaType.
     * 
     * @param path the API path
     * @param responseType the response type
     * @return the response
     * @throws ApiError if the request fails
     */
    public <T> T get(String path, JavaType responseType) throws ApiError {
        return execute(buildRequest("GET", path, null), responseType);
    }
    
    /**
     * Makes a GET request asynchronously.
     * 
     * @param path the request path
     * @param responseType the expected response type
     * @param <T> the response type
     * @return a CompletableFuture containing the response object
     */
    public <T> CompletableFuture<T> getAsync(String path, Class<T> responseType) {
        return executeAsync(buildRequest("GET", path, null), responseType);
    }
    
    /**
     * Makes a GET request asynchronously with JavaType.
     * 
     * @param path the request path
     * @param responseType the expected response type
     * @param <T> the response type
     * @return a CompletableFuture containing the response object
     */
    public <T> CompletableFuture<T> getAsync(String path, JavaType responseType) {
        return executeAsync(buildRequest("GET", path, null), responseType);
    }
    
    /**
     * Makes a POST request.
     * 
     * @param path the API path
     * @param requestBody the request body
     * @param responseType the response type
     * @return the response
     * @throws ApiError if the request fails
     */
    public <T> T post(String path, Object requestBody, Class<T> responseType) throws ApiError {
        return execute(buildRequest("POST", path, requestBody), responseType);
    }
    
    /**
     * Makes a POST request asynchronously.
     * 
     * @param path the request path
     * @param requestBody the request body
     * @param responseType the expected response type
     * @param <T> the response type
     * @return a CompletableFuture containing the response object
     */
    public <T> CompletableFuture<T> postAsync(String path, Object requestBody, Class<T> responseType) {
        return executeAsync(buildRequest("POST", path, requestBody), responseType);
    }
    
    /**
     * Makes a PUT request.
     * 
     * @param path the API path
     * @param requestBody the request body
     * @param responseType the response type
     * @return the response
     * @throws ApiError if the request fails
     */
    public <T> T put(String path, Object requestBody, Class<T> responseType) throws ApiError {
        return execute(buildRequest("PUT", path, requestBody), responseType);
    }
    
    /**
     * Makes a PUT request asynchronously.
     * 
     * @param path the request path
     * @param requestBody the request body
     * @param responseType the expected response type
     * @param <T> the response type
     * @return a CompletableFuture containing the response object
     */
    public <T> CompletableFuture<T> putAsync(String path, Object requestBody, Class<T> responseType) {
        return executeAsync(buildRequest("PUT", path, requestBody), responseType);
    }
    
    /**
     * Makes a PATCH request.
     * 
     * @param path the API path
     * @param requestBody the request body
     * @param responseType the response type
     * @return the response
     * @throws ApiError if the request fails
     */
    public <T> T patch(String path, Object requestBody, Class<T> responseType) throws ApiError {
        return execute(buildRequest("PATCH", path, requestBody), responseType);
    }
    
    /**
     * Makes a PATCH request asynchronously.
     * 
     * @param path the request path
     * @param requestBody the request body
     * @param responseType the expected response type
     * @param <T> the response type
     * @return a CompletableFuture containing the response object
     */
    public <T> CompletableFuture<T> patchAsync(String path, Object requestBody, Class<T> responseType) {
        return executeAsync(buildRequest("PATCH", path, requestBody), responseType);
    }
    
    /**
     * Makes a DELETE request.
     * 
     * @param path the API path
     * @param responseType the response type
     * @return the response
     * @throws ApiError if the request fails
     */
    public <T> T delete(String path, Class<T> responseType) throws ApiError {
        return execute(buildRequest("DELETE", path, null), responseType);
    }
    
    /**
     * Makes a DELETE request without response body.
     * 
     * @param path the API path
     * @throws ApiError if the request fails
     */
    public void delete(String path) throws ApiError {
        execute(buildRequest("DELETE", path, null), Void.class);
    }
    
    /**
     * Makes a DELETE request asynchronously.
     * 
     * @param path the request path
     * @param responseType the expected response type
     * @param <T> the response type
     * @return a CompletableFuture containing the response object
     */
    public <T> CompletableFuture<T> deleteAsync(String path, Class<T> responseType) {
        return executeAsync(buildRequest("DELETE", path, null), responseType);
    }
    
    /**
     * Makes a DELETE request asynchronously without response body.
     * 
     * @param path the request path
     * @return a CompletableFuture
     */
    public CompletableFuture<Void> deleteAsync(String path) {
        return executeAsync(buildRequest("DELETE", path, null), Void.class);
    }
    
    /**
     * Makes a GET request for paginated results.
     * 
     * @param path the API path
     * @param responseType the response type
     * @return the paginated response
     * @throws ApiError if the request fails
     */
    @SuppressWarnings("unchecked")
    public <T> Pagination<T> getPaginated(String path, Class<T> responseType) throws ApiError {
        return (Pagination<T>) get(path, Pagination.class);
    }
    
    /**
     * Makes an async GET request for paginated results.
     * 
     * @param path the API path
     * @param responseType the response type
     * @return a CompletableFuture with the paginated response
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> CompletableFuture<Pagination<T>> getPaginatedAsync(String path, Class<T> responseType) {
        CompletableFuture future = getAsync(path, Pagination.class);
        return (CompletableFuture<Pagination<T>>) future;
    }
    
    /**
     * Uploads a file.
     * 
     * @param path the API path
     * @param file the file to upload
     * @param options upload options
     * @param responseType the response type
     * @return the response
     * @throws ApiError if the request fails
     */
    public <T> T uploadFile(String path, java.io.File file, Object options, Class<T> responseType) throws ApiError {
        // This is a placeholder implementation
        // In a real implementation, you would handle multipart file upload
        throw new UnsupportedOperationException("File upload not implemented yet");
    }
    
    /**
     * Uploads a file asynchronously.
     * 
     * @param path the API path
     * @param file the file to upload
     * @param options upload options
     * @param responseType the response type
     * @return a CompletableFuture with the response
     */
    public <T> CompletableFuture<T> uploadFileAsync(String path, java.io.File file, Object options, Class<T> responseType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return uploadFile(path, file, options, responseType);
            } catch (ApiError e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    /**
     * Uploads a file from InputStream.
     * 
     * @param path the API path
     * @param inputStream the input stream
     * @param filename the filename
     * @param options upload options
     * @param responseType the response type
     * @return the response
     * @throws ApiError if the request fails
     */
    public <T> T uploadFile(String path, java.io.InputStream inputStream, String filename, Object options, Class<T> responseType) throws ApiError {
        // This is a placeholder implementation
        throw new UnsupportedOperationException("File upload from InputStream not implemented yet");
    }
    
    /**
     * Uploads a file from InputStream asynchronously.
     * 
     * @param path the API path
     * @param inputStream the input stream
     * @param filename the filename
     * @param options upload options
     * @param responseType the response type
     * @return a CompletableFuture with the response
     */
    public <T> CompletableFuture<T> uploadFileAsync(String path, java.io.InputStream inputStream, String filename, Object options, Class<T> responseType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return uploadFile(path, inputStream, filename, options, responseType);
            } catch (ApiError e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    /**
     * Downloads a file.
     * 
     * @param path the API path
     * @return the file content as byte array
     * @throws ApiError if the request fails
     */
    public byte[] downloadFile(String path) throws ApiError {
        // This is a placeholder implementation
        throw new UnsupportedOperationException("File download not implemented yet");
    }
    
    /**
     * Downloads a file asynchronously.
     * 
     * @param path the API path
     * @return a CompletableFuture with the file content
     */
    public CompletableFuture<byte[]> downloadFileAsync(String path) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return downloadFile(path);
            } catch (ApiError e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    /**
     * Gets the ObjectMapper instance used for JSON serialization/deserialization.
     * 
     * @return the ObjectMapper instance
     */
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
    
    // Private helper methods
    
    private Request buildRequest(String method, String path, Object requestBody) throws ApiError {
        String url = baseUrl + path;
        Request.Builder builder = new Request.Builder().url(url);
        
        // Add default headers
        if (defaultHeaders != null) {
            for (Map.Entry<String, String> entry : defaultHeaders.entrySet()) {
                String headerName = entry.getKey();
                String headerValue = entry.getValue();
                
                // For Authorization header, ensure it's set correctly
                if ("Authorization".equals(headerName)) {
                    // Remove any existing Authorization header first
                    builder.removeHeader("Authorization");
                    // Add the Authorization header
                    builder.addHeader(headerName, headerValue);
                    String maskedValue = headerValue != null && headerValue.length() > 20 
                        ? headerValue.substring(0, 20) + "..." 
                        : headerValue;
                    logger.debug("Setting Authorization header: {} (length: {})", maskedValue, 
                        headerValue != null ? headerValue.length() : 0);
                } else {
                    // Use header() for other headers to replace any existing ones
                    builder.header(headerName, headerValue);
                }
            }
        }
        
        // Set request body for POST, PUT, PATCH
        if (requestBody != null && ("POST".equals(method) || "PUT".equals(method) || "PATCH".equals(method))) {
            try {
                String json = objectMapper.writeValueAsString(requestBody);
                builder.method(method, RequestBody.create(json, JSON));
            } catch (Exception e) {
                throw new ApiError("Failed to serialize request body", e);
            }
        } else {
            builder.method(method, null);
        }
        
        Request request = builder.build();
        // Log request details for debugging - show actual Authorization header value
        Headers requestHeaders = request.headers();
        String authHeader = requestHeaders.get("Authorization");
        if (authHeader != null) {
            String maskedAuth = authHeader.length() > 30 ? authHeader.substring(0, 30) + "..." : authHeader;
            logger.debug("HTTP {} {} - Authorization: {} (full length: {})", method, url, maskedAuth, authHeader.length());
            // Log all headers for debugging
            logger.debug("All request headers:");
            for (int i = 0; i < requestHeaders.size(); i++) {
                String headerName = requestHeaders.name(i);
                String headerValue = requestHeaders.value(i);
                if ("Authorization".equals(headerName)) {
                    String masked = headerValue.length() > 30 ? headerValue.substring(0, 30) + "..." : headerValue;
                    logger.debug("  {}: {} (length: {})", headerName, masked, headerValue.length());
                } else {
                    logger.debug("  {}: {}", headerName, headerValue);
                }
            }
        }
        
        return request;
    }
    
    private <T> T execute(Request request, Class<T> responseType) throws ApiError {
        try (Response response = client.newCall(request).execute()) {
            return handleResponse(response, responseType);
        } catch (IOException e) {
            logger.error("HTTP request failed", e);
            throw new ApiError("HTTP request failed: " + e.getMessage(), e);
        }
    }
    
    private <T> T execute(Request request, JavaType responseType) throws ApiError {
        try (Response response = client.newCall(request).execute()) {
            return handleResponse(response, responseType);
        } catch (IOException e) {
            logger.error("HTTP request failed", e);
            throw new ApiError("HTTP request failed: " + e.getMessage(), e);
        }
    }
    
    private <T> CompletableFuture<T> executeAsync(Request request, Class<T> responseType) {
        CompletableFuture<T> future = new CompletableFuture<>();
        
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                logger.error("Async HTTP request failed", e);
                future.completeExceptionally(new ApiError("HTTP request failed: " + e.getMessage(), e));
            }
            
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    T result = handleResponse(response, responseType);
                    future.complete(result);
                } catch (ApiError e) {
                    future.completeExceptionally(e);
                }
            }
        });
        
        return future;
    }
    
    private <T> CompletableFuture<T> executeAsync(Request request, JavaType responseType) {
        CompletableFuture<T> future = new CompletableFuture<>();
        
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                logger.error("Async HTTP request failed", e);
                future.completeExceptionally(new ApiError("HTTP request failed: " + e.getMessage(), e));
            }
            
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    T result = handleResponse(response, responseType);
                    future.complete(result);
                } catch (ApiError e) {
                    future.completeExceptionally(e);
                }
            }
        });
        
        return future;
    }
    
    private <T> T handleResponse(Response response, Class<T> responseType) throws ApiError {
        try {
            String responseBody = response.body() != null ? response.body().string() : "";
            
            if (!response.isSuccessful()) {
                String errorMessage = String.format("API request failed with status %d: %s", 
                        response.code(), responseBody);
                throw new ApiError(errorMessage, response.code(), responseBody);
            }
            
            if (responseType == Void.class || responseType == void.class) {
                return null;
            }
            
            if (responseType == String.class) {
                return responseType.cast(responseBody);
            }
            
            return objectMapper.readValue(responseBody, responseType);
            
        } catch (com.fasterxml.jackson.databind.exc.MismatchedInputException e) {
            // This is expected in some cases (e.g., when API returns array instead of pagination)
            // The calling code will handle it, so we log at debug level
            logger.debug("Failed to parse response as expected type (may be handled by caller): {}", e.getMessage());
            throw new ApiError("Failed to parse response: " + e.getMessage(), e);
        } catch (IOException e) {
            logger.error("Failed to parse response", e);
            throw new ApiError("Failed to parse response: " + e.getMessage(), e);
        }
    }
    
    private <T> T handleResponse(Response response, JavaType responseType) throws ApiError {
        try {
            String responseBody = response.body() != null ? response.body().string() : "";
            
            if (!response.isSuccessful()) {
                String errorMessage = String.format("API request failed with status %d: %s", 
                        response.code(), responseBody);
                throw new ApiError(errorMessage, response.code(), responseBody);
            }
            
            return objectMapper.readValue(responseBody, responseType);
            
        } catch (com.fasterxml.jackson.databind.exc.MismatchedInputException e) {
            // This is expected in some cases (e.g., when API returns array instead of pagination)
            // The calling code will handle it, so we log at debug level
            logger.debug("Failed to parse response as expected type (may be handled by caller): {}", e.getMessage());
            throw new ApiError("Failed to parse response: " + e.getMessage(), e);
        } catch (IOException e) {
            logger.error("Failed to parse response", e);
            throw new ApiError("Failed to parse response: " + e.getMessage(), e);
        }
    }
}