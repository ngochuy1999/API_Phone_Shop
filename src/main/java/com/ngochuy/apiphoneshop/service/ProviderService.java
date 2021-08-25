package com.ngochuy.apiphoneshop.service;

import com.ngochuy.apiphoneshop.dao.ProviderDAO;
import com.ngochuy.apiphoneshop.entities.Product;
import com.ngochuy.apiphoneshop.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProviderService {
    @Autowired
    ProviderDAO providerDAO;

    public List<Provider> getAllProviders(){
        return providerDAO.getAllProviders();
    }
    public List<Product> getProductByBrand(String filter){
        return providerDAO.getProductByBrand(filter);
    }
}
