package com.ngochuy.apiphoneshop.payload;

public class ApiResponseUser{
    private int isStatus;

    private int id;

    public ApiResponseUser(int isStatus, int id) {
        this.isStatus = isStatus;
        this.id = id;
    }

    public int getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(int isStatus) {
        this.isStatus = isStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
