package com.ngochuy.apiphoneshop.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class InvoiceItemKey implements Serializable {

    @Column(name = "invoiceId")
    int invoiceId;

    @Column(name = "productId")
    int productId;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}
