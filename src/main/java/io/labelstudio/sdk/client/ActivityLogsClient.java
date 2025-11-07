package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.ActivityLog;
import io.labelstudio.sdk.vo.ActivityLogListOptions;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing activity logs in Label Studio.
 * 
 * <p>This client provides access to system and project activity logs,
 * including user actions, system events, and audit trails.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * Pagination&lt;ActivityLog&gt; logs = client.activityLogs().list();
 * </pre>
 */
public class ActivityLogsClient {
    
    private final HttpClient httpClient;
    
    public ActivityLogsClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all activity logs.
     * 
     * @return a paginated list of activity logs
     */
    public Pagination<ActivityLog> list() {
        return httpClient.getPaginated("/api/activity-logs/", ActivityLog.class);
    }
    
    /**
     * Lists all activity logs asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of activity logs
     */
    public CompletableFuture<Pagination<ActivityLog>> listAsync() {
        return httpClient.getPaginatedAsync("/api/activity-logs/", ActivityLog.class);
    }
    
    /**
     * Lists activity logs with options.
     * 
     * @param options the query options
     * @return a paginated list of activity logs
     */
    public Pagination<ActivityLog> list(ActivityLogListOptions options) {
        String path = "/api/activity-logs/";
        if (options != null) {
            path += buildQueryString(options);
        }
        return httpClient.getPaginated(path, ActivityLog.class);
    }
    
    /**
     * Lists activity logs with options asynchronously.
     * 
     * @param options the query options
     * @return a CompletableFuture containing a paginated list of activity logs
     */
    public CompletableFuture<Pagination<ActivityLog>> listAsync(ActivityLogListOptions options) {
        String path = "/api/activity-logs/";
        if (options != null) {
            path += buildQueryString(options);
        }
        return httpClient.getPaginatedAsync(path, ActivityLog.class);
    }
    
    /**
     * Builds the query string for the activity logs list.
     * 
     * @param options the list options
     * @return the query string
     */
    private String buildQueryString(ActivityLogListOptions options) {
        if (options == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder("?");
        boolean hasParam = false;
        
        if (options.getProject() != null) {
            sb.append("project=").append(options.getProject());
            hasParam = true;
        }
        
        if (options.getUser() != null) {
            if (hasParam) sb.append("&");
            sb.append("user=").append(options.getUser());
            hasParam = true;
        }
        
        if (options.getAction() != null) {
            if (hasParam) sb.append("&");
            sb.append("action=").append(options.getAction());
            hasParam = true;
        }
        
        if (options.getObjectType() != null) {
            if (hasParam) sb.append("&");
            sb.append("object_type=").append(options.getObjectType());
            hasParam = true;
        }
        
        if (options.getObjectId() != null) {
            if (hasParam) sb.append("&");
            sb.append("object_id=").append(options.getObjectId());
            hasParam = true;
        }
        
        if (options.getStartDate() != null) {
            if (hasParam) sb.append("&");
            sb.append("start_date=").append(options.getStartDate());
            hasParam = true;
        }
        
        if (options.getEndDate() != null) {
            if (hasParam) sb.append("&");
            sb.append("end_date=").append(options.getEndDate());
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
        
        return hasParam ? sb.toString() : "";
    }
    
    /**
     * Gets a specific activity log by ID.
     * 
     * @param logId the log ID
     * @return the activity log
     */
    public ActivityLog get(int logId) {
        return httpClient.get("/api/activity-logs/" + logId + "/", ActivityLog.class);
    }
    
    /**
     * Gets a specific activity log by ID asynchronously.
     * 
     * @param logId the log ID
     * @return a CompletableFuture containing the activity log
     */
    public CompletableFuture<ActivityLog> getAsync(int logId) {
        return httpClient.getAsync("/api/activity-logs/" + logId + "/", ActivityLog.class);
    }
    
    /**
     * Lists activity logs for a specific project.
     * 
     * @param projectId the project ID
     * @return a paginated list of activity logs for the project
     */
    public Pagination<ActivityLog> listByProject(int projectId) {
        return httpClient.getPaginated("/api/activity-logs/?project=" + projectId, ActivityLog.class);
    }
    
    /**
     * Lists activity logs for a specific project asynchronously.
     * 
     * @param projectId the project ID
     * @return a CompletableFuture containing a paginated list of activity logs for the project
     */
    public CompletableFuture<Pagination<ActivityLog>> listByProjectAsync(int projectId) {
        return httpClient.getPaginatedAsync("/api/activity-logs/?project=" + projectId, ActivityLog.class);
    }
    
    /**
     * Lists activity logs for a specific user.
     * 
     * @param userId the user ID
     * @return a paginated list of activity logs for the user
     */
    public Pagination<ActivityLog> listByUser(int userId) {
        return httpClient.getPaginated("/api/activity-logs/?user=" + userId, ActivityLog.class);
    }
    
    /**
     * Lists activity logs for a specific user asynchronously.
     * 
     * @param userId the user ID
     * @return a CompletableFuture containing a paginated list of activity logs for the user
     */
    public CompletableFuture<Pagination<ActivityLog>> listByUserAsync(int userId) {
        return httpClient.getPaginatedAsync("/api/activity-logs/?user=" + userId, ActivityLog.class);
    }
    
    /**
     * Lists activity logs by action type.
     * 
     * @param actionType the action type (e.g., "create", "update", "delete")
     * @return a paginated list of activity logs for the action type
     */
    public Pagination<ActivityLog> listByActionType(String actionType) {
        return httpClient.getPaginated("/api/activity-logs/?action=" + actionType, ActivityLog.class);
    }
    
    /**
     * Lists activity logs by action type asynchronously.
     * 
     * @param actionType the action type (e.g., "create", "update", "delete")
     * @return a CompletableFuture containing a paginated list of activity logs for the action type
     */
    public CompletableFuture<Pagination<ActivityLog>> listByActionTypeAsync(String actionType) {
        return httpClient.getPaginatedAsync("/api/activity-logs/?action=" + actionType, ActivityLog.class);
    }
}