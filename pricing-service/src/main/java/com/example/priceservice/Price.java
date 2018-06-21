package com.example.priceservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @Column(name = "billboardId")
    private String billboardId;
    @Column(name = "price")
    private Double price;

    public String getBillboardId() {
        return billboardId;
    }

    public void setBillboardId(String billboardId) {
        this.billboardId = billboardId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
