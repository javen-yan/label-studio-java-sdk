package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnotationHistory {
    @JsonProperty("id") private Integer id;
    @JsonProperty("annotation") private Integer annotationId;
    @JsonProperty("task") private Integer taskId;
    @JsonProperty("user") private Integer userId;
    @JsonProperty("user_name") private String userName;
    @JsonProperty("version") private Integer version;
    @JsonProperty("action") private String action;
    @JsonProperty("result") private Map<String, Object> result;
    @JsonProperty("previous_result") private Map<String, Object> previousResult;
    @JsonProperty("changes") private Map<String, Object> changes;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
}