package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

/**
 * Represents a project member with their role and permissions.
 * 
 * <p>A project member is a user who has been granted access to a specific project
 * with a defined role that determines their permissions within that project.</p>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
