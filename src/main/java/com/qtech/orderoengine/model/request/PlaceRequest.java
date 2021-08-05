package com.qtech.orderoengine.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class PlaceRequest {

    private final String placeName;

    //TODO this is added only because json gives error with one parameter, remove this if we add new column
    @JsonIgnore
    private final String description;

    public PlaceRequest(String placeName, String description) {
        this.placeName = placeName;
        this.description = description;

    }

    public String getPlaceName() {
        return placeName;
    }

    public String getDescription() {
        return description;
    }
}
