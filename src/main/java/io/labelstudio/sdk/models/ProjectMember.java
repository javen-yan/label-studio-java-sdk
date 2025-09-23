package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents a project member with their role and permissions.
 * 
 * <p>A project member is a user who has been granted access to a specific project
 * with a defined role that determines their permissions within that project.</p>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectMember {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("user")
    private UserSimple user;
    
    @JsonProperty("role")
    private String role;
    
    @JsonProperty("enabled")
    private Boolean enabled;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    
    /**
     * Default constructor.
     */
    public ProjectMember() {
    }
    
    /**
     * Gets the member ID.
     * 
     * @return the member ID
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the member ID.
     * 
     * @param id the member ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Gets the user information.
     * 
     * @return the user
     */
    public UserSimple getUser() {
        return user;
    }
    
    /**
     * Sets the user information.
     * 
     * @param user the user
     */
    public void setUser(UserSimple user) {
        this.user = user;
    }
    
    /**
     * Gets the member's role in the project.
     * 
     * @return the role
     */
    public String getRole() {
        return role;
    }
    
    /**
     * Sets the member's role in the project.
     * 
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    /**
     * Gets whether the member is enabled.
     * 
     * @return true if the member is enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }
    
    /**
     * Sets whether the member is enabled.
     * 
     * @param enabled true to enable the member
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    /**
     * Gets the creation timestamp.
     * 
     * @return the creation timestamp
     */
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    
    /**
     * Sets the creation timestamp.
     * 
     * @param createdAt the creation timestamp
     */
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * Gets the last update timestamp.
     * 
     * @return the last update timestamp
     */
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    /**
     * Sets the last update timestamp.
     * 
     * @param updatedAt the last update timestamp
     */
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    /**
     * Gets the user ID from the associated user.
     * 
     * @return the user ID or null if user is not set
     */
    public Integer getUserId() {
        return user != null ? user.getId() : null;
    }
    
    /**
     * Gets the username from the associated user.
     * 
     * @return the username or null if user is not set
     */
    public String getUsername() {
        return user != null ? user.getUsername() : null;
    }
    
    /**
     * Gets the full name from the associated user.
     * 
     * @return the full name or null if user is not set
     */
    public String getUserFullName() {
        return user != null ? user.getFullName() : null;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectMember that = (ProjectMember) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "ProjectMember{" +
                "id=" + id +
                ", user=" + user +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                ", createdAt=" + createdAt +
                '}';
    }
}