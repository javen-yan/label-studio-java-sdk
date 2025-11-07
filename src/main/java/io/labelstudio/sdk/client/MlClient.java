package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.MlBackend;
import io.labelstudio.sdk.vo.MlBackendCreateRequest;
import io.labelstudio.sdk.vo.MlBackendUpdateRequest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Client for managing Label Studio machine learning backends.
 * 
 * <p>This client provides methods to manage ML backends, allowing you to
 * connect machine learning models to Label Studio for automated pre-annotations,
 * active learning, and model training.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * // Create an ML backend
 * MlBackend backend = client.ml().create(
 *     MlBackendCreateRequest.builder()
 *         .url("http://ml-model:9090")
 *         .title("My ML Model")
 *         .description("Text classification model")
 *         .projectId(projectId)
 *         .interactive()
 *         .autoUpdate()
 *         .build()
 * );
 * 
 * // Train the model
 * client.ml().train(backend.getId());
 * </pre>
 */
public class MlClient {
    
    private final HttpClient httpClient;
    
    /**
     * Constructs a new ML client.
     * 
     * @param httpClient the HTTP client to use
     */
    public MlClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all ML backends.
     * 
     * @return a paginated list of ML backends
     */
    public Pagination<MlBackend> list() {
        return list(null);
    }
    
    /**
     * Lists all ML backends with options.
     * 
     * @param requestOptions request options
     * @return a paginated list of ML backends
     */
    public Pagination<MlBackend> list(RequestOptions requestOptions) {
        return httpClient.getPaginated("/api/ml/", MlBackend.class);
    }
    
    /**
     * Lists all ML backends asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of ML backends
     */
    public CompletableFuture<Pagination<MlBackend>> listAsync() {
        return listAsync(null);
    }
    
    /**
     * Lists all ML backends with options asynchronously.
     * 
     * @param requestOptions request options
     * @return a CompletableFuture containing a paginated list of ML backends
     */
    public CompletableFuture<Pagination<MlBackend>> listAsync(RequestOptions requestOptions) {
        return httpClient.getPaginatedAsync("/api/ml/", MlBackend.class);
    }
    
    /**
     * Creates a new ML backend.
     * 
     * @param request the ML backend creation request
     * @return the created ML backend
     */
    public MlBackend create(MlBackendCreateRequest request) {
        return create(request, null);
    }
    
    /**
     * Creates a new ML backend with options.
     * 
     * @param request the ML backend creation request
     * @param requestOptions request options
     * @return the created ML backend
     */
    public MlBackend create(MlBackendCreateRequest request, RequestOptions requestOptions) {
        return httpClient.post("/api/ml/", request, MlBackend.class);
    }
    
    /**
     * Creates a new ML backend asynchronously.
     * 
     * @param request the ML backend creation request
     * @return a CompletableFuture containing the created ML backend
     */
    public CompletableFuture<MlBackend> createAsync(MlBackendCreateRequest request) {
        return createAsync(request, null);
    }
    
    /**
     * Creates a new ML backend with options asynchronously.
     * 
     * @param request the ML backend creation request
     * @param requestOptions request options
     * @return a CompletableFuture containing the created ML backend
     */
    public CompletableFuture<MlBackend> createAsync(MlBackendCreateRequest request, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/ml/", request, MlBackend.class);
    }
    
    /**
     * Gets an ML backend by ID.
     * 
     * @param backendId the backend ID
     * @return the ML backend
     */
    public MlBackend get(int backendId) {
        return get(backendId, null);
    }
    
    /**
     * Gets an ML backend by ID with options.
     * 
     * @param backendId the backend ID
     * @param requestOptions request options
     * @return the ML backend
     */
    public MlBackend get(int backendId, RequestOptions requestOptions) {
        return httpClient.get("/api/ml/" + backendId + "/", MlBackend.class);
    }
    
    /**
     * Gets an ML backend by ID asynchronously.
     * 
     * @param backendId the backend ID
     * @return a CompletableFuture containing the ML backend
     */
    public CompletableFuture<MlBackend> getAsync(int backendId) {
        return getAsync(backendId, null);
    }
    
    /**
     * Gets an ML backend by ID with options asynchronously.
     * 
     * @param backendId the backend ID
     * @param requestOptions request options
     * @return a CompletableFuture containing the ML backend
     */
    public CompletableFuture<MlBackend> getAsync(int backendId, RequestOptions requestOptions) {
        return httpClient.getAsync("/api/ml/" + backendId + "/", MlBackend.class);
    }
    
    /**
     * Updates an ML backend.
     * 
     * @param backendId the backend ID
     * @param request the ML backend update request
     * @return the updated ML backend
     */
    public MlBackend update(int backendId, MlBackendUpdateRequest request) {
        return update(backendId, request, null);
    }
    
    /**
     * Updates an ML backend with options.
     * 
     * @param backendId the backend ID
     * @param request the ML backend update request
     * @param requestOptions request options
     * @return the updated ML backend
     */
    public MlBackend update(int backendId, MlBackendUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.put("/api/ml/" + backendId + "/", request, MlBackend.class);
    }
    
    /**
     * Updates an ML backend asynchronously.
     * 
     * @param backendId the backend ID
     * @param request the ML backend update request
     * @return a CompletableFuture containing the updated ML backend
     */
    public CompletableFuture<MlBackend> updateAsync(int backendId, MlBackendUpdateRequest request) {
        return updateAsync(backendId, request, null);
    }
    
    /**
     * Updates an ML backend with options asynchronously.
     * 
     * @param backendId the backend ID
     * @param request the ML backend update request
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated ML backend
     */
    public CompletableFuture<MlBackend> updateAsync(int backendId, MlBackendUpdateRequest request, RequestOptions requestOptions) {
        return httpClient.putAsync("/api/ml/" + backendId + "/", request, MlBackend.class);
    }
    
    /**
     * Deletes an ML backend.
     * 
     * @param backendId the backend ID to delete
     */
    public void delete(int backendId) {
        delete(backendId, null);
    }
    
    /**
     * Deletes an ML backend with options.
     * 
     * @param backendId the backend ID to delete
     * @param requestOptions request options
     */
    public void delete(int backendId, RequestOptions requestOptions) {
        httpClient.delete("/api/ml/" + backendId + "/", Void.class);
    }
    
    /**
     * Deletes an ML backend asynchronously.
     * 
     * @param backendId the backend ID to delete
     * @return a CompletableFuture that completes when the backend is deleted
     */
    public CompletableFuture<Void> deleteAsync(int backendId) {
        return deleteAsync(backendId, null);
    }
    
    /**
     * Deletes an ML backend with options asynchronously.
     * 
     * @param backendId the backend ID to delete
     * @param requestOptions request options
     * @return a CompletableFuture that completes when the backend is deleted
     */
    public CompletableFuture<Void> deleteAsync(int backendId, RequestOptions requestOptions) {
        return httpClient.deleteAsync("/api/ml/" + backendId + "/", Void.class);
    }
    
    /**
     * Trains an ML backend using project data.
     * 
     * @param backendId the backend ID to train
     * @return the updated ML backend
     */
    public MlBackend train(int backendId) {
        return train(backendId, null);
    }
    
    /**
     * Trains an ML backend using project data with options.
     * 
     * @param backendId the backend ID to train
     * @param requestOptions request options
     * @return the updated ML backend
     */
    public MlBackend train(int backendId, RequestOptions requestOptions) {
        return httpClient.post("/api/ml/" + backendId + "/train/", null, MlBackend.class);
    }
    
    /**
     * Trains an ML backend using project data asynchronously.
     * 
     * @param backendId the backend ID to train
     * @return a CompletableFuture containing the updated ML backend
     */
    public CompletableFuture<MlBackend> trainAsync(int backendId) {
        return trainAsync(backendId, null);
    }
    
    /**
     * Trains an ML backend using project data with options asynchronously.
     * 
     * @param backendId the backend ID to train
     * @param requestOptions request options
     * @return a CompletableFuture containing the updated ML backend
     */
    public CompletableFuture<MlBackend> trainAsync(int backendId, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/ml/" + backendId + "/train/", null, MlBackend.class);
    }
    
    /**
     * Validates an ML backend configuration.
     * 
     * @param request the ML backend configuration to validate
     * @return the validation result
     */
    public MlBackend validate(MlBackendCreateRequest request) {
        return validate(request, null);
    }
    
    /**
     * Validates an ML backend configuration with options.
     * 
     * @param request the ML backend configuration to validate
     * @param requestOptions request options
     * @return the validation result
     */
    public MlBackend validate(MlBackendCreateRequest request, RequestOptions requestOptions) {
        return httpClient.post("/api/ml/validate/", request, MlBackend.class);
    }
    
    /**
     * Validates an ML backend configuration asynchronously.
     * 
     * @param request the ML backend configuration to validate
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<MlBackend> validateAsync(MlBackendCreateRequest request) {
        return validateAsync(request, null);
    }
    
    /**
     * Validates an ML backend configuration with options asynchronously.
     * 
     * @param request the ML backend configuration to validate
     * @param requestOptions request options
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<MlBackend> validateAsync(MlBackendCreateRequest request, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/ml/validate/", request, MlBackend.class);
    }
    
    /**
     * Gets predictions from an ML backend for a specific task.
     * 
     * @param backendId the backend ID
     * @param taskId the task ID
     * @return the ML backend with prediction results
     */
    public MlBackend predict(int backendId, int taskId) {
        return predict(backendId, taskId, null);
    }
    
    /**
     * Gets predictions from an ML backend for a specific task with options.
     * 
     * @param backendId the backend ID
     * @param taskId the task ID
     * @param requestOptions request options
     * @return the ML backend with prediction results
     */
    public MlBackend predict(int backendId, int taskId, RequestOptions requestOptions) {
        return httpClient.post("/api/ml/" + backendId + "/predict/?task=" + taskId, null, MlBackend.class);
    }
    
    /**
     * Gets predictions from an ML backend for a specific task asynchronously.
     * 
     * @param backendId the backend ID
     * @param taskId the task ID
     * @return a CompletableFuture containing the ML backend with prediction results
     */
    public CompletableFuture<MlBackend> predictAsync(int backendId, int taskId) {
        return predictAsync(backendId, taskId, null);
    }
    
    /**
     * Gets predictions from an ML backend for a specific task with options asynchronously.
     * 
     * @param backendId the backend ID
     * @param taskId the task ID
     * @param requestOptions request options
     * @return a CompletableFuture containing the ML backend with prediction results
     */
    public CompletableFuture<MlBackend> predictAsync(int backendId, int taskId, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/ml/" + backendId + "/predict/?task=" + taskId, null, MlBackend.class);
    }
    
    /**
     * Requests interactive annotation from an ML backend.
     * 
     * @param backendId the backend ID
     * @param taskId the task ID
     * @return the prediction result
     */
    public Object predictInteractive(int backendId, int taskId) {
        return predictInteractive(backendId, taskId, null);
    }
    
    /**
     * Requests interactive annotation from an ML backend with options.
     * 
     * @param backendId the backend ID
     * @param taskId the task ID
     * @param requestOptions request options
     * @return the prediction result
     */
    public Object predictInteractive(int backendId, int taskId, RequestOptions requestOptions) {
        return httpClient.post("/api/ml/" + backendId + "/predict-interactive/?task=" + taskId, null, Object.class);
    }
    
    /**
     * Requests interactive annotation from an ML backend asynchronously.
     * 
     * @param backendId the backend ID
     * @param taskId the task ID
     * @return a CompletableFuture containing the prediction result
     */
    public CompletableFuture<Object> predictInteractiveAsync(int backendId, int taskId) {
        return predictInteractiveAsync(backendId, taskId, null);
    }
    
    /**
     * Requests interactive annotation from an ML backend with options asynchronously.
     * 
     * @param backendId the backend ID
     * @param taskId the task ID
     * @param requestOptions request options
     * @return a CompletableFuture containing the prediction result
     */
    public CompletableFuture<Object> predictInteractiveAsync(int backendId, int taskId, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/ml/" + backendId + "/predict-interactive/?task=" + taskId, null, Object.class);
    }
    
    /**
     * Creates predictions for all tasks in a project.
     * 
     * @param backendId the backend ID
     * @param projectId the project ID
     * @return the result
     */
    public Object predictAllTasks(int backendId, int projectId) {
        return predictAllTasks(backendId, projectId, null);
    }
    
    /**
     * Creates predictions for all tasks in a project with options.
     * 
     * @param backendId the backend ID
     * @param projectId the project ID
     * @param requestOptions request options
     * @return the result
     */
    public Object predictAllTasks(int backendId, int projectId, RequestOptions requestOptions) {
        return httpClient.post("/api/ml/" + backendId + "/predict-all-tasks/?project=" + projectId, null, Object.class);
    }
    
    /**
     * Creates predictions for all tasks in a project asynchronously.
     * 
     * @param backendId the backend ID
     * @param projectId the project ID
     * @return a CompletableFuture containing the result
     */
    public CompletableFuture<Object> predictAllTasksAsync(int backendId, int projectId) {
        return predictAllTasksAsync(backendId, projectId, null);
    }
    
    /**
     * Creates predictions for all tasks in a project with options asynchronously.
     * 
     * @param backendId the backend ID
     * @param projectId the project ID
     * @param requestOptions request options
     * @return a CompletableFuture containing the result
     */
    public CompletableFuture<Object> predictAllTasksAsync(int backendId, int projectId, RequestOptions requestOptions) {
        return httpClient.postAsync("/api/ml/" + backendId + "/predict-all-tasks/?project=" + projectId, null, Object.class);
    }
    
    /**
     * Lists model versions for an ML backend.
     * 
     * @param backendId the backend ID
     * @return a list of model versions
     */
    public List<Object> listModelVersions(int backendId) {
        return listModelVersions(backendId, null);
    }
    
    /**
     * Lists model versions for an ML backend with options.
     * 
     * @param backendId the backend ID
     * @param requestOptions request options
     * @return a list of model versions
     */
    public List<Object> listModelVersions(int backendId, RequestOptions requestOptions) {
        return httpClient.get("/api/ml/" + backendId + "/model-versions/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructCollectionType(List.class, Object.class));
    }
    
    /**
     * Lists model versions for an ML backend asynchronously.
     * 
     * @param backendId the backend ID
     * @return a CompletableFuture containing a list of model versions
     */
    public CompletableFuture<List<Object>> listModelVersionsAsync(int backendId) {
        return listModelVersionsAsync(backendId, null);
    }
    
    /**
     * Lists model versions for an ML backend with options asynchronously.
     * 
     * @param backendId the backend ID
     * @param requestOptions request options
     * @return a CompletableFuture containing a list of model versions
     */
    public CompletableFuture<List<Object>> listModelVersionsAsync(int backendId, RequestOptions requestOptions) {
        return httpClient.getAsync("/api/ml/" + backendId + "/model-versions/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructCollectionType(List.class, Object.class));
    }
}