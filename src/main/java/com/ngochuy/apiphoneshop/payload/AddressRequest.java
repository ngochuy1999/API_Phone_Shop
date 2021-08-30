package com.ngochuy.apiphoneshop.payload;

public class AddressRequest {
    int userId;
    int active;
    String district;
    int isDefault;
    String name;
    String phone;
    String provice;
    String street;
    String ward;

    public AddressRequest() {
    }

    public AddressRequest(int userId, int active, String district, int isDefault, String name, String phone, String provice, String street, String ward) {
        this.userId = userId;
        this.active = active;
        this.district = district;
        this.isDefault = isDefault;
        this.name = name;
        this.phone = phone;
        this.provice = provice;
        this.street = street;
        this.ward = ward;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
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
}
