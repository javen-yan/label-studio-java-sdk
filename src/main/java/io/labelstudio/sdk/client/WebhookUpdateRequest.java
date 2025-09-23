package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Request object for updating webhook configurations.
 */
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
    
    private WebhookUpdateRequest(Builder builder) {
        this.url = builder.url;
        this.sendPayload = builder.sendPayload;
        this.sendForAllActions = builder.sendForAllActions;
        this.actions = builder.actions;
        this.headers = builder.headers;
        this.isActive = builder.isActive;
        this.secret = builder.secret;
        this.description = builder.description;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public String getUrl() { return url; }
    public Boolean getSendPayload() { return sendPayload; }
    public Boolean getSendForAllActions() { return sendForAllActions; }
    public List<String> getActions() { return actions; }
    public Map<String, String> getHeaders() { return headers; }
    public Boolean getIsActive() { return isActive; }
    public String getSecret() { return secret; }
    public String getDescription() { return description; }
    
    public static class Builder {
        private String url;
        private Boolean sendPayload;
        private Boolean sendForAllActions;
        private List<String> actions;
        private Map<String, String> headers;
        private Boolean isActive;
        private String secret;
        private String description;
        
        public Builder url(String url) { this.url = url; return this; }
        public Builder sendPayload(Boolean sendPayload) { this.sendPayload = sendPayload; return this; }
        public Builder sendPayload() { this.sendPayload = true; return this; }
        public Builder noPayload() { this.sendPayload = false; return this; }
        public Builder sendForAllActions(Boolean sendForAllActions) { this.sendForAllActions = sendForAllActions; return this; }
        public Builder sendForAllActions() { this.sendForAllActions = true; return this; }
        public Builder sendForSpecificActions() { this.sendForAllActions = false; return this; }
        public Builder actions(List<String> actions) { this.actions = actions; return this; }
        public Builder headers(Map<String, String> headers) { this.headers = headers; return this; }
        public Builder isActive(Boolean isActive) { this.isActive = isActive; return this; }
        public Builder active() { this.isActive = true; return this; }
        public Builder inactive() { this.isActive = false; return this; }
        public Builder secret(String secret) { this.secret = secret; return this; }
        public Builder description(String description) { this.description = description; return this; }
        
        public WebhookUpdateRequest build() {
            return new WebhookUpdateRequest(this);
        }
    }
}