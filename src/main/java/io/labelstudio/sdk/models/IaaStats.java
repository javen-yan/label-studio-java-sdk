package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Represents Inter-Annotator Agreement (IAA) statistics in Label Studio.
 */
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
    
    // Constructors
    public IaaStats() {}
    
    // Getters and Setters
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    public Double getOverallAgreement() {
        return overallAgreement;
    }
    
    public void setOverallAgreement(Double overallAgreement) {
        this.overallAgreement = overallAgreement;
    }
    
    public Double getKappaScore() {
        return kappaScore;
    }
    
    public void setKappaScore(Double kappaScore) {
        this.kappaScore = kappaScore;
    }
    
    public Double getFleissKappa() {
        return fleissKappa;
    }
    
    public void setFleissKappa(Double fleissKappa) {
        this.fleissKappa = fleissKappa;
    }
    
    public Double getKrippendorffAlpha() {
        return krippendorffAlpha;
    }
    
    public void setKrippendorffAlpha(Double krippendorffAlpha) {
        this.krippendorffAlpha = krippendorffAlpha;
    }
    
    public List<List<Double>> getAgreementMatrix() {
        return agreementMatrix;
    }
    
    public void setAgreementMatrix(List<List<Double>> agreementMatrix) {
        this.agreementMatrix = agreementMatrix;
    }
    
    public List<AnnotatorPairAgreement> getAnnotatorPairs() {
        return annotatorPairs;
    }
    
    public void setAnnotatorPairs(List<AnnotatorPairAgreement> annotatorPairs) {
        this.annotatorPairs = annotatorPairs;
    }
    
    public Map<String, Double> getLabelAgreement() {
        return labelAgreement;
    }
    
    public void setLabelAgreement(Map<String, Double> labelAgreement) {
        this.labelAgreement = labelAgreement;
    }
    
    public Map<Integer, Double> getTaskAgreement() {
        return taskAgreement;
    }
    
    public void setTaskAgreement(Map<Integer, Double> taskAgreement) {
        this.taskAgreement = taskAgreement;
    }
    
    public ConfidenceInterval getConfidenceInterval() {
        return confidenceInterval;
    }
    
    public void setConfidenceInterval(ConfidenceInterval confidenceInterval) {
        this.confidenceInterval = confidenceInterval;
    }
    
    public Integer getSampleSize() {
        return sampleSize;
    }
    
    public void setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
    }
    
    public Integer getAnnotatorsCount() {
        return annotatorsCount;
    }
    
    public void setAnnotatorsCount(Integer annotatorsCount) {
        this.annotatorsCount = annotatorsCount;
    }
    
    /**
     * Represents agreement between a pair of annotators.
     */
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
        
        // Constructors
        public AnnotatorPairAgreement() {}
        
        // Getters and Setters
        public Integer getAnnotator1Id() {
            return annotator1Id;
        }
        
        public void setAnnotator1Id(Integer annotator1Id) {
            this.annotator1Id = annotator1Id;
        }
        
        public String getAnnotator1Name() {
            return annotator1Name;
        }
        
        public void setAnnotator1Name(String annotator1Name) {
            this.annotator1Name = annotator1Name;
        }
        
        public Integer getAnnotator2Id() {
            return annotator2Id;
        }
        
        public void setAnnotator2Id(Integer annotator2Id) {
            this.annotator2Id = annotator2Id;
        }
        
        public String getAnnotator2Name() {
            return annotator2Name;
        }
        
        public void setAnnotator2Name(String annotator2Name) {
            this.annotator2Name = annotator2Name;
        }
        
        public Double getAgreementScore() {
            return agreementScore;
        }
        
        public void setAgreementScore(Double agreementScore) {
            this.agreementScore = agreementScore;
        }
        
        public Double getKappaScore() {
            return kappaScore;
        }
        
        public void setKappaScore(Double kappaScore) {
            this.kappaScore = kappaScore;
        }
        
        public Integer getCommonTasks() {
            return commonTasks;
        }
        
        public void setCommonTasks(Integer commonTasks) {
            this.commonTasks = commonTasks;
        }
    }
    
    /**
     * Represents a confidence interval for agreement scores.
     */
    public static class ConfidenceInterval {
        @JsonProperty("lower_bound")
        private Double lowerBound;
        
        @JsonProperty("upper_bound")
        private Double upperBound;
        
        @JsonProperty("confidence_level")
        private Double confidenceLevel;
        
        // Constructors
        public ConfidenceInterval() {}
        
        // Getters and Setters
        public Double getLowerBound() {
            return lowerBound;
        }
        
        public void setLowerBound(Double lowerBound) {
            this.lowerBound = lowerBound;
        }
        
        public Double getUpperBound() {
            return upperBound;
        }
        
        public void setUpperBound(Double upperBound) {
            this.upperBound = upperBound;
        }
        
        public Double getConfidenceLevel() {
            return confidenceLevel;
        }
        
        public void setConfidenceLevel(Double confidenceLevel) {
            this.confidenceLevel = confidenceLevel;
        }
    }
}