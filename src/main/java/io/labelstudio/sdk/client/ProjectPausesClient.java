package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.ProjectPause;
import io.labelstudio.sdk.vo.PauseCreateRequest;
import io.labelstudio.sdk.vo.PauseUpdateRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing project pauses in Label Studio.
 * 
 * <p>This client provides functionality to pause and resume projects,
 * track pause history, and manage pause-related operations.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * ProjectPause pause = client.projects().pauses(projectId).create(
 *     PauseCreateRequest.builder()
 *         .reason("Maintenance")
 *         .build()
 * );
 * </pre>
 */
public class ProjectPausesClient {
    
    private final HttpClient httpClient;
    private final int projectId;
    
    public ProjectPausesClient(HttpClient httpClient, int projectId) {
        this.httpClient = httpClient;
        this.projectId = projectId;
    }
    
    /**
     * Lists all pauses for the project.
     * 
     * @return a paginated list of project pauses
     */
    public Pagination<ProjectPause> list() {
        return httpClient.getPaginated("/api/projects/" + projectId + "/pauses/", ProjectPause.class);
    }
    
    /**
     * Lists all pauses for the project asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of project pauses
     */
    public CompletableFuture<Pagination<ProjectPause>> listAsync() {
        return httpClient.getPaginatedAsync("/api/projects/" + projectId + "/pauses/", ProjectPause.class);
    }
    
    /**
     * Creates a new pause (pauses the project).
     * 
     * @param request the pause creation request
     * @return the created pause
     */
    public ProjectPause create(PauseCreateRequest request) {
        return httpClient.post("/api/projects/" + projectId + "/pauses/", request, ProjectPause.class);
    }
    
    /**
     * Creates a new pause (pauses the project) asynchronously.
     * 
     * @param request the pause creation request
     * @return a CompletableFuture containing the created pause
     */
    public CompletableFuture<ProjectPause> createAsync(PauseCreateRequest request) {
        return httpClient.postAsync("/api/projects/" + projectId + "/pauses/", request, ProjectPause.class);
    }
    
    /**
     * Gets a specific pause by ID.
     * 
     * @param pauseId the pause ID
     * @return the pause
     */
    public ProjectPause get(int pauseId) {
        return httpClient.get("/api/projects/" + projectId + "/pauses/" + pauseId + "/", ProjectPause.class);
    }
    
    /**
     * Gets a specific pause by ID asynchronously.
     * 
     * @param pauseId the pause ID
     * @return a CompletableFuture containing the pause
     */
    public CompletableFuture<ProjectPause> getAsync(int pauseId) {
        return httpClient.getAsync("/api/projects/" + projectId + "/pauses/" + pauseId + "/", ProjectPause.class);
    }
    
    /**
     * Updates a pause (can be used to resume).
     * 
     * @param pauseId the pause ID
     * @param request the pause update request
     * @return the updated pause
     */
    public ProjectPause update(int pauseId, PauseUpdateRequest request) {
        return httpClient.patch("/api/projects/" + projectId + "/pauses/" + pauseId + "/", request, ProjectPause.class);
    }
    
    /**
     * Updates a pause (can be used to resume) asynchronously.
     * 
     * @param pauseId the pause ID
     * @param request the pause update request
     * @return a CompletableFuture containing the updated pause
     */
    public CompletableFuture<ProjectPause> updateAsync(int pauseId, PauseUpdateRequest request) {
        return httpClient.patchAsync("/api/projects/" + projectId + "/pauses/" + pauseId + "/", request, ProjectPause.class);
    }
    
    /**
     * Deletes a pause record.
     * 
     * @param pauseId the pause ID
     */
    public void delete(int pauseId) {
        httpClient.delete("/api/projects/" + projectId + "/pauses/" + pauseId + "/");
    }
    
    /**
     * Deletes a pause record asynchronously.
     * 
     * @param pauseId the pause ID
     * @return a CompletableFuture that completes when the pause is deleted
     */
    public CompletableFuture<Void> deleteAsync(int pauseId) {
        return httpClient.deleteAsync("/api/projects/" + projectId + "/pauses/" + pauseId + "/");
    }
    
    /**
     * Gets the current active pause (if any).
     * 
     * @return the current active pause, or null if project is not paused
     */
    public ProjectPause getCurrentPause() {
        return httpClient.get("/api/projects/" + projectId + "/pauses/current/", ProjectPause.class);
    }
    
    /**
     * Gets the current active pause (if any) asynchronously.
     * 
     * @return a CompletableFuture containing the current active pause, or null if project is not paused
     */
    public CompletableFuture<ProjectPause> getCurrentPauseAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/pauses/current/", ProjectPause.class);
    }
    
    /**
     * Pauses the project with a simple reason.
     * 
     * @param reason the reason for pausing
     * @return the created pause
     */
    public ProjectPause pause(String reason) {
        return create(PauseCreateRequest.builder().reason(reason).build());
    }
    
    /**
     * Pauses the project with a simple reason asynchronously.
     * 
     * @param reason the reason for pausing
     * @return a CompletableFuture containing the created pause
     */
    public CompletableFuture<ProjectPause> pauseAsync(String reason) {
        return createAsync(PauseCreateRequest.builder().reason(reason).build());
    }
    
    /**
     * Resumes the project by ending the current pause.
     * 
     * @return the updated pause record
     */
    public ProjectPause resume() {
        ProjectPause currentPause = getCurrentPause();
        if (currentPause != null && currentPause.isActive()) {
            return update(currentPause.getId(), PauseUpdateRequest.builder()
                    .status("resumed")
                    .resumedAt(java.time.OffsetDateTime.now())
                    .build());
        }
        return null;
    }
    
    /**
     * Resumes the project by ending the current pause asynchronously.
     * 
     * @return a CompletableFuture containing the updated pause record
     */
    public CompletableFuture<ProjectPause> resumeAsync() {
        return getCurrentPauseAsync().thenCompose(currentPause -> {
            if (currentPause != null && currentPause.isActive()) {
                return updateAsync(currentPause.getId(), PauseUpdateRequest.builder()
                        .status("resumed")
                        .resumedAt(java.time.OffsetDateTime.now())
                        .build());
            }
            return CompletableFuture.completedFuture(null);
        });
    }
}