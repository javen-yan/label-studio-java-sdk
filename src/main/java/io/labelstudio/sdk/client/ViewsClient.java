package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;

/**
 * Client for managing Label Studio views.
 */
public class ViewsClient {
    
    private final HttpClient httpClient;
    
    public ViewsClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    // View management methods would be implemented here
}