package io.labelstudio.sdk.client;

import io.labelstudio.sdk.core.HttpClient;
import io.labelstudio.sdk.core.Pagination;
import io.labelstudio.sdk.models.FileUpload;
import io.labelstudio.sdk.vo.FileUploadOptions;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Client for managing files in Label Studio.
 * 
 * <p>This client provides functionality for uploading, downloading,
 * and managing files used in tasks and projects.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * FileUpload upload = client.files().upload(
 *     new File("image.jpg"),
 *     FileUploadOptions.builder()
 *         .projectId(projectId)
 *         .build()
 * );
 * </pre>
 */
public class FilesClient {
    
    private final HttpClient httpClient;
    
    public FilesClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    
    /**
     * Lists all uploaded files.
     * 
     * @return a paginated list of file uploads
     */
    public Pagination<FileUpload> list() {
        return httpClient.getPaginated("/api/files/", FileUpload.class);
    }
    
    /**
     * Lists all uploaded files asynchronously.
     * 
     * @return a CompletableFuture containing a paginated list of file uploads
     */
    public CompletableFuture<Pagination<FileUpload>> listAsync() {
        return httpClient.getPaginatedAsync("/api/files/", FileUpload.class);
    }
    
    /**
     * Uploads a file.
     * 
     * @param file the file to upload
     * @param options upload options
     * @return the file upload record
     */
    public FileUpload upload(File file, FileUploadOptions options) {
        return httpClient.uploadFile("/api/files/", file, options, FileUpload.class);
    }
    
    /**
     * Uploads a file asynchronously.
     * 
     * @param file the file to upload
     * @param options upload options
     * @return a CompletableFuture containing the file upload record
     */
    public CompletableFuture<FileUpload> uploadAsync(File file, FileUploadOptions options) {
        return httpClient.uploadFileAsync("/api/files/", file, options, FileUpload.class);
    }
    
    /**
     * Uploads a file from an input stream.
     * 
     * @param inputStream the input stream
     * @param filename the filename
     * @param options upload options
     * @return the file upload record
     */
    public FileUpload upload(InputStream inputStream, String filename, FileUploadOptions options) {
        return httpClient.uploadFile("/api/files/", inputStream, filename, options, FileUpload.class);
    }
    
    /**
     * Uploads a file from an input stream asynchronously.
     * 
     * @param inputStream the input stream
     * @param filename the filename
     * @param options upload options
     * @return a CompletableFuture containing the file upload record
     */
    public CompletableFuture<FileUpload> uploadAsync(InputStream inputStream, String filename, FileUploadOptions options) {
        return httpClient.uploadFileAsync("/api/files/", inputStream, filename, options, FileUpload.class);
    }
    
    /**
     * Gets a specific file upload by ID.
     * 
     * @param fileId the file ID
     * @return the file upload record
     */
    public FileUpload get(int fileId) {
        return httpClient.get("/api/files/" + fileId + "/", FileUpload.class);
    }
    
    /**
     * Gets a specific file upload by ID asynchronously.
     * 
     * @param fileId the file ID
     * @return a CompletableFuture containing the file upload record
     */
    public CompletableFuture<FileUpload> getAsync(int fileId) {
        return httpClient.getAsync("/api/files/" + fileId + "/", FileUpload.class);
    }
    
    /**
     * Downloads a file.
     * 
     * @param fileId the file ID
     * @return the file content as byte array
     */
    public byte[] download(int fileId) {
        return httpClient.downloadFile("/api/files/" + fileId + "/download/");
    }
    
    /**
     * Downloads a file asynchronously.
     * 
     * @param fileId the file ID
     * @return a CompletableFuture containing the file content as byte array
     */
    public CompletableFuture<byte[]> downloadAsync(int fileId) {
        return httpClient.downloadFileAsync("/api/files/" + fileId + "/download/");
    }
    
    /**
     * Deletes a file.
     * 
     * @param fileId the file ID
     */
    public void delete(int fileId) {
        httpClient.delete("/api/files/" + fileId + "/");
    }
    
    /**
     * Deletes a file asynchronously.
     * 
     * @param fileId the file ID
     * @return a CompletableFuture that completes when the file is deleted
     */
    public CompletableFuture<Void> deleteAsync(int fileId) {
        return httpClient.deleteAsync("/api/files/" + fileId + "/");
    }
    
    /**
     * Lists files for a specific project.
     * 
     * @param projectId the project ID
     * @return a paginated list of files for the project
     */
    public Pagination<FileUpload> listByProject(int projectId) {
        return httpClient.getPaginated("/api/files/?project=" + projectId, FileUpload.class);
    }
    
    /**
     * Lists files for a specific project asynchronously.
     * 
     * @param projectId the project ID
     * @return a CompletableFuture containing a paginated list of files for the project
     */
    public CompletableFuture<Pagination<FileUpload>> listByProjectAsync(int projectId) {
        return httpClient.getPaginatedAsync("/api/files/?project=" + projectId, FileUpload.class);
    }
    
    /**
     * Lists files uploaded by a specific user.
     * 
     * @param userId the user ID
     * @return a paginated list of files uploaded by the user
     */
    public Pagination<FileUpload> listByUser(int userId) {
        return httpClient.getPaginated("/api/files/?user=" + userId, FileUpload.class);
    }
    
    /**
     * Lists files uploaded by a specific user asynchronously.
     * 
     * @param userId the user ID
     * @return a CompletableFuture containing a paginated list of files uploaded by the user
     */
    public CompletableFuture<Pagination<FileUpload>> listByUserAsync(int userId) {
        return httpClient.getPaginatedAsync("/api/files/?user=" + userId, FileUpload.class);
    }
    
    /**
     * Gets file metadata without downloading the content.
     * 
     * @param fileId the file ID
     * @return the file metadata
     */
    public FileUpload getMetadata(int fileId) {
        return httpClient.get("/api/files/" + fileId + "/metadata/", FileUpload.class);
    }
    
    /**
     * Gets file metadata without downloading the content asynchronously.
     * 
     * @param fileId the file ID
     * @return a CompletableFuture containing the file metadata
     */
    public CompletableFuture<FileUpload> getMetadataAsync(int fileId) {
        return httpClient.getAsync("/api/files/" + fileId + "/metadata/", FileUpload.class);
    }
    
    /**
     * Updates a file upload.
     * 
     * @param fileId the file ID
     * @param options update options
     * @return the updated file upload record
     */
    public FileUpload update(int fileId, FileUploadOptions options) {
        return httpClient.put("/api/files/" + fileId + "/", options, FileUpload.class);
    }
    
    /**
     * Updates a file upload asynchronously.
     * 
     * @param fileId the file ID
     * @param options update options
     * @return a CompletableFuture containing the updated file upload record
     */
    public CompletableFuture<FileUpload> updateAsync(int fileId, FileUploadOptions options) {
        return httpClient.putAsync("/api/files/" + fileId + "/", options, FileUpload.class);
    }
    
    /**
     * Deletes multiple files.
     * 
     * @param fileIds the list of file IDs to delete
     */
    public void deleteMany(List<Integer> fileIds) {
        httpClient.post("/api/files/delete-many/", fileIds, Void.class);
    }
    
    /**
     * Deletes multiple files asynchronously.
     * 
     * @param fileIds the list of file IDs to delete
     * @return a CompletableFuture that completes when the files are deleted
     */
    public CompletableFuture<Void> deleteManyAsync(List<Integer> fileIds) {
        return httpClient.postAsync("/api/files/delete-many/", fileIds, Void.class);
    }
}