package io.labelstudio.sdk.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadOptions {
    private Integer projectId;
    private Integer taskId;
    private Boolean isPublic;
    private String description;
}