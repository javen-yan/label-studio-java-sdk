package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Request object for creating organizations.
 */
public class OrganizationCreateRequest {
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("contact_info")
    private Map<String, Object> contactInfo;
    
    @JsonProperty("settings")
    private Map<String, Object> settings;
    
    private OrganizationCreateRequest(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.contactInfo = builder.contactInfo;
        this.settings = builder.settings;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Map<String, Object> getContactInfo() { return contactInfo; }
    public Map<String, Object> getSettings() { return settings; }
    
    public static class Builder {
        private String title;
        private String description;
        private Map<String, Object> contactInfo;
        private Map<String, Object> settings;
        
        public Builder title(String title) { this.title = title; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder contactInfo(Map<String, Object> contactInfo) { this.contactInfo = contactInfo; return this; }
        public Builder settings(Map<String, Object> settings) { this.settings = settings; return this; }
        
        public OrganizationCreateRequest build() {
            return new OrganizationCreateRequest(this);
        }
    }
}