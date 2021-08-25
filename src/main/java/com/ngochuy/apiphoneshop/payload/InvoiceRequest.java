package com.ngochuy.apiphoneshop.payload;

import java.util.List;

public class InvoiceRequest {
    private int userId;
    private List<ProductInCart> listProInCart;

    public InvoiceRequest() {
    }

    public InvoiceRequest(int userId, List<ProductInCart> listProInCart) {
        this.userId = userId;
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
}
