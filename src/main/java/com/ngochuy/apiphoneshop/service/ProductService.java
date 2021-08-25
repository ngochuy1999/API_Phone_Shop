package com.ngochuy.apiphoneshop.service;

import com.ngochuy.apiphoneshop.dao.ProductDAO;
import com.ngochuy.apiphoneshop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductDAO productDAO;
    public Product getProduct(int productId){
        return productDAO.getProduct(productId);
    }
    public Product addProduct(Product product){
        return productDAO.addProduct(product);
    }
//    public Product updateProduct(Role role){
//        return roleDAO.updateRole(role);
//    }
    public void deleteProduct(int productID){
        productDAO.deleteProduct(productID);
    }
    public List<Product> getAllProducts(){
        return productDAO.getAllProducts();
    }
}