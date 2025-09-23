package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents project metrics and statistics in Label Studio.
 */
public class ProjectMetrics {
    
    @JsonProperty("total_tasks")
    private Integer totalTasks;
    
    @JsonProperty("completed_tasks")
    private Integer completedTasks;
    
    @JsonProperty("pending_tasks")
    private Integer pendingTasks;
    
    @JsonProperty("skipped_tasks")
    private Integer skippedTasks;
    
    @JsonProperty("total_annotations")
    private Integer totalAnnotations;
    
    @JsonProperty("total_predictions")
    private Integer totalPredictions;
    
    @JsonProperty("completion_percentage")
    private Double completionPercentage;
    
    @JsonProperty("annotation_speed")
    private Double annotationSpeed;
    
    @JsonProperty("quality_score")
    private Double qualityScore;
    
    @JsonProperty("inter_annotator_agreement")
    private Double interAnnotatorAgreement;
    
    @JsonProperty("annotators_count")
    private Integer annotatorsCount;
    
    @JsonProperty("reviewers_count")
    private Integer reviewersCount;
    
    @JsonProperty("average_annotation_time")
    private Double averageAnnotationTime;
    
    @JsonProperty("annotations_per_day")
    private Map<String, Integer> annotationsPerDay;
    
    @JsonProperty("annotator_performance")
    private List<AnnotatorPerformance> annotatorPerformance;
    
    @JsonProperty("label_distribution")
    private Map<String, Integer> labelDistribution;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    // Constructors
    public ProjectMetrics() {}
    
    // Getters and Setters
    public Integer getTotalTasks() {
        return totalTasks;
    }
    
    public void setTotalTasks(Integer totalTasks) {
        this.totalTasks = totalTasks;
    }
    
    public Integer getCompletedTasks() {
        return completedTasks;
    }
    
    public void setCompletedTasks(Integer completedTasks) {
        this.completedTasks = completedTasks;
    }
    
    public Integer getPendingTasks() {
        return pendingTasks;
    }
    
    public void setPendingTasks(Integer pendingTasks) {
        this.pendingTasks = pendingTasks;
    }
    
    public Integer getSkippedTasks() {
        return skippedTasks;
    }
    
    public void setSkippedTasks(Integer skippedTasks) {
        this.skippedTasks = skippedTasks;
    }
    
    public Integer getTotalAnnotations() {
        return totalAnnotations;
    }
    
    public void setTotalAnnotations(Integer totalAnnotations) {
        this.totalAnnotations = totalAnnotations;
    }
    
    public Integer getTotalPredictions() {
        return totalPredictions;
    }
    
    public void setTotalPredictions(Integer totalPredictions) {
        this.totalPredictions = totalPredictions;
    }
    
    public Double getCompletionPercentage() {
        return completionPercentage;
    }
    
    public void setCompletionPercentage(Double completionPercentage) {
        this.completionPercentage = completionPercentage;
    }
    
    public Double getAnnotationSpeed() {
        return annotationSpeed;
    }
    
    public void setAnnotationSpeed(Double annotationSpeed) {
        this.annotationSpeed = annotationSpeed;
    }
    
    public Double getQualityScore() {
        return qualityScore;
    }
    
    public void setQualityScore(Double qualityScore) {
        this.qualityScore = qualityScore;
    }
    
    public Double getInterAnnotatorAgreement() {
        return interAnnotatorAgreement;
    }
    
    public void setInterAnnotatorAgreement(Double interAnnotatorAgreement) {
        this.interAnnotatorAgreement = interAnnotatorAgreement;
    }
    
    public Integer getAnnotatorsCount() {
        return annotatorsCount;
    }
    
    public void setAnnotatorsCount(Integer annotatorsCount) {
        this.annotatorsCount = annotatorsCount;
    }
    
    public Integer getReviewersCount() {
        return reviewersCount;
    }
    
    public void setReviewersCount(Integer reviewersCount) {
        this.reviewersCount = reviewersCount;
    }
    
    public Double getAverageAnnotationTime() {
        return averageAnnotationTime;
    }
    
    public void setAverageAnnotationTime(Double averageAnnotationTime) {
        this.averageAnnotationTime = averageAnnotationTime;
    }
    
    public Map<String, Integer> getAnnotationsPerDay() {
        return annotationsPerDay;
    }
    
    public void setAnnotationsPerDay(Map<String, Integer> annotationsPerDay) {
        this.annotationsPerDay = annotationsPerDay;
    }
    
    public List<AnnotatorPerformance> getAnnotatorPerformance() {
        return annotatorPerformance;
    }
    
    public void setAnnotatorPerformance(List<AnnotatorPerformance> annotatorPerformance) {
        this.annotatorPerformance = annotatorPerformance;
    }
    
    public Map<String, Integer> getLabelDistribution() {
        return labelDistribution;
    }
    
    public void setLabelDistribution(Map<String, Integer> labelDistribution) {
        this.labelDistribution = labelDistribution;
    }
    
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    /**
     * Represents individual annotator performance metrics.
     */
    public static class AnnotatorPerformance {
        @JsonProperty("user_id")
        private Integer userId;
        
        @JsonProperty("user_name")
        private String userName;
        
        @JsonProperty("annotations_count")
        private Integer annotationsCount;
        
        @JsonProperty("average_time")
        private Double averageTime;
        
        @JsonProperty("quality_score")
        private Double qualityScore;
        
        // Constructors
        public AnnotatorPerformance() {}
        
        // Getters and Setters
        public Integer getUserId() {
            return userId;
        }
        
        public void setUserId(Integer userId) {
            this.userId = userId;
        }
        
        public String getUserName() {
            return userName;
        }
        
        public void setUserName(String userName) {
            this.userName = userName;
        }
        
        public Integer getAnnotationsCount() {
            return annotationsCount;
        }
        
        public void setAnnotationsCount(Integer annotationsCount) {
            this.annotationsCount = annotationsCount;
        }
        
        public Double getAverageTime() {
            return averageTime;
        }
        
        public void setAverageTime(Double averageTime) {
            this.averageTime = averageTime;
        }
        
        public Double getQualityScore() {
            return qualityScore;
        }
        
        public void setQualityScore(Double qualityScore) {
            this.qualityScore = qualityScore;
        }
    }
}