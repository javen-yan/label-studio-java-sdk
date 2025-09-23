package io.labelstudio.sdk.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Generic pagination wrapper for API responses.
 * 
 * @param <T> the type of items in the paginated response
 */
public class Pagination<T> {
    
    @JsonProperty("count")
    private int count;
    
    @JsonProperty("next")
    private String next;
    
    @JsonProperty("previous")
    private String previous;
    
    @JsonProperty("results")
    private List<T> results;
    
    /**
     * Default constructor for JSON deserialization.
     */
    public Pagination() {
    }
    
    /**
     * Constructs a pagination wrapper.
     * 
     * @param count total number of items
     * @param next URL for the next page
     * @param previous URL for the previous page
     * @param results list of items in this page
     */
    public Pagination(int count, String next, String previous, List<T> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }
    
    /**
     * Gets the total number of items across all pages.
     * 
     * @return the total count
     */
    public int getCount() {
        return count;
    }
    
    /**
     * Sets the total count.
     * 
     * @param count the total count
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    /**
     * Gets the URL for the next page.
     * 
     * @return the next page URL, or null if this is the last page
     */
    public String getNext() {
        return next;
    }
    
    /**
     * Sets the next page URL.
     * 
     * @param next the next page URL
     */
    public void setNext(String next) {
        this.next = next;
    }
    
    /**
     * Gets the URL for the previous page.
     * 
     * @return the previous page URL, or null if this is the first page
     */
    public String getPrevious() {
        return previous;
    }
    
    /**
     * Sets the previous page URL.
     * 
     * @param previous the previous page URL
     */
    public void setPrevious(String previous) {
        this.previous = previous;
    }
    
    /**
     * Gets the list of items in this page.
     * 
     * @return the list of results
     */
    public List<T> getResults() {
        return results;
    }
    
    /**
     * Sets the list of results.
     * 
     * @param results the list of results
     */
    public void setResults(List<T> results) {
        this.results = results;
    }
    
    /**
     * Checks if there is a next page.
     * 
     * @return true if there is a next page
     */
    public boolean hasNext() {
        return next != null && !next.isEmpty();
    }
    
    /**
     * Checks if there is a previous page.
     * 
     * @return true if there is a previous page
     */
    public boolean hasPrevious() {
        return previous != null && !previous.isEmpty();
    }
    
    /**
     * Gets the number of items in this page.
     * 
     * @return the number of items in this page
     */
    public int getPageSize() {
        return results != null ? results.size() : 0;
    }
    
    @Override
    public String toString() {
        return String.format("Pagination{count=%d, pageSize=%d, hasNext=%b, hasPrevious=%b}", 
                count, getPageSize(), hasNext(), hasPrevious());
    }
}