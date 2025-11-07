package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.Task;
import io.labelstudio.sdk.vo.TaskCreateRequest;
import io.labelstudio.sdk.vo.TaskEventRequest;
import io.labelstudio.sdk.vo.TaskEventResult;
import io.labelstudio.sdk.vo.TaskImportStatus;
import io.labelstudio.sdk.vo.TaskUpdateRequest;
import io.labelstudio.sdk.vo.TasksListOptions;

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
     * Lists tasks for a project with options.
     * 
     * @param listOptions the list options
     * @return a paginated list of tasks
     */
    public Pagination<Task> list(TasksListOptions listOptions) {
        String path = "/api/tasks/";
        if (listOptions != null) {
            path += buildQueryString(listOptions);
        }
        return httpClient.get(path, 
        httpClient.getObjectMapper().getTypeFactory()
                .constructParametricType(Pagination.class, Task.class));
    }

    /**
     * Lists tasks for a project with options asynchronously.
     * 
     * @param listOptions the list options
     * @return a CompletableFuture containing a paginated list of tasks
     */
    public CompletableFuture<Pagination<Task>> listAsync(TasksListOptions listOptions) {
        String path = "/api/tasks/";
        if (listOptions != null) {
            path += buildQueryString(listOptions);
        }
        return httpClient.getAsync(path, 
        httpClient.getObjectMapper().getTypeFactory()
                .constructParametricType(Pagination.class, Task.class));
    }

    /**
     * Builds the query string for the tasks list.
     * 
     * @param options the list options
     * @return the query string
     */
    private String buildQueryString(TasksListOptions options) {
        if (options == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder("?");
        boolean hasParam = false;
        
        if (options.getProject() != null) {
            sb.append("project=").append(options.getProject());
            hasParam = true;
        }
        
        if (options.getView() != null) {
            if (hasParam) sb.append("&");
            sb.append("view=").append(options.getView());
            hasParam = true;
        }
        
        if (options.getIds() != null) {
            if (hasParam) sb.append("&");
            sb.append("ids=").append(options.getIds());
            hasParam = true;
        }
        
        if (options.getPage() != null) {
            if (hasParam) sb.append("&");
            sb.append("page=").append(options.getPage());
            hasParam = true;
        }
        
        if (options.getPageSize() != null) {
            if (hasParam) sb.append("&");
            sb.append("page_size=").append(options.getPageSize());
            hasParam = true;
        }
        
        if (options.getOrdering() != null) {
            if (hasParam) sb.append("&");
            sb.append("ordering=").append(options.getOrdering());
            hasParam = true;
        }
        
        if (options.getResolvedOnly() != null) {
            if (hasParam) sb.append("&");
            sb.append("resolved_only=").append(options.getResolvedOnly());
            hasParam = true;
        }
        
        if (options.getCompletedBy() != null) {
            if (hasParam) sb.append("&");
            sb.append("completed_by=").append(options.getCompletedBy());
            hasParam = true;
        }
        
        if (options.getCanceledBy() != null) {
            if (hasParam) sb.append("&");
            sb.append("canceled_by=").append(options.getCanceledBy());
            hasParam = true;
        }
        
        if (options.getAnnotatedBy() != null) {
            if (hasParam) sb.append("&");
            sb.append("annotated_by=").append(options.getAnnotatedBy());
            hasParam = true;
        }
        
        if (options.getReviewedBy() != null) {
            if (hasParam) sb.append("&");
            sb.append("reviewed_by=").append(options.getReviewedBy());
            hasParam = true;
        }
        
        if (options.getInclude() != null) {
            if (hasParam) sb.append("&");
            sb.append("include=").append(options.getInclude());
            hasParam = true;
        }
        
        return hasParam ? sb.toString() : "";
    }
    
    /**
     * Creates a new task.
     * 
     * @param request the task creation request
     * @return the created task
     */
    public Task create(TaskCreateRequest request) {
        return create(request, null);
    }
    
    /**
     * Creates a new task with options.
     * 
     * @param request the task creation request
     * @param options request options
     * @return the created task
     */
    public Task create(TaskCreateRequest request, RequestOptions options) {
        return httpClient.post("/api/tasks/", request, Task.class);
    }
    
    /**
     * Creates a new task asynchronously.
     * 
     * @param request the task creation request
     * @return a CompletableFuture containing the created task
     */
    public CompletableFuture<Task> createAsync(TaskCreateRequest request) {
        return createAsync(request, null);
    }
    
    /**
     * Creates a new task with options asynchronously.
     * 
     * @param request the task creation request
     * @param options request options
     * @return a CompletableFuture containing the created task
     */
    public CompletableFuture<Task> createAsync(TaskCreateRequest request, RequestOptions options) {
        return httpClient.postAsync("/api/tasks/", request, Task.class);
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
    
    /**
     * Gets project import info/status.
     * 
     * @return the import status information
     */
    public TaskImportStatus getImportStatus() {
        return getImportStatus(null);
    }
    
    /**
     * Gets project import info/status with options.
     * 
     * @param options request options
     * @return the import status information
     */
    public TaskImportStatus getImportStatus(RequestOptions options) {
        return httpClient.get("/api/tasks/create-many-status/", TaskImportStatus.class);
    }
    
    /**
     * Gets project import info/status asynchronously.
     * 
     * @return a CompletableFuture containing the import status information
     */
    public CompletableFuture<TaskImportStatus> getImportStatusAsync() {
        return getImportStatusAsync(null);
    }
    
    /**
     * Gets project import info/status with options asynchronously.
     * 
     * @param options request options
     * @return a CompletableFuture containing the import status information
     */
    public CompletableFuture<TaskImportStatus> getImportStatusAsync(RequestOptions options) {
        return httpClient.getAsync("/api/tasks/create-many-status/", TaskImportStatus.class);
    }
    
    /**
     * Deletes all tasks.
     * 
     * @param projectId the project ID
     */
    public void deleteAll(int projectId) {
        deleteAll(projectId, null);
    }
    
    /**
     * Deletes all tasks with options.
     * 
     * @param projectId the project ID
     * @param options request options
     */
    public void deleteAll(int projectId, RequestOptions options) {
        httpClient.delete("/api/projects/" + projectId + "/tasks/", Void.class);
    }
    
    /**
     * Deletes all tasks asynchronously.
     * 
     * @param projectId the project ID
     * @return a CompletableFuture that completes when all tasks are deleted
     */
    public CompletableFuture<Void> deleteAllAsync(int projectId) {
        return deleteAllAsync(projectId, null);
    }
    
    /**
     * Deletes all tasks with options asynchronously.
     * 
     * @param projectId the project ID
     * @param options request options
     * @return a CompletableFuture that completes when all tasks are deleted
     */
    public CompletableFuture<Void> deleteAllAsync(int projectId, RequestOptions options) {
        return httpClient.deleteAsync("/api/projects/" + projectId + "/tasks/", Void.class);
    }
    
    /**
     * Creates a task event.
     * 
     * @param taskId the task ID
     * @param request the event creation request
     * @return the created event result
     */
    public TaskEventResult createEvent(int taskId, TaskEventRequest request) {
        return createEvent(taskId, request, null);
    }
    
    /**
     * Creates a task event with options.
     * 
     * @param taskId the task ID
     * @param request the event creation request
     * @param options request options
     * @return the created event result
     */
    public TaskEventResult createEvent(int taskId, TaskEventRequest request, RequestOptions options) {
        return httpClient.post("/api/tasks/" + taskId + "/events/", request, TaskEventResult.class);
    }
    
    /**
     * Creates a task event asynchronously.
     * 
     * @param taskId the task ID
     * @param request the event creation request
     * @return a CompletableFuture containing the created event result
     */
    public CompletableFuture<TaskEventResult> createEventAsync(int taskId, TaskEventRequest request) {
        return createEventAsync(taskId, request, null);
    }
    
    /**
     * Creates a task event with options asynchronously.
     * 
     * @param taskId the task ID
     * @param request the event creation request
     * @param options request options
     * @return a CompletableFuture containing the created event result
     */
    public CompletableFuture<TaskEventResult> createEventAsync(int taskId, TaskEventRequest request, RequestOptions options) {
        return httpClient.postAsync("/api/tasks/" + taskId + "/events/", request, TaskEventResult.class);
    }
}