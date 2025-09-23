package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Request object for creating task assignments.
 */
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
    
    private AssignmentCreateRequest(Builder builder) {
        this.taskId = builder.taskId;
        this.userId = builder.userId;
        this.assignedBy = builder.assignedBy;
        this.priority = builder.priority;
        this.note = builder.note;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public Integer getTaskId() {
        return taskId;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public Integer getAssignedBy() {
        return assignedBy;
    }
    
    public Integer getPriority() {
        return priority;
    }
    
    public String getNote() {
        return note;
    }
    
    public static class Builder {
        private Integer taskId;
        private Integer userId;
        private Integer assignedBy;
        private Integer priority;
        private String note;
        
        public Builder taskId(Integer taskId) {
            this.taskId = taskId;
            return this;
        }
        
        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }
        
        public Builder assignedBy(Integer assignedBy) {
            this.assignedBy = assignedBy;
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
        
        public AssignmentCreateRequest build() {
            return new AssignmentCreateRequest(this);
        }
    }
}