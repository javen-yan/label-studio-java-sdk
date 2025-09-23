package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a prediction for a task.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prediction {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
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
    
    @JsonProperty("project")
    private Integer project;
    
    @JsonProperty("model_version")
    private String modelVersion;
    
    @JsonProperty("created_by")
    private Integer createdBy;
    
    @JsonProperty("updated_by")
    private Integer updatedBy;
    
    @JsonProperty("import_id")
    private Integer importId;
    
    /**
     * Default constructor.
     */
    public Prediction() {
    }
    
    /**
     * Gets the prediction ID.
     * 
     * @return the prediction ID
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the prediction ID.
     * 
     * @param id the prediction ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Gets the creation timestamp.
     * 
     * @return the creation timestamp
     */
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    
    /**
     * Sets the creation timestamp.
     * 
     * @param createdAt the creation timestamp
     */
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * Gets the last update timestamp.
     * 
     * @return the last update timestamp
     */
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    /**
     * Sets the last update timestamp.
     * 
     * @param updatedAt the last update timestamp
     */
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
     * Gets the project ID.
     * 
     * @return the project ID
     */
    public Integer getProject() {
        return project;
    }
    
    /**
     * Sets the project ID.
     * 
     * @param project the project ID
     */
    public void setProject(Integer project) {
        this.project = project;
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
     * Gets the ID of the user who created the prediction.
     * 
     * @return the created by user ID
     */
    public Integer getCreatedBy() {
        return createdBy;
    }
    
    /**
     * Sets the ID of the user who created the prediction.
     * 
     * @param createdBy the created by user ID
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    
    /**
     * Gets the ID of the user who last updated the prediction.
     * 
     * @return the updated by user ID
     */
    public Integer getUpdatedBy() {
        return updatedBy;
    }
    
    /**
     * Sets the ID of the user who last updated the prediction.
     * 
     * @param updatedBy the updated by user ID
     */
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    /**
     * Gets the import ID.
     * 
     * @return the import ID
     */
    public Integer getImportId() {
        return importId;
    }
    
    /**
     * Sets the import ID.
     * 
     * @param importId the import ID
     */
    public void setImportId(Integer importId) {
        this.importId = importId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediction that = (Prediction) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Prediction{" +
                "id=" + id +
                ", task=" + task +
                ", project=" + project +
                ", score=" + score +
                ", modelVersion='" + modelVersion + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}