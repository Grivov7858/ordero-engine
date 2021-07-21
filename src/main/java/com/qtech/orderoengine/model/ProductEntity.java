package com.qtech.orderoengine.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "product")
public class ProductEntity {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private MenuEntity menu;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }
}
