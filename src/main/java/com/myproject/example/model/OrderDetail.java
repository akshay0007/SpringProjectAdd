package com.myproject.example.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by stpl on 1/1/19.
 */
@Entity
@Table(name = "Order_Details")
public class OrderDetail implements Serializable {
    private String id;
    private Order order;

    private Product product;
    private int quanity;
    private double price;
    private double amount;

    @Id
    @Column(name = "id", length = 50, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "oder_id", nullable = false
            , foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false,
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "Quanity", nullable = false)
    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    @Column(name = "Price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "Amount", nullable = false)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
