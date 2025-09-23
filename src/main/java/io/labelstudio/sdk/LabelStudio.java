package io.labelstudio.sdk;

import io.labelstudio.sdk.client.*;
import io.labelstudio.sdk.core.ApiError;
import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.LabelStudioEnvironment;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Main client for interacting with the Label Studio API.
 * 
 * <p>This client provides access to all Label Studio API endpoints through
 * specialized sub-clients for different resource types.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * LabelStudio client = LabelStudio.builder()
 *     .baseUrl("http://localhost:8080")
 *     .apiKey("your-api-key")
 *     .build();
 * 
 * // Create a project
 * Project project = client.projects().create(
 *     ProjectCreateRequest.builder()
 *         .title("My Project")
 *         .labelConfig("&lt;View&gt;...&lt;/View&gt;")
 *         .build()
 * );
 * </pre>
 */
public class LabelStudio {
    
    private static final String SDK_VERSION = "2.0.0";
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    
    private final HttpClient httpClient;
    private final ProjectsClient projects;
    private final TasksClient tasks;
    private final AnnotationsClient annotations;
    private final UsersClient users;
    private final OrganizationsClient organizations;
    private final ExportStorageClient exportStorage;
    private final ImportStorageClient importStorage;
    private final MlClient ml;
    private final WebhooksClient webhooks;
    private final ViewsClient views;
    private final ActivityLogsClient activityLogs;
    private final AnnotationHistoryClient annotationHistory;
    private final AnnotationReviewsClient annotationReviews;
    private final CommentsClient comments;
    private final FilesClient files;
    
    private LabelStudio(Builder builder) {
        String baseUrl = determineBaseUrl(builder.baseUrl, builder.environment);
        String apiKey = determineApiKey(builder.apiKey);
        
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new ApiError("API key is required. Set it via builder.apiKey() or LABEL_STUDIO_API_KEY environment variable.");
        }
        
        Map<String, String> defaultHeaders = createDefaultHeaders(apiKey);
        
        this.httpClient = new HttpClient(baseUrl, defaultHeaders, 
                builder.timeout != null ? builder.timeout : DEFAULT_TIMEOUT);
        
        // Initialize sub-clients
        this.projects = new ProjectsClient(httpClient);
        this.tasks = new TasksClient(httpClient);
        this.annotations = new AnnotationsClient(httpClient);
        this.users = new UsersClient(httpClient);
        this.organizations = new OrganizationsClient(httpClient);
        this.exportStorage = new ExportStorageClient(httpClient);
        this.importStorage = new ImportStorageClient(httpClient);
        this.ml = new MlClient(httpClient);
        this.webhooks = new WebhooksClient(httpClient);
        this.views = new ViewsClient(httpClient);
        this.activityLogs = new ActivityLogsClient(httpClient);
        this.annotationHistory = new AnnotationHistoryClient(httpClient);
        this.annotationReviews = new AnnotationReviewsClient(httpClient);
        this.comments = new CommentsClient(httpClient);
        this.files = new FilesClient(httpClient);
    }
    
    /**
     * Gets the projects client for managing Label Studio projects.
     * 
     * @return the projects client
     */
    public ProjectsClient projects() {
        return projects;
    }
    
    /**
     * Gets the tasks client for managing tasks within projects.
     * 
     * @return the tasks client
     */
    public TasksClient tasks() {
        return tasks;
    }
    
    /**
     * Gets the annotations client for managing task annotations.
     * 
     * @return the annotations client
     */
    public AnnotationsClient annotations() {
        return annotations;
    }
    
    /**
     * Gets the users client for managing users.
     * 
     * @return the users client
     */
    public UsersClient users() {
        return users;
    }
    
    /**
     * Gets the organizations client for managing organizations.
     * 
     * @return the organizations client
     */
    public OrganizationsClient organizations() {
        return organizations;
    }
    
    /**
     * Gets the export storage client for managing export storage configurations.
     * 
     * @return the export storage client
     */
    public ExportStorageClient exportStorage() {
        return exportStorage;
    }
    
    /**
     * Gets the import storage client for managing import storage configurations.
     * 
     * @return the import storage client
     */
    public ImportStorageClient importStorage() {
        return importStorage;
    }
    
    /**
     * Gets the ML client for managing machine learning backends.
     * 
     * @return the ML client
     */
    public MlClient ml() {
        return ml;
    }
    
    /**
     * Gets the webhooks client for managing webhooks.
     * 
     * @return the webhooks client
     */
    public WebhooksClient webhooks() {
        return webhooks;
    }
    
    /**
     * Gets the views client for managing data views.
     * 
     * @return the views client
     */
    public ViewsClient views() {
        return views;
    }
    
    /**
     * Gets the activity logs client for managing activity logs.
     * 
     * @return the activity logs client
     */
    public ActivityLogsClient activityLogs() {
        return activityLogs;
    }
    
    /**
     * Gets the annotation history client for managing annotation history.
     * 
     * @return the annotation history client
     */
    public AnnotationHistoryClient annotationHistory() {
        return annotationHistory;
    }
    
    /**
     * Gets the annotation reviews client for managing annotation reviews.
     * 
     * @return the annotation reviews client
     */
    public AnnotationReviewsClient annotationReviews() {
        return annotationReviews;
    }
    
    /**
     * Gets the comments client for managing comments.
     * 
     * @return the comments client
     */
    public CommentsClient comments() {
        return comments;
    }
    
    /**
     * Gets the files client for managing files.
     * 
     * @return the files client
     */
    public FilesClient files() {
        return files;
    }
    
    /**
     * Gets the underlying HTTP client.
     * 
     * @return the HTTP client
     */
    public HttpClient getHttpClient() {
        return httpClient;
    }
    
    /**
     * Creates a new builder for configuring the Label Studio client.
     * 
     * @return a new builder instance
     */
    public static Builder builder() {
        return new Builder();
    }
    
    private static String determineBaseUrl(String baseUrl, LabelStudioEnvironment environment) {
        if (baseUrl != null && !baseUrl.trim().isEmpty()) {
            return baseUrl.trim();
        }
        
        if (environment != null) {
            return environment.getUrl();
        }
        
        return LabelStudioEnvironment.DEFAULT.getUrl();
    }
    
    private static String determineApiKey(String apiKey) {
        if (apiKey != null && !apiKey.trim().isEmpty()) {
            return apiKey.trim();
        }
        
        return System.getenv("LABEL_STUDIO_API_KEY");
    }
    
    private static Map<String, String> createDefaultHeaders(String apiKey) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Token " + apiKey);
        headers.put("Content-Type", "application/json");
        headers.put("User-Agent", "label-studio-sdk-java/" + SDK_VERSION);
        headers.put("X-SDK-Language", "Java");
        headers.put("X-SDK-Name", "label-studio-sdk");
        headers.put("X-SDK-Version", SDK_VERSION);
        return headers;
    }
    
    /**
     * Builder for configuring the Label Studio client.
     */
    public static class Builder {
        private String baseUrl;
        private LabelStudioEnvironment environment;
        private String apiKey;
        private Duration timeout;
        
        /**
         * Sets the base URL for the Label Studio instance.
         * 
         * @param baseUrl the base URL (e.g., "http://localhost:8080")
         * @return this builder
         */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }
        
        /**
         * Sets the environment for the Label Studio instance.
         * 
         * @param environment the environment
         * @return this builder
         */
        public Builder environment(LabelStudioEnvironment environment) {
            this.environment = environment;
            return this;
        }
        
        /**
         * Sets the API key for authentication.
         * 
         * @param apiKey the API key
         * @return this builder
         */
        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }
        
        /**
         * Sets the request timeout.
         * 
         * @param timeout the timeout duration
         * @return this builder
         */
        public Builder timeout(Duration timeout) {
            this.timeout = timeout;
            return this;
        }
        
        /**
         * Builds the Label Studio client.
         * 
         * @return the configured client
         * @throws ApiError if the configuration is invalid
         */
        public LabelStudio build() {
            return new LabelStudio(this);
        }
    }
}