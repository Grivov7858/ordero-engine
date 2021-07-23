package com.qtech.orderoengine.model.request;

public final class MenuRequest {

    private final Integer id;

    private final String placeName;

    public MenuRequest(Integer id, String placeName) {
        this.id = id;
        this.placeName = placeName;
    }

    public Integer getId() {
        return id;
    }

    public String getPlaceName() {
        return placeName;
    }
}
