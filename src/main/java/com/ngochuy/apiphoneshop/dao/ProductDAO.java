package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Product getProduct(int productId){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class,productId);
        System.out.println(product);
        return product;
    }
    public Product addProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        return product;
    }
    public Product updateProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        Product productUpdate= (Product) session.get(Product.class,product.getProductId());
        productUpdate.setQuantity(product.getQuantity());
        session.update(productUpdate);
        return product;
    }
    public void deleteProduct(int productId){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class,productId);
        session.delete(product);
    }
    public List<Product> getAllProducts(){
        Session session = sessionFactory.getCurrentSession();
        List<Product> listProducts =(List<Product>) session.createQuery("from "+Product.class.getName()+" p order by p.price desc ").list();
        System.out.println(listProducts);
        return listProducts;
    }
}
