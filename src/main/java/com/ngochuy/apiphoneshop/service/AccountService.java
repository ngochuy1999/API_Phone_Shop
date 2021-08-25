package com.ngochuy.apiphoneshop.service;

import com.ngochuy.apiphoneshop.dao.AccountDAO;
import com.ngochuy.apiphoneshop.entities.Account;
import com.ngochuy.apiphoneshop.entities.Customer;
import com.ngochuy.apiphoneshop.payload.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public Customer getUser(int accId){
        return accountDAO.getUser(accId);
    }

    public List<Account> getAllAccounts(){
        return accountDAO.getAllAccounts();
    }

    public Integer loginUser(String email, String password) {
        LoginResponse userExists = accountDAO.findByEmail(email);
        System.out.println(userExists.getPassword());

        if (userExists == null||!password.equals(userExists.getPassword())) {
            // throw new BadRequestException("Invalid user name.");
            return 0;
        } else {
            return userExists.getId();
        }
    }
    public boolean signup(String email, String name, String password, String phone, String address){
        boolean result = accountDAO.createUser(email,name,password,phone,address);
        return result;
    }

    public boolean changeInfo(int id,String name, String phone, String address){
        boolean result = accountDAO.updateUser(id,name,phone,address);
        return result;
    }

    public boolean changePassword(int id,String oldPassword, String newPassword){
        boolean result = accountDAO.changePassword(id,oldPassword,newPassword);
        return result;
    }
}

