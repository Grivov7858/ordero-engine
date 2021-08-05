package com.qtech.orderoengine.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "mass")
public class MassEntity {

    private Integer massId;
    private PlaceEntity place;
    private List<Integer> productIds;

    @Id
    public Integer getMassId() {
        return massId;
    }

    @ManyToOne(targetEntity = PlaceEntity.class)
    @JoinColumn(name = "place", referencedColumnName = "placeId")
    public PlaceEntity getPlace() {
        return place;
    }

    @ElementCollection
    @CollectionTable(
            name = "mass_products",
            joinColumns = @JoinColumn(name = "mass_id")
    )
    @Column(name = "product_id")
    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setMassId(Integer massId) {
        this.massId = massId;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
