package io.labelstudio.sdk.client;

/**
 * Options for downloading export data.
 */
public class ExportDownloadOptions {
    
    private Boolean downloadAllTasks;
    private Boolean downloadResources;
    private String exportType;
    private String ids;
    
    /**
     * Default constructor.
     */
    public ExportDownloadOptions() {
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
     * Gets the task IDs to download.
     * 
     * @return comma-separated task IDs
     */
    public String getIds() {
        return ids;
    }
    
    /**
     * Sets the task IDs to download.
     * 
     * @param ids comma-separated task IDs
     */
    public void setIds(String ids) {
        this.ids = ids;
    }
    
    /**
     * Creates a new builder for ExportDownloadOptions.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for ExportDownloadOptions.
     */
    public static class Builder {
        private final ExportDownloadOptions options = new ExportDownloadOptions();
        
        /**
         * Sets whether to download all tasks.
         * 
         * @param downloadAllTasks true to download all tasks
         * @return this builder
         */
        public Builder downloadAllTasks(boolean downloadAllTasks) {
            options.setDownloadAllTasks(downloadAllTasks);
            return this;
        }
        
        /**
         * Sets whether to download resources.
         * 
         * @param downloadResources true to download resources
         * @return this builder
         */
        public Builder downloadResources(boolean downloadResources) {
            options.setDownloadResources(downloadResources);
            return this;
        }
        
        /**
         * Sets the export type.
         * 
         * @param exportType the export type
         * @return this builder
         */
        public Builder exportType(String exportType) {
            options.setExportType(exportType);
            return this;
        }
        
        /**
         * Sets the task IDs to download.
         * 
         * @param ids comma-separated task IDs
         * @return this builder
         */
        public Builder ids(String ids) {
            options.setIds(ids);
            return this;
        }
        
        /**
         * Builds the ExportDownloadOptions.
         * 
         * @return the ExportDownloadOptions instance
         */
        public ExportDownloadOptions build() {
            return options;
        }
    }
}