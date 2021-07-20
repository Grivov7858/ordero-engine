package com.qtech.orderoengine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity(name = "product")
public class ProductEntity {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private MenuEntity menu;

    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "category")
    public Category getCategory() {
        return category;
    }

    @ManyToOne(targetEntity = MenuEntity.class)
    @JoinColumn(name = "menu", referencedColumnName = "id")
    public MenuEntity getMenu() {
        return menu;
    }
}
