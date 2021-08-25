package com.ngochuy.apiphoneshop.payload;

public class ProductInCart {
    int productId;
    int quantityCart;

    public ProductInCart() {
    }

    public ProductInCart(int productId, int quantityCart) {
        this.productId = productId;
        this.quantityCart = quantityCart;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }
}
