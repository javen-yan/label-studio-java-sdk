package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;

/**
 * Client for managing Label Studio webhooks.
 */
public class WebhooksClient {
    
    private final HttpClient httpClient;
    
    public WebhooksClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    // Webhook management methods would be implemented here
}