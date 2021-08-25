package com.ngochuy.apiphoneshop.entities;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId",unique = true,nullable = false)
    private int addressId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "district",nullable = false)
    private String district;

    @Column(name = "province",nullable = false)
    private String provice;

    @Column(name = "street",nullable = false)
    private String street;

    @Column(name = "ward",nullable = false)
    private String ward;

    @Column(name = "isDefault",nullable = false)
    private Integer isDefault;

    @Column(name = "active")
    private Integer active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="userId",nullable = false)
    private Customer customer;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
