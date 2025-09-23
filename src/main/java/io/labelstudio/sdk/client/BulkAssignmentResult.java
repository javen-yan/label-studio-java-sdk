package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Result object for bulk assignment operations.
 */
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
    
    // Constructors
    public BulkAssignmentResult() {}
    
    // Getters and Setters
    public Integer getSuccessCount() {
        return successCount;
    }
    
    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }
    
    public Integer getErrorCount() {
        return errorCount;
    }
    
    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }
    
    public List<Integer> getCreatedAssignments() {
        return createdAssignments;
    }
    
    public void setCreatedAssignments(List<Integer> createdAssignments) {
        this.createdAssignments = createdAssignments;
    }
    
    public List<AssignmentError> getErrors() {
        return errors;
    }
    
    public void setErrors(List<AssignmentError> errors) {
        this.errors = errors;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Represents an error that occurred during bulk assignment.
     */
    public static class AssignmentError {
        @JsonProperty("task_id")
        private Integer taskId;
        
        @JsonProperty("user_id")
        private Integer userId;
        
        @JsonProperty("error_message")
        private String errorMessage;
        
        @JsonProperty("error_code")
        private String errorCode;
        
        // Constructors
        public AssignmentError() {}
        
        // Getters and Setters
        public Integer getTaskId() {
            return taskId;
        }
        
        public void setTaskId(Integer taskId) {
            this.taskId = taskId;
        }
        
        public Integer getUserId() {
            return userId;
        }
        
        public void setUserId(Integer userId) {
            this.userId = userId;
        }
        
        public String getErrorMessage() {
            return errorMessage;
        }
        
        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
        
        public String getErrorCode() {
            return errorCode;
        }
        
        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }
    }
}