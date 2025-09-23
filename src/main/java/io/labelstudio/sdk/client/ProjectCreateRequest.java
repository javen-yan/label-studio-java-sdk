package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object for creating a new project.
 */
public class ProjectCreateRequest {
    
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
    
    @JsonProperty("min_annotations_to_start_training")
    private Integer minAnnotationsToStartTraining;
    
    @JsonProperty("start_training_on_annotation_update")
    private Boolean startTrainingOnAnnotationUpdate;
    
    @JsonProperty("show_collab_predictions")
    private Boolean showCollabPredictions;
    
    /**
     * Default constructor.
     */
    public ProjectCreateRequest() {
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
     * Creates a new builder for ProjectCreateRequest.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for ProjectCreateRequest.
     */
    public static class Builder {
        private final ProjectCreateRequest request = new ProjectCreateRequest();
        
        /**
         * Sets the project title.
         * 
         * @param title the project title
         * @return this builder
         */
        public Builder title(String title) {
            request.setTitle(title);
            return this;
        }
        
        /**
         * Sets the project description.
         * 
         * @param description the project description
         * @return this builder
         */
        public Builder description(String description) {
            request.setDescription(description);
            return this;
        }
        
        /**
         * Sets the label configuration XML.
         * 
         * @param labelConfig the label configuration
         * @return this builder
         */
        public Builder labelConfig(String labelConfig) {
            request.setLabelConfig(labelConfig);
            return this;
        }
        
        /**
         * Sets the expert instruction HTML.
         * 
         * @param expertInstruction the expert instruction
         * @return this builder
         */
        public Builder expertInstruction(String expertInstruction) {
            request.setExpertInstruction(expertInstruction);
            return this;
        }
        
        /**
         * Sets whether to show instructions to annotators.
         * 
         * @param showInstruction true to show instructions
         * @return this builder
         */
        public Builder showInstruction(boolean showInstruction) {
            request.setShowInstruction(showInstruction);
            return this;
        }
        
        /**
         * Sets whether to show the skip button.
         * 
         * @param showSkipButton true to show skip button
         * @return this builder
         */
        public Builder showSkipButton(boolean showSkipButton) {
            request.setShowSkipButton(showSkipButton);
            return this;
        }
        
        /**
         * Sets whether empty annotations are allowed.
         * 
         * @param enableEmptyAnnotation true to allow empty annotations
         * @return this builder
         */
        public Builder enableEmptyAnnotation(boolean enableEmptyAnnotation) {
            request.setEnableEmptyAnnotation(enableEmptyAnnotation);
            return this;
        }
        
        /**
         * Sets whether to show annotation history.
         * 
         * @param showAnnotationHistory true to show annotation history
         * @return this builder
         */
        public Builder showAnnotationHistory(boolean showAnnotationHistory) {
            request.setShowAnnotationHistory(showAnnotationHistory);
            return this;
        }
        
        /**
         * Sets the organization ID.
         * 
         * @param organization the organization ID
         * @return this builder
         */
        public Builder organization(int organization) {
            request.setOrganization(organization);
            return this;
        }
        
        /**
         * Sets the project color.
         * 
         * @param color the project color
         * @return this builder
         */
        public Builder color(String color) {
            request.setColor(color);
            return this;
        }
        
        /**
         * Sets the maximum number of annotations per task.
         * 
         * @param maximumAnnotations the maximum annotations
         * @return this builder
         */
        public Builder maximumAnnotations(int maximumAnnotations) {
            request.setMaximumAnnotations(maximumAnnotations);
            return this;
        }
        
        /**
         * Sets whether the project is published.
         * 
         * @param isPublished true to publish the project
         * @return this builder
         */
        public Builder isPublished(boolean isPublished) {
            request.setIsPublished(isPublished);
            return this;
        }
        
        /**
         * Sets the minimum annotations to start training.
         * 
         * @param minAnnotationsToStartTraining the minimum annotations
         * @return this builder
         */
        public Builder minAnnotationsToStartTraining(int minAnnotationsToStartTraining) {
            request.setMinAnnotationsToStartTraining(minAnnotationsToStartTraining);
            return this;
        }
        
        /**
         * Sets whether to start training on annotation updates.
         * 
         * @param startTrainingOnAnnotationUpdate true to start training on updates
         * @return this builder
         */
        public Builder startTrainingOnAnnotationUpdate(boolean startTrainingOnAnnotationUpdate) {
            request.setStartTrainingOnAnnotationUpdate(startTrainingOnAnnotationUpdate);
            return this;
        }
        
        /**
         * Sets whether to show collaborative predictions.
         * 
         * @param showCollabPredictions true to show collaborative predictions
         * @return this builder
         */
        public Builder showCollabPredictions(boolean showCollabPredictions) {
            request.setShowCollabPredictions(showCollabPredictions);
            return this;
        }
        
        /**
         * Builds the ProjectCreateRequest.
         * 
         * @return the ProjectCreateRequest instance
         */
        public ProjectCreateRequest build() {
            return request;
        }
    }
}