package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Request object for bulk task unassignments.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BulkUnassignmentRequest {
    
    @JsonProperty("tasks")
    private List<Integer> taskIds;
    
    @JsonProperty("users")
    private List<Integer> userIds;
    
    @JsonProperty("unassigned_by")
    private Integer unassignedBy;
    
    @JsonProperty("note")
    private String note;
}
