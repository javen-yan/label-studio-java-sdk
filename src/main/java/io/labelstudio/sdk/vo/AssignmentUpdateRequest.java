package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object for updating task assignments.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentUpdateRequest {
    
    @JsonProperty("user")
    private Integer userId;
    
    @JsonProperty("priority")
    private Integer priority;
    
    @JsonProperty("note")
    private String note;
    
    @JsonProperty("status")
    private String status;
}