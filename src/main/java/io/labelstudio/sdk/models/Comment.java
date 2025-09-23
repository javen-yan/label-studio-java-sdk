package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public class Comment {
    @JsonProperty("id") private Integer id;
    @JsonProperty("task") private Integer taskId;
    @JsonProperty("annotation") private Integer annotationId;
    @JsonProperty("project") private Integer projectId;
    @JsonProperty("user") private Integer userId;
    @JsonProperty("user_name") private String userName;
    @JsonProperty("text") private String text;
    @JsonProperty("is_resolved") private Boolean isResolved;
    @JsonProperty("resolved_by") private Integer resolvedBy;
    @JsonProperty("resolved_by_name") private String resolvedByName;
    @JsonProperty("resolved_at") private OffsetDateTime resolvedAt;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
    @JsonProperty("updated_at") private OffsetDateTime updatedAt;
    
    public Comment() {}
    
    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getTaskId() { return taskId; }
    public void setTaskId(Integer taskId) { this.taskId = taskId; }
    public Integer getAnnotationId() { return annotationId; }
    public void setAnnotationId(Integer annotationId) { this.annotationId = annotationId; }
    public Integer getProjectId() { return projectId; }
    public void setProjectId(Integer projectId) { this.projectId = projectId; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public Boolean getIsResolved() { return isResolved; }
    public void setIsResolved(Boolean isResolved) { this.isResolved = isResolved; }
    public Integer getResolvedBy() { return resolvedBy; }
    public void setResolvedBy(Integer resolvedBy) { this.resolvedBy = resolvedBy; }
    public String getResolvedByName() { return resolvedByName; }
    public void setResolvedByName(String resolvedByName) { this.resolvedByName = resolvedByName; }
    public OffsetDateTime getResolvedAt() { return resolvedAt; }
    public void setResolvedAt(OffsetDateTime resolvedAt) { this.resolvedAt = resolvedAt; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}