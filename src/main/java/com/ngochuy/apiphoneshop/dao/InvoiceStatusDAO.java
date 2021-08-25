package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.InvoiceStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceStatusDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public InvoiceStatus getStatus(int statusId){
        Session session = sessionFactory.getCurrentSession();
        InvoiceStatus status = (InvoiceStatus) session.get(InvoiceStatus.class,statusId);
        return status;
    }
}
