package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;

/**
 * Client for managing Label Studio organizations.
 */
public class OrganizationsClient {
    
    private final HttpClient httpClient;
    
    public OrganizationsClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    // Organization management methods would be implemented here
}