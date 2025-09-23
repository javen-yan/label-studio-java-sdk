package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

/**
 * Represents a task assignment in Label Studio.
 */
public class Assignment {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("task")
    private Integer taskId;
    
    @JsonProperty("user")
    private Integer userId;
    
    @JsonProperty("assigned_by")
    private Integer assignedBy;
    
    @JsonProperty("project")
    private Integer projectId;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("priority")
    private Integer priority;
    
    @JsonProperty("note")
    private String note;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    @JsonProperty("assigned_at")
    private OffsetDateTime assignedAt;
    
    @JsonProperty("completed_at")
    private OffsetDateTime completedAt;
    
    @JsonProperty("user_name")
    private String userName;
    
    @JsonProperty("assigned_by_name")
    private String assignedByName;
    
    // Constructors
    public Assignment() {}
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
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
    
    public Integer getAssignedBy() {
        return assignedBy;
    }
    
    public void setAssignedBy(Integer assignedBy) {
        this.assignedBy = assignedBy;
    }
    
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Integer getPriority() {
        return priority;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public OffsetDateTime getAssignedAt() {
        return assignedAt;
    }
    
    public void setAssignedAt(OffsetDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
    
    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }
    
    public void setCompletedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getAssignedByName() {
        return assignedByName;
    }
    
    public void setAssignedByName(String assignedByName) {
        this.assignedByName = assignedByName;
    }
}