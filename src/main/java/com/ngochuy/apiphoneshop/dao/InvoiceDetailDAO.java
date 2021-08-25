package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.InvoiceItem;
import com.ngochuy.apiphoneshop.entities.InvoiceItemKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDetailDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem){
        Session session = sessionFactory.getCurrentSession();
        session.save(invoiceItem);
        return invoiceItem;
    }
}
