package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;
import java.util.Map;

/**
 * Represents a complete user object with all fields.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("first_name")
    private String firstName;
    
    @JsonProperty("last_name")
    private String lastName;
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("last_activity")
    private OffsetDateTime lastActivity;
    
    @JsonProperty("custom_hotkeys")
    private Map<String, Object> customHotkeys;
    
    @JsonProperty("avatar")
    private String avatar;
    
    @JsonProperty("initials")
    private String initials;
    
    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("active_organization")
    private Integer activeOrganization;
    
    @JsonProperty("active_organization_meta")
    private ActiveOrganizationMeta activeOrganizationMeta;
    
    @JsonProperty("allow_newsletters")
    private Boolean allowNewsletters;
    
    @JsonProperty("date_joined")
    private OffsetDateTime dateJoined;
    
    /**
     * Represents the active organization metadata.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ActiveOrganizationMeta {
        
        @JsonProperty("title")
        private String title;
        
        @JsonProperty("email")
        private String email;
    }
}

