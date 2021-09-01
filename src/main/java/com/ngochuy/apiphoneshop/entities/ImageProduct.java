package com.ngochuy.apiphoneshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ImageProduct")
public class ImageProduct {
    @Id
    @Column(name = "productId", unique = true, nullable = false)
    private Integer imageId;

    @Column(name = "imageUrl1",nullable = false,length = 200)
    private String imageUrl1;

    @Column(name = "imageUrl2",nullable = false,length = 200)
    private String imageUrl2;

    @Column(name = "imageUrl3",nullable = false,length = 200)
    private String imageUrl3;

    @Column(name = "imageUrl4",nullable = false,length = 200)
    private String imageUrl4;

    @Column(name = "imageUrl5",nullable = false,length = 200)
    private String imageUrl5;

    @OneToOne
    @MapsId
    @JoinColumn(name = "productId")
    Product product;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getImageUrl3() {
        return imageUrl3;
    }

    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    public String getImageUrl4() {
        return imageUrl4;
    }

    public void setImageUrl4(String imageUrl4) {
        this.imageUrl4 = imageUrl4;
    }

    public String getImageUrl5() {
        return imageUrl5;
    }

    public void setImageUrl5(String imageUrl5) {
        this.imageUrl5 = imageUrl5;
    }
}
