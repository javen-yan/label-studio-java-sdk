package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Request object for creating a new project member.
 */
public class MemberCreateRequest {
    
    @JsonProperty("user")
    private Integer userId;
    
    @JsonProperty("role")
    private String role;
    
    @JsonProperty("enabled")
    private Boolean enabled;
    
    /**
     * Default constructor.
     */
    public MemberCreateRequest() {
    }
    
    /**
     * Gets the user ID to add as a member.
     * 
     * @return the user ID
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * Sets the user ID to add as a member.
     * 
     * @param userId the user ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * Gets the role for the new member.
     * 
     * @return the role
     */
    public String getRole() {
        return role;
    }
    
    /**
     * Sets the role for the new member.
     * 
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    /**
     * Gets whether the member should be enabled.
     * 
     * @return true if the member should be enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }
    
    /**
     * Sets whether the member should be enabled.
     * 
     * @param enabled true to enable the member
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    /**
     * Creates a new builder for MemberCreateRequest.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberCreateRequest that = (MemberCreateRequest) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(role, that.role) &&
               Objects.equals(enabled, that.enabled);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(userId, role, enabled);
    }
    
    @Override
    public String toString() {
        return "MemberCreateRequest{" +
                "userId=" + userId +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                '}';
    }
    
    /**
     * Builder for creating MemberCreateRequest instances.
     */
    public static class Builder {
        private final MemberCreateRequest request;
        
        private Builder() {
            this.request = new MemberCreateRequest();
        }
        
        /**
         * Sets the user ID to add as a member.
         * 
         * @param userId the user ID
         * @return this builder
         */
        public Builder userId(Integer userId) {
            request.setUserId(userId);
            return this;
        }
        
        /**
         * Sets the role for the new member.
         * 
         * @param role the role
         * @return this builder
         */
        public Builder role(String role) {
            request.setRole(role);
            return this;
        }
        
        /**
         * Sets the member as enabled.
         * 
         * @return this builder
         */
        public Builder enabled() {
            request.setEnabled(true);
            return this;
        }
        
        /**
         * Sets whether the member should be enabled.
         * 
         * @param enabled true to enable the member
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            request.setEnabled(enabled);
            return this;
        }
        
        /**
         * Sets the role as annotator.
         * 
         * @return this builder
         */
        public Builder annotator() {
            request.setRole("annotator");
            return this;
        }
        
        /**
         * Sets the role as reviewer.
         * 
         * @return this builder
         */
        public Builder reviewer() {
            request.setRole("reviewer");
            return this;
        }
        
        /**
         * Sets the role as manager.
         * 
         * @return this builder
         */
        public Builder manager() {
            request.setRole("manager");
            return this;
        }
        
        /**
         * Builds the MemberCreateRequest.
         * 
         * @return the built request
         */
        public MemberCreateRequest build() {
            return request;
        }
    }
}