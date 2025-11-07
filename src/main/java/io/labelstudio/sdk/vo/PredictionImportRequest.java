package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Request object for importing predictions.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PredictionImportRequest {
    
    @JsonProperty("result")
    private List<Map<String, Object>> result;
    
    @JsonProperty("score")
    private Double score;
    
    @JsonProperty("cluster")
    private Integer cluster;
    
    @JsonProperty("neighbors")
    private List<Map<String, Object>> neighbors;
    
    @JsonProperty("mislabeling")
    private Double mislabeling;
    
    @JsonProperty("task")
    private Integer task;
    
    @JsonProperty("model_version")
    private String modelVersion;
}
