package com.ngochuy.apiphoneshop.entities;

import javax.persistence.*;

@Entity
@Table(name = "InvoiceItem")
public class InvoiceItem {
    @EmbeddedId
    InvoiceItemKey id;

    @ManyToOne
    @MapsId("invoiceId")
    @JoinColumn(name = "invoiceId")
    Invoice invoice;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    Product product;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;


    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public InvoiceItemKey getId() {
        return id;
    }

    public void setId(InvoiceItemKey id) {
        this.id = id;
    }
}
