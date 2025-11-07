package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Result of task event creation.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskEventResult {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("task")
    private Integer task;
    
    @JsonProperty("action")
    private String action;
    
    @JsonProperty("timestamp")
    private Long timestamp;
}

