package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Result of task import operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskImportResult {
    
    @JsonProperty("task_count")
    private int taskCount;
    
    @JsonProperty("annotation_count")
    private int annotationCount;
    
    @JsonProperty("prediction_count")
    private int predictionCount;
    
    @JsonProperty("duration")
    private double duration;
    
    @JsonProperty("file_upload_ids")
    private List<Integer> fileUploadIds;
    
    @JsonProperty("could_be_tasks_list")
    private boolean couldBeTasksList;
    
    @JsonProperty("found_formats")
    private List<String> foundFormats;
    
    @JsonProperty("data_columns")
    private List<String> dataColumns;
    
    /**
     * Default constructor.
     */
    public TaskImportResult() {
    }
    
    /**
     * Gets the number of tasks imported.
     * 
     * @return the task count
     */
    public int getTaskCount() {
        return taskCount;
    }
    
    /**
     * Sets the number of tasks imported.
     * 
     * @param taskCount the task count
     */
    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }
    
    /**
     * Gets the number of annotations imported.
     * 
     * @return the annotation count
     */
    public int getAnnotationCount() {
        return annotationCount;
    }
    
    /**
     * Sets the number of annotations imported.
     * 
     * @param annotationCount the annotation count
     */
    public void setAnnotationCount(int annotationCount) {
        this.annotationCount = annotationCount;
    }
    
    /**
     * Gets the number of predictions imported.
     * 
     * @return the prediction count
     */
    public int getPredictionCount() {
        return predictionCount;
    }
    
    /**
     * Sets the number of predictions imported.
     * 
     * @param predictionCount the prediction count
     */
    public void setPredictionCount(int predictionCount) {
        this.predictionCount = predictionCount;
    }
    
    /**
     * Gets the import duration in seconds.
     * 
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }
    
    /**
     * Sets the import duration in seconds.
     * 
     * @param duration the duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }
    
    /**
     * Gets the file upload IDs.
     * 
     * @return the file upload IDs
     */
    public List<Integer> getFileUploadIds() {
        return fileUploadIds;
    }
    
    /**
     * Sets the file upload IDs.
     * 
     * @param fileUploadIds the file upload IDs
     */
    public void setFileUploadIds(List<Integer> fileUploadIds) {
        this.fileUploadIds = fileUploadIds;
    }
    
    /**
     * Gets whether the data could be a tasks list.
     * 
     * @return true if could be tasks list
     */
    public boolean isCouldBeTasksList() {
        return couldBeTasksList;
    }
    
    /**
     * Sets whether the data could be a tasks list.
     * 
     * @param couldBeTasksList true if could be tasks list
     */
    public void setCouldBeTasksList(boolean couldBeTasksList) {
        this.couldBeTasksList = couldBeTasksList;
    }
    
    /**
     * Gets the found data formats.
     * 
     * @return the found formats
     */
    public List<String> getFoundFormats() {
        return foundFormats;
    }
    
    /**
     * Sets the found data formats.
     * 
     * @param foundFormats the found formats
     */
    public void setFoundFormats(List<String> foundFormats) {
        this.foundFormats = foundFormats;
    }
    
    /**
     * Gets the data columns found.
     * 
     * @return the data columns
     */
    public List<String> getDataColumns() {
        return dataColumns;
    }
    
    /**
     * Sets the data columns found.
     * 
     * @param dataColumns the data columns
     */
    public void setDataColumns(List<String> dataColumns) {
        this.dataColumns = dataColumns;
    }
    
    @Override
    public String toString() {
        return "TaskImportResult{" +
                "taskCount=" + taskCount +
                ", annotationCount=" + annotationCount +
                ", predictionCount=" + predictionCount +
                ", duration=" + duration +
                ", foundFormats=" + foundFormats +
                '}';
    }
}