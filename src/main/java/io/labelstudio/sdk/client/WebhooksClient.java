package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.Webhook;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing Label Studio webhooks.
 * 
 * <p>This client provides methods to manage webhook configurations,
 * allowing you to receive real-time notifications when various events
 * occur in Label Studio projects.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * // Create a webhook for annotation events
 * Webhook webhook = client.webhooks().create(
 *     WebhookCreateRequest.builder()
 *         .url("https://my-app.com/webhook")
 *         .description("Annotation completion webhook")
 *         .projectId(projectId)
 *         .sendPayload()
 *         .active()
 *         .actions(Arrays.asList("ANNOTATION_CREATED", "ANNOTATION_UPDATED"))
 *         .build()
 * );
 * 
 * // Test the webhook
 * client.webhooks().test(webhook.getId());
 * </pre>
 */
public class WebhooksClient {
    
    private final HttpClient httpClient;
    
    /**
     * Constructs a new webhooks client.
     * 
     * @param httpClient the HTTP client to use
     */
    public WebhooksClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all webhooks.
     * 
     * @return a paginated list of webhooks
     */
    public Pagination<Webhook> list() {
        return list(null);
    }
    
    /**
     * Lists all webhooks with options.
     * 
     * @param requestOptions request options
     * @return a paginated list of webhooks
     */
    public Pagination<Webhook> list(RequestOptions requestOptions) {
        return httpClient.getPaginated("/api/webhooks/", Webhook.class);
    }
    
    /**
     * Lists all webhooks asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of webhooks
     */
    public CompletableFuture<Pagination<Webhook>> listAsync() {
        return listAsync(null);
    }
    
    /**
     * Lists all webhooks with options asynchronously.
     * 
     * @param requestOptions request options
     * @return a CompletableFuture containing a paginated list of webhooks
     */
    public CompletableFuture<Pagination<Webhook>> listAsync(RequestOptions requestOptions) {
        return httpClient.getPaginatedAsync("/api/webhooks/", Webhook.class);
    }
    
    /**
     * Creates a new webhook.
     * 
     * @param request the webhook creation request
     * @return the created webhook
     */
    public Webhook create(WebhookCreateRequest request) {
        return create(request, null);
    }
    
    /**
     * Creates a new webhook with options.
     * 
     * @param request the webhook creation request
     * @param requestOptions request options
     * @return the created webhook
     */
    public Webhook create(WebhookCreateRequest request, RequestOptions requestOptions) {
        return httpClient.post("/api/webhooks/", request, Webhook.class);
    }
    
    /**
     * Creates a new webhook asynchronously.
     * 
     * @param request the webhook creation request
     * @return a CompletableFuture containing the created webhook
     */
    public CompletableFuture<Webhook> createAsync(WebhookCreateRequest request) {
        return createAsync(request, null);
    }
    
    /**
     * Creates a new webhook with options asynchronously.
     * 
     * @param request the webhook creation request
     * @param requestOptions request options
     * @return a CompletableFuture containing the created webhook
     */
    public CompletableFuture<Webhook> createAsync(WebhookCreateRequest request, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/webhooks/", request, Webhook.class);
    }
    
    /**
     * Gets a webhook by ID.
     * 
     * @param webhookId the webhook ID
     * @return the webhook
     */
    public Webhook get(int webhookId) {
        return get(webhookId, null);
    }
    
    /**
     * Gets a webhook by ID with options.
     * 
     * @param webhookId the webhook ID
     * @param requestOptions request options
     * @return the webhook
     */
    public Webhook get(int webhookId, RequestOptions requestOptions) {
        return httpClient.get("/api/webhooks/" + webhookId + "/", Webhook.class);
    }
    
    /**
     * Gets a webhook by ID asynchronously.
     * 
     * @param webhookId the webhook ID
     * @return a CompletableFuture containing the webhook
     */
    public CompletableFuture<Webhook> getAsync(int webhookId) {
        return getAsync(webhookId, null);
    }
    
    /**
     * Gets a webhook by ID with options asynchronously.
     * 
     * @param webhookId the webhook ID
     * @param requestOptions request options
     * @return a CompletableFuture containing the webhook
     */
    public CompletableFuture<Webhook> getAsync(int webhookId, RequestOptions requestOptions) {
        return httpClient.getAsync("/api/webhooks/" + webhookId + "/", Webhook.class);
    }
    
    /**
     * Updates a webhook.
     * 
     * @param webhookId the webhook ID
     * @param request the webhook update request
     * @return the updated webhook
     */
    public Webhook update(int webhookId, WebhookUpdateRequest request) {
        return update(webhookId, request, null);
    }
    
    /**
     * Updates a webhook with options.
     * 
     * @param webhookId the webhook ID
     * @param request the webhook update request
     * @param requestOptions request options
     * @return the updated webhook
     */
    public Webhook update(int webhookId, WebhookUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.put("/api/webhooks/" + webhookId + "/", request, Webhook.class);
    }
    
    /**
     * Updates a webhook asynchronously.
     * 
     * @param webhookId the webhook ID
     * @param request the webhook update request
     * @return a CompletableFuture containing the updated webhook
     */
    public CompletableFuture<Webhook> updateAsync(int webhookId, WebhookUpdateRequest request) {
        return updateAsync(webhookId, request, null);
    }
    
    /**
     * Updates a webhook with options asynchronously.
     * 
     * @param webhookId the webhook ID
     * @param request the webhook update request
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated webhook
     */
    public CompletableFuture<Webhook> updateAsync(int webhookId, WebhookUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.putAsync("/api/webhooks/" + webhookId + "/", request, Webhook.class);
    }
    
    /**
     * Deletes a webhook.
     * 
     * @param webhookId the webhook ID to delete
     */
    public void delete(int webhookId) {
        delete(webhookId, null);
    }
    
    /**
     * Deletes a webhook with options.
     * 
     * @param webhookId the webhook ID to delete
     * @param requestOptions request options
     */
    public void delete(int webhookId, RequestOptions requestOptions) {
        httpClient.delete("/api/webhooks/" + webhookId + "/", Void.class);
    }
    
    /**
     * Deletes a webhook asynchronously.
     * 
     * @param webhookId the webhook ID to delete
     * @return a CompletableFuture that completes when the webhook is deleted
     */
    public CompletableFuture<Void> deleteAsync(int webhookId) {
        return deleteAsync(webhookId, null);
    }
    
    /**
     * Deletes a webhook with options asynchronously.
     * 
     * @param webhookId the webhook ID to delete
     * @param requestOptions request options
     * @return a CompletableFuture that completes when the webhook is deleted
     */
    public CompletableFuture<Void> deleteAsync(int webhookId, RequestOptions requestOptions) {
        return httpClient.deleteAsync("/api/webhooks/" + webhookId + "/", Void.class);
    }
    
    /**
     * Tests a webhook by sending a test event.
     * 
     * @param webhookId the webhook ID to test
     * @return the webhook with test results
     */
    public Webhook test(int webhookId) {
        return test(webhookId, null);
    }
    
    /**
     * Tests a webhook by sending a test event with options.
     * 
     * @param webhookId the webhook ID to test
     * @param requestOptions request options
     * @return the webhook with test results
     */
    public Webhook test(int webhookId, RequestOptions requestOptions) {
        return httpClient.post("/api/webhooks/" + webhookId + "/test/", null, Webhook.class);
    }
    
    /**
     * Tests a webhook by sending a test event asynchronously.
     * 
     * @param webhookId the webhook ID to test
     * @return a CompletableFuture containing the webhook with test results
     */
    public CompletableFuture<Webhook> testAsync(int webhookId) {
        return testAsync(webhookId, null);
    }
    
    /**
     * Tests a webhook by sending a test event with options asynchronously.
     * 
     * @param webhookId the webhook ID to test
     * @param requestOptions request options
     * @return a CompletableFuture containing the webhook with test results
     */
    public CompletableFuture<Webhook> testAsync(int webhookId, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/webhooks/" + webhookId + "/test/", null, Webhook.class);
    }
    
    /**
     * Validates a webhook configuration.
     * 
     * @param request the webhook configuration to validate
     * @return the validation result
     */
    public Webhook validate(WebhookCreateRequest request) {
        return validate(request, null);
    }
    
    /**
     * Validates a webhook configuration with options.
     * 
     * @param request the webhook configuration to validate
     * @param requestOptions request options
     * @return the validation result
     */
    public Webhook validate(WebhookCreateRequest request, RequestOptions requestOptions) {
        return httpClient.post("/api/webhooks/validate/", request, Webhook.class);
    }
    
    /**
     * Validates a webhook configuration asynchronously.
     * 
     * @param request the webhook configuration to validate
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<Webhook> validateAsync(WebhookCreateRequest request) {
        return validateAsync(request, null);
    }
    
    /**
     * Validates a webhook configuration with options asynchronously.
     * 
     * @param request the webhook configuration to validate
     * @param requestOptions request options
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<Webhook> validateAsync(WebhookCreateRequest request, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/webhooks/validate/", request, Webhook.class);
    }
}