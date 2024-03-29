package com.zomato_demo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListModel {

    @SerializedName("results_found")
    @Expose
    private String resultsFound;
    @SerializedName("results_start")
    @Expose
    private String resultsStart;
    @SerializedName("results_shown")
    @Expose
    private String resultsShown;
    @SerializedName("restaurants")
    @Expose
    private List<DetailsModel> restaurants = null;

    public String getResultsFound() {
        return resultsFound;
    }

    public void setResultsFound(String resultsFound) {
        this.resultsFound = resultsFound;
    }

    public String getResultsStart() {
        return resultsStart;
    }

    public void setResultsStart(String resultsStart) {
        this.resultsStart = resultsStart;
    }

    public String getResultsShown() {
        return resultsShown;
    }

    public void setResultsShown(String resultsShown) {
        this.resultsShown = resultsShown;
    }

    public List<DetailsModel> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<DetailsModel> restaurants) {
        this.restaurants = restaurants;
    }

}
