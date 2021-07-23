package com.qtech.orderoengine.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "menu")
public class MenuEntity {
    private Integer id;
    private String placeName;
    private List<ProductEntity> products;

    @Id
    public Integer getId() {
        return id;
    }

    @Column(name = "place_name")
    public String getPlaceName() {
        return placeName;
    }

    @OneToMany(targetEntity = ProductEntity.class, mappedBy = "menu")
    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
