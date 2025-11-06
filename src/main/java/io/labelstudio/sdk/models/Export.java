package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents an export from Label Studio.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Export {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    @JsonProperty("created_by")
    private UserSimple createdBy;
    
    @JsonProperty("finished_at")
    private OffsetDateTime finishedAt;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("export_type")
    private String exportType;
    
    @JsonProperty("task_count")
    private Integer taskCount;
    
    @JsonProperty("annotation_count")
    private Integer annotationCount;
    
    @JsonProperty("file_name")
    private String fileName;
    
    @JsonProperty("file_size")
    private Long fileSize;
    
    @JsonProperty("download_url")
    private String downloadUrl;
    
    @JsonProperty("could_be_tasks_list")
    private Boolean couldBeTasksList;
    
    @JsonProperty("project")
    private Integer project;
    
    @JsonProperty("md5")
    private String md5;
    
    @JsonProperty("converted_formats")
    private List<ConvertedFormat> convertedFormats;
    
    @JsonProperty("counters")
    private Map<String, Object> counters;
    
    /**
     * Represents a converted format in an export.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ConvertedFormat {
        @JsonProperty("id")
        private Integer id;
        
        @JsonProperty("export_type")
        private String exportType;
        
        public ConvertedFormat() {
        }
        
        public Integer getId() {
            return id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getExportType() {
            return exportType;
        }
        
        public void setExportType(String exportType) {
            this.exportType = exportType;
        }
    }
    
    /**
     * Default constructor.
     */
    public Export() {
    }
    
    /**
     * Gets the export ID.
     * 
     * @return the export ID
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the export ID.
     * 
     * @param id the export ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Gets the export title.
     * 
     * @return the export title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the export title.
     * 
     * @param title the export title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the creation timestamp.
     * 
     * @return the creation timestamp
     */
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    
    /**
     * Sets the creation timestamp.
     * 
     * @param createdAt the creation timestamp
     */
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * Gets the user who created the export.
     * 
     * @return the creator
     */
    public UserSimple getCreatedBy() {
        return createdBy;
    }
    
    /**
     * Sets the user who created the export.
     * 
     * @param createdBy the creator
     */
    public void setCreatedBy(UserSimple createdBy) {
        this.createdBy = createdBy;
    }
    
    /**
     * Gets the completion timestamp.
     * 
     * @return the completion timestamp
     */
    public OffsetDateTime getFinishedAt() {
        return finishedAt;
    }
    
    /**
     * Sets the completion timestamp.
     * 
     * @param finishedAt the completion timestamp
     */
    public void setFinishedAt(OffsetDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }
    
    /**
     * Gets the export status.
     * 
     * @return the export status
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * Sets the export status.
     * 
     * @param status the export status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Gets the export type.
     * 
     * @return the export type
     */
    public String getExportType() {
        return exportType;
    }
    
    /**
     * Sets the export type.
     * 
     * @param exportType the export type
     */
    public void setExportType(String exportType) {
        this.exportType = exportType;
    }
    
    /**
     * Gets the number of tasks in the export.
     * 
     * @return the task count
     */
    public Integer getTaskCount() {
        return taskCount;
    }
    
    /**
     * Sets the number of tasks in the export.
     * 
     * @param taskCount the task count
     */
    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }
    
    /**
     * Gets the number of annotations in the export.
     * 
     * @return the annotation count
     */
    public Integer getAnnotationCount() {
        return annotationCount;
    }
    
    /**
     * Sets the number of annotations in the export.
     * 
     * @param annotationCount the annotation count
     */
    public void setAnnotationCount(Integer annotationCount) {
        this.annotationCount = annotationCount;
    }
    
    /**
     * Gets the export file name.
     * 
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }
    
    /**
     * Sets the export file name.
     * 
     * @param fileName the file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Gets the export file size in bytes.
     * 
     * @return the file size
     */
    public Long getFileSize() {
        return fileSize;
    }
    
    /**
     * Sets the export file size in bytes.
     * 
     * @param fileSize the file size
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
    
    /**
     * Gets the download URL.
     * 
     * @return the download URL
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }
    
    /**
     * Sets the download URL.
     * 
     * @param downloadUrl the download URL
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    
    /**
     * Gets whether this could be a tasks list.
     * 
     * @return true if could be tasks list
     */
    public Boolean getCouldBeTasksList() {
        return couldBeTasksList;
    }
    
    /**
     * Sets whether this could be a tasks list.
     * 
     * @param couldBeTasksList true if could be tasks list
     */
    public void setCouldBeTasksList(Boolean couldBeTasksList) {
        this.couldBeTasksList = couldBeTasksList;
    }
    
    /**
     * Gets the project ID.
     * 
     * @return the project ID
     */
    public Integer getProject() {
        return project;
    }
    
    /**
     * Sets the project ID.
     * 
     * @param project the project ID
     */
    public void setProject(Integer project) {
        this.project = project;
    }
    
    /**
     * Gets the MD5 hash of the export file.
     * 
     * @return the MD5 hash
     */
    public String getMd5() {
        return md5;
    }
    
    /**
     * Sets the MD5 hash of the export file.
     * 
     * @param md5 the MD5 hash
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }
    
    /**
     * Gets the list of converted formats.
     * 
     * @return the converted formats
     */
    public List<ConvertedFormat> getConvertedFormats() {
        return convertedFormats;
    }
    
    /**
     * Sets the list of converted formats.
     * 
     * @param convertedFormats the converted formats
     */
    public void setConvertedFormats(List<ConvertedFormat> convertedFormats) {
        this.convertedFormats = convertedFormats;
    }
    
    /**
     * Gets the counters map.
     * 
     * @return the counters
     */
    public Map<String, Object> getCounters() {
        return counters;
    }
    
    /**
     * Sets the counters map.
     * 
     * @param counters the counters
     */
    public void setCounters(Map<String, Object> counters) {
        this.counters = counters;
    }
    
    /**
     * Checks if the export is completed.
     * 
     * @return true if the export is completed
     */
    public boolean isCompleted() {
        return "completed".equalsIgnoreCase(status);
    }
    
    /**
     * Checks if the export is in progress.
     * 
     * @return true if the export is in progress
     */
    public boolean isInProgress() {
        return "in_progress".equalsIgnoreCase(status) || "created".equalsIgnoreCase(status);
    }
    
    /**
     * Checks if the export failed.
     * 
     * @return true if the export failed
     */
    public boolean isFailed() {
        return "failed".equalsIgnoreCase(status) || "error".equalsIgnoreCase(status);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Export export = (Export) o;
        return Objects.equals(id, export.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Export{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", exportType='" + exportType + '\'' +
                ", taskCount=" + taskCount +
                ", annotationCount=" + annotationCount +
                ", createdAt=" + createdAt +
                '}';
    }
}