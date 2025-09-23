package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Request object for bulk task assignments.
 */
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
    
    private BulkAssignmentRequest(Builder builder) {
        this.taskIds = builder.taskIds;
        this.userIds = builder.userIds;
        this.assignedBy = builder.assignedBy;
        this.priority = builder.priority;
        this.note = builder.note;
        this.assignmentType = builder.assignmentType;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public List<Integer> getTaskIds() {
        return taskIds;
    }
    
    public List<Integer> getUserIds() {
        return userIds;
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
    
    public String getAssignmentType() {
        return assignmentType;
    }
    
    public static class Builder {
        private List<Integer> taskIds;
        private List<Integer> userIds;
        private Integer assignedBy;
        private Integer priority;
        private String note;
        private String assignmentType;
        
        public Builder taskIds(List<Integer> taskIds) {
            this.taskIds = taskIds;
            return this;
        }
        
        public Builder userIds(List<Integer> userIds) {
            this.userIds = userIds;
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
        
        public Builder assignmentType(String assignmentType) {
            this.assignmentType = assignmentType;
            return this;
        }
        
        public Builder roundRobin() {
            this.assignmentType = "round_robin";
            return this;
        }
        
        public Builder manual() {
            this.assignmentType = "manual";
            return this;
        }
        
        public BulkAssignmentRequest build() {
            return new BulkAssignmentRequest(this);
        }
    }
}