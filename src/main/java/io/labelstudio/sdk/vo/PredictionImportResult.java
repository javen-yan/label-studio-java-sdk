package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Result of prediction import operation.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PredictionImportResult {
    
    @JsonProperty("prediction_count")
    private int predictionCount;
    
    @JsonProperty("duration")
    private double duration;
    
    @JsonProperty("created")
    private int created;
    
    @JsonProperty("updated")
    private int updated;
    
    @JsonProperty("errors")
    private int errors;
}
