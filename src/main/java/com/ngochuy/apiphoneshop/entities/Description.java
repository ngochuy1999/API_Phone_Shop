package com.ngochuy.apiphoneshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Description")
public class Description {
    @Id
    @Column(name = "productId", unique = true, nullable = false)
    private Integer descriptionId;
    @Column(name = "des1", nullable = false,length = 200)
    private String des1;
    @Column(name = "imageUrl", nullable = false,length = 50)
    private String image;
    @Column(name = "des2", nullable = false,length = 200)
    private String des2;

    @OneToOne
    @MapsId
    @JoinColumn(name = "productId")
    private Product product;

    public Integer getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getDes1() {
        return des1;
    }

    public void setDes1(String des1) {
        this.des1 = des1;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDes2() {
        return des2;
    }

    public void setDes2(String des2) {
        this.des2 = des2;
    }

}
