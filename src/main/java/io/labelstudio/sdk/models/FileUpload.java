package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public class FileUpload {
    @JsonProperty("id") private Integer id;
    @JsonProperty("filename") private String filename;
    @JsonProperty("original_filename") private String originalFilename;
    @JsonProperty("file_size") private Long fileSize;
    @JsonProperty("content_type") private String contentType;
    @JsonProperty("file_path") private String filePath;
    @JsonProperty("url") private String url;
    @JsonProperty("project") private Integer projectId;
    @JsonProperty("task") private Integer taskId;
    @JsonProperty("user") private Integer userId;
    @JsonProperty("user_name") private String userName;
    @JsonProperty("is_public") private Boolean isPublic;
    @JsonProperty("checksum") private String checksum;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
    @JsonProperty("updated_at") private OffsetDateTime updatedAt;
    
    public FileUpload() {}
    
    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }
    public String getOriginalFilename() { return originalFilename; }
    public void setOriginalFilename(String originalFilename) { this.originalFilename = originalFilename; }
    public Long getFileSize() { return fileSize; }
    public void setFileSize(Long fileSize) { this.fileSize = fileSize; }
    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public Integer getProjectId() { return projectId; }
    public void setProjectId(Integer projectId) { this.projectId = projectId; }
    public Integer getTaskId() { return taskId; }
    public void setTaskId(Integer taskId) { this.taskId = taskId; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public Boolean getIsPublic() { return isPublic; }
    public void setIsPublic(Boolean isPublic) { this.isPublic = isPublic; }
    public String getChecksum() { return checksum; }
    public void setChecksum(String checksum) { this.checksum = checksum; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}