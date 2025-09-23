package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents an annotation for a task.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Annotation {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    @JsonProperty("draft_created_at")
    private OffsetDateTime draftCreatedAt;
    
    @JsonProperty("lead_time")
    private Double leadTime;
    
    @JsonProperty("result")
    private List<Map<String, Object>> result;
    
    @JsonProperty("task")
    private Integer task;
    
    @JsonProperty("project")
    private Integer project;
    
    @JsonProperty("completed_by")
    private Integer completedBy;
    
    @JsonProperty("parent_prediction")
    private Integer parentPrediction;
    
    @JsonProperty("parent_annotation")
    private Integer parentAnnotation;
    
    @JsonProperty("last_created_by")
    private Integer lastCreatedBy;
    
    @JsonProperty("ground_truth")
    private Boolean groundTruth;
    
    @JsonProperty("created_username")
    private String createdUsername;
    
    @JsonProperty("created_ago")
    private String createdAgo;
    
    @JsonProperty("was_cancelled")
    private Boolean wasCancelled;
    
    @JsonProperty("import_id")
    private Integer importId;
    
    @JsonProperty("last_action")
    private String lastAction;
    
    @JsonProperty("updated_by")
    private Integer updatedBy;
    
    @JsonProperty("bulk_created")
    private Boolean bulkCreated;
    
    /**
     * Default constructor.
     */
    public Annotation() {
    }
    
    /**
     * Gets the annotation ID.
     * 
     * @return the annotation ID
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the annotation ID.
     * 
     * @param id the annotation ID
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
     * Gets the draft creation timestamp.
     * 
     * @return the draft creation timestamp
     */
    public OffsetDateTime getDraftCreatedAt() {
        return draftCreatedAt;
    }
    
    /**
     * Sets the draft creation timestamp.
     * 
     * @param draftCreatedAt the draft creation timestamp
     */
    public void setDraftCreatedAt(OffsetDateTime draftCreatedAt) {
        this.draftCreatedAt = draftCreatedAt;
    }
    
    /**
     * Gets the lead time.
     * 
     * @return the lead time
     */
    public Double getLeadTime() {
        return leadTime;
    }
    
    /**
     * Sets the lead time.
     * 
     * @param leadTime the lead time
     */
    public void setLeadTime(Double leadTime) {
        this.leadTime = leadTime;
    }
    
    /**
     * Gets the annotation result.
     * 
     * @return the annotation result
     */
    public List<Map<String, Object>> getResult() {
        return result;
    }
    
    /**
     * Sets the annotation result.
     * 
     * @param result the annotation result
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
     * Gets the ID of the user who completed the annotation.
     * 
     * @return the completed by user ID
     */
    public Integer getCompletedBy() {
        return completedBy;
    }
    
    /**
     * Sets the ID of the user who completed the annotation.
     * 
     * @param completedBy the completed by user ID
     */
    public void setCompletedBy(Integer completedBy) {
        this.completedBy = completedBy;
    }
    
    /**
     * Gets the parent prediction ID.
     * 
     * @return the parent prediction ID
     */
    public Integer getParentPrediction() {
        return parentPrediction;
    }
    
    /**
     * Sets the parent prediction ID.
     * 
     * @param parentPrediction the parent prediction ID
     */
    public void setParentPrediction(Integer parentPrediction) {
        this.parentPrediction = parentPrediction;
    }
    
    /**
     * Gets the parent annotation ID.
     * 
     * @return the parent annotation ID
     */
    public Integer getParentAnnotation() {
        return parentAnnotation;
    }
    
    /**
     * Sets the parent annotation ID.
     * 
     * @param parentAnnotation the parent annotation ID
     */
    public void setParentAnnotation(Integer parentAnnotation) {
        this.parentAnnotation = parentAnnotation;
    }
    
    /**
     * Gets the ID of the user who last created this annotation.
     * 
     * @return the last created by user ID
     */
    public Integer getLastCreatedBy() {
        return lastCreatedBy;
    }
    
    /**
     * Sets the ID of the user who last created this annotation.
     * 
     * @param lastCreatedBy the last created by user ID
     */
    public void setLastCreatedBy(Integer lastCreatedBy) {
        this.lastCreatedBy = lastCreatedBy;
    }
    
    /**
     * Gets whether this is a ground truth annotation.
     * 
     * @return true if this is a ground truth annotation
     */
    public Boolean getGroundTruth() {
        return groundTruth;
    }
    
    /**
     * Sets whether this is a ground truth annotation.
     * 
     * @param groundTruth true if this is a ground truth annotation
     */
    public void setGroundTruth(Boolean groundTruth) {
        this.groundTruth = groundTruth;
    }
    
    /**
     * Gets the username of the creator.
     * 
     * @return the creator username
     */
    public String getCreatedUsername() {
        return createdUsername;
    }
    
    /**
     * Sets the username of the creator.
     * 
     * @param createdUsername the creator username
     */
    public void setCreatedUsername(String createdUsername) {
        this.createdUsername = createdUsername;
    }
    
    /**
     * Gets the time delta from creation.
     * 
     * @return the time delta from creation
     */
    public String getCreatedAgo() {
        return createdAgo;
    }
    
    /**
     * Sets the time delta from creation.
     * 
     * @param createdAgo the time delta from creation
     */
    public void setCreatedAgo(String createdAgo) {
        this.createdAgo = createdAgo;
    }
    
    /**
     * Gets whether the annotation was cancelled.
     * 
     * @return true if the annotation was cancelled
     */
    public Boolean getWasCancelled() {
        return wasCancelled;
    }
    
    /**
     * Sets whether the annotation was cancelled.
     * 
     * @param wasCancelled true if the annotation was cancelled
     */
    public void setWasCancelled(Boolean wasCancelled) {
        this.wasCancelled = wasCancelled;
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
    
    /**
     * Gets the last action performed.
     * 
     * @return the last action
     */
    public String getLastAction() {
        return lastAction;
    }
    
    /**
     * Sets the last action performed.
     * 
     * @param lastAction the last action
     */
    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }
    
    /**
     * Gets the ID of the user who last updated the annotation.
     * 
     * @return the updated by user ID
     */
    public Integer getUpdatedBy() {
        return updatedBy;
    }
    
    /**
     * Sets the ID of the user who last updated the annotation.
     * 
     * @param updatedBy the updated by user ID
     */
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    /**
     * Gets whether the annotation was created in bulk mode.
     * 
     * @return true if created in bulk mode
     */
    public Boolean getBulkCreated() {
        return bulkCreated;
    }
    
    /**
     * Sets whether the annotation was created in bulk mode.
     * 
     * @param bulkCreated true if created in bulk mode
     */
    public void setBulkCreated(Boolean bulkCreated) {
        this.bulkCreated = bulkCreated;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annotation that = (Annotation) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Annotation{" +
                "id=" + id +
                ", task=" + task +
                ", project=" + project +
                ", createdAt=" + createdAt +
                ", completedBy=" + completedBy +
                ", groundTruth=" + groundTruth +
                '}';
    }
}