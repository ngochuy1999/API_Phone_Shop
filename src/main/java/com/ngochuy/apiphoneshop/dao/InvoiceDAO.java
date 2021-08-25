package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.Invoice;
import com.ngochuy.apiphoneshop.entities.InvoiceItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Invoice addInvoice(Invoice invoice){
        Session session = sessionFactory.getCurrentSession();
        session.save(invoice);
        return invoice;
    }

    public List<Invoice> getAllInvoices(){
        Session session = sessionFactory.getCurrentSession();
        List<Invoice> listInvoices =(List<Invoice>) session.createQuery("from "+Invoice.class.getName()).list();
        System.out.println(listInvoices);
        return listInvoices;
    }

    public List<Invoice> getList(){
        Session session = sessionFactory.getCurrentSession();
        List<Invoice> listInvoices =(List<Invoice>) session.createQuery("from "+Invoice.class.getName()).list();
        System.out.println(listInvoices);
        return listInvoices;
    }

    public  List<InvoiceItem> getDetailInvoice(int invoiceId){
        Session session = sessionFactory.getCurrentSession();
        List<InvoiceItem> invoiceItemList = (List<InvoiceItem>) session.createQuery("FROM InvoiceItem i WHERE i.id.invoiceId = "+invoiceId).list();
        return invoiceItemList;
    }
}
