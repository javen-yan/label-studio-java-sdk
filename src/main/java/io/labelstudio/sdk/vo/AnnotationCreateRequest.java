package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Request object for creating an annotation.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnotationCreateRequest {
    
    @JsonProperty("result")
    private List<Map<String, Object>> result;
    
    @JsonProperty("task")
    private Integer task;
    
    @JsonProperty("ground_truth")
    private Boolean groundTruth;
    
    @JsonProperty("lead_time")
    private Double leadTime;
}