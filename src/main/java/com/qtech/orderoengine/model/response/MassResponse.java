package com.qtech.orderoengine.model.response;

import java.util.List;

public final class MassResponse {

    private final Integer massId;
    private final List<ProductResponse> products;

    public MassResponse(Integer massId, List<ProductResponse> products) {
        this.massId = massId;
        this.products = products;
    }

    public Integer getMassId() {
        return massId;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }
}
