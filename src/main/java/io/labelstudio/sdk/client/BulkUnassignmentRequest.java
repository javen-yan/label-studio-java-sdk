package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Request object for bulk task unassignments.
 */
public class BulkUnassignmentRequest {
    
    @JsonProperty("tasks")
    private List<Integer> taskIds;
    
    @JsonProperty("users")
    private List<Integer> userIds;
    
    @JsonProperty("unassigned_by")
    private Integer unassignedBy;
    
    @JsonProperty("note")
    private String note;
    
    private BulkUnassignmentRequest(Builder builder) {
        this.taskIds = builder.taskIds;
        this.userIds = builder.userIds;
        this.unassignedBy = builder.unassignedBy;
        this.note = builder.note;
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
    
    public Integer getUnassignedBy() {
        return unassignedBy;
    }
    
    public String getNote() {
        return note;
    }
    
    public static class Builder {
        private List<Integer> taskIds;
        private List<Integer> userIds;
        private Integer unassignedBy;
        private String note;
        
        public Builder taskIds(List<Integer> taskIds) {
            this.taskIds = taskIds;
            return this;
        }
        
        public Builder userIds(List<Integer> userIds) {
            this.userIds = userIds;
            return this;
        }
        
        public Builder unassignedBy(Integer unassignedBy) {
            this.unassignedBy = unassignedBy;
            return this;
        }
        
        public Builder note(String note) {
            this.note = note;
            return this;
        }
        
        public BulkUnassignmentRequest build() {
            return new BulkUnassignmentRequest(this);
        }
    }
}