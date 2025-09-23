package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.models.ProjectStats;
import io.labelstudio.sdk.models.IaaStats;

import java.util.concurrent.CompletableFuture;

/**
 * Client for managing project statistics in Label Studio.
 * 
 * <p>This client provides access to detailed project statistics including
 * task distribution, annotation statistics, and inter-annotator agreement (IAA).</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * ProjectStats stats = client.projects().stats(projectId).get();
 * IaaStats iaaStats = client.projects().stats(projectId).getIaa();
 * </pre>
 */
public class ProjectStatsClient {
    
    private final HttpClient httpClient;
    private final int projectId;
    
    public ProjectStatsClient(HttpClient httpClient, int projectId) {
        this.httpClient = httpClient;
        this.projectId = projectId;
    }
    
    /**
     * Gets general statistics for the project.
     * 
     * @return the project statistics
     */
    public ProjectStats get() {
        return httpClient.get("/api/projects/" + projectId + "/stats/", ProjectStats.class);
    }
    
    /**
     * Gets general statistics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the project statistics
     */
    public CompletableFuture<ProjectStats> getAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/stats/", ProjectStats.class);
    }
    
    /**
     * Gets task distribution statistics for the project.
     * 
     * @return the task distribution statistics
     */
    public ProjectStats getTaskDistribution() {
        return httpClient.get("/api/projects/" + projectId + "/stats/task-distribution/", ProjectStats.class);
    }
    
    /**
     * Gets task distribution statistics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the task distribution statistics
     */
    public CompletableFuture<ProjectStats> getTaskDistributionAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/stats/task-distribution/", ProjectStats.class);
    }
    
    /**
     * Gets annotation statistics for the project.
     * 
     * @return the annotation statistics
     */
    public ProjectStats getAnnotationStats() {
        return httpClient.get("/api/projects/" + projectId + "/stats/annotations/", ProjectStats.class);
    }
    
    /**
     * Gets annotation statistics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the annotation statistics
     */
    public CompletableFuture<ProjectStats> getAnnotationStatsAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/stats/annotations/", ProjectStats.class);
    }
    
    /**
     * Gets inter-annotator agreement (IAA) statistics for the project.
     * 
     * @return the IAA statistics
     */
    public IaaStats getIaa() {
        return httpClient.get("/api/projects/" + projectId + "/stats/iaa/", IaaStats.class);
    }
    
    /**
     * Gets inter-annotator agreement (IAA) statistics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the IAA statistics
     */
    public CompletableFuture<IaaStats> getIaaAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/stats/iaa/", IaaStats.class);
    }
    
    /**
     * Gets time-based statistics for the project.
     * 
     * @return the time-based statistics
     */
    public ProjectStats getTimeStats() {
        return httpClient.get("/api/projects/" + projectId + "/stats/time/", ProjectStats.class);
    }
    
    /**
     * Gets time-based statistics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the time-based statistics
     */
    public CompletableFuture<ProjectStats> getTimeStatsAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/stats/time/", ProjectStats.class);
    }
    
    /**
     * Gets quality statistics for the project.
     * 
     * @return the quality statistics
     */
    public ProjectStats getQualityStats() {
        return httpClient.get("/api/projects/" + projectId + "/stats/quality/", ProjectStats.class);
    }
    
    /**
     * Gets quality statistics for the project asynchronously.
     * 
     * @return a CompletableFuture containing the quality statistics
     */
    public CompletableFuture<ProjectStats> getQualityStatsAsync() {
        return httpClient.getAsync("/api/projects/" + projectId + "/stats/quality/", ProjectStats.class);
    }
}