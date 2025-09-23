package io.labelstudio.sdk.client;

public class ActivityLogListOptions {
    private Integer projectId;
    private Integer userId;
    private String action;
    private String objectType;
    private String startDate;
    private String endDate;
    private Integer page;
    private Integer pageSize;
    
    private ActivityLogListOptions(Builder builder) {
        this.projectId = builder.projectId;
        this.userId = builder.userId;
        this.action = builder.action;
        this.objectType = builder.objectType;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.page = builder.page;
        this.pageSize = builder.pageSize;
    }
    
    public static Builder builder() { return new Builder(); }
    
    public String toQueryString() {
        StringBuilder sb = new StringBuilder("?");
        if (projectId != null) sb.append("project=").append(projectId).append("&");
        if (userId != null) sb.append("user=").append(userId).append("&");
        if (action != null) sb.append("action=").append(action).append("&");
        if (objectType != null) sb.append("object_type=").append(objectType).append("&");
        if (startDate != null) sb.append("start_date=").append(startDate).append("&");
        if (endDate != null) sb.append("end_date=").append(endDate).append("&");
        if (page != null) sb.append("page=").append(page).append("&");
        if (pageSize != null) sb.append("page_size=").append(pageSize).append("&");
        return sb.toString();
    }
    
    public static class Builder {
        private Integer projectId;
        private Integer userId;
        private String action;
        private String objectType;
        private String startDate;
        private String endDate;
        private Integer page;
        private Integer pageSize;
        
        public Builder projectId(Integer projectId) { this.projectId = projectId; return this; }
        public Builder userId(Integer userId) { this.userId = userId; return this; }
        public Builder action(String action) { this.action = action; return this; }
        public Builder objectType(String objectType) { this.objectType = objectType; return this; }
        public Builder startDate(String startDate) { this.startDate = startDate; return this; }
        public Builder endDate(String endDate) { this.endDate = endDate; return this; }
        public Builder page(Integer page) { this.page = page; return this; }
        public Builder pageSize(Integer pageSize) { this.pageSize = pageSize; return this; }
        
        public ActivityLogListOptions build() { return new ActivityLogListOptions(this); }
    }
}