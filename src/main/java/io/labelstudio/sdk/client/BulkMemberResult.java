package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Result object for bulk member operations.
 */
public class BulkMemberResult {
    
    @JsonProperty("success_count")
    private Integer successCount;
    
    @JsonProperty("error_count")
    private Integer errorCount;
    
    @JsonProperty("created_members")
    private List<Integer> createdMembers;
    
    @JsonProperty("updated_members")
    private List<Integer> updatedMembers;
    
    @JsonProperty("removed_members")
    private List<Integer> removedMembers;
    
    @JsonProperty("errors")
    private List<MemberError> errors;
    
    @JsonProperty("message")
    private String message;
    
    // Constructors
    public BulkMemberResult() {}
    
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
    
    public List<Integer> getCreatedMembers() {
        return createdMembers;
    }
    
    public void setCreatedMembers(List<Integer> createdMembers) {
        this.createdMembers = createdMembers;
    }
    
    public List<Integer> getUpdatedMembers() {
        return updatedMembers;
    }
    
    public void setUpdatedMembers(List<Integer> updatedMembers) {
        this.updatedMembers = updatedMembers;
    }
    
    public List<Integer> getRemovedMembers() {
        return removedMembers;
    }
    
    public void setRemovedMembers(List<Integer> removedMembers) {
        this.removedMembers = removedMembers;
    }
    
    public List<MemberError> getErrors() {
        return errors;
    }
    
    public void setErrors(List<MemberError> errors) {
        this.errors = errors;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Represents an error that occurred during bulk member operations.
     */
    public static class MemberError {
        @JsonProperty("user_id")
        private Integer userId;
        
        @JsonProperty("email")
        private String email;
        
        @JsonProperty("error_message")
        private String errorMessage;
        
        @JsonProperty("error_code")
        private String errorCode;
        
        // Constructors
        public MemberError() {}
        
        // Getters and Setters
        public Integer getUserId() {
            return userId;
        }
        
        public void setUserId(Integer userId) {
            this.userId = userId;
        }
        
        public String getEmail() {
            return email;
        }
        
        public void setEmail(String email) {
            this.email = email;
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