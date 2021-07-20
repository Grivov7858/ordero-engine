package com.qtech.orderoengine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "menu")
public class MenuEntity {
    private Integer id;
    private String placeName;
    private List<ProductEntity> products;

    @Column(name = "id", nullable = false)
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
}
