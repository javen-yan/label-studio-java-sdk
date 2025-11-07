package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents a draft annotation.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Draft {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    @JsonProperty("result")
    private List<Map<String, Object>> result;
    
    @JsonProperty("task")
    private Integer task;
    
    @JsonProperty("annotation")
    private Integer annotation;
    
    @JsonProperty("created_by")
    private Integer createdBy;
    
    @JsonProperty("updated_by")
    private Integer updatedBy;
}
