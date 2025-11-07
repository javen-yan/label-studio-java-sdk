package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents detailed project statistics in Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
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
    
    /**
     * Represents individual annotator statistics.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @JsonIgnoreProperties(ignoreUnknown = true)
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
    }
    
    /**
     * Represents label-specific statistics.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LabelStats {
        @JsonProperty("label_name")
        private String labelName;
        
        @JsonProperty("count")
        private Integer count;
        
        @JsonProperty("percentage")
        private Double percentage;
    }
    
    /**
     * Represents time-based statistics.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @JsonIgnoreProperties(ignoreUnknown = true)
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
    }
    
    /**
     * Represents quality-related statistics.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @JsonIgnoreProperties(ignoreUnknown = true)
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
    }
}