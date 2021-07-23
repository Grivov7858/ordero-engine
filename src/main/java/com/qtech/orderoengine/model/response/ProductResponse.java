package com.qtech.orderoengine.model.response;

import com.qtech.orderoengine.model.Category;

import java.math.BigDecimal;

public class ProductResponse {

    private final Integer id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Category category;

    public ProductResponse(Integer id, String name, String description, BigDecimal price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Integer getId() {
        return id;
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
