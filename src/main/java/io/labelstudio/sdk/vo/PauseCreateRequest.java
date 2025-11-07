package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * Request object for creating project pauses.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PauseCreateRequest {
    
    @JsonProperty("reason")
    private String reason;
    
    @JsonProperty("paused_by")
    private Integer pausedBy;
    
    @JsonProperty("scheduled_resume")
    private OffsetDateTime scheduledResume;
    
    @JsonProperty("note")
    private String note;
}