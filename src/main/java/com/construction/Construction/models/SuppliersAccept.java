package com.construction.Construction.models;

import javax.persistence.*;

@Entity
@Table(name = "suppliersAccept")
public class SuppliersAccept {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long supplierOrderId;
    private int price;
    private String firstName;
    private String lastName;
    private String number;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(Long supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
