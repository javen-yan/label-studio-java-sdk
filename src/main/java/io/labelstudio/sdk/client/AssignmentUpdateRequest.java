package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object for updating task assignments.
 */
public class AssignmentUpdateRequest {
    
    @JsonProperty("user")
    private Integer userId;
    
    @JsonProperty("priority")
    private Integer priority;
    
    @JsonProperty("note")
    private String note;
    
    @JsonProperty("status")
    private String status;
    
    private AssignmentUpdateRequest(Builder builder) {
        this.userId = builder.userId;
        this.priority = builder.priority;
        this.note = builder.note;
        this.status = builder.status;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public Integer getUserId() {
        return userId;
    }
    
    public Integer getPriority() {
        return priority;
    }
    
    public String getNote() {
        return note;
    }
    
    public String getStatus() {
        return status;
    }
    
    public static class Builder {
        private Integer userId;
        private Integer priority;
        private String note;
        private String status;
        
        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }
        
        public Builder priority(Integer priority) {
            this.priority = priority;
            return this;
        }
        
        public Builder note(String note) {
            this.note = note;
            return this;
        }
        
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        
        public Builder active() {
            this.status = "active";
            return this;
        }
        
        public Builder completed() {
            this.status = "completed";
            return this;
        }
        
        public Builder cancelled() {
            this.status = "cancelled";
            return this;
        }
        
        public AssignmentUpdateRequest build() {
            return new AssignmentUpdateRequest(this);
        }
    }
}