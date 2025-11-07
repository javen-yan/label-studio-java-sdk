package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Options for listing tasks with filtering, sorting, and pagination.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TasksListOptions {
    
    @JsonProperty("project")
    private Integer project;
    
    @JsonProperty("view")
    private Integer view;
    
    @JsonProperty("ids")
    private String ids;
    
    @JsonProperty("page")
    private Integer page;
    
    @JsonProperty("page_size")
    private Integer pageSize;
    
    @JsonProperty("ordering")
    private String ordering;
    
    @JsonProperty("resolved_only")
    private Boolean resolvedOnly;
    
    @JsonProperty("completed_by")
    private Integer completedBy;
    
    @JsonProperty("canceled_by")
    private Integer canceledBy;
    
    @JsonProperty("annotated_by")
    private Integer annotatedBy;
    
    @JsonProperty("reviewed_by")
    private Integer reviewedBy;
    
    @JsonProperty("include")
    private String include;
}
