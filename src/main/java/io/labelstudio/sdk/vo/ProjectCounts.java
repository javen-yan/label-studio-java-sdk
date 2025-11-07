package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents project counts and statistics.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectCounts {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("task_number")
    private Integer taskNumber;
    
    @JsonProperty("finished_task_number")
    private Integer finishedTaskNumber;
    
    @JsonProperty("total_predictions_number")
    private Integer totalPredictionsNumber;
    
    @JsonProperty("total_annotations_number")
    private Integer totalAnnotationsNumber;
    
    @JsonProperty("num_tasks_with_annotations")
    private Integer numTasksWithAnnotations;
    
    @JsonProperty("useful_annotation_number")
    private Integer usefulAnnotationNumber;
    
    @JsonProperty("ground_truth_number")
    private Integer groundTruthNumber;
    
    @JsonProperty("skipped_annotations_number")
    private Integer skippedAnnotationsNumber;
}
