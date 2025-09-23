package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object for updating a project.
 */
public class ProjectUpdateRequest {
    
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
    public ProjectUpdateRequest() {
    }
    
    // Getters and setters (similar to ProjectCreateRequest)
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getLabelConfig() {
        return labelConfig;
    }
    
    public void setLabelConfig(String labelConfig) {
        this.labelConfig = labelConfig;
    }
    
    public String getExpertInstruction() {
        return expertInstruction;
    }
    
    public void setExpertInstruction(String expertInstruction) {
        this.expertInstruction = expertInstruction;
    }
    
    public Boolean getShowInstruction() {
        return showInstruction;
    }
    
    public void setShowInstruction(Boolean showInstruction) {
        this.showInstruction = showInstruction;
    }
    
    public Boolean getShowSkipButton() {
        return showSkipButton;
    }
    
    public void setShowSkipButton(Boolean showSkipButton) {
        this.showSkipButton = showSkipButton;
    }
    
    public Boolean getEnableEmptyAnnotation() {
        return enableEmptyAnnotation;
    }
    
    public void setEnableEmptyAnnotation(Boolean enableEmptyAnnotation) {
        this.enableEmptyAnnotation = enableEmptyAnnotation;
    }
    
    public Boolean getShowAnnotationHistory() {
        return showAnnotationHistory;
    }
    
    public void setShowAnnotationHistory(Boolean showAnnotationHistory) {
        this.showAnnotationHistory = showAnnotationHistory;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public Integer getMaximumAnnotations() {
        return maximumAnnotations;
    }
    
    public void setMaximumAnnotations(Integer maximumAnnotations) {
        this.maximumAnnotations = maximumAnnotations;
    }
    
    public Boolean getIsPublished() {
        return isPublished;
    }
    
    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }
    
    public Integer getMinAnnotationsToStartTraining() {
        return minAnnotationsToStartTraining;
    }
    
    public void setMinAnnotationsToStartTraining(Integer minAnnotationsToStartTraining) {
        this.minAnnotationsToStartTraining = minAnnotationsToStartTraining;
    }
    
    public Boolean getStartTrainingOnAnnotationUpdate() {
        return startTrainingOnAnnotationUpdate;
    }
    
    public void setStartTrainingOnAnnotationUpdate(Boolean startTrainingOnAnnotationUpdate) {
        this.startTrainingOnAnnotationUpdate = startTrainingOnAnnotationUpdate;
    }
    
    public Boolean getShowCollabPredictions() {
        return showCollabPredictions;
    }
    
    public void setShowCollabPredictions(Boolean showCollabPredictions) {
        this.showCollabPredictions = showCollabPredictions;
    }
    
    /**
     * Creates a new builder for ProjectUpdateRequest.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for ProjectUpdateRequest.
     */
    public static class Builder {
        private final ProjectUpdateRequest request = new ProjectUpdateRequest();
        
        public Builder title(String title) {
            request.setTitle(title);
            return this;
        }
        
        public Builder description(String description) {
            request.setDescription(description);
            return this;
        }
        
        public Builder labelConfig(String labelConfig) {
            request.setLabelConfig(labelConfig);
            return this;
        }
        
        public Builder expertInstruction(String expertInstruction) {
            request.setExpertInstruction(expertInstruction);
            return this;
        }
        
        public Builder showInstruction(boolean showInstruction) {
            request.setShowInstruction(showInstruction);
            return this;
        }
        
        public Builder showSkipButton(boolean showSkipButton) {
            request.setShowSkipButton(showSkipButton);
            return this;
        }
        
        public Builder enableEmptyAnnotation(boolean enableEmptyAnnotation) {
            request.setEnableEmptyAnnotation(enableEmptyAnnotation);
            return this;
        }
        
        public Builder showAnnotationHistory(boolean showAnnotationHistory) {
            request.setShowAnnotationHistory(showAnnotationHistory);
            return this;
        }
        
        public Builder color(String color) {
            request.setColor(color);
            return this;
        }
        
        public Builder maximumAnnotations(int maximumAnnotations) {
            request.setMaximumAnnotations(maximumAnnotations);
            return this;
        }
        
        public Builder isPublished(boolean isPublished) {
            request.setIsPublished(isPublished);
            return this;
        }
        
        public Builder minAnnotationsToStartTraining(int minAnnotationsToStartTraining) {
            request.setMinAnnotationsToStartTraining(minAnnotationsToStartTraining);
            return this;
        }
        
        public Builder startTrainingOnAnnotationUpdate(boolean startTrainingOnAnnotationUpdate) {
            request.setStartTrainingOnAnnotationUpdate(startTrainingOnAnnotationUpdate);
            return this;
        }
        
        public Builder showCollabPredictions(boolean showCollabPredictions) {
            request.setShowCollabPredictions(showCollabPredictions);
            return this;
        }
        
        public ProjectUpdateRequest build() {
            return request;
        }
    }
}