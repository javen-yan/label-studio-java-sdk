package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;

/**
 * Client for managing Label Studio import storage.
 */
public class ImportStorageClient {
    
    private final HttpClient httpClient;
    
    public ImportStorageClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    // Import storage management methods would be implemented here
}