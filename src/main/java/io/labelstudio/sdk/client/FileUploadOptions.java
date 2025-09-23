package io.labelstudio.sdk.client;

public class FileUploadOptions {
    private Integer projectId;
    private Integer taskId;
    private Boolean isPublic;
    private String description;
    
    private FileUploadOptions(Builder builder) {
        this.projectId = builder.projectId;
        this.taskId = builder.taskId;
        this.isPublic = builder.isPublic;
        this.description = builder.description;
    }
    
    public static Builder builder() { return new Builder(); }
    
    public Integer getProjectId() { return projectId; }
    public Integer getTaskId() { return taskId; }
    public Boolean getIsPublic() { return isPublic; }
    public String getDescription() { return description; }
    
    public static class Builder {
        private Integer projectId;
        private Integer taskId;
        private Boolean isPublic;
        private String description;
        
        public Builder projectId(Integer projectId) { this.projectId = projectId; return this; }
        public Builder taskId(Integer taskId) { this.taskId = taskId; return this; }
        public Builder isPublic(Boolean isPublic) { this.isPublic = isPublic; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder publicFile() { this.isPublic = true; return this; }
        public Builder privateFile() { this.isPublic = false; return this; }
        
        public FileUploadOptions build() { return new FileUploadOptions(this); }
    }
}