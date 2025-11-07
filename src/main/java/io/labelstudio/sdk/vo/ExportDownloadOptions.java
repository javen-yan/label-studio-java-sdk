package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Options for downloading export data.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportDownloadOptions {
    
    @JsonProperty("download_all_tasks")
    private Boolean downloadAllTasks;
    
    @JsonProperty("download_resources")
    private Boolean downloadResources;
    
    @JsonProperty("export_type")
    private String exportType;
    
    @JsonProperty("ids")
    private String ids;
}