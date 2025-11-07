package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Request object for bulk task assignments.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BulkAssignmentRequest {
    
    @JsonProperty("tasks")
    private List<Integer> taskIds;
    
    @JsonProperty("users")
    private List<Integer> userIds;
    
    @JsonProperty("assigned_by")
    private Integer assignedBy;
    
    @JsonProperty("priority")
    private Integer priority;
    
    @JsonProperty("note")
    private String note;
    
    @JsonProperty("assignment_type")
    private String assignmentType;
}