package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object for creating an export.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
