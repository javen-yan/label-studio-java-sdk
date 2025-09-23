package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object for creating an export.
 */
public class ExportCreateRequest {
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("export_type")
    private String exportType;
    
    @JsonProperty("download_all_tasks")
    private Boolean downloadAllTasks;
    
    @JsonProperty("download_resources")
    private Boolean downloadResources;
    
    @JsonProperty("ids")
    private String ids;
    
    /**
     * Default constructor.
     */
    public ExportCreateRequest() {
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
     * @param exportType the export type (e.g., "JSON", "CSV", "YOLO")
     */
    public void setExportType(String exportType) {
        this.exportType = exportType;
    }
    
    /**
     * Gets whether to download all tasks.
     * 
     * @return true if downloading all tasks
     */
    public Boolean getDownloadAllTasks() {
        return downloadAllTasks;
    }
    
    /**
     * Sets whether to download all tasks.
     * 
     * @param downloadAllTasks true to download all tasks
     */
    public void setDownloadAllTasks(Boolean downloadAllTasks) {
        this.downloadAllTasks = downloadAllTasks;
    }
    
    /**
     * Gets whether to download resources.
     * 
     * @return true if downloading resources
     */
    public Boolean getDownloadResources() {
        return downloadResources;
    }
    
    /**
     * Sets whether to download resources.
     * 
     * @param downloadResources true to download resources
     */
    public void setDownloadResources(Boolean downloadResources) {
        this.downloadResources = downloadResources;
    }
    
    /**
     * Gets the task IDs to export.
     * 
     * @return comma-separated task IDs
     */
    public String getIds() {
        return ids;
    }
    
    /**
     * Sets the task IDs to export.
     * 
     * @param ids comma-separated task IDs
     */
    public void setIds(String ids) {
        this.ids = ids;
    }
    
    /**
     * Creates a new builder for ExportCreateRequest.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for ExportCreateRequest.
     */
    public static class Builder {
        private final ExportCreateRequest request = new ExportCreateRequest();
        
        /**
         * Sets the export title.
         * 
         * @param title the export title
         * @return this builder
         */
        public Builder title(String title) {
            request.setTitle(title);
            return this;
        }
        
        /**
         * Sets the export type.
         * 
         * @param exportType the export type
         * @return this builder
         */
        public Builder exportType(String exportType) {
            request.setExportType(exportType);
            return this;
        }
        
        /**
         * Sets the export type to JSON.
         * 
         * @return this builder
         */
        public Builder json() {
            request.setExportType("JSON");
            return this;
        }
        
        /**
         * Sets the export type to CSV.
         * 
         * @return this builder
         */
        public Builder csv() {
            request.setExportType("CSV");
            return this;
        }
        
        /**
         * Sets the export type to YOLO.
         * 
         * @return this builder
         */
        public Builder yolo() {
            request.setExportType("YOLO");
            return this;
        }
        
        /**
         * Sets the export type to COCO.
         * 
         * @return this builder
         */
        public Builder coco() {
            request.setExportType("COCO");
            return this;
        }
        
        /**
         * Sets whether to download all tasks.
         * 
         * @param downloadAllTasks true to download all tasks
         * @return this builder
         */
        public Builder downloadAllTasks(boolean downloadAllTasks) {
            request.setDownloadAllTasks(downloadAllTasks);
            return this;
        }
        
        /**
         * Sets whether to download resources.
         * 
         * @param downloadResources true to download resources
         * @return this builder
         */
        public Builder downloadResources(boolean downloadResources) {
            request.setDownloadResources(downloadResources);
            return this;
        }
        
        /**
         * Sets the task IDs to export.
         * 
         * @param ids comma-separated task IDs
         * @return this builder
         */
        public Builder ids(String ids) {
            request.setIds(ids);
            return this;
        }
        
        /**
         * Builds the ExportCreateRequest.
         * 
         * @return the ExportCreateRequest instance
         */
        public ExportCreateRequest build() {
            return request;
        }
    }
}