package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a draft annotation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Draft {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    @JsonProperty("result")
    private List<Map<String, Object>> result;
    
    @JsonProperty("task")
    private Integer task;
    
    @JsonProperty("annotation")
    private Integer annotation;
    
    @JsonProperty("created_by")
    private Integer createdBy;
    
    @JsonProperty("updated_by")
    private Integer updatedBy;
    
    /**
     * Default constructor.
     */
    public Draft() {
    }
    
    /**
     * Gets the draft ID.
     * 
     * @return the draft ID
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the draft ID.
     * 
     * @param id the draft ID
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
     * Gets the draft result.
     * 
     * @return the draft result
     */
    public List<Map<String, Object>> getResult() {
        return result;
    }
    
    /**
     * Sets the draft result.
     * 
     * @param result the draft result
     */
    public void setResult(List<Map<String, Object>> result) {
        this.result = result;
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
     * Gets the annotation ID.
     * 
     * @return the annotation ID
     */
    public Integer getAnnotation() {
        return annotation;
    }
    
    /**
     * Sets the annotation ID.
     * 
     * @param annotation the annotation ID
     */
    public void setAnnotation(Integer annotation) {
        this.annotation = annotation;
    }
    
    /**
     * Gets the ID of the user who created the draft.
     * 
     * @return the created by user ID
     */
    public Integer getCreatedBy() {
        return createdBy;
    }
    
    /**
     * Sets the ID of the user who created the draft.
     * 
     * @param createdBy the created by user ID
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    
    /**
     * Gets the ID of the user who last updated the draft.
     * 
     * @return the updated by user ID
     */
    public Integer getUpdatedBy() {
        return updatedBy;
    }
    
    /**
     * Sets the ID of the user who last updated the draft.
     * 
     * @param updatedBy the updated by user ID
     */
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Draft draft = (Draft) o;
        return Objects.equals(id, draft.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Draft{" +
                "id=" + id +
                ", task=" + task +
                ", annotation=" + annotation +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}