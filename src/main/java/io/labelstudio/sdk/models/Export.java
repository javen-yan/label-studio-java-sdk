package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents an export from Label Studio.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  
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
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ConvertedFormat {
        @JsonProperty("id")
        private Integer id;
        
        @JsonProperty("export_type")
        private String exportType;
    }
}