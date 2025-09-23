package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents detailed project statistics in Label Studio.
 */
public class ProjectStats {
    
    @JsonProperty("project_id")
    private Integer projectId;
    
    @JsonProperty("total_tasks")
    private Integer totalTasks;
    
    @JsonProperty("completed_tasks")
    private Integer completedTasks;
    
    @JsonProperty("pending_tasks")
    private Integer pendingTasks;
    
    @JsonProperty("skipped_tasks")
    private Integer skippedTasks;
    
    @JsonProperty("reviewed_tasks")
    private Integer reviewedTasks;
    
    @JsonProperty("total_annotations")
    private Integer totalAnnotations;
    
    @JsonProperty("total_predictions")
    private Integer totalPredictions;
    
    @JsonProperty("task_distribution")
    private Map<String, Integer> taskDistribution;
    
    @JsonProperty("annotation_distribution")
    private Map<String, Integer> annotationDistribution;
    
    @JsonProperty("annotator_stats")
    private List<AnnotatorStats> annotatorStats;
    
    @JsonProperty("label_stats")
    private Map<String, LabelStats> labelStats;
    
    @JsonProperty("time_stats")
    private TimeStats timeStats;
    
    @JsonProperty("quality_stats")
    private QualityStats qualityStats;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    // Constructors
    public ProjectStats() {}
    
    // Getters and Setters
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
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
    
    public Integer getReviewedTasks() {
        return reviewedTasks;
    }
    
    public void setReviewedTasks(Integer reviewedTasks) {
        this.reviewedTasks = reviewedTasks;
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
    
    public Map<String, Integer> getTaskDistribution() {
        return taskDistribution;
    }
    
    public void setTaskDistribution(Map<String, Integer> taskDistribution) {
        this.taskDistribution = taskDistribution;
    }
    
    public Map<String, Integer> getAnnotationDistribution() {
        return annotationDistribution;
    }
    
    public void setAnnotationDistribution(Map<String, Integer> annotationDistribution) {
        this.annotationDistribution = annotationDistribution;
    }
    
    public List<AnnotatorStats> getAnnotatorStats() {
        return annotatorStats;
    }
    
    public void setAnnotatorStats(List<AnnotatorStats> annotatorStats) {
        this.annotatorStats = annotatorStats;
    }
    
    public Map<String, LabelStats> getLabelStats() {
        return labelStats;
    }
    
    public void setLabelStats(Map<String, LabelStats> labelStats) {
        this.labelStats = labelStats;
    }
    
    public TimeStats getTimeStats() {
        return timeStats;
    }
    
    public void setTimeStats(TimeStats timeStats) {
        this.timeStats = timeStats;
    }
    
    public QualityStats getQualityStats() {
        return qualityStats;
    }
    
    public void setQualityStats(QualityStats qualityStats) {
        this.qualityStats = qualityStats;
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
     * Represents individual annotator statistics.
     */
    public static class AnnotatorStats {
        @JsonProperty("user_id")
        private Integer userId;
        
        @JsonProperty("user_name")
        private String userName;
        
        @JsonProperty("total_annotations")
        private Integer totalAnnotations;
        
        @JsonProperty("completed_tasks")
        private Integer completedTasks;
        
        @JsonProperty("average_time_per_task")
        private Double averageTimePerTask;
        
        @JsonProperty("accuracy_score")
        private Double accuracyScore;
        
        // Constructors
        public AnnotatorStats() {}
        
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
        
        public Integer getTotalAnnotations() {
            return totalAnnotations;
        }
        
        public void setTotalAnnotations(Integer totalAnnotations) {
            this.totalAnnotations = totalAnnotations;
        }
        
        public Integer getCompletedTasks() {
            return completedTasks;
        }
        
        public void setCompletedTasks(Integer completedTasks) {
            this.completedTasks = completedTasks;
        }
        
        public Double getAverageTimePerTask() {
            return averageTimePerTask;
        }
        
        public void setAverageTimePerTask(Double averageTimePerTask) {
            this.averageTimePerTask = averageTimePerTask;
        }
        
        public Double getAccuracyScore() {
            return accuracyScore;
        }
        
        public void setAccuracyScore(Double accuracyScore) {
            this.accuracyScore = accuracyScore;
        }
    }
    
    /**
     * Represents label-specific statistics.
     */
    public static class LabelStats {
        @JsonProperty("label_name")
        private String labelName;
        
        @JsonProperty("count")
        private Integer count;
        
        @JsonProperty("percentage")
        private Double percentage;
        
        // Constructors
        public LabelStats() {}
        
        // Getters and Setters
        public String getLabelName() {
            return labelName;
        }
        
        public void setLabelName(String labelName) {
            this.labelName = labelName;
        }
        
        public Integer getCount() {
            return count;
        }
        
        public void setCount(Integer count) {
            this.count = count;
        }
        
        public Double getPercentage() {
            return percentage;
        }
        
        public void setPercentage(Double percentage) {
            this.percentage = percentage;
        }
    }
    
    /**
     * Represents time-based statistics.
     */
    public static class TimeStats {
        @JsonProperty("average_annotation_time")
        private Double averageAnnotationTime;
        
        @JsonProperty("median_annotation_time")
        private Double medianAnnotationTime;
        
        @JsonProperty("total_annotation_time")
        private Double totalAnnotationTime;
        
        @JsonProperty("fastest_annotation")
        private Double fastestAnnotation;
        
        @JsonProperty("slowest_annotation")
        private Double slowestAnnotation;
        
        // Constructors
        public TimeStats() {}
        
        // Getters and Setters
        public Double getAverageAnnotationTime() {
            return averageAnnotationTime;
        }
        
        public void setAverageAnnotationTime(Double averageAnnotationTime) {
            this.averageAnnotationTime = averageAnnotationTime;
        }
        
        public Double getMedianAnnotationTime() {
            return medianAnnotationTime;
        }
        
        public void setMedianAnnotationTime(Double medianAnnotationTime) {
            this.medianAnnotationTime = medianAnnotationTime;
        }
        
        public Double getTotalAnnotationTime() {
            return totalAnnotationTime;
        }
        
        public void setTotalAnnotationTime(Double totalAnnotationTime) {
            this.totalAnnotationTime = totalAnnotationTime;
        }
        
        public Double getFastestAnnotation() {
            return fastestAnnotation;
        }
        
        public void setFastestAnnotation(Double fastestAnnotation) {
            this.fastestAnnotation = fastestAnnotation;
        }
        
        public Double getSlowestAnnotation() {
            return slowestAnnotation;
        }
        
        public void setSlowestAnnotation(Double slowestAnnotation) {
            this.slowestAnnotation = slowestAnnotation;
        }
    }
    
    /**
     * Represents quality-related statistics.
     */
    public static class QualityStats {
        @JsonProperty("average_quality_score")
        private Double averageQualityScore;
        
        @JsonProperty("agreement_rate")
        private Double agreementRate;
        
        @JsonProperty("consistency_score")
        private Double consistencyScore;
        
        @JsonProperty("reviewed_annotations")
        private Integer reviewedAnnotations;
        
        @JsonProperty("accepted_annotations")
        private Integer acceptedAnnotations;
        
        @JsonProperty("rejected_annotations")
        private Integer rejectedAnnotations;
        
        // Constructors
        public QualityStats() {}
        
        // Getters and Setters
        public Double getAverageQualityScore() {
            return averageQualityScore;
        }
        
        public void setAverageQualityScore(Double averageQualityScore) {
            this.averageQualityScore = averageQualityScore;
        }
        
        public Double getAgreementRate() {
            return agreementRate;
        }
        
        public void setAgreementRate(Double agreementRate) {
            this.agreementRate = agreementRate;
        }
        
        public Double getConsistencyScore() {
            return consistencyScore;
        }
        
        public void setConsistencyScore(Double consistencyScore) {
            this.consistencyScore = consistencyScore;
        }
        
        public Integer getReviewedAnnotations() {
            return reviewedAnnotations;
        }
        
        public void setReviewedAnnotations(Integer reviewedAnnotations) {
            this.reviewedAnnotations = reviewedAnnotations;
        }
        
        public Integer getAcceptedAnnotations() {
            return acceptedAnnotations;
        }
        
        public void setAcceptedAnnotations(Integer acceptedAnnotations) {
            this.acceptedAnnotations = acceptedAnnotations;
        }
        
        public Integer getRejectedAnnotations() {
            return rejectedAnnotations;
        }
        
        public void setRejectedAnnotations(Integer rejectedAnnotations) {
            this.rejectedAnnotations = rejectedAnnotations;
        }
    }
}