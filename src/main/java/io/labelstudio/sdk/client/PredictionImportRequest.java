package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Request object for importing predictions.
 */
public class PredictionImportRequest {
    
    @JsonProperty("result")
    private List<Map<String, Object>> result;
    
    @JsonProperty("score")
    private Double score;
    
    @JsonProperty("cluster")
    private Integer cluster;
    
    @JsonProperty("neighbors")
    private List<Map<String, Object>> neighbors;
    
    @JsonProperty("mislabeling")
    private Double mislabeling;
    
    @JsonProperty("task")
    private Integer task;
    
    @JsonProperty("model_version")
    private String modelVersion;
    
    /**
     * Default constructor.
     */
    public PredictionImportRequest() {
    }
    
    /**
     * Gets the prediction result.
     * 
     * @return the prediction result
     */
    public List<Map<String, Object>> getResult() {
        return result;
    }
    
    /**
     * Sets the prediction result.
     * 
     * @param result the prediction result
     */
    public void setResult(List<Map<String, Object>> result) {
        this.result = result;
    }
    
    /**
     * Gets the prediction score.
     * 
     * @return the prediction score
     */
    public Double getScore() {
        return score;
    }
    
    /**
     * Sets the prediction score.
     * 
     * @param score the prediction score
     */
    public void setScore(Double score) {
        this.score = score;
    }
    
    /**
     * Gets the cluster ID.
     * 
     * @return the cluster ID
     */
    public Integer getCluster() {
        return cluster;
    }
    
    /**
     * Sets the cluster ID.
     * 
     * @param cluster the cluster ID
     */
    public void setCluster(Integer cluster) {
        this.cluster = cluster;
    }
    
    /**
     * Gets the neighbors.
     * 
     * @return the neighbors
     */
    public List<Map<String, Object>> getNeighbors() {
        return neighbors;
    }
    
    /**
     * Sets the neighbors.
     * 
     * @param neighbors the neighbors
     */
    public void setNeighbors(List<Map<String, Object>> neighbors) {
        this.neighbors = neighbors;
    }
    
    /**
     * Gets the mislabeling score.
     * 
     * @return the mislabeling score
     */
    public Double getMislabeling() {
        return mislabeling;
    }
    
    /**
     * Sets the mislabeling score.
     * 
     * @param mislabeling the mislabeling score
     */
    public void setMislabeling(Double mislabeling) {
        this.mislabeling = mislabeling;
    }
    
    /**
     * Gets the task ID.
     * 
     * @return the task ID
     */
    public Integer getTask() {
        return task;
    }
    
    /**
     * Sets the task ID.
     * 
     * @param task the task ID
     */
    public void setTask(Integer task) {
        this.task = task;
    }
    
    /**
     * Gets the model version.
     * 
     * @return the model version
     */
    public String getModelVersion() {
        return modelVersion;
    }
    
    /**
     * Sets the model version.
     * 
     * @param modelVersion the model version
     */
    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }
    
    /**
     * Creates a new builder for PredictionImportRequest.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for PredictionImportRequest.
     */
    public static class Builder {
        private final PredictionImportRequest request = new PredictionImportRequest();
        
        /**
         * Sets the prediction result.
         * 
         * @param result the prediction result
         * @return this builder
         */
        public Builder result(List<Map<String, Object>> result) {
            request.setResult(result);
            return this;
        }
        
        /**
         * Sets the prediction score.
         * 
         * @param score the prediction score
         * @return this builder
         */
        public Builder score(double score) {
            request.setScore(score);
            return this;
        }
        
        /**
         * Sets the cluster ID.
         * 
         * @param cluster the cluster ID
         * @return this builder
         */
        public Builder cluster(int cluster) {
            request.setCluster(cluster);
            return this;
        }
        
        /**
         * Sets the neighbors.
         * 
         * @param neighbors the neighbors
         * @return this builder
         */
        public Builder neighbors(List<Map<String, Object>> neighbors) {
            request.setNeighbors(neighbors);
            return this;
        }
        
        /**
         * Sets the mislabeling score.
         * 
         * @param mislabeling the mislabeling score
         * @return this builder
         */
        public Builder mislabeling(double mislabeling) {
            request.setMislabeling(mislabeling);
            return this;
        }
        
        /**
         * Sets the task ID.
         * 
         * @param task the task ID
         * @return this builder
         */
        public Builder task(int task) {
            request.setTask(task);
            return this;
        }
        
        /**
         * Sets the model version.
         * 
         * @param modelVersion the model version
         * @return this builder
         */
        public Builder modelVersion(String modelVersion) {
            request.setModelVersion(modelVersion);
            return this;
        }
        
        /**
         * Builds the PredictionImportRequest.
         * 
         * @return the PredictionImportRequest instance
         */
        public PredictionImportRequest build() {
            return request;
        }
    }
}