package com.qtech.orderoengine.model.response;

import java.util.List;

public final class OrderResponse {

    private final Integer placeId;
    private final List<MassResponse> masses;

    public OrderResponse(Integer placeId, List<MassResponse> masses) {
        this.placeId = placeId;
        this.masses = masses;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public List<MassResponse> getMasses() {
        return masses;
    }
}
