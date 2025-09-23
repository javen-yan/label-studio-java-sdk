package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

/**
 * Represents a project pause in Label Studio.
 */
public class ProjectPause {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("project")
    private Integer projectId;
    
    @JsonProperty("reason")
    private String reason;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("paused_at")
    private OffsetDateTime pausedAt;
    
    @JsonProperty("resumed_at")
    private OffsetDateTime resumedAt;
    
    @JsonProperty("paused_by")
    private Integer pausedBy;
    
    @JsonProperty("resumed_by")
    private Integer resumedBy;
    
    @JsonProperty("scheduled_resume")
    private OffsetDateTime scheduledResume;
    
    @JsonProperty("note")
    private String note;
    
    @JsonProperty("duration_seconds")
    private Long durationSeconds;
    
    @JsonProperty("paused_by_name")
    private String pausedByName;
    
    @JsonProperty("resumed_by_name")
    private String resumedByName;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    // Constructors
    public ProjectPause() {}
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public OffsetDateTime getPausedAt() {
        return pausedAt;
    }
    
    public void setPausedAt(OffsetDateTime pausedAt) {
        this.pausedAt = pausedAt;
    }
    
    public OffsetDateTime getResumedAt() {
        return resumedAt;
    }
    
    public void setResumedAt(OffsetDateTime resumedAt) {
        this.resumedAt = resumedAt;
    }
    
    public Integer getPausedBy() {
        return pausedBy;
    }
    
    public void setPausedBy(Integer pausedBy) {
        this.pausedBy = pausedBy;
    }
    
    public Integer getResumedBy() {
        return resumedBy;
    }
    
    public void setResumedBy(Integer resumedBy) {
        this.resumedBy = resumedBy;
    }
    
    public OffsetDateTime getScheduledResume() {
        return scheduledResume;
    }
    
    public void setScheduledResume(OffsetDateTime scheduledResume) {
        this.scheduledResume = scheduledResume;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public Long getDurationSeconds() {
        return durationSeconds;
    }
    
    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
    
    public String getPausedByName() {
        return pausedByName;
    }
    
    public void setPausedByName(String pausedByName) {
        this.pausedByName = pausedByName;
    }
    
    public String getResumedByName() {
        return resumedByName;
    }
    
    public void setResumedByName(String resumedByName) {
        this.resumedByName = resumedByName;
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
    
    // Convenience methods
    public boolean isActive() {
        return "active".equals(status) || "paused".equals(status);
    }
    
    public boolean isResumed() {
        return "resumed".equals(status);
    }
    
    public boolean isCancelled() {
        return "cancelled".equals(status);
    }
}