package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public class AnnotationReview {
    @JsonProperty("id") private Integer id;
    @JsonProperty("annotation") private Integer annotationId;
    @JsonProperty("task") private Integer taskId;
    @JsonProperty("reviewer") private Integer reviewerId;
    @JsonProperty("reviewer_name") private String reviewerName;
    @JsonProperty("action") private String action;
    @JsonProperty("status") private String status;
    @JsonProperty("comment") private String comment;
    @JsonProperty("score") private Double score;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
    @JsonProperty("updated_at") private OffsetDateTime updatedAt;
    
    public AnnotationReview() {}
    
    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getAnnotationId() { return annotationId; }
    public void setAnnotationId(Integer annotationId) { this.annotationId = annotationId; }
    public Integer getTaskId() { return taskId; }
    public void setTaskId(Integer taskId) { this.taskId = taskId; }
    public Integer getReviewerId() { return reviewerId; }
    public void setReviewerId(Integer reviewerId) { this.reviewerId = reviewerId; }
    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}