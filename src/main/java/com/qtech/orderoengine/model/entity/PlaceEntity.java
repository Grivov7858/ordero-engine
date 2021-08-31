package com.qtech.orderoengine.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "place")
public class PlaceEntity {
    private Integer id;
    private String placeName;
    private List<ProductEntity> products;
    private List<MassEntity> masses;

    public PlaceEntity() {
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

    public PlaceEntity(String placeName,
                       List<ProductEntity> products,
                       List<MassEntity> masses) {
        this.placeName = placeName;
        this.products = products;
        this.masses = masses;
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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
