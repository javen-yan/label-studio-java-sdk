package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;

public class AnnotationHistory {
    @JsonProperty("id") private Integer id;
    @JsonProperty("annotation") private Integer annotationId;
    @JsonProperty("task") private Integer taskId;
    @JsonProperty("user") private Integer userId;
    @JsonProperty("user_name") private String userName;
    @JsonProperty("version") private Integer version;
    @JsonProperty("action") private String action;
    @JsonProperty("result") private Map<String, Object> result;
    @JsonProperty("previous_result") private Map<String, Object> previousResult;
    @JsonProperty("changes") private Map<String, Object> changes;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
    
    public AnnotationHistory() {}
    
    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getAnnotationId() { return annotationId; }
    public void setAnnotationId(Integer annotationId) { this.annotationId = annotationId; }
    public Integer getTaskId() { return taskId; }
    public void setTaskId(Integer taskId) { this.taskId = taskId; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public Map<String, Object> getResult() { return result; }
    public void setResult(Map<String, Object> result) { this.result = result; }
    public Map<String, Object> getPreviousResult() { return previousResult; }
    public void setPreviousResult(Map<String, Object> previousResult) { this.previousResult = previousResult; }
    public Map<String, Object> getChanges() { return changes; }
    public void setChanges(Map<String, Object> changes) { this.changes = changes; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}