package com.ngochuy.apiphoneshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Detail")
public class Detail {
    @Id
    @Column(name = "productId", unique = true, nullable = false)
    private Integer detailId;
    @Column(name = "display", nullable = false,length = 50)
    private String display;
    @Column(name = "pixel", nullable = false,length = 50)
    private String pixel;
    @Column(name = "Inch", nullable = false,length = 50)
    private String Inch;
    @Column(name = "cpu", nullable = false,length = 50)
    private String cpu;
    @Column(name = "OS", nullable = false,length = 50)
    private String os;
    @Column(name = "RAM", nullable = false,length = 50)
    private String RAM;
    @Column(name = "ROM", nullable = false,length = 50)
    private String ROM;
    @Column(name = "battery", nullable = false,length = 50)
    private String battery;

    @OneToOne
    @MapsId
    @JoinColumn(name = "productId")
    private Product product;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getPixel() {
        return pixel;
    }

    public void setPixel(String pixel) {
        this.pixel = pixel;
    }

    public String getInch() {
        return Inch;
    }

    public void setInch(String inch) {
        Inch = inch;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getROM() {
        return ROM;
    }

    public void setROM(String ROM) {
        this.ROM = ROM;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }


}
