package io.labelstudio.sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Result object for bulk member operations.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BulkMemberResult {
    
    @JsonProperty("success_count")
    private Integer successCount;
    
    @JsonProperty("error_count")
    private Integer errorCount;
    
    @JsonProperty("created_members")
    private List<Integer> createdMembers;
    
    @JsonProperty("updated_members")
    private List<Integer> updatedMembers;
    
    @JsonProperty("removed_members")
    private List<Integer> removedMembers;
    
    @JsonProperty("errors")
    private List<MemberError> errors;
    
    @JsonProperty("message")
    private String message;
    
    /**
     * Represents an error that occurred during bulk member operations.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberError {
        @JsonProperty("user_id")
        private Integer userId;
        
        @JsonProperty("email")
        private String email;
        
        @JsonProperty("error_message")
        private String errorMessage;
        
        @JsonProperty("error_code")
        private String errorCode;
    }
}
