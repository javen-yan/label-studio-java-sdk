package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Represents Inter-Annotator Agreement (IAA) statistics in Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  
public class IaaStats {
    
    @JsonProperty("project_id")
    private Integer projectId;
    
    @JsonProperty("overall_agreement")
    private Double overallAgreement;
    
    @JsonProperty("kappa_score")
    private Double kappaScore;
    
    @JsonProperty("fleiss_kappa")
    private Double fleissKappa;
    
    @JsonProperty("krippendorff_alpha")
    private Double krippendorffAlpha;
    
    @JsonProperty("agreement_matrix")
    private List<List<Double>> agreementMatrix;
    
    @JsonProperty("annotator_pairs")
    private List<AnnotatorPairAgreement> annotatorPairs;
    
    @JsonProperty("label_agreement")
    private Map<String, Double> labelAgreement;
    
    @JsonProperty("task_agreement")
    private Map<Integer, Double> taskAgreement;
    
    @JsonProperty("confidence_interval")
    private ConfidenceInterval confidenceInterval;
    
    @JsonProperty("sample_size")
    private Integer sampleSize;
    
    @JsonProperty("annotators_count")
    private Integer annotatorsCount;

    /**
     * Represents agreement between a pair of annotators.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode  
    public static class AnnotatorPairAgreement {
        @JsonProperty("annotator1_id")
        private Integer annotator1Id;
        
        @JsonProperty("annotator1_name")
        private String annotator1Name;
        
        @JsonProperty("annotator2_id")
        private Integer annotator2Id;
        
        @JsonProperty("annotator2_name")
        private String annotator2Name;
        
        @JsonProperty("agreement_score")
        private Double agreementScore;
        
        @JsonProperty("kappa_score")
        private Double kappaScore;
        
        @JsonProperty("common_tasks")
        private Integer commonTasks;
    }
    
    /**
     * Represents a confidence interval for agreement scores.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode  
    public static class ConfidenceInterval {
        @JsonProperty("lower_bound")
        private Double lowerBound;
        
        @JsonProperty("upper_bound")
        private Double upperBound;
        
        @JsonProperty("confidence_level")
        private Double confidenceLevel;
    }
}