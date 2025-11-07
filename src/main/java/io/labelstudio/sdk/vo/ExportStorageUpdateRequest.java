package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object for updating export storage configurations.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
