package com.ngochuy.apiphoneshop.entities;


import javax.persistence.*;


@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId",unique = true,nullable = false)
    private int accountId;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "username",nullable = false)
    private String userName;

    @Column(name = "isAccuracy")
    private Integer isAccuracy;

    @Column(name = "active")
    private Integer active;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Employee employee;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="roleId",nullable = false)
    private Role role;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIsAccuracy() {
        return isAccuracy;
    }

    public void setIsAccuracy(Integer isAccuracy) {
        this.isAccuracy = isAccuracy;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}