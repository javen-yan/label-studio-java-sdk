package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Represents an import storage configuration in Label Studio.
 */
public class ImportStorage {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("project")
    private Integer projectId;
    
    @JsonProperty("bucket")
    private String bucket;
    
    @JsonProperty("prefix")
    private String prefix;
    
    @JsonProperty("regex_filter")
    private String regexFilter;
    
    @JsonProperty("use_blob_urls")
    private Boolean useBlobUrls;
    
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
    
    @JsonProperty("glob_pattern")
    private String globPattern;
    
    @JsonProperty("presign")
    private Boolean presign;
    
    @JsonProperty("presign_ttl")
    private Integer presignTtl;
    
    @JsonProperty("recursive_scan")
    private Boolean recursiveScan;
    
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    
    @JsonProperty("last_sync")
    private LocalDateTime lastSync;
    
    @JsonProperty("last_sync_count")
    private Integer lastSyncCount;
    
    @JsonProperty("last_sync_job")
    private String lastSyncJob;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("traceback")
    private String traceback;
    
    @JsonProperty("meta")
    private Map<String, Object> meta;
    
    // Constructors
    public ImportStorage() {}
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    public String getBucket() {
        return bucket;
    }
    
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
    
    public String getPrefix() {
        return prefix;
    }
    
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    public String getRegexFilter() {
        return regexFilter;
    }
    
    public void setRegexFilter(String regexFilter) {
        this.regexFilter = regexFilter;
    }
    
    public Boolean getUseBlobUrls() {
        return useBlobUrls;
    }
    
    public void setUseBlobUrls(Boolean useBlobUrls) {
        this.useBlobUrls = useBlobUrls;
    }
    
    public String getAwsAccessKeyId() {
        return awsAccessKeyId;
    }
    
    public void setAwsAccessKeyId(String awsAccessKeyId) {
        this.awsAccessKeyId = awsAccessKeyId;
    }
    
    public String getAwsSecretAccessKey() {
        return awsSecretAccessKey;
    }
    
    public void setAwsSecretAccessKey(String awsSecretAccessKey) {
        this.awsSecretAccessKey = awsSecretAccessKey;
    }
    
    public String getAwsSessionToken() {
        return awsSessionToken;
    }
    
    public void setAwsSessionToken(String awsSessionToken) {
        this.awsSessionToken = awsSessionToken;
    }
    
    public String getRegionName() {
        return regionName;
    }
    
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
    public String getS3Endpoint() {
        return s3Endpoint;
    }
    
    public void setS3Endpoint(String s3Endpoint) {
        this.s3Endpoint = s3Endpoint;
    }
    
    public String getGoogleApplicationCredentials() {
        return googleApplicationCredentials;
    }
    
    public void setGoogleApplicationCredentials(String googleApplicationCredentials) {
        this.googleApplicationCredentials = googleApplicationCredentials;
    }
    
    public String getAzureAccountName() {
        return azureAccountName;
    }
    
    public void setAzureAccountName(String azureAccountName) {
        this.azureAccountName = azureAccountName;
    }
    
    public String getAzureAccountKey() {
        return azureAccountKey;
    }
    
    public void setAzureAccountKey(String azureAccountKey) {
        this.azureAccountKey = azureAccountKey;
    }
    
    public String getAzureConnectionString() {
        return azureConnectionString;
    }
    
    public void setAzureConnectionString(String azureConnectionString) {
        this.azureConnectionString = azureConnectionString;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public String getHost() {
        return host;
    }
    
    public void setHost(String host) {
        this.host = host;
    }
    
    public Integer getPort() {
        return port;
    }
    
    public void setPort(Integer port) {
        this.port = port;
    }
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPathSeparator() {
        return pathSeparator;
    }
    
    public void setPathSeparator(String pathSeparator) {
        this.pathSeparator = pathSeparator;
    }
    
    public String getGlobPattern() {
        return globPattern;
    }
    
    public void setGlobPattern(String globPattern) {
        this.globPattern = globPattern;
    }
    
    public Boolean getPresign() {
        return presign;
    }
    
    public void setPresign(Boolean presign) {
        this.presign = presign;
    }
    
    public Integer getPresignTtl() {
        return presignTtl;
    }
    
    public void setPresignTtl(Integer presignTtl) {
        this.presignTtl = presignTtl;
    }
    
    public Boolean getRecursiveScan() {
        return recursiveScan;
    }
    
    public void setRecursiveScan(Boolean recursiveScan) {
        this.recursiveScan = recursiveScan;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getLastSync() {
        return lastSync;
    }
    
    public void setLastSync(LocalDateTime lastSync) {
        this.lastSync = lastSync;
    }
    
    public Integer getLastSyncCount() {
        return lastSyncCount;
    }
    
    public void setLastSyncCount(Integer lastSyncCount) {
        this.lastSyncCount = lastSyncCount;
    }
    
    public String getLastSyncJob() {
        return lastSyncJob;
    }
    
    public void setLastSyncJob(String lastSyncJob) {
        this.lastSyncJob = lastSyncJob;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getTraceback() {
        return traceback;
    }
    
    public void setTraceback(String traceback) {
        this.traceback = traceback;
    }
    
    public Map<String, Object> getMeta() {
        return meta;
    }
    
    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }
}