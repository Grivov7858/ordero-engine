package com.qtech.orderoengine.model.response;

import com.qtech.orderoengine.model.Category;

import java.math.BigDecimal;

public final class ProductResponse {

    private final Integer productId;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Category category;

    public ProductResponse(Integer productId, String name, String description, BigDecimal price, Category category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
