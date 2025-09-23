package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;

public class ActivityLog {
    @JsonProperty("id") private Integer id;
    @JsonProperty("user") private Integer userId;
    @JsonProperty("user_name") private String userName;
    @JsonProperty("project") private Integer projectId;
    @JsonProperty("action") private String action;
    @JsonProperty("object_type") private String objectType;
    @JsonProperty("object_id") private Integer objectId;
    @JsonProperty("details") private Map<String, Object> details;
    @JsonProperty("ip_address") private String ipAddress;
    @JsonProperty("user_agent") private String userAgent;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
    
    public ActivityLog() {}
    
    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public Integer getProjectId() { return projectId; }
    public void setProjectId(Integer projectId) { this.projectId = projectId; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getObjectType() { return objectType; }
    public void setObjectType(String objectType) { this.objectType = objectType; }
    public Integer getObjectId() { return objectId; }
    public void setObjectId(Integer objectId) { this.objectId = objectId; }
    public Map<String, Object> getDetails() { return details; }
    public void setDetails(Map<String, Object> details) { this.details = details; }
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}