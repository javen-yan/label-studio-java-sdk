package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Options for listing projects with filtering, sorting, and pagination.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectsListOptions {
    
    @JsonProperty("filter")
    private String filter;
    
    @JsonProperty("ids")
    private String ids;
    
    @JsonProperty("include")
    private String include;
    
    @JsonProperty("members_limit")
    private Integer membersLimit;
    
    @JsonProperty("ordering")
    private String ordering;
    
    @JsonProperty("page")
    private Integer page;
    
    @JsonProperty("page_size")
    private Integer pageSize;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("workspaces")
    private Integer workspaces;
}
