package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * Request object for updating project pauses.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}