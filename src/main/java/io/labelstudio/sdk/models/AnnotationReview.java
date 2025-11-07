package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnotationReview {
    @JsonProperty("id") private Integer id;
    @JsonProperty("annotation") private Integer annotationId;
    @JsonProperty("task") private Integer taskId;
    @JsonProperty("reviewer") private Integer reviewerId;
    @JsonProperty("reviewer_name") private String reviewerName;
    @JsonProperty("action") private String action;
    @JsonProperty("status") private String status;
    @JsonProperty("comment") private String comment;
    @JsonProperty("score") private Double score;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
    @JsonProperty("updated_at") private OffsetDateTime updatedAt;
}