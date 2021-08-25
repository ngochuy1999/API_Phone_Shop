package com.ngochuy.apiphoneshop.controller;

import com.ngochuy.apiphoneshop.entities.Customer;
import com.ngochuy.apiphoneshop.payload.ApiResponseUser;
import com.ngochuy.apiphoneshop.payload.BadResponse;
import com.ngochuy.apiphoneshop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class AuthRESTController {
    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/login",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticateUser(@RequestParam (value = "email") String email,
                                              @RequestParam(value = "password")String password){

        int id = accountService.loginUser(email, password);
        if(id == 0)  return ResponseEntity.ok(new BadResponse(0));
        else
        return ResponseEntity.ok(new ApiResponseUser(1,id));
    }


    @GetMapping(value = "/users",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Customer getUser(@RequestHeader(value = "id") int accId){
        return accountService.getUser(accId);
    }

    @PostMapping(value = "/signup",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> signup(@RequestParam (value = "email") String email,
                                    @RequestParam(value = "name")String name,
                                    @RequestParam(value = "password")String password,
                                    @RequestParam(value = "phone")String phone,
                                    @RequestParam(value = "address")String address){

        boolean result = accountService.signup(email,name,password,phone,address);
        if(result!=true)  return ResponseEntity.ok(new BadResponse(0));
        else
            return ResponseEntity.ok(new BadResponse(1));
    }

    @PutMapping(value = "/users",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> changeInfo(@RequestParam (value = "id") int id,
                                    @RequestParam(value = "name")String name,
                                    @RequestParam(value = "phone")String phone,
                                    @RequestParam(value = "address")String address){

        boolean result = accountService.changeInfo(id,name,phone,address);
        if(result!=true)  return ResponseEntity.ok(new BadResponse(0));
        else
            return ResponseEntity.ok(new BadResponse(1));
    }

    @PutMapping(value = "/password",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> changePass(@RequestParam (value = "id") int id,
                                        @RequestParam(value = "oldPassword")String oldPassword,
                                        @RequestParam(value = "newPassword")String newPassword){

        boolean result = accountService.changePassword(id,oldPassword,newPassword);
        if(result!=true)  return ResponseEntity.ok(new BadResponse(0));
        else
            return ResponseEntity.ok(new BadResponse(1));
    }



}
