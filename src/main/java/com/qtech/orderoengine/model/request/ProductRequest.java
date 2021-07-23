package com.qtech.orderoengine.model.request;

import com.qtech.orderoengine.model.Category;

import java.math.BigDecimal;

public final class ProductRequest {
    private final Integer id;
    private final Category category;
    private final String description;
    private final String name;
    private final BigDecimal price;
    private final Integer menuId;

    public ProductRequest(Integer id, Category category, String description, String name, BigDecimal price, Integer menuId) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.name = name;
        this.price = price;
        this.menuId = menuId;
    }

    public Integer getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getMenuId() {
        return menuId;
    }
}
