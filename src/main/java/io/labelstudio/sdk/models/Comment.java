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
public class Comment {
    @JsonProperty("id") private Integer id;
    @JsonProperty("task") private Integer taskId;
    @JsonProperty("annotation") private Integer annotationId;
    @JsonProperty("project") private Integer projectId;
    @JsonProperty("user") private Integer userId;
    @JsonProperty("user_name") private String userName;
    @JsonProperty("text") private String text;
    @JsonProperty("is_resolved") private Boolean isResolved;
    @JsonProperty("resolved_by") private Integer resolvedBy;
    @JsonProperty("resolved_by_name") private String resolvedByName;
    @JsonProperty("resolved_at") private OffsetDateTime resolvedAt;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
    @JsonProperty("updated_at") private OffsetDateTime updatedAt;
}