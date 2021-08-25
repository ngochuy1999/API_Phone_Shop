package com.ngochuy.apiphoneshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.management.Descriptor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", unique = true, nullable = false)
    private Integer productId;

    @Column(name = "title",nullable = false,length = 200)
    private String title;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="categoryId",nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="provideId",nullable = false)
    private Provider provider;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="imageId",nullable = false)
    private ImageDetail imageDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="descriptionId",nullable = false)
    private Description description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="detailId",nullable = false)
    private Detail detail;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "addDate",nullable = false)
    private Date addDate;

    @Column(name = "sale", nullable = false)
    private Integer sale;

    @Column(name = "active")
    private Integer active;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "product")
    List<InvoiceItem> invoiceItem;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public ImageDetail getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(ImageDetail imageDetail) {
        this.imageDetail = imageDetail;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public List<InvoiceItem> getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(List<InvoiceItem> invoiceItem) {
        this.invoiceItem = invoiceItem;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
