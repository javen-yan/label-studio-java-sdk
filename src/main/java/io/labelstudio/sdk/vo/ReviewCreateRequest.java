package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreateRequest {
    @JsonProperty("annotation") private Integer annotationId;
    @JsonProperty("action") private String action;
    @JsonProperty("comment") private String comment;
    @JsonProperty("score") private Double score;
}