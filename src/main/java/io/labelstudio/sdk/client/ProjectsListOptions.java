package io.labelstudio.sdk.client;

/**
 * Options for listing projects with filtering, sorting, and pagination.
 */
public class ProjectsListOptions {
    
    private String filter;
    private String ids;
    private String include;
    private Integer membersLimit;
    private String ordering;
    private Integer page;
    private Integer pageSize;
    private String title;
    private Integer workspaces;
    
    /**
     * Default constructor.
     */
    public ProjectsListOptions() {
    }
    
    /**
     * Gets the filter criteria.
     * 
     * @return the filter criteria
     */
    public String getFilter() {
        return filter;
    }
    
    /**
     * Sets the filter criteria.
     * Use 'pinned_only' to return only pinned projects, 
     * 'exclude_pinned' to return only non-pinned projects, 
     * or 'all' to return all projects.
     * 
     * @param filter the filter criteria
     */
    public void setFilter(String filter) {
        this.filter = filter;
    }
    
    /**
     * Gets the project IDs to filter by.
     * 
     * @return comma-separated project IDs
     */
    public String getIds() {
        return ids;
    }
    
    /**
     * Sets the project IDs to filter by.
     * 
     * @param ids comma-separated project IDs
     */
    public void setIds(String ids) {
        this.ids = ids;
    }
    
    /**
     * Gets the count fields to include.
     * 
     * @return comma-separated count fields
     */
    public String getInclude() {
        return include;
    }
    
    /**
     * Sets the count fields to include in the response.
     * Available fields: task_number, finished_task_number, total_predictions_number,
     * total_annotations_number, num_tasks_with_annotations, useful_annotation_number,
     * ground_truth_number, skipped_annotations_number.
     * 
     * @param include comma-separated count fields
     */
    public void setInclude(String include) {
        this.include = include;
    }
    
    /**
     * Gets the maximum number of members to return.
     * 
     * @return the members limit
     */
    public Integer getMembersLimit() {
        return membersLimit;
    }
    
    /**
     * Sets the maximum number of members to return.
     * 
     * @param membersLimit the members limit
     */
    public void setMembersLimit(Integer membersLimit) {
        this.membersLimit = membersLimit;
    }
    
    /**
     * Gets the ordering field.
     * 
     * @return the ordering field
     */
    public String getOrdering() {
        return ordering;
    }
    
    /**
     * Sets the field to use for ordering results.
     * 
     * @param ordering the ordering field (e.g., "title", "-created_at")
     */
    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }
    
    /**
     * Gets the page number.
     * 
     * @return the page number
     */
    public Integer getPage() {
        return page;
    }
    
    /**
     * Sets the page number within the paginated result set.
     * 
     * @param page the page number
     */
    public void setPage(Integer page) {
        this.page = page;
    }
    
    /**
     * Gets the page size.
     * 
     * @return the page size
     */
    public Integer getPageSize() {
        return pageSize;
    }
    
    /**
     * Sets the number of results to return per page.
     * 
     * @param pageSize the page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    
    /**
     * Gets the title filter.
     * 
     * @return the title filter
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the title to filter by.
     * 
     * @param title the title filter
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the workspace ID filter.
     * 
     * @return the workspace ID
     */
    public Integer getWorkspaces() {
        return workspaces;
    }
    
    /**
     * Sets the workspace ID to filter by.
     * 
     * @param workspaces the workspace ID
     */
    public void setWorkspaces(Integer workspaces) {
        this.workspaces = workspaces;
    }
    
    /**
     * Creates a new builder for ProjectsListOptions.
     * 
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Builder for ProjectsListOptions.
     */
    public static class Builder {
        private final ProjectsListOptions options = new ProjectsListOptions();
        
        /**
         * Sets the filter criteria.
         * 
         * @param filter the filter criteria
         * @return this builder
         */
        public Builder filter(String filter) {
            options.setFilter(filter);
            return this;
        }
        
        /**
         * Filters for pinned projects only.
         * 
         * @return this builder
         */
        public Builder pinnedOnly() {
            options.setFilter("pinned_only");
            return this;
        }
        
        /**
         * Excludes pinned projects.
         * 
         * @return this builder
         */
        public Builder excludePinned() {
            options.setFilter("exclude_pinned");
            return this;
        }
        
        /**
         * Sets the project IDs to filter by.
         * 
         * @param ids comma-separated project IDs
         * @return this builder
         */
        public Builder ids(String ids) {
            options.setIds(ids);
            return this;
        }
        
        /**
         * Sets the count fields to include.
         * 
         * @param include comma-separated count fields
         * @return this builder
         */
        public Builder include(String include) {
            options.setInclude(include);
            return this;
        }
        
        /**
         * Sets the members limit.
         * 
         * @param membersLimit the members limit
         * @return this builder
         */
        public Builder membersLimit(int membersLimit) {
            options.setMembersLimit(membersLimit);
            return this;
        }
        
        /**
         * Sets the ordering field.
         * 
         * @param ordering the ordering field
         * @return this builder
         */
        public Builder ordering(String ordering) {
            options.setOrdering(ordering);
            return this;
        }
        
        /**
         * Orders by title ascending.
         * 
         * @return this builder
         */
        public Builder orderByTitle() {
            options.setOrdering("title");
            return this;
        }
        
        /**
         * Orders by title descending.
         * 
         * @return this builder
         */
        public Builder orderByTitleDesc() {
            options.setOrdering("-title");
            return this;
        }
        
        /**
         * Orders by creation date ascending.
         * 
         * @return this builder
         */
        public Builder orderByCreatedAt() {
            options.setOrdering("created_at");
            return this;
        }
        
        /**
         * Orders by creation date descending.
         * 
         * @return this builder
         */
        public Builder orderByCreatedAtDesc() {
            options.setOrdering("-created_at");
            return this;
        }
        
        /**
         * Sets the page number.
         * 
         * @param page the page number
         * @return this builder
         */
        public Builder page(int page) {
            options.setPage(page);
            return this;
        }
        
        /**
         * Sets the page size.
         * 
         * @param pageSize the page size
         * @return this builder
         */
        public Builder pageSize(int pageSize) {
            options.setPageSize(pageSize);
            return this;
        }
        
        /**
         * Sets the title filter.
         * 
         * @param title the title filter
         * @return this builder
         */
        public Builder title(String title) {
            options.setTitle(title);
            return this;
        }
        
        /**
         * Sets the workspace ID filter.
         * 
         * @param workspaces the workspace ID
         * @return this builder
         */
        public Builder workspaces(int workspaces) {
            options.setWorkspaces(workspaces);
            return this;
        }
        
        /**
         * Builds the ProjectsListOptions.
         * 
         * @return the ProjectsListOptions instance
         */
        public ProjectsListOptions build() {
            return options;
        }
    }
}