package com.ngochuy.apiphoneshop.payload;

public class BadResponse {
    private int isStatus;

    public BadResponse(int isStatus) {
        this.isStatus = isStatus;
    }

    public int getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(int isStatus) {
        this.isStatus = isStatus;
    }
}
