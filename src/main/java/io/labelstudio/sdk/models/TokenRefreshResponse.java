package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the response from a token refresh request.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenRefreshResponse {
    
    @JsonProperty("access")
    private String access;
    
    @JsonProperty("refresh")
    private String refresh;
    
    @Override
    public String toString() {
        return "TokenRefreshResponse{" +
                "access='" + (access != null ? access.substring(0, Math.min(20, access.length())) + "..." : null) + '\'' +
                ", refresh='" + (refresh != null ? refresh.substring(0, Math.min(20, refresh.length())) + "..." : null) + '\'' +
                '}';
    }
}
