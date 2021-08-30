package com.ngochuy.apiphoneshop.payload;

public class LoginResponse {
    String email;
    String password;
    int id;
    int roleId;
    int active;

    public LoginResponse(String email, String password,int id, int roleId, int active) {
        this.email = email;
        this.password = password;
        this.id =id;
        this.roleId = roleId;
        this.active =active;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
