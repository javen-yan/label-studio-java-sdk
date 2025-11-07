package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Represents an organization in Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
