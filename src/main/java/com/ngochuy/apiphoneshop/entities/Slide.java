package com.ngochuy.apiphoneshop.entities;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Table(name = "Slide")
public class Slide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private int id;

    @Column(name = "image",nullable = false)
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
