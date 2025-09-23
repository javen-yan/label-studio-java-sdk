package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents a webhook configuration in Label Studio.
 */
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
    
    // Constructors
    public Webhook() {}
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Boolean getSendPayload() {
        return sendPayload;
    }
    
    public void setSendPayload(Boolean sendPayload) {
        this.sendPayload = sendPayload;
    }
    
    public Boolean getSendForAllActions() {
        return sendForAllActions;
    }
    
    public void setSendForAllActions(Boolean sendForAllActions) {
        this.sendForAllActions = sendForAllActions;
    }
    
    public List<String> getActions() {
        return actions;
    }
    
    public void setActions(List<String> actions) {
        this.actions = actions;
    }
    
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    public Integer getOrganizationId() {
        return organizationId;
    }
    
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
    
    public Map<String, String> getHeaders() {
        return headers;
    }
    
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Integer getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    
    public String getSecret() {
        return secret;
    }
    
    public void setSecret(String secret) {
        this.secret = secret;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}