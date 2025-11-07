package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUpload {
    @JsonProperty("id") private Integer id;
    @JsonProperty("filename") private String filename;
    @JsonProperty("original_filename") private String originalFilename;
    @JsonProperty("file_size") private Long fileSize;
    @JsonProperty("content_type") private String contentType;
    @JsonProperty("file_path") private String filePath;
    @JsonProperty("url") private String url;
    @JsonProperty("project") private Integer projectId;
    @JsonProperty("task") private Integer taskId;
    @JsonProperty("user") private Integer userId;
    @JsonProperty("user_name") private String userName;
    @JsonProperty("is_public") private Boolean isPublic;
    @JsonProperty("checksum") private String checksum;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
    @JsonProperty("updated_at") private OffsetDateTime updatedAt;
}