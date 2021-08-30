package com.ngochuy.apiphoneshop.payload;

import java.util.List;

public class InvoiceRequest {
    private int userId;
    private String name;
    private String phone;
    private String address;
    private Long totalPrice;
    private List<ProductInCart> listProInCart;

    public InvoiceRequest() {
    }

    public InvoiceRequest(int userId, String name, String phone, String address, Long totalPrice, List<ProductInCart> listProInCart) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.totalPrice = totalPrice;
        this.listProInCart = listProInCart;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ProductInCart> getListProInCart() {
        return listProInCart;
    }

    public void setListProInCart(List<ProductInCart> listProInCart) {
        this.listProInCart = listProInCart;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
