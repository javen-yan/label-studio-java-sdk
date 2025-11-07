package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Result of task import operation.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskImportResult {
    
    @JsonProperty("task_count")
    private int taskCount;
    
    @JsonProperty("annotation_count")
    private int annotationCount;
    
    @JsonProperty("prediction_count")
    private int predictionCount;
    
    @JsonProperty("duration")
    private double duration;
    
    @JsonProperty("file_upload_ids")
    private List<Integer> fileUploadIds;
    
    @JsonProperty("could_be_tasks_list")
    private boolean couldBeTasksList;
    
    @JsonProperty("found_formats")
    private List<String> foundFormats;
    
    @JsonProperty("data_columns")
    private List<String> dataColumns;
}
