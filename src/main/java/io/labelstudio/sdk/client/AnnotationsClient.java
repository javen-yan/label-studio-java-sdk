package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.Annotation;
import io.labelstudio.sdk.vo.AnnotationCreateRequest;
import io.labelstudio.sdk.vo.AnnotationUpdateRequest;
import com.fasterxml.jackson.databind.JavaType;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Client for managing Label Studio annotations.
 */
public class AnnotationsClient {
    
    private final HttpClient httpClient;
    
    public AnnotationsClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    public Pagination<Annotation> list() {
        return list(null);
    }
    
    public Pagination<Annotation> list(RequestOptions options) {
        return httpClient.get("/api/annotations/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, Annotation.class));
    }
    
    /**
     * Lists all annotations for a specific task.
     * 
     * @param taskId the task ID
     * @return a paginated list of annotations for the task
     */
    public Pagination<Annotation> list(int taskId) {
        return list(taskId, null);
    }
    
    /**
     * Lists all annotations for a specific task with options.
     * 
     * @param taskId the task ID
     * @param options request options
     * @return a paginated list of annotations for the task
     */
    public Pagination<Annotation> list(int taskId, RequestOptions options) {
        return httpClient.get("/api/tasks/" + taskId + "/annotations/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, Annotation.class));
    }
    
    public CompletableFuture<Pagination<Annotation>> listAsync() {
        return listAsync(null);
    }
    
    public CompletableFuture<Pagination<Annotation>> listAsync(RequestOptions options) {
        return httpClient.getAsync("/api/annotations/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, Annotation.class));
    }
    
    /**
     * Lists all annotations for a specific task asynchronously.
     * 
     * @param taskId the task ID
     * @return a CompletableFuture containing a paginated list of annotations for the task
     */
    public CompletableFuture<Pagination<Annotation>> listAsync(int taskId) {
        return listAsync(taskId, null);
    }
    
    /**
     * Lists all annotations for a specific task with options asynchronously.
     * 
     * @param taskId the task ID
     * @param options request options
     * @return a CompletableFuture containing a paginated list of annotations for the task
     */
    public CompletableFuture<Pagination<Annotation>> listAsync(int taskId, RequestOptions options) {
        return httpClient.getAsync("/api/tasks/" + taskId + "/annotations/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, Annotation.class));
    }
    
    public Annotation get(int id) {
        return get(id, null);
    }
    
    public Annotation get(int id, RequestOptions options) {
        return httpClient.get("/api/annotations/" + id + "/", Annotation.class);
    }
    
    public CompletableFuture<Annotation> getAsync(int id) {
        return getAsync(id, null);
    }
    
    public CompletableFuture<Annotation> getAsync(int id, RequestOptions options) {
        return httpClient.getAsync("/api/annotations/" + id + "/", Annotation.class);
    }
    
    public Annotation create(AnnotationCreateRequest request) {
        return create(request, null);
    }
    
    public Annotation create(AnnotationCreateRequest request, RequestOptions options) {
        // Label Studio API requires task ID in the path
        if (request.getTask() == null) {
            throw new IllegalArgumentException("Task ID is required to create an annotation");
        }
        return httpClient.post("/api/tasks/" + request.getTask() + "/annotations/", request, Annotation.class);
    }
    
    /**
     * Creates a new annotation for a specific task.
     * 
     * @param taskId the task ID
     * @param request the annotation creation request
     * @return the created annotation
     */
    public Annotation create(int taskId, AnnotationCreateRequest request) {
        return create(taskId, request, null);
    }
    
    /**
     * Creates a new annotation for a specific task with options.
     * 
     * @param taskId the task ID
     * @param request the annotation creation request
     * @param options request options
     * @return the created annotation
     */
    public Annotation create(int taskId, AnnotationCreateRequest request, RequestOptions options) {
        // Ensure task ID in request matches the path parameter
        if (request.getTask() == null) {
            request.setTask(taskId);
        } else if (!request.getTask().equals(taskId)) {
            // If task ID is provided in both places, they should match
            throw new IllegalArgumentException("Task ID in request (" + request.getTask() + 
                    ") does not match path parameter (" + taskId + ")");
        }
        return httpClient.post("/api/tasks/" + taskId + "/annotations/", request, Annotation.class);
    }
    
    public CompletableFuture<Annotation> createAsync(AnnotationCreateRequest request) {
        return createAsync(request, null);
    }
    
    public CompletableFuture<Annotation> createAsync(AnnotationCreateRequest request, RequestOptions options) {
        if (request.getTask() == null) {
            throw new IllegalArgumentException("Task ID is required to create an annotation");
        }
        return httpClient.postAsync("/api/tasks/" + request.getTask() + "/annotations/", request, Annotation.class);
    }
    
    /**
     * Creates a new annotation for a specific task asynchronously.
     * 
     * @param taskId the task ID
     * @param request the annotation creation request
     * @return a CompletableFuture containing the created annotation
     */
    public CompletableFuture<Annotation> createAsync(int taskId, AnnotationCreateRequest request) {
        return createAsync(taskId, request, null);
    }
    
    /**
     * Creates a new annotation for a specific task with options asynchronously.
     * 
     * @param taskId the task ID
     * @param request the annotation creation request
     * @param options request options
     * @return a CompletableFuture containing the created annotation
     */
    public CompletableFuture<Annotation> createAsync(int taskId, AnnotationCreateRequest request, RequestOptions options) {
        // Ensure task ID in request matches the path parameter
        if (request.getTask() == null) {
            request.setTask(taskId);
        } else if (!request.getTask().equals(taskId)) {
            // If task ID is provided in both places, they should match
            throw new IllegalArgumentException("Task ID in request (" + request.getTask() + 
                    ") does not match path parameter (" + taskId + ")");
        }
        return httpClient.postAsync("/api/tasks/" + taskId + "/annotations/", request, Annotation.class);
    }
    
    /**
     * Bulk creates annotations.
     * 
     * @param requests the list of annotation creation requests
     * @return a list of created annotations
     */
    public List<Annotation> createBulk(List<AnnotationCreateRequest> requests) {
        return createBulk(requests, null);
    }
    
    /**
     * Bulk creates annotations with options.
     * 
     * @param requests the list of annotation creation requests
     * @param options request options
     * @return a list of created annotations
     */
    @SuppressWarnings("unchecked")
    public List<Annotation> createBulk(List<AnnotationCreateRequest> requests, RequestOptions options) {
        JavaType responseType = httpClient.getObjectMapper().getTypeFactory()
                .constructCollectionType(List.class, Annotation.class);
        return (List<Annotation>) httpClient.getObjectMapper().convertValue(
            httpClient.post("/api/annotations/bulk/", requests, Object.class), 
            responseType);
    }
    
    /**
     * Bulk creates annotations asynchronously.
     * 
     * @param requests the list of annotation creation requests
     * @return a CompletableFuture containing a list of created annotations
     */
    public CompletableFuture<List<Annotation>> createBulkAsync(List<AnnotationCreateRequest> requests) {
        return createBulkAsync(requests, null);
    }
    
    /**
     * Bulk creates annotations with options asynchronously.
     * 
     * @param requests the list of annotation creation requests
     * @param options request options
     * @return a CompletableFuture containing a list of created annotations
     */
    @SuppressWarnings("unchecked")
    public CompletableFuture<List<Annotation>> createBulkAsync(List<AnnotationCreateRequest> requests, RequestOptions options) {
        JavaType responseType = httpClient.getObjectMapper().getTypeFactory()
                .constructCollectionType(List.class, Annotation.class);
        return httpClient.postAsync("/api/annotations/bulk/", requests, Object.class)
            .thenApply(result -> (List<Annotation>) httpClient.getObjectMapper().convertValue(result, responseType));
    }
    
    public Annotation update(int id, AnnotationUpdateRequest request) {
        return update(id, request, null);
    }
    
    public Annotation update(int id, AnnotationUpdateRequest request, RequestOptions options) {
        return httpClient.put("/api/annotations/" + id + "/", request, Annotation.class);
    }
    
    public CompletableFuture<Annotation> updateAsync(int id, AnnotationUpdateRequest request) {
        return updateAsync(id, request, null);
    }
    
    public CompletableFuture<Annotation> updateAsync(int id, AnnotationUpdateRequest request, RequestOptions options) {
        return httpClient.putAsync("/api/annotations/" + id + "/", request, Annotation.class);
    }
    
    public void delete(int id) {
        delete(id, null);
    }
    
    public void delete(int id, RequestOptions options) {
        httpClient.delete("/api/annotations/" + id + "/", Void.class);
    }
    
    public CompletableFuture<Void> deleteAsync(int id) {
        return deleteAsync(id, null);
    }
    
    public CompletableFuture<Void> deleteAsync(int id, RequestOptions options) {
        return httpClient.deleteAsync("/api/annotations/" + id + "/", Void.class);
    }
}