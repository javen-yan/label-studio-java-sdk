package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.ActivityLog;

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
        return httpClient.getPaginated("/api/activity-logs/" + options.toQueryString(), ActivityLog.class);
    }
    
    /**
     * Lists activity logs with options asynchronously.
     * 
     * @param options the query options
     * @return a CompletableFuture containing a paginated list of activity logs
     */
    public CompletableFuture<Pagination<ActivityLog>> listAsync(ActivityLogListOptions options) {
        return httpClient.getPaginatedAsync("/api/activity-logs/" + options.toQueryString(), ActivityLog.class);
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