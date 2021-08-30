package com.ngochuy.apiphoneshop.service;

import com.ngochuy.apiphoneshop.dao.AccountDAO;
import com.ngochuy.apiphoneshop.dao.AddressDAO;
import com.ngochuy.apiphoneshop.entities.Address;
import com.ngochuy.apiphoneshop.entities.Customer;
import com.ngochuy.apiphoneshop.payload.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private AccountDAO accountDAO;

    public List<Address> getAllAddresses(int userId){
        return addressDAO.getAddress(userId);
    }
    public Address getAddressDefault(int userId){
        return addressDAO.getAddressDefault(userId);
    }

    public Address addAddress(AddressRequest addressRequest){
        Customer customer = accountDAO.getUser(addressRequest.getUserId());
        Address address = new Address();

        address.setCustomer(customer);
        address.setActive(addressRequest.getActive());
        address.setName(addressRequest.getName());
        address.setPhone(addressRequest.getPhone());
        address.setProvice(addressRequest.getProvice());
        address.setDistrict(addressRequest.getDistrict());
        address.setWard(addressRequest.getWard());
        address.setStreet(addressRequest.getStreet());
        address.setIsDefault(addressRequest.getIsDefault());

        addressDAO.addAddress(address);
        return address;
    }
}
