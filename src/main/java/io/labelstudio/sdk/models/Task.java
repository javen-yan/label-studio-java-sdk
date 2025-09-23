package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a Label Studio task.
 * 
 * <p>A task contains data to be labeled and tracks its annotation status.</p>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("inner_id")
    private Integer innerId;
    
    @JsonProperty("data")
    private Map<String, Object> data;
    
    @JsonProperty("meta")
    private Map<String, Object> meta;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    @JsonProperty("is_labeled")
    private Boolean isLabeled;
    
    @JsonProperty("overlap")
    private Integer overlap;
    
    @JsonProperty("project")
    private Integer project;
    
    @JsonProperty("annotations")
    private List<Annotation> annotations;
    
    @JsonProperty("predictions")
    private List<Prediction> predictions;
    
    @JsonProperty("drafts")
    private List<Draft> drafts;
    
    @JsonProperty("annotators")
    private List<Integer> annotators;
    
    @JsonProperty("total_annotations")
    private Integer totalAnnotations;
    
    @JsonProperty("cancelled_annotations")
    private Integer cancelledAnnotations;
    
    @JsonProperty("total_predictions")
    private Integer totalPredictions;
    
    @JsonProperty("comment_count")
    private Integer commentCount;
    
    @JsonProperty("unresolved_comment_count")
    private Integer unresolvedCommentCount;
    
    @JsonProperty("last_comment_updated_at")
    private OffsetDateTime lastCommentUpdatedAt;
    
    @JsonProperty("completed_at")
    private OffsetDateTime completedAt;
    
    @JsonProperty("ground_truth")
    private Boolean groundTruth;
    
    @JsonProperty("reviewed")
    private Boolean reviewed;
    
    @JsonProperty("file_upload")
    private String fileUpload;
    
    @JsonProperty("storage_filename")
    private String storageFilename;
    
    @JsonProperty("annotators_count")
    private Integer annotatorsCount;
    
    @JsonProperty("predictions_score")
    private Double predictionsScore;
    
    @JsonProperty("avg_lead_time")
    private Double avgLeadTime;
    
    @JsonProperty("draft_exists")
    private Boolean draftExists;
    
    /**
     * Default constructor.
     */
    public Task() {
    }
    
    /**
     * Gets the task ID.
     * 
     * @return the task ID
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the task ID.
     * 
     * @param id the task ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Gets the inner ID.
     * 
     * @return the inner ID
     */
    public Integer getInnerId() {
        return innerId;
    }
    
    /**
     * Sets the inner ID.
     * 
     * @param innerId the inner ID
     */
    public void setInnerId(Integer innerId) {
        this.innerId = innerId;
    }
    
    /**
     * Gets the task data.
     * 
     * @return the task data
     */
    public Map<String, Object> getData() {
        return data;
    }
    
    /**
     * Sets the task data.
     * 
     * @param data the task data
     */
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    
    /**
     * Gets the task metadata.
     * 
     * @return the task metadata
     */
    public Map<String, Object> getMeta() {
        return meta;
    }
    
    /**
     * Sets the task metadata.
     * 
     * @param meta the task metadata
     */
    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
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
     * Gets whether the task is labeled.
     * 
     * @return true if the task is labeled
     */
    public Boolean getIsLabeled() {
        return isLabeled;
    }
    
    /**
     * Sets whether the task is labeled.
     * 
     * @param isLabeled true if the task is labeled
     */
    public void setIsLabeled(Boolean isLabeled) {
        this.isLabeled = isLabeled;
    }
    
    /**
     * Gets the overlap count.
     * 
     * @return the overlap count
     */
    public Integer getOverlap() {
        return overlap;
    }
    
    /**
     * Sets the overlap count.
     * 
     * @param overlap the overlap count
     */
    public void setOverlap(Integer overlap) {
        this.overlap = overlap;
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
     * Gets the annotations.
     * 
     * @return the annotations
     */
    public List<Annotation> getAnnotations() {
        return annotations;
    }
    
    /**
     * Sets the annotations.
     * 
     * @param annotations the annotations
     */
    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
    
    /**
     * Gets the predictions.
     * 
     * @return the predictions
     */
    public List<Prediction> getPredictions() {
        return predictions;
    }
    
    /**
     * Sets the predictions.
     * 
     * @param predictions the predictions
     */
    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }
    
    /**
     * Gets the drafts.
     * 
     * @return the drafts
     */
    public List<Draft> getDrafts() {
        return drafts;
    }
    
    /**
     * Sets the drafts.
     * 
     * @param drafts the drafts
     */
    public void setDrafts(List<Draft> drafts) {
        this.drafts = drafts;
    }
    
    /**
     * Gets the annotator IDs.
     * 
     * @return the annotator IDs
     */
    public List<Integer> getAnnotators() {
        return annotators;
    }
    
    /**
     * Sets the annotator IDs.
     * 
     * @param annotators the annotator IDs
     */
    public void setAnnotators(List<Integer> annotators) {
        this.annotators = annotators;
    }
    
    /**
     * Gets the total number of annotations.
     * 
     * @return the total number of annotations
     */
    public Integer getTotalAnnotations() {
        return totalAnnotations;
    }
    
    /**
     * Sets the total number of annotations.
     * 
     * @param totalAnnotations the total number of annotations
     */
    public void setTotalAnnotations(Integer totalAnnotations) {
        this.totalAnnotations = totalAnnotations;
    }
    
    /**
     * Gets the number of cancelled annotations.
     * 
     * @return the number of cancelled annotations
     */
    public Integer getCancelledAnnotations() {
        return cancelledAnnotations;
    }
    
    /**
     * Sets the number of cancelled annotations.
     * 
     * @param cancelledAnnotations the number of cancelled annotations
     */
    public void setCancelledAnnotations(Integer cancelledAnnotations) {
        this.cancelledAnnotations = cancelledAnnotations;
    }
    
    /**
     * Gets the total number of predictions.
     * 
     * @return the total number of predictions
     */
    public Integer getTotalPredictions() {
        return totalPredictions;
    }
    
    /**
     * Sets the total number of predictions.
     * 
     * @param totalPredictions the total number of predictions
     */
    public void setTotalPredictions(Integer totalPredictions) {
        this.totalPredictions = totalPredictions;
    }
    
    /**
     * Gets the comment count.
     * 
     * @return the comment count
     */
    public Integer getCommentCount() {
        return commentCount;
    }
    
    /**
     * Sets the comment count.
     * 
     * @param commentCount the comment count
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
    
    /**
     * Gets the unresolved comment count.
     * 
     * @return the unresolved comment count
     */
    public Integer getUnresolvedCommentCount() {
        return unresolvedCommentCount;
    }
    
    /**
     * Sets the unresolved comment count.
     * 
     * @param unresolvedCommentCount the unresolved comment count
     */
    public void setUnresolvedCommentCount(Integer unresolvedCommentCount) {
        this.unresolvedCommentCount = unresolvedCommentCount;
    }
    
    /**
     * Gets the last comment update timestamp.
     * 
     * @return the last comment update timestamp
     */
    public OffsetDateTime getLastCommentUpdatedAt() {
        return lastCommentUpdatedAt;
    }
    
    /**
     * Sets the last comment update timestamp.
     * 
     * @param lastCommentUpdatedAt the last comment update timestamp
     */
    public void setLastCommentUpdatedAt(OffsetDateTime lastCommentUpdatedAt) {
        this.lastCommentUpdatedAt = lastCommentUpdatedAt;
    }
    
    /**
     * Gets the completion timestamp.
     * 
     * @return the completion timestamp
     */
    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }
    
    /**
     * Sets the completion timestamp.
     * 
     * @param completedAt the completion timestamp
     */
    public void setCompletedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
    }
    
    /**
     * Gets whether this is a ground truth task.
     * 
     * @return true if this is a ground truth task
     */
    public Boolean getGroundTruth() {
        return groundTruth;
    }
    
    /**
     * Sets whether this is a ground truth task.
     * 
     * @param groundTruth true if this is a ground truth task
     */
    public void setGroundTruth(Boolean groundTruth) {
        this.groundTruth = groundTruth;
    }
    
    /**
     * Gets whether the task has been reviewed.
     * 
     * @return true if the task has been reviewed
     */
    public Boolean getReviewed() {
        return reviewed;
    }
    
    /**
     * Sets whether the task has been reviewed.
     * 
     * @param reviewed true if the task has been reviewed
     */
    public void setReviewed(Boolean reviewed) {
        this.reviewed = reviewed;
    }
    
    /**
     * Gets the file upload reference.
     * 
     * @return the file upload reference
     */
    public String getFileUpload() {
        return fileUpload;
    }
    
    /**
     * Sets the file upload reference.
     * 
     * @param fileUpload the file upload reference
     */
    public void setFileUpload(String fileUpload) {
        this.fileUpload = fileUpload;
    }
    
    /**
     * Gets the storage filename.
     * 
     * @return the storage filename
     */
    public String getStorageFilename() {
        return storageFilename;
    }
    
    /**
     * Sets the storage filename.
     * 
     * @param storageFilename the storage filename
     */
    public void setStorageFilename(String storageFilename) {
        this.storageFilename = storageFilename;
    }
    
    /**
     * Gets the annotators count.
     * 
     * @return the annotators count
     */
    public Integer getAnnotatorsCount() {
        return annotatorsCount;
    }
    
    /**
     * Sets the annotators count.
     * 
     * @param annotatorsCount the annotators count
     */
    public void setAnnotatorsCount(Integer annotatorsCount) {
        this.annotatorsCount = annotatorsCount;
    }
    
    /**
     * Gets the predictions score.
     * 
     * @return the predictions score
     */
    public Double getPredictionsScore() {
        return predictionsScore;
    }
    
    /**
     * Sets the predictions score.
     * 
     * @param predictionsScore the predictions score
     */
    public void setPredictionsScore(Double predictionsScore) {
        this.predictionsScore = predictionsScore;
    }
    
    /**
     * Gets the average lead time.
     * 
     * @return the average lead time
     */
    public Double getAvgLeadTime() {
        return avgLeadTime;
    }
    
    /**
     * Sets the average lead time.
     * 
     * @param avgLeadTime the average lead time
     */
    public void setAvgLeadTime(Double avgLeadTime) {
        this.avgLeadTime = avgLeadTime;
    }
    
    /**
     * Gets whether a draft exists.
     * 
     * @return true if a draft exists
     */
    public Boolean getDraftExists() {
        return draftExists;
    }
    
    /**
     * Sets whether a draft exists.
     * 
     * @param draftExists true if a draft exists
     */
    public void setDraftExists(Boolean draftExists) {
        this.draftExists = draftExists;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", innerId=" + innerId +
                ", project=" + project +
                ", isLabeled=" + isLabeled +
                ", totalAnnotations=" + totalAnnotations +
                ", createdAt=" + createdAt +
                '}';
    }
}