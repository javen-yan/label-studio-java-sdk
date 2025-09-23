package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Request object for creating ML backend configurations.
 */
public class MlBackendCreateRequest {
    
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
    
    @JsonProperty("project")
    private Integer projectId;
    
    @JsonProperty("auth_method")
    private String authMethod;
    
    @JsonProperty("basic_auth_user")
    private String basicAuthUser;
    
    @JsonProperty("basic_auth_pass")
    private String basicAuthPass;
    
    @JsonProperty("extra_params")
    private Map<String, Object> extraParams;
    
    private MlBackendCreateRequest(Builder builder) {
        this.url = builder.url;
        this.title = builder.title;
        this.description = builder.description;
        this.modelVersion = builder.modelVersion;
        this.isInteractive = builder.isInteractive;
        this.timeout = builder.timeout;
        this.autoUpdate = builder.autoUpdate;
        this.projectId = builder.projectId;
        this.authMethod = builder.authMethod;
        this.basicAuthUser = builder.basicAuthUser;
        this.basicAuthPass = builder.basicAuthPass;
        this.extraParams = builder.extraParams;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public String getUrl() { return url; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getModelVersion() { return modelVersion; }
    public Boolean getIsInteractive() { return isInteractive; }
    public Integer getTimeout() { return timeout; }
    public Boolean getAutoUpdate() { return autoUpdate; }
    public Integer getProjectId() { return projectId; }
    public String getAuthMethod() { return authMethod; }
    public String getBasicAuthUser() { return basicAuthUser; }
    public String getBasicAuthPass() { return basicAuthPass; }
    public Map<String, Object> getExtraParams() { return extraParams; }
    
    public static class Builder {
        private String url;
        private String title;
        private String description;
        private String modelVersion;
        private Boolean isInteractive;
        private Integer timeout;
        private Boolean autoUpdate;
        private Integer projectId;
        private String authMethod;
        private String basicAuthUser;
        private String basicAuthPass;
        private Map<String, Object> extraParams;
        
        public Builder url(String url) { this.url = url; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder modelVersion(String modelVersion) { this.modelVersion = modelVersion; return this; }
        public Builder isInteractive(Boolean isInteractive) { this.isInteractive = isInteractive; return this; }
        public Builder interactive() { this.isInteractive = true; return this; }
        public Builder nonInteractive() { this.isInteractive = false; return this; }
        public Builder timeout(Integer timeout) { this.timeout = timeout; return this; }
        public Builder autoUpdate(Boolean autoUpdate) { this.autoUpdate = autoUpdate; return this; }
        public Builder autoUpdate() { this.autoUpdate = true; return this; }
        public Builder noAutoUpdate() { this.autoUpdate = false; return this; }
        public Builder projectId(Integer projectId) { this.projectId = projectId; return this; }
        public Builder authMethod(String authMethod) { this.authMethod = authMethod; return this; }
        public Builder noAuth() { this.authMethod = "NONE"; return this; }
        public Builder basicAuth() { this.authMethod = "BASIC_AUTH"; return this; }
        public Builder basicAuthUser(String basicAuthUser) { this.basicAuthUser = basicAuthUser; return this; }
        public Builder basicAuthPass(String basicAuthPass) { this.basicAuthPass = basicAuthPass; return this; }
        public Builder extraParams(Map<String, Object> extraParams) { this.extraParams = extraParams; return this; }
        
        public MlBackendCreateRequest build() {
            return new MlBackendCreateRequest(this);
        }
    }
}