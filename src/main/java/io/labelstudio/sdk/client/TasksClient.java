package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.Task;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Client for managing Label Studio tasks.
 */
public class TasksClient {
    
    private final HttpClient httpClient;
    
    /**
     * Constructs a new tasks client.
     * 
     * @param httpClient the HTTP client to use
     */
    public TasksClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all tasks for a project.
     * 
     * @param projectId the project ID
     * @return a paginated list of tasks
     */
    public Pagination<Task> list(int projectId) {
        return list(projectId, null);
    }
    
    /**
     * Lists tasks for a project with options.
     * 
     * @param projectId the project ID
     * @param options request options
     * @return a paginated list of tasks
     */
    public Pagination<Task> list(int projectId, RequestOptions options) {
        return httpClient.get("/api/projects/" + projectId + "/tasks/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, Task.class));
    }
    
    /**
     * Lists all tasks for a project asynchronously.
     * 
     * @param projectId the project ID
     * @return a CompletableFuture containing a paginated list of tasks
     */
    public CompletableFuture<Pagination<Task>> listAsync(int projectId) {
        return listAsync(projectId, null);
    }
    
    /**
     * Lists tasks for a project with options asynchronously.
     * 
     * @param projectId the project ID
     * @param options request options
     * @return a CompletableFuture containing a paginated list of tasks
     */
    public CompletableFuture<Pagination<Task>> listAsync(int projectId, RequestOptions options) {
        return httpClient.getAsync("/api/projects/" + projectId + "/tasks/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, Task.class));
    }
    
    /**
     * Creates a new task.
     * 
     * @param projectId the project ID
     * @param request the task creation request
     * @return the created task
     */
    public Task create(int projectId, TaskCreateRequest request) {
        return create(projectId, request, null);
    }
    
    /**
     * Creates a new task with options.
     * 
     * @param projectId the project ID
     * @param request the task creation request
     * @param options request options
     * @return the created task
     */
    public Task create(int projectId, TaskCreateRequest request, RequestOptions options) {
        return httpClient.post("/api/projects/" + projectId + "/tasks/", request, Task.class);
    }
    
    /**
     * Creates a new task asynchronously.
     * 
     * @param projectId the project ID
     * @param request the task creation request
     * @return a CompletableFuture containing the created task
     */
    public CompletableFuture<Task> createAsync(int projectId, TaskCreateRequest request) {
        return createAsync(projectId, request, null);
    }
    
    /**
     * Creates a new task with options asynchronously.
     * 
     * @param projectId the project ID
     * @param request the task creation request
     * @param options request options
     * @return a CompletableFuture containing the created task
     */
    public CompletableFuture<Task> createAsync(int projectId, TaskCreateRequest request, RequestOptions options) {
        return httpClient.postAsync("/api/projects/" + projectId + "/tasks/", request, Task.class);
    }
    
    /**
     * Gets a task by ID.
     * 
     * @param id the task ID
     * @return the task
     */
    public Task get(int id) {
        return get(id, null);
    }
    
    /**
     * Gets a task by ID with options.
     * 
     * @param id the task ID
     * @param options request options
     * @return the task
     */
    public Task get(int id, RequestOptions options) {
        return httpClient.get("/api/tasks/" + id + "/", Task.class);
    }
    
    /**
     * Gets a task by ID asynchronously.
     * 
     * @param id the task ID
     * @return a CompletableFuture containing the task
     */
    public CompletableFuture<Task> getAsync(int id) {
        return getAsync(id, null);
    }
    
    /**
     * Gets a task by ID with options asynchronously.
     * 
     * @param id the task ID
     * @param options request options
     * @return a CompletableFuture containing the task
     */
    public CompletableFuture<Task> getAsync(int id, RequestOptions options) {
        return httpClient.getAsync("/api/tasks/" + id + "/", Task.class);
    }
    
    /**
     * Updates a task.
     * 
     * @param id the task ID
     * @param request the task update request
     * @return the updated task
     */
    public Task update(int id, TaskUpdateRequest request) {
        return update(id, request, null);
    }
    
    /**
     * Updates a task with options.
     * 
     * @param id the task ID
     * @param request the task update request
     * @param options request options
     * @return the updated task
     */
    public Task update(int id, TaskUpdateRequest request, RequestOptions options) {
        return httpClient.put("/api/tasks/" + id + "/", request, Task.class);
    }
    
    /**
     * Updates a task asynchronously.
     * 
     * @param id the task ID
     * @param request the task update request
     * @return a CompletableFuture containing the updated task
     */
    public CompletableFuture<Task> updateAsync(int id, TaskUpdateRequest request) {
        return updateAsync(id, request, null);
    }
    
    /**
     * Updates a task with options asynchronously.
     * 
     * @param id the task ID
     * @param request the task update request
     * @param options request options
     * @return a CompletableFuture containing the updated task
     */
    public CompletableFuture<Task> updateAsync(int id, TaskUpdateRequest request, RequestOptions options) {
        return httpClient.putAsync("/api/tasks/" + id + "/", request, Task.class);
    }
    
    /**
     * Deletes a task.
     * 
     * @param id the task ID
     */
    public void delete(int id) {
        delete(id, null);
    }
    
    /**
     * Deletes a task with options.
     * 
     * @param id the task ID
     * @param options request options
     */
    public void delete(int id, RequestOptions options) {
        httpClient.delete("/api/tasks/" + id + "/", Void.class);
    }
    
    /**
     * Deletes a task asynchronously.
     * 
     * @param id the task ID
     * @return a CompletableFuture that completes when the task is deleted
     */
    public CompletableFuture<Void> deleteAsync(int id) {
        return deleteAsync(id, null);
    }
    
    /**
     * Deletes a task with options asynchronously.
     * 
     * @param id the task ID
     * @param options request options
     * @return a CompletableFuture that completes when the task is deleted
     */
    public CompletableFuture<Void> deleteAsync(int id, RequestOptions options) {
        return httpClient.deleteAsync("/api/tasks/" + id + "/", Void.class);
    }
}