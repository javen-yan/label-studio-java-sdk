package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;

/**
 * Client for managing Label Studio ML backends.
 */
public class MlClient {
    
    private final HttpClient httpClient;
    
    public MlClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    // ML backend management methods would be implemented here
}