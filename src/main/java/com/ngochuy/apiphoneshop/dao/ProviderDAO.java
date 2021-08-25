package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.Product;
import com.ngochuy.apiphoneshop.entities.Provider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProviderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Provider> getAllProviders(){
        Session session = sessionFactory.getCurrentSession();
        List<Provider> listProviders =(List<Provider>) session.createQuery("from "+Provider.class.getName()).list();
        System.out.println(listProviders);
        return listProviders;
    }

    public List<Product> getProductByBrand(String filter){
        Session session = sessionFactory.getCurrentSession();
        List<Product> listProducts =(List<Product>) session.createQuery("SELECT p.products FROM Provider p WHERE p.branchName = '"+filter+"'").list();
        System.out.println(listProducts);
        return listProducts;
    }
}
