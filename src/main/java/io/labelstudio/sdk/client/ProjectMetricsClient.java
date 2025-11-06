package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.models.ProjectMetrics;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing project metrics in Label Studio.
 * 
 * <p>This client provides access to project-level metrics and statistics
 * such as annotation progress, task completion rates, and custom metrics.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * ProjectMetrics metrics = client.projects().metrics(projectId).get();
 * </pre>
 */
public class ProjectMetricsClient {
    
    private final HttpClient httpClient;
    private final int projectId;
    
    public ProjectMetricsClient(HttpClient httpClient, int projectId) {
        this.httpClient = httpClient;
        this.projectId = projectId;
    }
    
    /**
     * Gets general metrics for the project.
     * 
     * @return the project metrics
     */
    public ProjectMetrics get() {
        return httpClient.get("/api/projects/" + projectId + "/metrics/", ProjectMetrics.class);
    }
    
    /**
     * Gets general metrics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the project metrics
     */
    public CompletableFuture<ProjectMetrics> getAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/metrics/", ProjectMetrics.class);
    }
    
    /**
     * Gets annotation progress metrics for the project.
     * 
     * @return the annotation progress metrics
     */
    public ProjectMetrics getAnnotationProgress() {
        return httpClient.get("/api/projects/" + projectId + "/metrics/annotation-progress/", ProjectMetrics.class);
    }
    
    /**
     * Gets annotation progress metrics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the annotation progress metrics
     */
    public CompletableFuture<ProjectMetrics> getAnnotationProgressAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/metrics/annotation-progress/", ProjectMetrics.class);
    }
    
    /**
     * Gets task completion metrics for the project.
     * 
     * @return the task completion metrics
     */
    public ProjectMetrics getTaskCompletion() {
        return httpClient.get("/api/projects/" + projectId + "/metrics/task-completion/", ProjectMetrics.class);
    }
    
    /**
     * Gets task completion metrics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the task completion metrics
     */
    public CompletableFuture<ProjectMetrics> getTaskCompletionAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/metrics/task-completion/", ProjectMetrics.class);
    }
    
    /**
     * Gets annotator performance metrics for the project.
     * 
     * @return the annotator performance metrics
     */
    public ProjectMetrics getAnnotatorPerformance() {
        return httpClient.get("/api/projects/" + projectId + "/metrics/annotator-performance/", ProjectMetrics.class);
    }
    
    /**
     * Gets annotator performance metrics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the annotator performance metrics
     */
    public CompletableFuture<ProjectMetrics> getAnnotatorPerformanceAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/metrics/annotator-performance/", ProjectMetrics.class);
    }
    
    /**
     * Gets quality metrics for the project.
     * 
     * @return the quality metrics
     */
    public ProjectMetrics getQuality() {
        return httpClient.get("/api/projects/" + projectId + "/metrics/quality/", ProjectMetrics.class);
    }
    
    /**
     * Gets quality metrics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the quality metrics
     */
    public CompletableFuture<ProjectMetrics> getQualityAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/metrics/quality/", ProjectMetrics.class);
    }
}