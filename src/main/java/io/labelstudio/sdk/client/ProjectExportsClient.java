package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.RequestOptions;
import io.labelstudio.sdk.models.Export;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Client for managing project exports.
 */
public class ProjectExportsClient {
    
    private final HttpClient httpClient;
    private final int projectId;
    
    /**
     * Constructs a new project exports client.
     * 
     * @param httpClient the HTTP client to use
     * @param projectId the project ID
     */
    public ProjectExportsClient(HttpClient httpClient, int projectId) {
        this.httpClient = httpClient;
        this.projectId = projectId;
    }
    
    /**
     * Lists exports for the project with options.
     * 
     * @param options request options
     * @return a paginated list of exports
     */
    public List<Export> list(RequestOptions options) {
        List<Export> exports = httpClient.get("/api/projects/" + projectId + "/exports/", 
                            httpClient.getObjectMapper().getTypeFactory()
                                    .constructCollectionType(List.class, Export.class));
        return exports;
    }
    
    /**
     * Lists all exports for the project asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of exports
     */
    public CompletableFuture<List<Export>> listAsync() {
        return listAsync(null);
    }
    
    /**
     * Lists exports for the project with options asynchronously.
     * 
     * @param options request options
     * @return a CompletableFuture containing a paginated list of exports
     */
    public CompletableFuture<List<Export>> listAsync(RequestOptions options) {
        return httpClient.getAsync("/api/projects/" + projectId + "/exports/", 
                httpClient.getObjectMapper().getTypeFactory()
                        .constructCollectionType(List.class, Export.class));
    }
    
    /**
     * Creates a new export.
     * 
     * @param request the export creation request
     * @return the created export
     */
    public Export create(ExportCreateRequest request) {
        return create(request, null);
    }
    
    /**
     * Creates a new export with options.
     * 
     * @param request the export creation request
     * @param options request options
     * @return the created export
     */
    public Export create(ExportCreateRequest request, RequestOptions options) {
        return httpClient.post("/api/projects/" + projectId + "/exports/", request, Export.class);
    }
    
    /**
     * Creates a new export asynchronously.
     * 
     * @param request the export creation request
     * @return a CompletableFuture containing the created export
     */
    public CompletableFuture<Export> createAsync(ExportCreateRequest request) {
        return createAsync(request, null);
    }
    
    /**
     * Creates a new export with options asynchronously.
     * 
     * @param request the export creation request
     * @param options request options
     * @return a CompletableFuture containing the created export
     */
    public CompletableFuture<Export> createAsync(ExportCreateRequest request, RequestOptions options) {
        return httpClient.postAsync("/api/projects/" + projectId + "/exports/", request, Export.class);
    }
    
    /**
     * Gets an export by ID.
     * 
     * @param exportId the export ID
     * @return the export
     */
    public Export get(int exportId) {
        return get(exportId, null);
    }
    
    /**
     * Gets an export by ID with options.
     * 
     * @param exportId the export ID
     * @param options request options
     * @return the export
     */
    public Export get(int exportId, RequestOptions options) {
        return httpClient.get("/api/projects/" + projectId + "/exports/" + exportId, Export.class);
    }
    
    /**
     * Gets an export by ID asynchronously.
     * 
     * @param exportId the export ID
     * @return a CompletableFuture containing the export
     */
    public CompletableFuture<Export> getAsync(int exportId) {
        return getAsync(exportId, null);
    }
    
    /**
     * Gets an export by ID with options asynchronously.
     * 
     * @param exportId the export ID
     * @param options request options
     * @return a CompletableFuture containing the export
     */
    public CompletableFuture<Export> getAsync(int exportId, RequestOptions options) {
        return httpClient.getAsync("/api/projects/" + projectId + "/exports/" + exportId, Export.class);
    }
    
    /**
     * Deletes an export.
     * 
     * @param exportId the export ID
     */
    public void delete(int exportId) {
        delete(exportId, null);
    }
    
    /**
     * Deletes an export with options.
     * 
     * @param exportId the export ID
     * @param options request options
     */
    public void delete(int exportId, RequestOptions options) {
        httpClient.delete("/api/projects/" + projectId + "/exports/" + exportId, Void.class);
    }
    
    /**
     * Deletes an export asynchronously.
     * 
     * @param exportId the export ID
     * @return a CompletableFuture that completes when the export is deleted
     */
    public CompletableFuture<Void> deleteAsync(int exportId) {
        return deleteAsync(exportId, null);
    }
    
    /**
     * Deletes an export with options asynchronously.
     * 
     * @param exportId the export ID
     * @param options request options
     * @return a CompletableFuture that completes when the export is deleted
     */
    public CompletableFuture<Void> deleteAsync(int exportId, RequestOptions options) {
        return httpClient.deleteAsync("/api/projects/" + projectId + "/exports/" + exportId, Void.class);
    }
    
    /**
     * Downloads export data synchronously.
     * 
     * @param exportId the export ID
     * @param options export download options
     * @return the export data as bytes
     */
    public byte[] download(int exportId, ExportDownloadOptions options) {
        return download(exportId, options, null);
    }
    
    /**
     * Downloads export data synchronously with request options.
     * 
     * @param exportId the export ID
     * @param downloadOptions export download options
     * @param requestOptions request options
     * @return the export data as bytes
     */
    public byte[] download(int exportId, ExportDownloadOptions downloadOptions, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/exports/" + exportId + "/download";
        if (downloadOptions != null) {
            path += buildDownloadQueryString(downloadOptions);
        }
        return httpClient.get(path, byte[].class);
    }
    
    /**
     * Downloads export data asynchronously.
     * 
     * @param exportId the export ID
     * @param options export download options
     * @return a CompletableFuture containing the export data as bytes
     */
    public CompletableFuture<byte[]> downloadAsync(int exportId, ExportDownloadOptions options) {
        return downloadAsync(exportId, options, null);
    }
    
    /**
     * Downloads export data asynchronously with request options.
     * 
     * @param exportId the export ID
     * @param downloadOptions export download options
     * @param requestOptions request options
     * @return a CompletableFuture containing the export data as bytes
     */
    public CompletableFuture<byte[]> downloadAsync(int exportId, ExportDownloadOptions downloadOptions, RequestOptions requestOptions) {
        String path = "/api/projects/" + projectId + "/exports/" + exportId + "/download";
        if (downloadOptions != null) {
            path += buildDownloadQueryString(downloadOptions);
        }
        return httpClient.getAsync(path, byte[].class);
    }
    
    /**
     * Builds query string for download options.
     * 
     * @param options the download options
     * @return the query string (starting with ?)
     */
    private String buildDownloadQueryString(ExportDownloadOptions options) {
        StringBuilder sb = new StringBuilder("?");
        boolean hasParam = false;
        
        if (options.getDownloadAllTasks() != null) {
            sb.append("download_all_tasks=").append(options.getDownloadAllTasks());
            hasParam = true;
        }
        
        if (options.getDownloadResources() != null) {
            if (hasParam) sb.append("&");
            sb.append("download_resources=").append(options.getDownloadResources());
            hasParam = true;
        }
        
        if (options.getExportType() != null) {
            if (hasParam) sb.append("&");
            sb.append("export_type=").append(options.getExportType());
            hasParam = true;
        }
        
        if (options.getIds() != null) {
            if (hasParam) sb.append("&");
            sb.append("ids=").append(options.getIds());
            hasParam = true;
        }
        
        return hasParam ? sb.toString() : "";
    }
}