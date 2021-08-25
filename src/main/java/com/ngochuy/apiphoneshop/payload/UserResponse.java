package com.ngochuy.apiphoneshop.payload;

import com.ngochuy.apiphoneshop.entities.Account;
import com.ngochuy.apiphoneshop.entities.Customer;


public class UserResponse {
    private Account account;
    private Customer customer;

    public UserResponse(Account account, Customer customer) {
        this.account = account;
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
