package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a Label Studio project.
 * 
 * <p>A project contains tasks to be labeled, label configuration,
 * and manages the annotation workflow.</p>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("label_config")
    private String labelConfig;
    
    @JsonProperty("expert_instruction")
    private String expertInstruction;
    
    @JsonProperty("show_instruction")
    private Boolean showInstruction;
    
    @JsonProperty("show_skip_button")
    private Boolean showSkipButton;
    
    @JsonProperty("enable_empty_annotation")
    private Boolean enableEmptyAnnotation;
    
    @JsonProperty("show_annotation_history")
    private Boolean showAnnotationHistory;
    
    @JsonProperty("organization")
    private Integer organization;
    
    @JsonProperty("color")
    private String color;
    
    @JsonProperty("maximum_annotations")
    private Integer maximumAnnotations;
    
    @JsonProperty("is_published")
    private Boolean isPublished;
    
    @JsonProperty("model_version")
    private String modelVersion;
    
    @JsonProperty("is_draft")
    private Boolean isDraft;
    
    @JsonProperty("created_by")
    private UserSimple createdBy;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("min_annotations_to_start_training")
    private Integer minAnnotationsToStartTraining;
    
    @JsonProperty("start_training_on_annotation_update")
    private Boolean startTrainingOnAnnotationUpdate;
    
    @JsonProperty("show_collab_predictions")
    private Boolean showCollabPredictions;
    
    @JsonProperty("num_tasks_with_annotations")
    private Integer numTasksWithAnnotations;
    
    @JsonProperty("task_number")
    private Integer taskNumber;
    
    @JsonProperty("useful_annotation_number")
    private Integer usefulAnnotationNumber;
    
    @JsonProperty("ground_truth_number")
    private Integer groundTruthNumber;
    
    @JsonProperty("skipped_annotations_number")
    private Integer skippedAnnotationsNumber;
    
    @JsonProperty("total_annotations_number")
    private Integer totalAnnotationsNumber;
    
    @JsonProperty("total_predictions_number")
    private Integer totalPredictionsNumber;
    
    @JsonProperty("finished_task_number")
    private Integer finishedTaskNumber;
    
    @JsonProperty("queue_total")
    private Integer queueTotal;
    
    @JsonProperty("queue_done")
    private Integer queueDone;
    
    @JsonProperty("config_has_control_tags")
    private Boolean configHasControlTags;
    
    @JsonProperty("config_suitable_for_bulk_annotation")
    private Boolean configSuitableForBulkAnnotation;
    
    /**
     * Default constructor.
     */
    public Project() {
    }
    
    /**
     * Gets the project ID.
     * 
     * @return the project ID
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the project ID.
     * 
     * @param id the project ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Gets the project title.
     * 
     * @return the project title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the project title.
     * 
     * @param title the project title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the project description.
     * 
     * @return the project description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the project description.
     * 
     * @param description the project description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Gets the label configuration XML.
     * 
     * @return the label configuration
     */
    public String getLabelConfig() {
        return labelConfig;
    }
    
    /**
     * Sets the label configuration XML.
     * 
     * @param labelConfig the label configuration
     */
    public void setLabelConfig(String labelConfig) {
        this.labelConfig = labelConfig;
    }
    
    /**
     * Gets the expert instruction HTML.
     * 
     * @return the expert instruction
     */
    public String getExpertInstruction() {
        return expertInstruction;
    }
    
    /**
     * Sets the expert instruction HTML.
     * 
     * @param expertInstruction the expert instruction
     */
    public void setExpertInstruction(String expertInstruction) {
        this.expertInstruction = expertInstruction;
    }
    
    /**
     * Gets whether to show instructions to annotators.
     * 
     * @return true if instructions should be shown
     */
    public Boolean getShowInstruction() {
        return showInstruction;
    }
    
    /**
     * Sets whether to show instructions to annotators.
     * 
     * @param showInstruction true to show instructions
     */
    public void setShowInstruction(Boolean showInstruction) {
        this.showInstruction = showInstruction;
    }
    
    /**
     * Gets whether to show the skip button.
     * 
     * @return true if skip button should be shown
     */
    public Boolean getShowSkipButton() {
        return showSkipButton;
    }
    
    /**
     * Sets whether to show the skip button.
     * 
     * @param showSkipButton true to show skip button
     */
    public void setShowSkipButton(Boolean showSkipButton) {
        this.showSkipButton = showSkipButton;
    }
    
    /**
     * Gets whether empty annotations are allowed.
     * 
     * @return true if empty annotations are allowed
     */
    public Boolean getEnableEmptyAnnotation() {
        return enableEmptyAnnotation;
    }
    
    /**
     * Sets whether empty annotations are allowed.
     * 
     * @param enableEmptyAnnotation true to allow empty annotations
     */
    public void setEnableEmptyAnnotation(Boolean enableEmptyAnnotation) {
        this.enableEmptyAnnotation = enableEmptyAnnotation;
    }
    
    /**
     * Gets whether to show annotation history.
     * 
     * @return true if annotation history should be shown
     */
    public Boolean getShowAnnotationHistory() {
        return showAnnotationHistory;
    }
    
    /**
     * Sets whether to show annotation history.
     * 
     * @param showAnnotationHistory true to show annotation history
     */
    public void setShowAnnotationHistory(Boolean showAnnotationHistory) {
        this.showAnnotationHistory = showAnnotationHistory;
    }
    
    /**
     * Gets the organization ID.
     * 
     * @return the organization ID
     */
    public Integer getOrganization() {
        return organization;
    }
    
    /**
     * Sets the organization ID.
     * 
     * @param organization the organization ID
     */
    public void setOrganization(Integer organization) {
        this.organization = organization;
    }
    
    /**
     * Gets the project color.
     * 
     * @return the project color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Sets the project color.
     * 
     * @param color the project color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Gets the maximum number of annotations per task.
     * 
     * @return the maximum annotations
     */
    public Integer getMaximumAnnotations() {
        return maximumAnnotations;
    }
    
    /**
     * Sets the maximum number of annotations per task.
     * 
     * @param maximumAnnotations the maximum annotations
     */
    public void setMaximumAnnotations(Integer maximumAnnotations) {
        this.maximumAnnotations = maximumAnnotations;
    }
    
    /**
     * Gets whether the project is published.
     * 
     * @return true if the project is published
     */
    public Boolean getIsPublished() {
        return isPublished;
    }
    
    /**
     * Sets whether the project is published.
     * 
     * @param isPublished true to publish the project
     */
    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
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
     * Gets whether the project is a draft.
     * 
     * @return true if the project is a draft
     */
    public Boolean getIsDraft() {
        return isDraft;
    }
    
    /**
     * Sets whether the project is a draft.
     * 
     * @param isDraft true if the project is a draft
     */
    public void setIsDraft(Boolean isDraft) {
        this.isDraft = isDraft;
    }
    
    /**
     * Gets the user who created the project.
     * 
     * @return the creator
     */
    public UserSimple getCreatedBy() {
        return createdBy;
    }
    
    /**
     * Sets the user who created the project.
     * 
     * @param createdBy the creator
     */
    public void setCreatedBy(UserSimple createdBy) {
        this.createdBy = createdBy;
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
     * Gets the minimum annotations to start training.
     * 
     * @return the minimum annotations
     */
    public Integer getMinAnnotationsToStartTraining() {
        return minAnnotationsToStartTraining;
    }
    
    /**
     * Sets the minimum annotations to start training.
     * 
     * @param minAnnotationsToStartTraining the minimum annotations
     */
    public void setMinAnnotationsToStartTraining(Integer minAnnotationsToStartTraining) {
        this.minAnnotationsToStartTraining = minAnnotationsToStartTraining;
    }
    
    /**
     * Gets whether to start training on annotation updates.
     * 
     * @return true if training should start on updates
     */
    public Boolean getStartTrainingOnAnnotationUpdate() {
        return startTrainingOnAnnotationUpdate;
    }
    
    /**
     * Sets whether to start training on annotation updates.
     * 
     * @param startTrainingOnAnnotationUpdate true to start training on updates
     */
    public void setStartTrainingOnAnnotationUpdate(Boolean startTrainingOnAnnotationUpdate) {
        this.startTrainingOnAnnotationUpdate = startTrainingOnAnnotationUpdate;
    }
    
    /**
     * Gets whether to show collaborative predictions.
     * 
     * @return true if collaborative predictions should be shown
     */
    public Boolean getShowCollabPredictions() {
        return showCollabPredictions;
    }
    
    /**
     * Sets whether to show collaborative predictions.
     * 
     * @param showCollabPredictions true to show collaborative predictions
     */
    public void setShowCollabPredictions(Boolean showCollabPredictions) {
        this.showCollabPredictions = showCollabPredictions;
    }
    
    /**
     * Gets the number of tasks with annotations.
     * 
     * @return the number of tasks with annotations
     */
    public Integer getNumTasksWithAnnotations() {
        return numTasksWithAnnotations;
    }
    
    /**
     * Sets the number of tasks with annotations.
     * 
     * @param numTasksWithAnnotations the number of tasks with annotations
     */
    public void setNumTasksWithAnnotations(Integer numTasksWithAnnotations) {
        this.numTasksWithAnnotations = numTasksWithAnnotations;
    }
    
    /**
     * Gets the total number of tasks.
     * 
     * @return the total number of tasks
     */
    public Integer getTaskNumber() {
        return taskNumber;
    }
    
    /**
     * Sets the total number of tasks.
     * 
     * @param taskNumber the total number of tasks
     */
    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }
    
    /**
     * Gets the number of useful annotations.
     * 
     * @return the number of useful annotations
     */
    public Integer getUsefulAnnotationNumber() {
        return usefulAnnotationNumber;
    }
    
    /**
     * Sets the number of useful annotations.
     * 
     * @param usefulAnnotationNumber the number of useful annotations
     */
    public void setUsefulAnnotationNumber(Integer usefulAnnotationNumber) {
        this.usefulAnnotationNumber = usefulAnnotationNumber;
    }
    
    /**
     * Gets the number of ground truth annotations.
     * 
     * @return the number of ground truth annotations
     */
    public Integer getGroundTruthNumber() {
        return groundTruthNumber;
    }
    
    /**
     * Sets the number of ground truth annotations.
     * 
     * @param groundTruthNumber the number of ground truth annotations
     */
    public void setGroundTruthNumber(Integer groundTruthNumber) {
        this.groundTruthNumber = groundTruthNumber;
    }
    
    /**
     * Gets the number of skipped annotations.
     * 
     * @return the number of skipped annotations
     */
    public Integer getSkippedAnnotationsNumber() {
        return skippedAnnotationsNumber;
    }
    
    /**
     * Sets the number of skipped annotations.
     * 
     * @param skippedAnnotationsNumber the number of skipped annotations
     */
    public void setSkippedAnnotationsNumber(Integer skippedAnnotationsNumber) {
        this.skippedAnnotationsNumber = skippedAnnotationsNumber;
    }
    
    /**
     * Gets the total number of annotations.
     * 
     * @return the total number of annotations
     */
    public Integer getTotalAnnotationsNumber() {
        return totalAnnotationsNumber;
    }
    
    /**
     * Sets the total number of annotations.
     * 
     * @param totalAnnotationsNumber the total number of annotations
     */
    public void setTotalAnnotationsNumber(Integer totalAnnotationsNumber) {
        this.totalAnnotationsNumber = totalAnnotationsNumber;
    }
    
    /**
     * Gets the total number of predictions.
     * 
     * @return the total number of predictions
     */
    public Integer getTotalPredictionsNumber() {
        return totalPredictionsNumber;
    }
    
    /**
     * Sets the total number of predictions.
     * 
     * @param totalPredictionsNumber the total number of predictions
     */
    public void setTotalPredictionsNumber(Integer totalPredictionsNumber) {
        this.totalPredictionsNumber = totalPredictionsNumber;
    }
    
    /**
     * Gets the number of finished tasks.
     * 
     * @return the number of finished tasks
     */
    public Integer getFinishedTaskNumber() {
        return finishedTaskNumber;
    }
    
    /**
     * Sets the number of finished tasks.
     * 
     * @param finishedTaskNumber the number of finished tasks
     */
    public void setFinishedTaskNumber(Integer finishedTaskNumber) {
        this.finishedTaskNumber = finishedTaskNumber;
    }
    
    /**
     * Gets the total queue size.
     * 
     * @return the total queue size
     */
    public Integer getQueueTotal() {
        return queueTotal;
    }
    
    /**
     * Sets the total queue size.
     * 
     * @param queueTotal the total queue size
     */
    public void setQueueTotal(Integer queueTotal) {
        this.queueTotal = queueTotal;
    }
    
    /**
     * Gets the number of completed queue items.
     * 
     * @return the number of completed queue items
     */
    public Integer getQueueDone() {
        return queueDone;
    }
    
    /**
     * Sets the number of completed queue items.
     * 
     * @param queueDone the number of completed queue items
     */
    public void setQueueDone(Integer queueDone) {
        this.queueDone = queueDone;
    }
    
    /**
     * Gets whether the config has control tags.
     * 
     * @return true if the config has control tags
     */
    public Boolean getConfigHasControlTags() {
        return configHasControlTags;
    }
    
    /**
     * Sets whether the config has control tags.
     * 
     * @param configHasControlTags true if the config has control tags
     */
    public void setConfigHasControlTags(Boolean configHasControlTags) {
        this.configHasControlTags = configHasControlTags;
    }
    
    /**
     * Gets whether the config is suitable for bulk annotation.
     * 
     * @return true if suitable for bulk annotation
     */
    public Boolean getConfigSuitableForBulkAnnotation() {
        return configSuitableForBulkAnnotation;
    }
    
    /**
     * Sets whether the config is suitable for bulk annotation.
     * 
     * @param configSuitableForBulkAnnotation true if suitable for bulk annotation
     */
    public void setConfigSuitableForBulkAnnotation(Boolean configSuitableForBulkAnnotation) {
        this.configSuitableForBulkAnnotation = configSuitableForBulkAnnotation;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isPublished=" + isPublished +
                ", isDraft=" + isDraft +
                ", taskNumber=" + taskNumber +
                ", createdAt=" + createdAt +
                '}';
    }
}