package io.labelstudio.sdk;

import io.labelstudio.sdk.client.*;
import io.labelstudio.sdk.core.ApiError;
import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.TokenManager;
import io.labelstudio.sdk.models.LoginResponse;

import java.time.Duration;

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
    private final ActivityLogsClient activityLogs;
    private final AnnotationHistoryClient annotationHistory;
    private final AnnotationReviewsClient annotationReviews;
    private final CommentsClient comments;
    private final FilesClient files;
    
    private final TokenManager tokenManager;
    
    private LabelStudio(Builder builder) {
        String baseUrl = determineBaseUrl(builder.baseUrl);
        String apiKey = determineApiKey(builder.apiKey);
        
        // Create HTTP client first (without auth headers, will be set by interceptor)
        this.httpClient = new HttpClient(baseUrl, null, 
                builder.timeout != null ? builder.timeout : DEFAULT_TIMEOUT);
        
        // Initialize sub-clients (users client needed for token refresh)
        this.users = new UsersClient(httpClient);
        
        // Create token manager
        this.tokenManager = new TokenManager(baseUrl, apiKey, users);
        
        // Update HTTP client to use token manager
        this.httpClient.setTokenManager(tokenManager);
        
        // Initialize remaining sub-clients
        this.projects = new ProjectsClient(httpClient);
        this.tasks = new TasksClient(httpClient);
        this.annotations = new AnnotationsClient(httpClient);
        this.organizations = new OrganizationsClient(httpClient);
        this.exportStorage = new ExportStorageClient(httpClient);
        this.importStorage = new ImportStorageClient(httpClient);
        this.ml = new MlClient(httpClient);
        this.webhooks = new WebhooksClient(httpClient);
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
    
    /**
     * Creates a Label Studio client by logging in with email and password.
     * 
     * <p>This method creates a temporary client, performs login, and then
     * creates a new authenticated client using the returned token.</p>
     * 
     * <p>Example usage:</p>
     * <pre>
     * LabelStudio client = LabelStudio.login(
     *     LabelStudioEnvironment.DEFAULT,
     *     "user@example.com",
     *     "password"
     * );
     * </pre>
     * 
     * @param environment the Label Studio environment
     * @param email the user email
     * @param password the user password
     * @return an authenticated Label Studio client
     * @throws ApiError if login fails
     */
    public static LabelStudio login(String baseUrl, String email, String password, Duration timeout) {
        // Create a temporary client without API key for login
        Builder tempBuilder = new Builder();
        tempBuilder.baseUrl(baseUrl);
        tempBuilder.timeout(timeout);
        LabelStudio tempClient = tempBuilder.build();
        
        // Perform login
        LoginResponse loginResponse = tempClient.users().login(email, password);
        String token = loginResponse.getToken();
        
        if (token == null || token.trim().isEmpty()) {
            throw new ApiError("Login failed: token is null or empty");
        }
        
        // Create and return authenticated client
        return new Builder()
                .baseUrl(baseUrl)
                .apiKey(token)
                .timeout(timeout)
                .build();
    }
    
    /**
     * Creates a Label Studio client by logging in with email and password.
     * 
     * <p>This method creates a temporary client, performs login, and then
     * creates a new authenticated client using the returned token.</p>
     * 
     * @param baseUrl the base URL of the Label Studio instance
     * @param email the user email
     * @param password the user password
     * @return an authenticated Label Studio client
     * @throws ApiError if login fails
     */
    public static LabelStudio login(String baseUrl, String email, String password) {
        return login(baseUrl, email, password, DEFAULT_TIMEOUT);
    }
    
    private static String determineBaseUrl(String baseUrl) {
        if (baseUrl != null && !baseUrl.trim().isEmpty()) {
            return baseUrl.trim();
        }
        throw new IllegalArgumentException("Base URL is required");
    }
    
    private static String determineApiKey(String apiKey) {
        // If apiKey is explicitly provided (even if empty string), use it
        // Only fall back to environment variable if apiKey is null
        if (apiKey != null) {
            return apiKey.trim();
        }
        
        return System.getenv("LABEL_STUDIO_API_KEY");
    }
    
    /**
     * Builder for configuring the Label Studio client.
     */
    public static class Builder {
        private String baseUrl;
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