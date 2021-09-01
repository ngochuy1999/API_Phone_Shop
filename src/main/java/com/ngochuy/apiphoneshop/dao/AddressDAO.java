package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AddressDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Address> getAddress(int userId){
        Session session = sessionFactory.getCurrentSession();
        List<Address> listAddresses =(List<Address>) session.createQuery("from "+Address.class.getName()+ " a where a.customer.userId = "+userId).list();
        return listAddresses;
    }

    public Address getAddressDefault(int userId){
        Session session = sessionFactory.getCurrentSession();
        return (Address) session.createQuery("from "+Address.class.getName()+ " a where a.customer.userId = "+ userId +" and a.isDefault = 1").uniqueResult();
    }

    public Address addAddress(Address address){
        Session session = sessionFactory.getCurrentSession();
        session.save(address);
        return address;
    }

    public Address changeDefault(Address address){
        Session session = sessionFactory.getCurrentSession();
        Address addressUpdate= (Address) session.createQuery("FROM Address as a WHERE a.addressId= '"+address.getAddressId()+"'").uniqueResult();
        addressUpdate.setIsDefault(0);
        session.update(addressUpdate);
        return addressUpdate;
    }

    public void deleteAddress(int addressId){
        Session session = sessionFactory.getCurrentSession();
        Address address = (Address) session.get(Address.class,addressId);
        session.delete(address);
    }
}
