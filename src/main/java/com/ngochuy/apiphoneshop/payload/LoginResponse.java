package com.ngochuy.apiphoneshop.payload;

public class LoginResponse {
    String email;
    String password;
    int id;

    public LoginResponse(String email, String password,int id) {
        this.email = email;
        this.password = password;
        this.id =id;
    }

    public LoginResponse() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
