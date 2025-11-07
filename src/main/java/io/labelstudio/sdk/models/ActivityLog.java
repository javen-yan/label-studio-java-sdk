package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {
    @JsonProperty("id") private Integer id;
    @JsonProperty("user") private Integer userId;
    @JsonProperty("user_name") private String userName;
    @JsonProperty("project") private Integer projectId;
    @JsonProperty("action") private String action;
    @JsonProperty("object_type") private String objectType;
    @JsonProperty("object_id") private Integer objectId;
    @JsonProperty("details") private Map<String, Object> details;
    @JsonProperty("ip_address") private String ipAddress;
    @JsonProperty("user_agent") private String userAgent;
    @JsonProperty("created_at") private OffsetDateTime createdAt;
}