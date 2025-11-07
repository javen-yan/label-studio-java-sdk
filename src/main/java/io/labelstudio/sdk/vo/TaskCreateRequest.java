package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.Map;

/**
 * Request object for creating a new task.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateRequest {
    
    @JsonProperty("data")
    private Map<String, Object> data;
    
    @JsonProperty("meta")
    private Map<String, Object> meta;
    
    @JsonProperty("project")
    private Integer project;
}