package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentCreateRequest {
    @JsonProperty("task") private Integer taskId;
    @JsonProperty("annotation") private Integer annotationId;
    @JsonProperty("text") private String text;
    
    private CommentCreateRequest(Builder builder) {
        this.taskId = builder.taskId;
        this.annotationId = builder.annotationId;
        this.text = builder.text;
    }
    
    public static Builder builder() { return new Builder(); }
    
    public Integer getTaskId() { return taskId; }
    public Integer getAnnotationId() { return annotationId; }
    public String getText() { return text; }
    
    public static class Builder {
        private Integer taskId;
        private Integer annotationId;
        private String text;
        
        public Builder taskId(Integer taskId) { this.taskId = taskId; return this; }
        public Builder annotationId(Integer annotationId) { this.annotationId = annotationId; return this; }
        public Builder text(String text) { this.text = text; return this; }
        
        public CommentCreateRequest build() { return new CommentCreateRequest(this); }
    }
}