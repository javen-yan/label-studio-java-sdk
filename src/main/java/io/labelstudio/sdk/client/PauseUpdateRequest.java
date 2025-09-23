package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

/**
 * Request object for updating project pauses.
 */
public class PauseUpdateRequest {
    
    @JsonProperty("reason")
    private String reason;
    
    @JsonProperty("resumed_at")
    private OffsetDateTime resumedAt;
    
    @JsonProperty("resumed_by")
    private Integer resumedBy;
    
    @JsonProperty("scheduled_resume")
    private OffsetDateTime scheduledResume;
    
    @JsonProperty("note")
    private String note;
    
    @JsonProperty("status")
    private String status;
    
    private PauseUpdateRequest(Builder builder) {
        this.reason = builder.reason;
        this.resumedAt = builder.resumedAt;
        this.resumedBy = builder.resumedBy;
        this.scheduledResume = builder.scheduledResume;
        this.note = builder.note;
        this.status = builder.status;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public String getReason() {
        return reason;
    }
    
    public OffsetDateTime getResumedAt() {
        return resumedAt;
    }
    
    public Integer getResumedBy() {
        return resumedBy;
    }
    
    public OffsetDateTime getScheduledResume() {
        return scheduledResume;
    }
    
    public String getNote() {
        return note;
    }
    
    public String getStatus() {
        return status;
    }
    
    public static class Builder {
        private String reason;
        private OffsetDateTime resumedAt;
        private Integer resumedBy;
        private OffsetDateTime scheduledResume;
        private String note;
        private String status;
        
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }
        
        public Builder resumedAt(OffsetDateTime resumedAt) {
            this.resumedAt = resumedAt;
            return this;
        }
        
        public Builder resumedBy(Integer resumedBy) {
            this.resumedBy = resumedBy;
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
        
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        
        public Builder resume() {
            this.status = "resumed";
            this.resumedAt = OffsetDateTime.now();
            return this;
        }
        
        public PauseUpdateRequest build() {
            return new PauseUpdateRequest(this);
        }
    }
}