package com.ngochuy.apiphoneshop.controller;

import com.ngochuy.apiphoneshop.entities.Address;
import com.ngochuy.apiphoneshop.entities.Customer;
import com.ngochuy.apiphoneshop.payload.AddressRequest;
import com.ngochuy.apiphoneshop.payload.ApiResponseUser;
import com.ngochuy.apiphoneshop.payload.BadResponse;
import com.ngochuy.apiphoneshop.service.AccountService;
import com.ngochuy.apiphoneshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AuthRESTController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/login",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticateUser(@RequestParam (value = "email") String email,
                                              @RequestParam(value = "password")String password){

        int id = accountService.loginUser(email, password);
        if(id == 0)  return ResponseEntity.ok(new BadResponse(0));
        else {
            if (id == -1) return ResponseEntity.ok(new BadResponse(-1));
            else return ResponseEntity.ok(new ApiResponseUser(1, id));
        }
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

        int result = accountService.signup(email,name,password,phone,address);
        if(result == 0)  return ResponseEntity.ok(new BadResponse(0));
        else if(result == -1)  return ResponseEntity.ok(new BadResponse(-1));
        else    return ResponseEntity.ok(new BadResponse(1));
    }

    @PutMapping(value = "/users",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> changeInfo(@RequestParam (value = "id") int id,
                                    @RequestParam(value = "name")String name,
                                    @RequestParam(value = "phone")String phone,
                                    @RequestParam(value = "address")String address){

        boolean result = accountService.changeInfo(id,name,phone,address);
        if(!result)  return ResponseEntity.ok(new BadResponse(0));
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
        if(!result)  return ResponseEntity.ok(new BadResponse(0));
        else
            return ResponseEntity.ok(new BadResponse(1));
    }

    @GetMapping(value = "/confirmAcc",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String confirm(@RequestParam (value = "email") String email){

        boolean result = accountService.confirm(email);
        if(!result)  return "Activation failed";
        else return "Successful activation";
    }

    @GetMapping(value = "/address",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Address> getAddress(@RequestParam (value = "userId") int userId){
        return addressService.getAllAddresses(userId);
    }

    @GetMapping(value = "/addressDefault",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Address getAddressDefault(@RequestParam (value = "userId") int userId){
        return addressService.getAddressDefault(userId);
    }

    //add invoice
    @PostMapping(value = "/address",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addAddress(@RequestBody AddressRequest addressRequest){
        Address result = addressService.addAddress(addressRequest);
        if(result != null){
            return ResponseEntity.ok(new BadResponse(1));
        }else{
            return ResponseEntity.ok(new BadResponse(0));
        }
    }
}
