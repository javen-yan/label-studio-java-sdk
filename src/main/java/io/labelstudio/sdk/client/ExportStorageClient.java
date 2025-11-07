package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.ExportStorage;
import io.labelstudio.sdk.vo.ExportStorageCreateRequest;
import io.labelstudio.sdk.vo.ExportStorageUpdateRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing Label Studio export storage configurations.
 * 
 * <p>This client provides methods to manage export storage configurations,
 * allowing you to automatically export completed annotations to various
 * cloud storage services and local file systems.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * // Create an S3 export storage
 * ExportStorage storage = client.exportStorage().create(
 *     ExportStorageCreateRequest.builder()
 *         .s3()
 *         .title("My S3 Export Storage")
 *         .bucket("my-export-bucket")
 *         .prefix("exports/")
 *         .awsAccessKeyId("your-access-key")
 *         .awsSecretAccessKey("your-secret-key")
 *         .projectId(projectId)
 *         .build()
 * );
 * 
 * // Sync storage to export annotations
 * client.exportStorage().sync(storage.getId());
 * </pre>
 */
public class ExportStorageClient {
    
    private final HttpClient httpClient;
    
    /**
     * Constructs a new export storage client.
     * 
     * @param httpClient the HTTP client to use
     */
    public ExportStorageClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all export storage configurations.
     * 
     * @return a paginated list of export storage configurations
     */
    public Pagination<ExportStorage> list() {
        return list(null);
    }
    
    /**
     * Lists all export storage configurations with options.
     * 
     * @param requestOptions request options
     * @return a paginated list of export storage configurations
     */
    public Pagination<ExportStorage> list(RequestOptions requestOptions) {
        return httpClient.getPaginated("/api/storages/export/", ExportStorage.class);
    }
    
    /**
     * Lists all export storage configurations asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of export storage configurations
     */
    public CompletableFuture<Pagination<ExportStorage>> listAsync() {
        return listAsync(null);
    }
    
    /**
     * Lists all export storage configurations with options asynchronously.
     * 
     * @param requestOptions request options
     * @return a CompletableFuture containing a paginated list of export storage configurations
     */
    public CompletableFuture<Pagination<ExportStorage>> listAsync(RequestOptions requestOptions) {
        return httpClient.getPaginatedAsync("/api/storages/export/", ExportStorage.class);
    }
    
    /**
     * Creates a new export storage configuration.
     * 
     * @param request the export storage creation request
     * @return the created export storage configuration
     */
    public ExportStorage create(ExportStorageCreateRequest request) {
        return create(request, null);
    }
    
    /**
     * Creates a new export storage configuration with options.
     * 
     * @param request the export storage creation request
     * @param requestOptions request options
     * @return the created export storage configuration
     */
    public ExportStorage create(ExportStorageCreateRequest request, RequestOptions requestOptions) {
        return httpClient.post("/api/storages/export/", request, ExportStorage.class);
    }
    
    /**
     * Creates a new export storage configuration asynchronously.
     * 
     * @param request the export storage creation request
     * @return a CompletableFuture containing the created export storage configuration
     */
    public CompletableFuture<ExportStorage> createAsync(ExportStorageCreateRequest request) {
        return createAsync(request, null);
    }
    
    /**
     * Creates a new export storage configuration with options asynchronously.
     * 
     * @param request the export storage creation request
     * @param requestOptions request options
     * @return a CompletableFuture containing the created export storage configuration
     */
    public CompletableFuture<ExportStorage> createAsync(ExportStorageCreateRequest request, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/storages/export/", request, ExportStorage.class);
    }
    
    /**
     * Gets an export storage configuration by ID.
     * 
     * @param storageId the storage ID
     * @return the export storage configuration
     */
    public ExportStorage get(int storageId) {
        return get(storageId, null);
    }
    
    /**
     * Gets an export storage configuration by ID with options.
     * 
     * @param storageId the storage ID
     * @param requestOptions request options
     * @return the export storage configuration
     */
    public ExportStorage get(int storageId, RequestOptions requestOptions) {
        return httpClient.get("/api/storages/export/" + storageId + "/", ExportStorage.class);
    }
    
    /**
     * Gets an export storage configuration by ID asynchronously.
     * 
     * @param storageId the storage ID
     * @return a CompletableFuture containing the export storage configuration
     */
    public CompletableFuture<ExportStorage> getAsync(int storageId) {
        return getAsync(storageId, null);
    }
    
    /**
     * Gets an export storage configuration by ID with options asynchronously.
     * 
     * @param storageId the storage ID
     * @param requestOptions request options
     * @return a CompletableFuture containing the export storage configuration
     */
    public CompletableFuture<ExportStorage> getAsync(int storageId, RequestOptions requestOptions) {
        return httpClient.getAsync("/api/storages/export/" + storageId + "/", ExportStorage.class);
    }
    
    /**
     * Updates an export storage configuration.
     * 
     * @param storageId the storage ID
     * @param request the export storage update request
     * @return the updated export storage configuration
     */
    public ExportStorage update(int storageId, ExportStorageUpdateRequest request) {
        return update(storageId, request, null);
    }
    
    /**
     * Updates an export storage configuration with options.
     * 
     * @param storageId the storage ID
     * @param request the export storage update request
     * @param requestOptions request options
     * @return the updated export storage configuration
     */
    public ExportStorage update(int storageId, ExportStorageUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.put("/api/storages/export/" + storageId + "/", request, ExportStorage.class);
    }
    
    /**
     * Updates an export storage configuration asynchronously.
     * 
     * @param storageId the storage ID
     * @param request the export storage update request
     * @return a CompletableFuture containing the updated export storage configuration
     */
    public CompletableFuture<ExportStorage> updateAsync(int storageId, ExportStorageUpdateRequest request) {
        return updateAsync(storageId, request, null);
    }
    
    /**
     * Updates an export storage configuration with options asynchronously.
     * 
     * @param storageId the storage ID
     * @param request the export storage update request
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated export storage configuration
     */
    public CompletableFuture<ExportStorage> updateAsync(int storageId, ExportStorageUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.putAsync("/api/storages/export/" + storageId + "/", request, ExportStorage.class);
    }
    
    /**
     * Deletes an export storage configuration.
     * 
     * @param storageId the storage ID to delete
     */
    public void delete(int storageId) {
        delete(storageId, null);
    }
    
    /**
     * Deletes an export storage configuration with options.
     * 
     * @param storageId the storage ID to delete
     * @param requestOptions request options
     */
    public void delete(int storageId, RequestOptions requestOptions) {
        httpClient.delete("/api/storages/export/" + storageId + "/", Void.class);
    }
    
    /**
     * Deletes an export storage configuration asynchronously.
     * 
     * @param storageId the storage ID to delete
     * @return a CompletableFuture that completes when the storage is deleted
     */
    public CompletableFuture<Void> deleteAsync(int storageId) {
        return deleteAsync(storageId, null);
    }
    
    /**
     * Deletes an export storage configuration with options asynchronously.
     * 
     * @param storageId the storage ID to delete
     * @param requestOptions request options
     * @return a CompletableFuture that completes when the storage is deleted
     */
    public CompletableFuture<Void> deleteAsync(int storageId, RequestOptions requestOptions) {
        return httpClient.deleteAsync("/api/storages/export/" + storageId + "/", Void.class);
    }
    
    /**
     * Synchronizes an export storage to export annotations.
     * 
     * @param storageId the storage ID to synchronize
     * @return the updated export storage configuration
     */
    public ExportStorage sync(int storageId) {
        return sync(storageId, null);
    }
    
    /**
     * Synchronizes an export storage to export annotations with options.
     * 
     * @param storageId the storage ID to synchronize
     * @param requestOptions request options
     * @return the updated export storage configuration
     */
    public ExportStorage sync(int storageId, RequestOptions requestOptions) {
        return httpClient.post("/api/storages/export/" + storageId + "/sync/", null, ExportStorage.class);
    }
    
    /**
     * Synchronizes an export storage to export annotations asynchronously.
     * 
     * @param storageId the storage ID to synchronize
     * @return a CompletableFuture containing the updated export storage configuration
     */
    public CompletableFuture<ExportStorage> syncAsync(int storageId) {
        return syncAsync(storageId, null);
    }
    
    /**
     * Synchronizes an export storage to export annotations with options asynchronously.
     * 
     * @param storageId the storage ID to synchronize
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated export storage configuration
     */
    public CompletableFuture<ExportStorage> syncAsync(int storageId, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/storages/export/" + storageId + "/sync/", null, ExportStorage.class);
    }
    
    /**
     * Validates an export storage configuration.
     * 
     * @param request the export storage configuration to validate
     * @return the validation result
     */
    public ExportStorage validate(ExportStorageCreateRequest request) {
        return validate(request, null);
    }
    
    /**
     * Validates an export storage configuration with options.
     * 
     * @param request the export storage configuration to validate
     * @param requestOptions request options
     * @return the validation result
     */
    public ExportStorage validate(ExportStorageCreateRequest request, RequestOptions requestOptions) {
        return httpClient.post("/api/storages/export/validate/", request, ExportStorage.class);
    }
    
    /**
     * Validates an export storage configuration asynchronously.
     * 
     * @param request the export storage configuration to validate
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<ExportStorage> validateAsync(ExportStorageCreateRequest request) {
        return validateAsync(request, null);
    }
    
    /**
     * Validates an export storage configuration with options asynchronously.
     * 
     * @param request the export storage configuration to validate
     * @param requestOptions request options
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<ExportStorage> validateAsync(ExportStorageCreateRequest request, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/storages/export/validate/", request, ExportStorage.class);
    }
}