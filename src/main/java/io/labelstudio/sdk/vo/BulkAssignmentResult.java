package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Result object for bulk assignment operations.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BulkAssignmentResult {
    
    @JsonProperty("success_count")
    private Integer successCount;
    
    @JsonProperty("error_count")
    private Integer errorCount;
    
    @JsonProperty("created_assignments")
    private List<Integer> createdAssignments;
    
    @JsonProperty("errors")
    private List<AssignmentError> errors;
    
    @JsonProperty("message")
    private String message;
    
    /**
     * Represents an error that occurred during bulk assignment.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AssignmentError {
        @JsonProperty("task_id")
        private Integer taskId;
        
        @JsonProperty("user_id")
        private Integer userId;
        
        @JsonProperty("error_message")
        private String errorMessage;
        
        @JsonProperty("error_code")
        private String errorCode;
    }
}
