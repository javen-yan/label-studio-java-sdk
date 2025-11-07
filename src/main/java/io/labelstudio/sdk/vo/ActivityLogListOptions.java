package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Options for listing activity logs with filtering and pagination.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLogListOptions {
    
    @JsonProperty("project")
    private Integer project;
    
    @JsonProperty("user")
    private Integer user;
    
    @JsonProperty("action")
    private String action;
    
    @JsonProperty("object_type")
    private String objectType;
    
    @JsonProperty("object_id")
    private Integer objectId;
    
    @JsonProperty("start_date")
    private String startDate;
    
    @JsonProperty("end_date")
    private String endDate;
    
    @JsonProperty("page")
    private Integer page;
    
    @JsonProperty("page_size")
    private Integer pageSize;
}