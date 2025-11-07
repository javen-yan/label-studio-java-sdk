package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object for creating task assignments.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentCreateRequest {
    
    @JsonProperty("task")
    private Integer taskId;
    
    @JsonProperty("user")
    private Integer userId;
    
    @JsonProperty("assigned_by")
    private Integer assignedBy;
    
    @JsonProperty("priority")
    private Integer priority;
    
    @JsonProperty("note")
    private String note;
}