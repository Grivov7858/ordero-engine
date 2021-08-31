package com.qtech.orderoengine.model.entity;

import com.qtech.orderoengine.model.Category;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "product")
public class ProductEntity {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private PlaceEntity place;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(targetEntity = PlaceEntity.class)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    public PlaceEntity getPlace() {
        return place;
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

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }
}
