package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents an annotation for a task.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  
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
}