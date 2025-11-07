package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.ImportStorage;
import io.labelstudio.sdk.vo.ImportStorageCreateRequest;
import io.labelstudio.sdk.vo.ImportStorageUpdateRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing Label Studio import storage configurations.
 * 
 * <p>This client provides methods to manage import storage configurations,
 * allowing you to connect various cloud storage services and local file systems
 * to automatically import data into Label Studio projects.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * // Create an S3 import storage
 * ImportStorage storage = client.importStorage().create(
 *     ImportStorageCreateRequest.builder()
 *         .s3()
 *         .title("My S3 Storage")
 *         .bucket("my-bucket")
 *         .prefix("data/")
 *         .awsAccessKeyId("your-access-key")
 *         .awsSecretAccessKey("your-secret-key")
 *         .projectId(projectId)
 *         .build()
 * );
 * 
 * // Sync storage to import new files
 * client.importStorage().sync(storage.getId());
 * </pre>
 */
public class ImportStorageClient {
    
    private final HttpClient httpClient;
    
    /**
     * Constructs a new import storage client.
     * 
     * @param httpClient the HTTP client to use
     */
    public ImportStorageClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all import storage configurations.
     * 
     * @return a paginated list of import storage configurations
     */
    public Pagination<ImportStorage> list() {
        return list(null);
    }
    
    /**
     * Lists all import storage configurations with options.
     * 
     * @param requestOptions request options
     * @return a paginated list of import storage configurations
     */
    public Pagination<ImportStorage> list(RequestOptions requestOptions) {
        return httpClient.getPaginated("/api/storages/import/", ImportStorage.class);
    }
    
    /**
     * Lists all import storage configurations asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of import storage configurations
     */
    public CompletableFuture<Pagination<ImportStorage>> listAsync() {
        return listAsync(null);
    }
    
    /**
     * Lists all import storage configurations with options asynchronously.
     * 
     * @param requestOptions request options
     * @return a CompletableFuture containing a paginated list of import storage configurations
     */
    public CompletableFuture<Pagination<ImportStorage>> listAsync(RequestOptions requestOptions) {
        return httpClient.getPaginatedAsync("/api/storages/import/", ImportStorage.class);
    }
    
    /**
     * Creates a new import storage configuration.
     * 
     * @param request the import storage creation request
     * @return the created import storage configuration
     */
    public ImportStorage create(ImportStorageCreateRequest request) {
        return create(request, null);
    }
    
    /**
     * Creates a new import storage configuration with options.
     * 
     * @param request the import storage creation request
     * @param requestOptions request options
     * @return the created import storage configuration
     */
    public ImportStorage create(ImportStorageCreateRequest request, RequestOptions requestOptions) {
        return httpClient.post("/api/storages/import/", request, ImportStorage.class);
    }
    
    /**
     * Creates a new import storage configuration asynchronously.
     * 
     * @param request the import storage creation request
     * @return a CompletableFuture containing the created import storage configuration
     */
    public CompletableFuture<ImportStorage> createAsync(ImportStorageCreateRequest request) {
        return createAsync(request, null);
    }
    
    /**
     * Creates a new import storage configuration with options asynchronously.
     * 
     * @param request the import storage creation request
     * @param requestOptions request options
     * @return a CompletableFuture containing the created import storage configuration
     */
    public CompletableFuture<ImportStorage> createAsync(ImportStorageCreateRequest request, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/storages/import/", request, ImportStorage.class);
    }
    
    /**
     * Gets an import storage configuration by ID.
     * 
     * @param storageId the storage ID
     * @return the import storage configuration
     */
    public ImportStorage get(int storageId) {
        return get(storageId, null);
    }
    
    /**
     * Gets an import storage configuration by ID with options.
     * 
     * @param storageId the storage ID
     * @param requestOptions request options
     * @return the import storage configuration
     */
    public ImportStorage get(int storageId, RequestOptions requestOptions) {
        return httpClient.get("/api/storages/import/" + storageId + "/", ImportStorage.class);
    }
    
    /**
     * Gets an import storage configuration by ID asynchronously.
     * 
     * @param storageId the storage ID
     * @return a CompletableFuture containing the import storage configuration
     */
    public CompletableFuture<ImportStorage> getAsync(int storageId) {
        return getAsync(storageId, null);
    }
    
    /**
     * Gets an import storage configuration by ID with options asynchronously.
     * 
     * @param storageId the storage ID
     * @param requestOptions request options
     * @return a CompletableFuture containing the import storage configuration
     */
    public CompletableFuture<ImportStorage> getAsync(int storageId, RequestOptions requestOptions) {
        return httpClient.getAsync("/api/storages/import/" + storageId + "/", ImportStorage.class);
    }
    
    /**
     * Updates an import storage configuration.
     * 
     * @param storageId the storage ID
     * @param request the import storage update request
     * @return the updated import storage configuration
     */
    public ImportStorage update(int storageId, ImportStorageUpdateRequest request) {
        return update(storageId, request, null);
    }
    
    /**
     * Updates an import storage configuration with options.
     * 
     * @param storageId the storage ID
     * @param request the import storage update request
     * @param requestOptions request options
     * @return the updated import storage configuration
     */
    public ImportStorage update(int storageId, ImportStorageUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.put("/api/storages/import/" + storageId + "/", request, ImportStorage.class);
    }
    
    /**
     * Updates an import storage configuration asynchronously.
     * 
     * @param storageId the storage ID
     * @param request the import storage update request
     * @return a CompletableFuture containing the updated import storage configuration
     */
    public CompletableFuture<ImportStorage> updateAsync(int storageId, ImportStorageUpdateRequest request) {
        return updateAsync(storageId, request, null);
    }
    
    /**
     * Updates an import storage configuration with options asynchronously.
     * 
     * @param storageId the storage ID
     * @param request the import storage update request
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated import storage configuration
     */
    public CompletableFuture<ImportStorage> updateAsync(int storageId, ImportStorageUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.putAsync("/api/storages/import/" + storageId + "/", request, ImportStorage.class);
    }
    
    /**
     * Deletes an import storage configuration.
     * 
     * @param storageId the storage ID to delete
     */
    public void delete(int storageId) {
        delete(storageId, null);
    }
    
    /**
     * Deletes an import storage configuration with options.
     * 
     * @param storageId the storage ID to delete
     * @param requestOptions request options
     */
    public void delete(int storageId, RequestOptions requestOptions) {
        httpClient.delete("/api/storages/import/" + storageId + "/", Void.class);
    }
    
    /**
     * Deletes an import storage configuration asynchronously.
     * 
     * @param storageId the storage ID to delete
     * @return a CompletableFuture that completes when the storage is deleted
     */
    public CompletableFuture<Void> deleteAsync(int storageId) {
        return deleteAsync(storageId, null);
    }
    
    /**
     * Deletes an import storage configuration with options asynchronously.
     * 
     * @param storageId the storage ID to delete
     * @param requestOptions request options
     * @return a CompletableFuture that completes when the storage is deleted
     */
    public CompletableFuture<Void> deleteAsync(int storageId, RequestOptions requestOptions) {
        return httpClient.deleteAsync("/api/storages/import/" + storageId + "/", Void.class);
    }
    
    /**
     * Synchronizes an import storage to import new files.
     * 
     * @param storageId the storage ID to synchronize
     * @return the updated import storage configuration
     */
    public ImportStorage sync(int storageId) {
        return sync(storageId, null);
    }
    
    /**
     * Synchronizes an import storage to import new files with options.
     * 
     * @param storageId the storage ID to synchronize
     * @param requestOptions request options
     * @return the updated import storage configuration
     */
    public ImportStorage sync(int storageId, RequestOptions requestOptions) {
        return httpClient.post("/api/storages/import/" + storageId + "/sync/", null, ImportStorage.class);
    }
    
    /**
     * Synchronizes an import storage to import new files asynchronously.
     * 
     * @param storageId the storage ID to synchronize
     * @return a CompletableFuture containing the updated import storage configuration
     */
    public CompletableFuture<ImportStorage> syncAsync(int storageId) {
        return syncAsync(storageId, null);
    }
    
    /**
     * Synchronizes an import storage to import new files with options asynchronously.
     * 
     * @param storageId the storage ID to synchronize
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated import storage configuration
     */
    public CompletableFuture<ImportStorage> syncAsync(int storageId, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/storages/import/" + storageId + "/sync/", null, ImportStorage.class);
    }
    
    /**
     * Validates an import storage configuration.
     * 
     * @param request the import storage configuration to validate
     * @return the validation result
     */
    public ImportStorage validate(ImportStorageCreateRequest request) {
        return validate(request, null);
    }
    
    /**
     * Validates an import storage configuration with options.
     * 
     * @param request the import storage configuration to validate
     * @param requestOptions request options
     * @return the validation result
     */
    public ImportStorage validate(ImportStorageCreateRequest request, RequestOptions requestOptions) {
        return httpClient.post("/api/storages/import/validate/", request, ImportStorage.class);
    }
    
    /**
     * Validates an import storage configuration asynchronously.
     * 
     * @param request the import storage configuration to validate
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<ImportStorage> validateAsync(ImportStorageCreateRequest request) {
        return validateAsync(request, null);
    }
    
    /**
     * Validates an import storage configuration with options asynchronously.
     * 
     * @param request the import storage configuration to validate
     * @param requestOptions request options
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<ImportStorage> validateAsync(ImportStorageCreateRequest request, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/storages/import/validate/", request, ImportStorage.class);
    }
}