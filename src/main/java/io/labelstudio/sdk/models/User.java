package io.labelstudio.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a complete user object with all fields.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("first_name")
    private String firstName;
    
    @JsonProperty("last_name")
    private String lastName;
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("last_activity")
    private OffsetDateTime lastActivity;
    
    @JsonProperty("custom_hotkeys")
    private Map<String, Object> customHotkeys;
    
    @JsonProperty("avatar")
    private String avatar;
    
    @JsonProperty("initials")
    private String initials;
    
    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("active_organization")
    private Integer activeOrganization;
    
    @JsonProperty("active_organization_meta")
    private ActiveOrganizationMeta activeOrganizationMeta;
    
    @JsonProperty("allow_newsletters")
    private Boolean allowNewsletters;
    
    @JsonProperty("date_joined")
    private OffsetDateTime dateJoined;
    
    /**
     * Represents the active organization metadata.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ActiveOrganizationMeta {
        
        @JsonProperty("title")
        private String title;
        
        @JsonProperty("email")
        private String email;
        
        /**
         * Default constructor.
         */
        public ActiveOrganizationMeta() {
        }
        
        /**
         * Gets the organization title.
         * 
         * @return the organization title
         */
        public String getTitle() {
            return title;
        }
        
        /**
         * Sets the organization title.
         * 
         * @param title the organization title
         */
        public void setTitle(String title) {
            this.title = title;
        }
        
        /**
         * Gets the organization email.
         * 
         * @return the organization email
         */
        public String getEmail() {
            return email;
        }
        
        /**
         * Sets the organization email.
         * 
         * @param email the organization email
         */
        public void setEmail(String email) {
            this.email = email;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ActiveOrganizationMeta that = (ActiveOrganizationMeta) o;
            return Objects.equals(title, that.title) && Objects.equals(email, that.email);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(title, email);
        }
        
        @Override
        public String toString() {
            return "ActiveOrganizationMeta{" +
                    "title='" + title + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
    
    /**
     * Default constructor.
     */
    public User() {
    }
    
    /**
     * Gets the user ID.
     * 
     * @return the user ID
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the user ID.
     * 
     * @param id the user ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Gets the first name.
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the first name.
     * 
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Gets the last name.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the last name.
     * 
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Gets the username.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Sets the username.
     * 
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Gets the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the email.
     * 
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Gets the last activity timestamp.
     * 
     * @return the last activity timestamp
     */
    public OffsetDateTime getLastActivity() {
        return lastActivity;
    }
    
    /**
     * Sets the last activity timestamp.
     * 
     * @param lastActivity the last activity timestamp
     */
    public void setLastActivity(OffsetDateTime lastActivity) {
        this.lastActivity = lastActivity;
    }
    
    /**
     * Gets the custom hotkeys.
     * 
     * @return the custom hotkeys
     */
    public Map<String, Object> getCustomHotkeys() {
        return customHotkeys;
    }
    
    /**
     * Sets the custom hotkeys.
     * 
     * @param customHotkeys the custom hotkeys
     */
    public void setCustomHotkeys(Map<String, Object> customHotkeys) {
        this.customHotkeys = customHotkeys;
    }
    
    /**
     * Gets the avatar URL.
     * 
     * @return the avatar URL
     */
    public String getAvatar() {
        return avatar;
    }
    
    /**
     * Sets the avatar URL.
     * 
     * @param avatar the avatar URL
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    /**
     * Gets the initials.
     * 
     * @return the initials
     */
    public String getInitials() {
        return initials;
    }
    
    /**
     * Sets the initials.
     * 
     * @param initials the initials
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }
    
    /**
     * Gets the phone number.
     * 
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * Sets the phone number.
     * 
     * @param phone the phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * Gets the active organization ID.
     * 
     * @return the active organization ID
     */
    public Integer getActiveOrganization() {
        return activeOrganization;
    }
    
    /**
     * Sets the active organization ID.
     * 
     * @param activeOrganization the active organization ID
     */
    public void setActiveOrganization(Integer activeOrganization) {
        this.activeOrganization = activeOrganization;
    }
    
    /**
     * Gets the active organization metadata.
     * 
     * @return the active organization metadata
     */
    public ActiveOrganizationMeta getActiveOrganizationMeta() {
        return activeOrganizationMeta;
    }
    
    /**
     * Sets the active organization metadata.
     * 
     * @param activeOrganizationMeta the active organization metadata
     */
    public void setActiveOrganizationMeta(ActiveOrganizationMeta activeOrganizationMeta) {
        this.activeOrganizationMeta = activeOrganizationMeta;
    }
    
    /**
     * Gets whether newsletters are allowed.
     * 
     * @return whether newsletters are allowed
     */
    public Boolean getAllowNewsletters() {
        return allowNewsletters;
    }
    
    /**
     * Sets whether newsletters are allowed.
     * 
     * @param allowNewsletters whether newsletters are allowed
     */
    public void setAllowNewsletters(Boolean allowNewsletters) {
        this.allowNewsletters = allowNewsletters;
    }
    
    /**
     * Gets the date joined timestamp.
     * 
     * @return the date joined timestamp
     */
    public OffsetDateTime getDateJoined() {
        return dateJoined;
    }
    
    /**
     * Sets the date joined timestamp.
     * 
     * @param dateJoined the date joined timestamp
     */
    public void setDateJoined(OffsetDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }
    
    /**
     * Gets the full name (first name + last name).
     * 
     * @return the full name
     */
    public String getFullName() {
        if (firstName == null && lastName == null) {
            return username;
        }
        
        StringBuilder sb = new StringBuilder();
        if (firstName != null) {
            sb.append(firstName);
        }
        if (lastName != null) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(lastName);
        }
        
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + getFullName() + '\'' +
                '}';
    }
}

