package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Request object for updating a project member.
 */
public class MemberUpdateRequest {
    
    @JsonProperty("role")
    private String role;
    
    @JsonProperty("enabled")
    private Boolean enabled;
    
    /**
     * Default constructor.
     */
    public MemberUpdateRequest() {
    }
    
    /**
     * Gets the role for the member.
     * 
     * @return the role
     */
    public String getRole() {
        return role;
    }
    
    /**
     * Sets the role for the member.
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
     * Creates a new builder for MemberUpdateRequest.
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
        MemberUpdateRequest that = (MemberUpdateRequest) o;
        return Objects.equals(role, that.role) &&
               Objects.equals(enabled, that.enabled);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(role, enabled);
    }
    
    @Override
    public String toString() {
        return "MemberUpdateRequest{" +
                "role='" + role + '\'' +
                ", enabled=" + enabled +
                '}';
    }
    
    /**
     * Builder for creating MemberUpdateRequest instances.
     */
    public static class Builder {
        private final MemberUpdateRequest request;
        
        private Builder() {
            this.request = new MemberUpdateRequest();
        }
        
        /**
         * Sets the role for the member.
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
         * Sets the member as disabled.
         * 
         * @return this builder
         */
        public Builder disabled() {
            request.setEnabled(false);
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
         * Builds the MemberUpdateRequest.
         * 
         * @return the built request
         */
        public MemberUpdateRequest build() {
            return request;
        }
    }
}