package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Request object for bulk member operations.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}