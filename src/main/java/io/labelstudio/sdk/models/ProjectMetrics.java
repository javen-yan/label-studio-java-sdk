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
 * Represents project metrics and statistics in Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  
@JsonIgnoreProperties(ignoreUnknown = true)
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
    
    /**
     * Represents individual annotator performance metrics.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode  
    @JsonIgnoreProperties(ignoreUnknown = true)
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
    }
}