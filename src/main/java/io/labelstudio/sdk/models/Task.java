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
 * Represents a Label Studio task.
 * 
 * <p>A task contains data to be labeled and tracks its annotation status.</p>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
}