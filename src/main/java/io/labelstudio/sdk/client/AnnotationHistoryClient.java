package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.AnnotationHistory;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing annotation history in Label Studio.
 * 
 * <p>This client provides access to annotation change history,
 * version tracking, and revision management.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * Pagination&lt;AnnotationHistory&gt; history = client.annotationHistory().list();
 * </pre>
 */
public class AnnotationHistoryClient {
    
    private final HttpClient httpClient;
    
    public AnnotationHistoryClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all annotation history records.
     * 
     * @return a paginated list of annotation history records
     */
    public Pagination<AnnotationHistory> list() {
        return httpClient.getPaginated("/api/annotation-history/", AnnotationHistory.class);
    }
    
    /**
     * Lists all annotation history records asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of annotation history records
     */
    public CompletableFuture<Pagination<AnnotationHistory>> listAsync() {
        return httpClient.getPaginatedAsync("/api/annotation-history/", AnnotationHistory.class);
    }
    
    /**
     * Gets a specific annotation history record by ID.
     * 
     * @param historyId the history record ID
     * @return the annotation history record
     */
    public AnnotationHistory get(int historyId) {
        return httpClient.get("/api/annotation-history/" + historyId + "/", AnnotationHistory.class);
    }
    
    /**
     * Gets a specific annotation history record by ID asynchronously.
     * 
     * @param historyId the history record ID
     * @return a CompletableFuture containing the annotation history record
     */
    public CompletableFuture<AnnotationHistory> getAsync(int historyId) {
        return httpClient.getAsync("/api/annotation-history/" + historyId + "/", AnnotationHistory.class);
    }
    
    /**
     * Lists annotation history for a specific annotation.
     * 
     * @param annotationId the annotation ID
     * @return a paginated list of history records for the annotation
     */
    public Pagination<AnnotationHistory> listByAnnotation(int annotationId) {
        return httpClient.getPaginated("/api/annotation-history/?annotation=" + annotationId, AnnotationHistory.class);
    }
    
    /**
     * Lists annotation history for a specific annotation asynchronously.
     * 
     * @param annotationId the annotation ID
     * @return a CompletableFuture containing a paginated list of history records for the annotation
     */
    public CompletableFuture<Pagination<AnnotationHistory>> listByAnnotationAsync(int annotationId) {
        return httpClient.getPaginatedAsync("/api/annotation-history/?annotation=" + annotationId, AnnotationHistory.class);
    }
    
    /**
     * Lists annotation history for a specific task.
     * 
     * @param taskId the task ID
     * @return a paginated list of history records for the task
     */
    public Pagination<AnnotationHistory> listByTask(int taskId) {
        return httpClient.getPaginated("/api/annotation-history/?task=" + taskId, AnnotationHistory.class);
    }
    
    /**
     * Lists annotation history for a specific task asynchronously.
     * 
     * @param taskId the task ID
     * @return a CompletableFuture containing a paginated list of history records for the task
     */
    public CompletableFuture<Pagination<AnnotationHistory>> listByTaskAsync(int taskId) {
        return httpClient.getPaginatedAsync("/api/annotation-history/?task=" + taskId, AnnotationHistory.class);
    }
    
    /**
     * Lists annotation history for a specific user.
     * 
     * @param userId the user ID
     * @return a paginated list of history records for the user
     */
    public Pagination<AnnotationHistory> listByUser(int userId) {
        return httpClient.getPaginated("/api/annotation-history/?user=" + userId, AnnotationHistory.class);
    }
    
    /**
     * Lists annotation history for a specific user asynchronously.
     * 
     * @param userId the user ID
     * @return a CompletableFuture containing a paginated list of history records for the user
     */
    public CompletableFuture<Pagination<AnnotationHistory>> listByUserAsync(int userId) {
        return httpClient.getPaginatedAsync("/api/annotation-history/?user=" + userId, AnnotationHistory.class);
    }
    
    /**
     * Restores an annotation to a specific version from history.
     * 
     * @param historyId the history record ID to restore from
     * @return the restored annotation
     */
    public AnnotationHistory restore(int historyId) {
        return httpClient.post("/api/annotation-history/" + historyId + "/restore/", null, AnnotationHistory.class);
    }
    
    /**
     * Restores an annotation to a specific version from history asynchronously.
     * 
     * @param historyId the history record ID to restore from
     * @return a CompletableFuture containing the restored annotation
     */
    public CompletableFuture<AnnotationHistory> restoreAsync(int historyId) {
        return httpClient.postAsync("/api/annotation-history/" + historyId + "/restore/", null, AnnotationHistory.class);
    }
    
    /**
     * Lists annotation history for a specific project.
     * 
     * @param projectId the project ID
     * @return a paginated list of history records for the project
     */
    public Pagination<AnnotationHistory> listByProject(int projectId) {
        return httpClient.getPaginated("/api/projects/" + projectId + "/annotation-history/", AnnotationHistory.class);
    }
    
    /**
     * Lists annotation history for a specific project asynchronously.
     * 
     * @param projectId the project ID
     * @return a CompletableFuture containing a paginated list of history records for the project
     */
    public CompletableFuture<Pagination<AnnotationHistory>> listByProjectAsync(int projectId) {
        return httpClient.getPaginatedAsync("/api/projects/" + projectId + "/annotation-history/", AnnotationHistory.class);
    }
    
    /**
     * Deletes annotation history items.
     * 
     * @param historyId the history record ID to delete
     */
    public void delete(int historyId) {
        httpClient.delete("/api/annotation-history/" + historyId + "/");
    }
    
    /**
     * Deletes annotation history items asynchronously.
     * 
     * @param historyId the history record ID to delete
     * @return a CompletableFuture that completes when the history record is deleted
     */
    public CompletableFuture<Void> deleteAsync(int historyId) {
        return httpClient.deleteAsync("/api/annotation-history/" + historyId + "/");
    }
}