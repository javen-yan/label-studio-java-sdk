package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;

/**
 * Client for managing Label Studio export storage.
 */
public class ExportStorageClient {
    
    private final HttpClient httpClient;
    
    public ExportStorageClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    // Export storage management methods would be implemented here
}