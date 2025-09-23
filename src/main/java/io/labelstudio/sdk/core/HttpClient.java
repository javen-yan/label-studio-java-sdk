package io.labelstudio.sdk.core;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        
        this.client = new OkHttpClient.Builder()
                .connectTimeout(timeout)
                .readTimeout(timeout)
                .writeTimeout(timeout)
                .build();
                
        this.objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
    }
    
    /**
     * Makes a GET request.
     * 
     * @param path the request path
     * @param responseType the expected response type
     * @param <T> the response type
     * @return the response object
     * @throws ApiError if the request fails
     */
    public <T> T get(String path, Class<T> responseType) throws ApiError {
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
     * Makes a POST request.
     * 
     * @param path the request path
     * @param requestBody the request body object
     * @param responseType the expected response type
     * @param <T> the response type
     * @return the response object
     * @throws ApiError if the request fails
     */
    public <T> T post(String path, Object requestBody, Class<T> responseType) throws ApiError {
        return execute(buildRequest("POST", path, requestBody), responseType);
    }
    
    /**
     * Makes a POST request asynchronously.
     * 
     * @param path the request path
     * @param requestBody the request body object
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
     * @param path the request path
     * @param requestBody the request body object
     * @param responseType the expected response type
     * @param <T> the response type
     * @return the response object
     * @throws ApiError if the request fails
     */
    public <T> T put(String path, Object requestBody, Class<T> responseType) throws ApiError {
        return execute(buildRequest("PUT", path, requestBody), responseType);
    }
    
    /**
     * Makes a DELETE request.
     * 
     * @param path the request path
     * @param responseType the expected response type
     * @param <T> the response type
     * @return the response object
     * @throws ApiError if the request fails
     */
    public <T> T delete(String path, Class<T> responseType) throws ApiError {
        return execute(buildRequest("DELETE", path, null), responseType);
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
    
    private Request buildRequest(String method, String path, Object requestBody) {
        String url = baseUrl + (path.startsWith("/") ? path : "/" + path);
        
        Request.Builder builder = new Request.Builder().url(url);
        
        // Add default headers
        defaultHeaders.forEach(builder::addHeader);
        
        // Build request body
        RequestBody body = null;
        if (requestBody != null) {
            try {
                String json = objectMapper.writeValueAsString(requestBody);
                body = RequestBody.create(json, JSON);
            } catch (Exception e) {
                throw new ApiError("Failed to serialize request body", e);
            }
        }
        
        // Set HTTP method
        switch (method.toUpperCase()) {
            case "GET":
                builder.get();
                break;
            case "POST":
                builder.post(body != null ? body : RequestBody.create("", JSON));
                break;
            case "PUT":
                builder.put(body != null ? body : RequestBody.create("", JSON));
                break;
            case "DELETE":
                builder.delete(body);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
        
        return builder.build();
    }
    
    private <T> T execute(Request request, Class<T> responseType) throws ApiError {
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
                } catch (Exception e) {
                    future.completeExceptionally(e);
                } finally {
                    response.close();
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
            
        } catch (IOException e) {
            logger.error("Failed to parse response", e);
            throw new ApiError("Failed to parse response: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets the ObjectMapper instance used for JSON serialization/deserialization.
     * 
     * @return the ObjectMapper instance
     */
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}