package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object for updating a project.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
