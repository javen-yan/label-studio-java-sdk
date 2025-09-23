package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

/**
 * Request object for creating project pauses.
 */
public class PauseCreateRequest {
    
    @JsonProperty("reason")
    private String reason;
    
    @JsonProperty("paused_by")
    private Integer pausedBy;
    
    @JsonProperty("scheduled_resume")
    private OffsetDateTime scheduledResume;
    
    @JsonProperty("note")
    private String note;
    
    private PauseCreateRequest(Builder builder) {
        this.reason = builder.reason;
        this.pausedBy = builder.pausedBy;
        this.scheduledResume = builder.scheduledResume;
        this.note = builder.note;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public String getReason() {
        return reason;
    }
    
    public Integer getPausedBy() {
        return pausedBy;
    }
    
    public OffsetDateTime getScheduledResume() {
        return scheduledResume;
    }
    
    public String getNote() {
        return note;
    }
    
    public static class Builder {
        private String reason;
        private Integer pausedBy;
        private OffsetDateTime scheduledResume;
        private String note;
        
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }
        
        public Builder pausedBy(Integer pausedBy) {
            this.pausedBy = pausedBy;
            return this;
        }
        
        public Builder scheduledResume(OffsetDateTime scheduledResume) {
            this.scheduledResume = scheduledResume;
            return this;
        }
        
        public Builder note(String note) {
            this.note = note;
            return this;
        }
        
        public PauseCreateRequest build() {
            return new PauseCreateRequest(this);
        }
    }
}