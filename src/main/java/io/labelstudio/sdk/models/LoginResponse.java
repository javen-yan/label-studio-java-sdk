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
 * Represents the response from a login request.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
    
    @JsonProperty("detail")
    private String detail;
    
    @JsonProperty("token")
    private String token;
    
    @JsonProperty("user")
    private User user;
    
    @Override
    public String toString() {
        return "LoginResponse{" +
                "detail='" + detail + '\'' +
                ", token='" + (token != null ? token.substring(0, Math.min(20, token.length())) + "..." : null) + '\'' +
                ", user=" + user +
                '}';
    }
}
