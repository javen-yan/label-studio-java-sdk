package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents project counts and statistics.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectCounts {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("task_number")
    private Integer taskNumber;
    
    @JsonProperty("finished_task_number")
    private Integer finishedTaskNumber;
    
    @JsonProperty("total_predictions_number")
    private Integer totalPredictionsNumber;
    
    @JsonProperty("total_annotations_number")
    private Integer totalAnnotationsNumber;
    
    @JsonProperty("num_tasks_with_annotations")
    private Integer numTasksWithAnnotations;
    
    @JsonProperty("useful_annotation_number")
    private Integer usefulAnnotationNumber;
    
    @JsonProperty("ground_truth_number")
    private Integer groundTruthNumber;
    
    @JsonProperty("skipped_annotations_number")
    private Integer skippedAnnotationsNumber;
    
    /**
     * Default constructor.
     */
    public ProjectCounts() {
    }
    
    /**
     * Gets the project ID.
     * 
     * @return the project ID
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the project ID.
     * 
     * @param id the project ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Gets the project title.
     * 
     * @return the project title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the project title.
     * 
     * @param title the project title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the total number of tasks.
     * 
     * @return the task number
     */
    public Integer getTaskNumber() {
        return taskNumber;
    }
    
    /**
     * Sets the total number of tasks.
     * 
     * @param taskNumber the task number
     */
    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }
    
    /**
     * Gets the number of finished tasks.
     * 
     * @return the finished task number
     */
    public Integer getFinishedTaskNumber() {
        return finishedTaskNumber;
    }
    
    /**
     * Sets the number of finished tasks.
     * 
     * @param finishedTaskNumber the finished task number
     */
    public void setFinishedTaskNumber(Integer finishedTaskNumber) {
        this.finishedTaskNumber = finishedTaskNumber;
    }
    
    /**
     * Gets the total number of predictions.
     * 
     * @return the total predictions number
     */
    public Integer getTotalPredictionsNumber() {
        return totalPredictionsNumber;
    }
    
    /**
     * Sets the total number of predictions.
     * 
     * @param totalPredictionsNumber the total predictions number
     */
    public void setTotalPredictionsNumber(Integer totalPredictionsNumber) {
        this.totalPredictionsNumber = totalPredictionsNumber;
    }
    
    /**
     * Gets the total number of annotations.
     * 
     * @return the total annotations number
     */
    public Integer getTotalAnnotationsNumber() {
        return totalAnnotationsNumber;
    }
    
    /**
     * Sets the total number of annotations.
     * 
     * @param totalAnnotationsNumber the total annotations number
     */
    public void setTotalAnnotationsNumber(Integer totalAnnotationsNumber) {
        this.totalAnnotationsNumber = totalAnnotationsNumber;
    }
    
    /**
     * Gets the number of tasks with annotations.
     * 
     * @return the number of tasks with annotations
     */
    public Integer getNumTasksWithAnnotations() {
        return numTasksWithAnnotations;
    }
    
    /**
     * Sets the number of tasks with annotations.
     * 
     * @param numTasksWithAnnotations the number of tasks with annotations
     */
    public void setNumTasksWithAnnotations(Integer numTasksWithAnnotations) {
        this.numTasksWithAnnotations = numTasksWithAnnotations;
    }
    
    /**
     * Gets the number of useful annotations.
     * 
     * @return the useful annotation number
     */
    public Integer getUsefulAnnotationNumber() {
        return usefulAnnotationNumber;
    }
    
    /**
     * Sets the number of useful annotations.
     * 
     * @param usefulAnnotationNumber the useful annotation number
     */
    public void setUsefulAnnotationNumber(Integer usefulAnnotationNumber) {
        this.usefulAnnotationNumber = usefulAnnotationNumber;
    }
    
    /**
     * Gets the number of ground truth annotations.
     * 
     * @return the ground truth number
     */
    public Integer getGroundTruthNumber() {
        return groundTruthNumber;
    }
    
    /**
     * Sets the number of ground truth annotations.
     * 
     * @param groundTruthNumber the ground truth number
     */
    public void setGroundTruthNumber(Integer groundTruthNumber) {
        this.groundTruthNumber = groundTruthNumber;
    }
    
    /**
     * Gets the number of skipped annotations.
     * 
     * @return the skipped annotations number
     */
    public Integer getSkippedAnnotationsNumber() {
        return skippedAnnotationsNumber;
    }
    
    /**
     * Sets the number of skipped annotations.
     * 
     * @param skippedAnnotationsNumber the skipped annotations number
     */
    public void setSkippedAnnotationsNumber(Integer skippedAnnotationsNumber) {
        this.skippedAnnotationsNumber = skippedAnnotationsNumber;
    }
    
    @Override
    public String toString() {
        return "ProjectCounts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskNumber=" + taskNumber +
                ", finishedTaskNumber=" + finishedTaskNumber +
                ", totalAnnotationsNumber=" + totalAnnotationsNumber +
                ", totalPredictionsNumber=" + totalPredictionsNumber +
                '}';
    }
}