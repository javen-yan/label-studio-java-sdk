package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Request object for bulk member operations.
 */
public class BulkMemberRequest {
    
    @JsonProperty("user_ids")
    private List<Integer> userIds;
    
    @JsonProperty("emails")
    private List<String> emails;
    
    @JsonProperty("role")
    private String role;
    
    @JsonProperty("enabled")
    private Boolean enabled;
    
    @JsonProperty("action")
    private String action;
    
    private BulkMemberRequest(Builder builder) {
        this.userIds = builder.userIds;
        this.emails = builder.emails;
        this.role = builder.role;
        this.enabled = builder.enabled;
        this.action = builder.action;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public List<Integer> getUserIds() {
        return userIds;
    }
    
    public List<String> getEmails() {
        return emails;
    }
    
    public String getRole() {
        return role;
    }
    
    public Boolean getEnabled() {
        return enabled;
    }
    
    public String getAction() {
        return action;
    }
    
    public static class Builder {
        private List<Integer> userIds;
        private List<String> emails;
        private String role;
        private Boolean enabled;
        private String action;
        
        public Builder userIds(List<Integer> userIds) {
            this.userIds = userIds;
            return this;
        }
        
        public Builder emails(List<String> emails) {
            this.emails = emails;
            return this;
        }
        
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        
        public Builder annotator() {
            this.role = "annotator";
            return this;
        }
        
        public Builder reviewer() {
            this.role = "reviewer";
            return this;
        }
        
        public Builder manager() {
            this.role = "manager";
            return this;
        }
        
        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }
        
        public Builder enabled() {
            this.enabled = true;
            return this;
        }
        
        public Builder disabled() {
            this.enabled = false;
            return this;
        }
        
        public Builder action(String action) {
            this.action = action;
            return this;
        }
        
        public Builder add() {
            this.action = "add";
            return this;
        }
        
        public Builder remove() {
            this.action = "remove";
            return this;
        }
        
        public Builder update() {
            this.action = "update";
            return this;
        }
        
        public BulkMemberRequest build() {
            return new BulkMemberRequest(this);
        }
    }
}