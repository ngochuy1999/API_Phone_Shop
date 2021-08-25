package com.ngochuy.apiphoneshop.payload;

import java.util.List;

public class InvoiceRequest {
    private int userId;
    private Long totalPrice;
    private List<ProductInCart> listProInCart;

    public InvoiceRequest() {
    }

    public InvoiceRequest(int userId, Long totalPrice, List<ProductInCart> listProInCart) {
        this.userId = userId;
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
}
