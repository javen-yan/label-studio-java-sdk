package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Represents an organization in Label Studio.
 */
public class Organization {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("token")
    private String token;
    
    @JsonProperty("created_by")
    private Integer createdBy;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    
    @JsonProperty("contact_info")
    private Map<String, Object> contactInfo;
    
    @JsonProperty("settings")
    private Map<String, Object> settings;
    
    @JsonProperty("is_active")
    private Boolean isActive;
    
    @JsonProperty("max_users")
    private Integer maxUsers;
    
    @JsonProperty("max_projects")
    private Integer maxProjects;
    
    @JsonProperty("max_datasets")
    private Integer maxDatasets;
    
    @JsonProperty("plan")
    private String plan;
    
    // Constructors
    public Organization() {}
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public Integer getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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
    
    public Map<String, Object> getContactInfo() {
        return contactInfo;
    }
    
    public void setContactInfo(Map<String, Object> contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    public Map<String, Object> getSettings() {
        return settings;
    }
    
    public void setSettings(Map<String, Object> settings) {
        this.settings = settings;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public Integer getMaxUsers() {
        return maxUsers;
    }
    
    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }
    
    public Integer getMaxProjects() {
        return maxProjects;
    }
    
    public void setMaxProjects(Integer maxProjects) {
        this.maxProjects = maxProjects;
    }
    
    public Integer getMaxDatasets() {
        return maxDatasets;
    }
    
    public void setMaxDatasets(Integer maxDatasets) {
        this.maxDatasets = maxDatasets;
    }
    
    public String getPlan() {
        return plan;
    }
    
    public void setPlan(String plan) {
        this.plan = plan;
    }
}