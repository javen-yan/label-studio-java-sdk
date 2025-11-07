package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Request object for updating webhook configurations.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebhookUpdateRequest {
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("send_payload")
    private Boolean sendPayload;
    
    @JsonProperty("send_for_all_actions")
    private Boolean sendForAllActions;
    
    @JsonProperty("actions")
    private List<String> actions;
    
    @JsonProperty("headers")
    private Map<String, String> headers;
    
    @JsonProperty("is_active")
    private Boolean isActive;
    
    @JsonProperty("secret")
    private String secret;
    
    @JsonProperty("description")
    private String description;
}