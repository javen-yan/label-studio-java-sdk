package io.labelstudio.sdk.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Result of label configuration validation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelConfigValidationResult {
    
    @JsonProperty("valid")
    private boolean valid;
    
    @JsonProperty("errors")
    private List<String> errors;
    
    @JsonProperty("warnings")
    private List<String> warnings;
    
    /**
     * Default constructor.
     */
    public LabelConfigValidationResult() {
    }
    
    /**
     * Gets whether the configuration is valid.
     * 
     * @return true if the configuration is valid
     */
    public boolean isValid() {
        return valid;
    }
    
    /**
     * Sets whether the configuration is valid.
     * 
     * @param valid true if the configuration is valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    /**
     * Gets the validation errors.
     * 
     * @return the list of errors
     */
    public List<String> getErrors() {
        return errors;
    }
    
    /**
     * Sets the validation errors.
     * 
     * @param errors the list of errors
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    
    /**
     * Gets the validation warnings.
     * 
     * @return the list of warnings
     */
    public List<String> getWarnings() {
        return warnings;
    }
    
    /**
     * Sets the validation warnings.
     * 
     * @param warnings the list of warnings
     */
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }
    
    /**
     * Gets whether there are any errors.
     * 
     * @return true if there are errors
     */
    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }
    
    /**
     * Gets whether there are any warnings.
     * 
     * @return true if there are warnings
     */
    public boolean hasWarnings() {
        return warnings != null && !warnings.isEmpty();
    }
    
    @Override
    public String toString() {
        return "LabelConfigValidationResult{" +
                "valid=" + valid +
                ", errors=" + errors +
                ", warnings=" + warnings +
                '}';
    }
}