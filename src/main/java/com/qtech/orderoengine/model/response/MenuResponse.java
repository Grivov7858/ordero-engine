package com.qtech.orderoengine.model.response;

import java.util.List;


public final class MenuResponse {
    private final Integer id;

    private final String placeName;

    private final List<ProductResponse> products;

    public MenuResponse(Integer id, String placeName, List<ProductResponse> products) {
        this.id = id;
        this.placeName = placeName;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }
}
