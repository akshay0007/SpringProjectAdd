//package com.myproject.example.model;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * Created by stpl on 1/1/19.
// */
//@Entity
//@Table(name = "product")
//public class Product implements Serializable {
//    private String code;
//    private String name;
//    private Double price;
//    private byte[] image;
//    private Date createDate;
//
//
//    @Id
//    @Column(name = "code", length = 20, nullable = false)
//    public String getCode() {
//        return code;
//    }
//
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    @Column(name = "Name", length = 255, nullable = false)
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Column(name = "Price", nullable = false)
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public byte[] getImage() {
//        return image;
//    }
//
//    @Column(name = "image", columnDefinition = "BLOB NOT NULL", length = Integer.MAX_VALUE)
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//}
