package com.qtech.orderoengine.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "mass")
public class MassEntity {

    private Integer id;
    private PlaceEntity place;
    private List<Integer> productIds;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(targetEntity = PlaceEntity.class)
    @JoinColumn(name = "place", referencedColumnName = "id")
    public PlaceEntity getPlace() {
        return place;
    }

    @ElementCollection
    @CollectionTable(
            name = "mass_products",
            joinColumns = @JoinColumn(name = "id")
    )
    @Column(name = "product_id")
    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
