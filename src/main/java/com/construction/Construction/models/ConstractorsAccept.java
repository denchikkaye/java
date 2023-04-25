package com.construction.Construction.models;

import javax.persistence.*;

@Entity
@Table(name = "constactorsAccept")
public class ConstractorsAccept {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long constractorsOrder;
    private Long homeId;
    private int price;
    private String number;
    private String firstName;
    private String lastName;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getConstractorsOrder() {
        return constractorsOrder;
    }

    public void setConstractorsOrder(Long constractorsOrder) {
        this.constractorsOrder = constractorsOrder;
    }

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
