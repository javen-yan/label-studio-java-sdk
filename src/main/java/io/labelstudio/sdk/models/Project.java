package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;    

/**
 * Represents a Label Studio project.
 * 
 * <p>A project contains tasks to be labeled, label configuration,
 * and manages the annotation workflow.</p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  
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
}