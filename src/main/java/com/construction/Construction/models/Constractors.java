package com.construction.Construction.models;


import javax.persistence.*;

@Entity
@Table(name = "contractors")
public class Constractors {
    @Id
    private Long id;
    private int price;
    private Long homeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }
}
