package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object for updating export storage configurations.
 */
public class ExportStorageUpdateRequest {
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("bucket")
    private String bucket;
    
    @JsonProperty("prefix")
    private String prefix;
    
    @JsonProperty("aws_access_key_id")
    private String awsAccessKeyId;
    
    @JsonProperty("aws_secret_access_key")
    private String awsSecretAccessKey;
    
    @JsonProperty("aws_session_token")
    private String awsSessionToken;
    
    @JsonProperty("region_name")
    private String regionName;
    
    @JsonProperty("s3_endpoint")
    private String s3Endpoint;
    
    @JsonProperty("google_application_credentials")
    private String googleApplicationCredentials;
    
    @JsonProperty("azure_account_name")
    private String azureAccountName;
    
    @JsonProperty("azure_account_key")
    private String azureAccountKey;
    
    @JsonProperty("azure_connection_string")
    private String azureConnectionString;
    
    @JsonProperty("path")
    private String path;
    
    @JsonProperty("host")
    private String host;
    
    @JsonProperty("port")
    private Integer port;
    
    @JsonProperty("user")
    private String user;
    
    @JsonProperty("password")
    private String password;
    
    @JsonProperty("path_separator")
    private String pathSeparator;
    
    @JsonProperty("can_delete_objects")
    private Boolean canDeleteObjects;
    
    private ExportStorageUpdateRequest(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.bucket = builder.bucket;
        this.prefix = builder.prefix;
        this.awsAccessKeyId = builder.awsAccessKeyId;
        this.awsSecretAccessKey = builder.awsSecretAccessKey;
        this.awsSessionToken = builder.awsSessionToken;
        this.regionName = builder.regionName;
        this.s3Endpoint = builder.s3Endpoint;
        this.googleApplicationCredentials = builder.googleApplicationCredentials;
        this.azureAccountName = builder.azureAccountName;
        this.azureAccountKey = builder.azureAccountKey;
        this.azureConnectionString = builder.azureConnectionString;
        this.path = builder.path;
        this.host = builder.host;
        this.port = builder.port;
        this.user = builder.user;
        this.password = builder.password;
        this.pathSeparator = builder.pathSeparator;
        this.canDeleteObjects = builder.canDeleteObjects;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getBucket() { return bucket; }
    public String getPrefix() { return prefix; }
    public String getAwsAccessKeyId() { return awsAccessKeyId; }
    public String getAwsSecretAccessKey() { return awsSecretAccessKey; }
    public String getAwsSessionToken() { return awsSessionToken; }
    public String getRegionName() { return regionName; }
    public String getS3Endpoint() { return s3Endpoint; }
    public String getGoogleApplicationCredentials() { return googleApplicationCredentials; }
    public String getAzureAccountName() { return azureAccountName; }
    public String getAzureAccountKey() { return azureAccountKey; }
    public String getAzureConnectionString() { return azureConnectionString; }
    public String getPath() { return path; }
    public String getHost() { return host; }
    public Integer getPort() { return port; }
    public String getUser() { return user; }
    public String getPassword() { return password; }
    public String getPathSeparator() { return pathSeparator; }
    public Boolean getCanDeleteObjects() { return canDeleteObjects; }
    
    public static class Builder {
        private String title;
        private String description;
        private String bucket;
        private String prefix;
        private String awsAccessKeyId;
        private String awsSecretAccessKey;
        private String awsSessionToken;
        private String regionName;
        private String s3Endpoint;
        private String googleApplicationCredentials;
        private String azureAccountName;
        private String azureAccountKey;
        private String azureConnectionString;
        private String path;
        private String host;
        private Integer port;
        private String user;
        private String password;
        private String pathSeparator;
        private Boolean canDeleteObjects;
        
        public Builder title(String title) { this.title = title; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder bucket(String bucket) { this.bucket = bucket; return this; }
        public Builder prefix(String prefix) { this.prefix = prefix; return this; }
        public Builder awsAccessKeyId(String awsAccessKeyId) { this.awsAccessKeyId = awsAccessKeyId; return this; }
        public Builder awsSecretAccessKey(String awsSecretAccessKey) { this.awsSecretAccessKey = awsSecretAccessKey; return this; }
        public Builder awsSessionToken(String awsSessionToken) { this.awsSessionToken = awsSessionToken; return this; }
        public Builder regionName(String regionName) { this.regionName = regionName; return this; }
        public Builder s3Endpoint(String s3Endpoint) { this.s3Endpoint = s3Endpoint; return this; }
        public Builder googleApplicationCredentials(String googleApplicationCredentials) { this.googleApplicationCredentials = googleApplicationCredentials; return this; }
        public Builder azureAccountName(String azureAccountName) { this.azureAccountName = azureAccountName; return this; }
        public Builder azureAccountKey(String azureAccountKey) { this.azureAccountKey = azureAccountKey; return this; }
        public Builder azureConnectionString(String azureConnectionString) { this.azureConnectionString = azureConnectionString; return this; }
        public Builder path(String path) { this.path = path; return this; }
        public Builder host(String host) { this.host = host; return this; }
        public Builder port(Integer port) { this.port = port; return this; }
        public Builder user(String user) { this.user = user; return this; }
        public Builder password(String password) { this.password = password; return this; }
        public Builder pathSeparator(String pathSeparator) { this.pathSeparator = pathSeparator; return this; }
        public Builder canDeleteObjects(Boolean canDeleteObjects) { this.canDeleteObjects = canDeleteObjects; return this; }
        
        public ExportStorageUpdateRequest build() {
            return new ExportStorageUpdateRequest(this);
        }
    }
}