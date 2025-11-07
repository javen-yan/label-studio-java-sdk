package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Represents an import storage configuration in Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
