package com.qtech.orderoengine.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "place")
public class PlaceEntity {
    private Integer placeId;
    private String placeName;
    private List<ProductEntity> products;
    private List<MassEntity> masses;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getPlaceId() {
        return placeId;
    }

    @Column(name = "place_name")
    public String getPlaceName() {
        return placeName;
    }

    @OneToMany(targetEntity = ProductEntity.class, mappedBy = "place")
    public List<ProductEntity> getProducts() {
        return products;
    }

    @OneToMany(targetEntity = MassEntity.class, mappedBy = "place")
    public List<MassEntity> getMasses() {
        return masses;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public void setMasses(List<MassEntity> masses) {
        this.masses = masses;
    }
}
