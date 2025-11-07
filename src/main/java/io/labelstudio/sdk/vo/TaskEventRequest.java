package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Request object for creating a task event.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskEventRequest {
    
    @JsonProperty("action")
    private String action;
    
    @JsonProperty("timestamp")
    private Long timestamp;
    
    @JsonProperty("data")
    private Map<String, Object> data;
}

