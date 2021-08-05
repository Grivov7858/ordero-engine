package com.qtech.orderoengine.model.response;

import java.util.List;


public final class PlaceResponse {
    private final Integer placeId;

    private final String placeName;

    private final List<ProductResponse> products;

    public PlaceResponse(Integer placeId, String placeName, List<ProductResponse> products) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.products = products;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }
}
