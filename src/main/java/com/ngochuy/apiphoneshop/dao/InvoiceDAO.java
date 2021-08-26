package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.Invoice;
import com.ngochuy.apiphoneshop.entities.InvoiceItem;
import com.ngochuy.apiphoneshop.entities.InvoiceStatus;
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

    // cancel invoice
    public Boolean cancelInvoice(int invoiceId){
        Session session = sessionFactory.getCurrentSession();
        Invoice invoiceUpdate = (Invoice) session.get(Invoice.class, invoiceId);
        if(invoiceUpdate.getInvoiceStatus().getStatusId()==1) {
            InvoiceStatus invoiceStatus = (InvoiceStatus) session.createQuery("FROM InvoiceStatus as i WHERE i.statusId = 5").uniqueResult();
            invoiceUpdate.setInvoiceStatus(invoiceStatus);
            session.update(invoiceUpdate);
            return true;
        }else{
            return false;
        }
    }

    public List<Invoice> getAllInvoices(int userId){
        Session session = sessionFactory.getCurrentSession();
        List<Invoice> listInvoices =(List<Invoice>) session.createQuery("from "+Invoice.class.getName()+ " i where i.customer.userId = "+userId+" order by i.invoiceId desc").list();
        System.out.println(listInvoices);
        return listInvoices;
    }

    //list accomplished
    public List<Invoice> getListAccomplish(int userId){
        Session session = sessionFactory.getCurrentSession();
        List<Invoice> listInvoices =(List<Invoice>) session.createQuery("from "+Invoice.class.getName()+ " i where i.invoiceStatus.statusId = 4 and i.customer.userId = "+userId+" order by i.invoiceId desc").list();
        System.out.println(listInvoices);
        return listInvoices;
    }

    //Awaiting confirmation
    public List<Invoice> getListConfirm(int userId){
        Session session = sessionFactory.getCurrentSession();
        List<Invoice> listInvoices =(List<Invoice>) session.createQuery("from "+Invoice.class.getName()+ " i where i.invoiceStatus.statusId = 1 and i.customer.userId = "+userId+" order by i.invoiceId desc").list();
        System.out.println(listInvoices);
        return listInvoices;
    }

    //list waiting for payment
    public List<Invoice> getListPayment(int userId){
        Session session = sessionFactory.getCurrentSession();
        List<Invoice> listInvoices =(List<Invoice>) session.createQuery("from "+Invoice.class.getName()+ " i where i.invoiceStatus.statusId = 3 and i.customer.userId = "+userId+" order by i.invoiceId desc").list();
        System.out.println(listInvoices);
        return listInvoices;
    }

    //list delivery
    public List<Invoice> getListDeliver(int userId){
        Session session = sessionFactory.getCurrentSession();
        List<Invoice> listInvoices =(List<Invoice>) session.createQuery("from "+Invoice.class.getName()+ " i where i.invoiceStatus.statusId = 2 and i.customer.userId = "+userId+" order by i.invoiceId desc").list();
        System.out.println(listInvoices);
        return listInvoices;
    }

    //list canceled invoice
    public List<Invoice> getListCancel(int userId){
        Session session = sessionFactory.getCurrentSession();
        List<Invoice> listInvoices =(List<Invoice>) session.createQuery("from "+Invoice.class.getName()+ " i where i.invoiceStatus.statusId = 5 and i.customer.userId = "+userId+" order by i.invoiceId desc").list();
        System.out.println(listInvoices);
        return listInvoices;
    }

    public  List<InvoiceItem> getDetailInvoice(int invoiceId){
        Session session = sessionFactory.getCurrentSession();
        List<InvoiceItem> invoiceItemList = (List<InvoiceItem>) session.createQuery("FROM InvoiceItem i WHERE i.id.invoiceId = "+invoiceId).list();
        return invoiceItemList;
    }
}
