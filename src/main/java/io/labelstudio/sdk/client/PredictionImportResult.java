package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Result of prediction import operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PredictionImportResult {
    
    @JsonProperty("prediction_count")
    private int predictionCount;
    
    @JsonProperty("duration")
    private double duration;
    
    @JsonProperty("created")
    private int created;
    
    @JsonProperty("updated")
    private int updated;
    
    @JsonProperty("errors")
    private int errors;
    
    /**
     * Default constructor.
     */
    public PredictionImportResult() {
    }
    
    /**
     * Gets the number of predictions imported.
     * 
     * @return the prediction count
     */
    public int getPredictionCount() {
        return predictionCount;
    }
    
    /**
     * Sets the number of predictions imported.
     * 
     * @param predictionCount the prediction count
     */
    public void setPredictionCount(int predictionCount) {
        this.predictionCount = predictionCount;
    }
    
    /**
     * Gets the import duration in seconds.
     * 
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }
    
    /**
     * Sets the import duration in seconds.
     * 
     * @param duration the duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }
    
    /**
     * Gets the number of predictions created.
     * 
     * @return the number created
     */
    public int getCreated() {
        return created;
    }
    
    /**
     * Sets the number of predictions created.
     * 
     * @param created the number created
     */
    public void setCreated(int created) {
        this.created = created;
    }
    
    /**
     * Gets the number of predictions updated.
     * 
     * @return the number updated
     */
    public int getUpdated() {
        return updated;
    }
    
    /**
     * Sets the number of predictions updated.
     * 
     * @param updated the number updated
     */
    public void setUpdated(int updated) {
        this.updated = updated;
    }
    
    /**
     * Gets the number of errors encountered.
     * 
     * @return the number of errors
     */
    public int getErrors() {
        return errors;
    }
    
    /**
     * Sets the number of errors encountered.
     * 
     * @param errors the number of errors
     */
    public void setErrors(int errors) {
        this.errors = errors;
    }
    
    @Override
    public String toString() {
        return "PredictionImportResult{" +
                "predictionCount=" + predictionCount +
                ", duration=" + duration +
                ", created=" + created +
                ", updated=" + updated +
                ", errors=" + errors +
                '}';
    }
}