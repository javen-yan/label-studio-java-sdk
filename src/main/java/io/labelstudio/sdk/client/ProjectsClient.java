package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.Project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Client for managing Label Studio projects.
 */
public class ProjectsClient {
    
    private final HttpClient httpClient;
    
    /**
     * Constructs a new projects client.
     * 
     * @param httpClient the HTTP client to use
     */
    public ProjectsClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Gets the exports client for a specific project.
     * 
     * @param projectId the project ID
     * @return the project exports client
     */
    public ProjectExportsClient exports(int projectId) {
        return new ProjectExportsClient(httpClient, projectId);
    }
    
    /**
     * Gets the members client for a specific project.
     * 
     * @param projectId the project ID
     * @return the project members client
     */
    public ProjectMembersClient members(int projectId) {
        return new ProjectMembersClient(httpClient, projectId);
    }
    
    /**
     * Lists all projects.
     * 
     * @return a paginated list of projects
     */
    public Pagination<Project> list() {
        return list(null, null);
    }
    
    /**
     * Lists projects with list options.
     * 
     * @param listOptions the list options for filtering, sorting, and pagination
     * @return a paginated list of projects
     */
    public Pagination<Project> list(ProjectsListOptions listOptions) {
        return list(listOptions, null);
    }
    
    /**
     * Lists projects with options.
     * 
     * @param listOptions the list options for filtering, sorting, and pagination
     * @param requestOptions request options
     * @return a paginated list of projects
     */
    public Pagination<Project> list(ProjectsListOptions listOptions, RequestOptions requestOptions) {
        String path = "/api/projects/";
        if (listOptions != null) {
            path += buildQueryString(listOptions);
        }
        return httpClient.get(path, 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, Project.class));
    }
    
    /**
     * Lists all projects asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of projects
     */
    public CompletableFuture<Pagination<Project>> listAsync() {
        return listAsync(null, null);
    }
    
    /**
     * Lists projects with list options asynchronously.
     * 
     * @param listOptions the list options for filtering, sorting, and pagination
     * @return a CompletableFuture containing a paginated list of projects
     */
    public CompletableFuture<Pagination<Project>> listAsync(ProjectsListOptions listOptions) {
        return listAsync(listOptions, null);
    }
    
    /**
     * Lists projects with options asynchronously.
     * 
     * @param listOptions the list options for filtering, sorting, and pagination
     * @param requestOptions request options
     * @return a CompletableFuture containing a paginated list of projects
     */
    public CompletableFuture<Pagination<Project>> listAsync(ProjectsListOptions listOptions, RequestOptions requestOptions) {
        String path = "/api/projects/";
        if (listOptions != null) {
            path += buildQueryString(listOptions);
        }
        return httpClient.getAsync(path, 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, Project.class));
    }
    
    /**
     * Creates a new project.
     * 
     * @param request the project creation request
     * @return the created project
     */
    public Project create(ProjectCreateRequest request) {
        return create(request, null);
    }
    
    /**
     * Creates a new project with options.
     * 
     * @param request the project creation request
     * @param options request options
     * @return the created project
     */
    public Project create(ProjectCreateRequest request, RequestOptions options) {
        return httpClient.post("/api/projects/", request, Project.class);
    }
    
    /**
     * Creates a new project asynchronously.
     * 
     * @param request the project creation request
     * @return a CompletableFuture containing the created project
     */
    public CompletableFuture<Project> createAsync(ProjectCreateRequest request) {
        return createAsync(request, null);
    }
    
    /**
     * Creates a new project with options asynchronously.
     * 
     * @param request the project creation request
     * @param options request options
     * @return a CompletableFuture containing the created project
     */
    public CompletableFuture<Project> createAsync(ProjectCreateRequest request, RequestOptions options) {
        return httpClient.postAsync("/api/projects/", request, Project.class);
    }
    
    /**
     * Gets a project by ID.
     * 
     * @param id the project ID
     * @return the project
     */
    public Project get(int id) {
        return get(id, null);
    }
    
    /**
     * Gets a project by ID with options.
     * 
     * @param id the project ID
     * @param options request options
     * @return the project
     */
    public Project get(int id, RequestOptions options) {
        return httpClient.get("/api/projects/" + id + "/", Project.class);
    }
    
    /**
     * Gets a project by ID asynchronously.
     * 
     * @param id the project ID
     * @return a CompletableFuture containing the project
     */
    public CompletableFuture<Project> getAsync(int id) {
        return getAsync(id, null);
    }
    
    /**
     * Gets a project by ID with options asynchronously.
     * 
     * @param id the project ID
     * @param options request options
     * @return a CompletableFuture containing the project
     */
    public CompletableFuture<Project> getAsync(int id, RequestOptions options) {
        return httpClient.getAsync("/api/projects/" + id + "/", Project.class);
    }
    
    /**
     * Updates a project.
     * 
     * @param id the project ID
     * @param request the project update request
     * @return the updated project
     */
    public Project update(int id, ProjectUpdateRequest request) {
        return update(id, request, null);
    }
    
    /**
     * Updates a project with options.
     * 
     * @param id the project ID
     * @param request the project update request
     * @param options request options
     * @return the updated project
     */
    public Project update(int id, ProjectUpdateRequest request, RequestOptions options) {
        return httpClient.put("/api/projects/" + id + "/", request, Project.class);
    }
    
    /**
     * Updates a project asynchronously.
     * 
     * @param id the project ID
     * @param request the project update request
     * @return a CompletableFuture containing the updated project
     */
    public CompletableFuture<Project> updateAsync(int id, ProjectUpdateRequest request) {
        return updateAsync(id, request, null);
    }
    
    /**
     * Updates a project with options asynchronously.
     * 
     * @param id the project ID
     * @param request the project update request
     * @param options request options
     * @return a CompletableFuture containing the updated project
     */
    public CompletableFuture<Project> updateAsync(int id, ProjectUpdateRequest request, RequestOptions options) {
        return httpClient.putAsync("/api/projects/" + id + "/", request, Project.class);
    }
    
    /**
     * Deletes a project.
     * 
     * @param id the project ID
     */
    public void delete(int id) {
        delete(id, null);
    }
    
    /**
     * Deletes a project with options.
     * 
     * @param id the project ID
     * @param options request options
     */
    public void delete(int id, RequestOptions options) {
        httpClient.delete("/api/projects/" + id + "/", Void.class);
    }
    
    /**
     * Deletes a project asynchronously.
     * 
     * @param id the project ID
     * @return a CompletableFuture that completes when the project is deleted
     */
    public CompletableFuture<Void> deleteAsync(int id) {
        return deleteAsync(id, null);
    }
    
    /**
     * Deletes a project with options asynchronously.
     * 
     * @param id the project ID
     * @param options request options
     * @return a CompletableFuture that completes when the project is deleted
     */
    public CompletableFuture<Void> deleteAsync(int id, RequestOptions options) {
        return httpClient.deleteAsync("/api/projects/" + id + "/", Void.class);
    }
    
    /**
     * Validates a label configuration.
     * 
     * @param id the project ID
     * @param labelConfig the label configuration XML
     * @return validation result
     */
    public LabelConfigValidationResult validateLabelConfig(int id, String labelConfig) {
        return validateLabelConfig(id, labelConfig, null);
    }
    
    /**
     * Validates a label configuration with options.
     * 
     * @param id the project ID
     * @param labelConfig the label configuration XML
     * @param options request options
     * @return validation result
     */
    public LabelConfigValidationResult validateLabelConfig(int id, String labelConfig, RequestOptions options) {
        Map<String, String> request = new HashMap<>();
        request.put("label_config", labelConfig);
        return httpClient.post("/api/projects/" + id + "/validate/", request, LabelConfigValidationResult.class);
    }
    
    /**
     * Validates a label configuration asynchronously.
     * 
     * @param id the project ID
     * @param labelConfig the label configuration XML
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<LabelConfigValidationResult> validateLabelConfigAsync(int id, String labelConfig) {
        return validateLabelConfigAsync(id, labelConfig, null);
    }
    
    /**
     * Validates a label configuration with options asynchronously.
     * 
     * @param id the project ID
     * @param labelConfig the label configuration XML
     * @param options request options
     * @return a CompletableFuture containing the validation result
     */
    public CompletableFuture<LabelConfigValidationResult> validateLabelConfigAsync(int id, String labelConfig, RequestOptions options) {
        Map<String, String> request = new HashMap<>();
        request.put("label_config", labelConfig);
        return httpClient.postAsync("/api/projects/" + id + "/validate/", request, LabelConfigValidationResult.class);
    }
    
    /**
     * Imports tasks into a project.
     * 
     * @param id the project ID
     * @param tasks the tasks to import
     * @return import result
     */
    public TaskImportResult importTasks(int id, List<Map<String, Object>> tasks) {
        return importTasks(id, tasks, null);
    }
    
    /**
     * Imports tasks into a project with options.
     * 
     * @param id the project ID
     * @param tasks the tasks to import
     * @param options request options
     * @return import result
     */
    public TaskImportResult importTasks(int id, List<Map<String, Object>> tasks, RequestOptions options) {
        return httpClient.post("/api/projects/" + id + "/import/", tasks, TaskImportResult.class);
    }
    
    /**
     * Imports tasks into a project asynchronously.
     * 
     * @param id the project ID
     * @param tasks the tasks to import
     * @return a CompletableFuture containing the import result
     */
    public CompletableFuture<TaskImportResult> importTasksAsync(int id, List<Map<String, Object>> tasks) {
        return importTasksAsync(id, tasks, null);
    }
    
    /**
     * Imports tasks into a project with options asynchronously.
     * 
     * @param id the project ID
     * @param tasks the tasks to import
     * @param options request options
     * @return a CompletableFuture containing the import result
     */
    public CompletableFuture<TaskImportResult> importTasksAsync(int id, List<Map<String, Object>> tasks, RequestOptions options) {
        return httpClient.postAsync("/api/projects/" + id + "/import/", tasks, TaskImportResult.class);
    }
    
    /**
     * Gets project counts with filtering options.
     * 
     * @return a paginated list of project counts
     */
    public Pagination<ProjectCounts> listCounts() {
        return listCounts(null, null);
    }
    
    /**
     * Gets project counts with filtering options.
     * 
     * @param listOptions the list options for filtering
     * @return a paginated list of project counts
     */
    public Pagination<ProjectCounts> listCounts(ProjectsListOptions listOptions) {
        return listCounts(listOptions, null);
    }
    
    /**
     * Gets project counts with filtering options.
     * 
     * @param listOptions the list options for filtering
     * @param requestOptions request options
     * @return a paginated list of project counts
     */
    public Pagination<ProjectCounts> listCounts(ProjectsListOptions listOptions, RequestOptions requestOptions) {
        String path = "/api/projects/counts/";
        if (listOptions != null) {
            path += buildQueryString(listOptions);
        }
        return httpClient.get(path, 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructParametricType(Pagination.class, ProjectCounts.class));
    }
    
    /**
     * Duplicates a project.
     * 
     * @param id the project ID to duplicate
     * @param request the duplication request
     * @return the duplicated project
     */
    public Project duplicate(int id, ProjectDuplicateRequest request) {
        return duplicate(id, request, null);
    }
    
    /**
     * Duplicates a project with options.
     * 
     * @param id the project ID to duplicate
     * @param request the duplication request
     * @param options request options
     * @return the duplicated project
     */
    public Project duplicate(int id, ProjectDuplicateRequest request, RequestOptions options) {
        return httpClient.post("/api/projects/" + id + "/duplicate/", request, Project.class);
    }
    
    /**
     * Duplicates a project asynchronously.
     * 
     * @param id the project ID to duplicate
     * @param request the duplication request
     * @return a CompletableFuture containing the duplicated project
     */
    public CompletableFuture<Project> duplicateAsync(int id, ProjectDuplicateRequest request) {
        return duplicateAsync(id, request, null);
    }
    
    /**
     * Duplicates a project with options asynchronously.
     * 
     * @param id the project ID to duplicate
     * @param request the duplication request
     * @param options request options
     * @return a CompletableFuture containing the duplicated project
     */
    public CompletableFuture<Project> duplicateAsync(int id, ProjectDuplicateRequest request, RequestOptions options) {
        return httpClient.postAsync("/api/projects/" + id + "/duplicate/", request, Project.class);
    }
    
    /**
     * Imports predictions into a project.
     * 
     * @param id the project ID
     * @param predictions the predictions to import
     * @return import result
     */
    public PredictionImportResult importPredictions(int id, List<PredictionImportRequest> predictions) {
        return importPredictions(id, predictions, null);
    }
    
    /**
     * Imports predictions into a project with options.
     * 
     * @param id the project ID
     * @param predictions the predictions to import
     * @param options request options
     * @return import result
     */
    public PredictionImportResult importPredictions(int id, List<PredictionImportRequest> predictions, RequestOptions options) {
        return httpClient.post("/api/projects/" + id + "/import/predictions/", predictions, PredictionImportResult.class);
    }
    
    /**
     * Imports predictions into a project asynchronously.
     * 
     * @param id the project ID
     * @param predictions the predictions to import
     * @return a CompletableFuture containing the import result
     */
    public CompletableFuture<PredictionImportResult> importPredictionsAsync(int id, List<PredictionImportRequest> predictions) {
        return importPredictionsAsync(id, predictions, null);
    }
    
    /**
     * Imports predictions into a project with options asynchronously.
     * 
     * @param id the project ID
     * @param predictions the predictions to import
     * @param options request options
     * @return a CompletableFuture containing the import result
     */
    public CompletableFuture<PredictionImportResult> importPredictionsAsync(int id, List<PredictionImportRequest> predictions, RequestOptions options) {
        return httpClient.postAsync("/api/projects/" + id + "/import/predictions/", predictions, PredictionImportResult.class);
    }
    
    /**
     * Builds query string from list options.
     * 
     * @param options the list options
     * @return the query string (starting with ?)
     */
    private String buildQueryString(ProjectsListOptions options) {
        StringBuilder sb = new StringBuilder("?");
        boolean hasParam = false;
        
        if (options.getFilter() != null) {
            sb.append("filter=").append(options.getFilter());
            hasParam = true;
        }
        
        if (options.getIds() != null) {
            if (hasParam) sb.append("&");
            sb.append("ids=").append(options.getIds());
            hasParam = true;
        }
        
        if (options.getInclude() != null) {
            if (hasParam) sb.append("&");
            sb.append("include=").append(options.getInclude());
            hasParam = true;
        }
        
        if (options.getMembersLimit() != null) {
            if (hasParam) sb.append("&");
            sb.append("members_limit=").append(options.getMembersLimit());
            hasParam = true;
        }
        
        if (options.getOrdering() != null) {
            if (hasParam) sb.append("&");
            sb.append("ordering=").append(options.getOrdering());
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
        
        if (options.getTitle() != null) {
            if (hasParam) sb.append("&");
            sb.append("title=").append(options.getTitle());
            hasParam = true;
        }
        
        if (options.getWorkspaces() != null) {
            if (hasParam) sb.append("&");
            sb.append("workspaces=").append(options.getWorkspaces());
            hasParam = true;
        }
        
        return hasParam ? sb.toString() : "";
    }
}