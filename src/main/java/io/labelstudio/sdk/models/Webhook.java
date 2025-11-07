package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents a webhook configuration in Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Webhook {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("send_payload")
    private Boolean sendPayload;
    
    @JsonProperty("send_for_all_actions")
    private Boolean sendForAllActions;
    
    @JsonProperty("actions")
    private List<String> actions;
    
    @JsonProperty("project")
    private Integer projectId;
    
    @JsonProperty("organization")
    private Integer organizationId;
    
    @JsonProperty("headers")
    private Map<String, String> headers;
    
    @JsonProperty("is_active")
    private Boolean isActive;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    @JsonProperty("created_by")
    private Integer createdBy;
    
    @JsonProperty("secret")
    private String secret;
    
    @JsonProperty("description")
    private String description;
}
