package com.qtech.orderoengine.model.request;

import java.util.List;

public final class OrderRequest {
    private final List<Integer> productIds;
    private final Integer massId;
    private final Integer placeId;

    public OrderRequest(List<Integer> productIds, Integer massId, Integer placeId) {
        this.productIds = productIds;
        this.massId = massId;
        this.placeId = placeId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public Integer getMassId() {
        return massId;
    }

    public Integer getPlaceId() {
        return placeId;
    }
}
