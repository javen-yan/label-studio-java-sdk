package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * Represents a project pause in Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
