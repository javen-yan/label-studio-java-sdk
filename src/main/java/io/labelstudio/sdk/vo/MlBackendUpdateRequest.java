package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Request object for updating ML backend configurations.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MlBackendUpdateRequest {
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("model_version")
    private String modelVersion;
    
    @JsonProperty("is_interactive")
    private Boolean isInteractive;
    
    @JsonProperty("timeout")
    private Integer timeout;
    
    @JsonProperty("auto_update")
    private Boolean autoUpdate;
    
    @JsonProperty("auth_method")
    private String authMethod;
    
    @JsonProperty("basic_auth_user")
    private String basicAuthUser;
    
    @JsonProperty("basic_auth_pass")
    private String basicAuthPass;
    
    @JsonProperty("extra_params")
    private Map<String, Object> extraParams;
}