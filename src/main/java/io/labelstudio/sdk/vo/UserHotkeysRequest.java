package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * Request object for updating user hotkeys.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserHotkeysRequest {
    
    @JsonProperty("custom_hotkeys")
    private Map<String, Object> customHotkeys;
}

