package com.ngochuy.apiphoneshop.service;

import com.ngochuy.apiphoneshop.dao.*;
import com.ngochuy.apiphoneshop.entities.*;
import com.ngochuy.apiphoneshop.payload.InvoiceRequest;
import com.ngochuy.apiphoneshop.payload.ProductInCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class InvoiceService {
    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private InvoiceDetailDAO invoiceDetailDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private InvoiceStatusDAO invoiceStatusDAO;

    @Autowired
    private EmployeeDAO employeeDAO;


    public List<Invoice> getAllInvoices(int userId){
        return invoiceDAO.getAllInvoices(userId);
    }

    //List invoice by invoice status
    public List<Invoice> getListAccomplish(int userId){
        return invoiceDAO.getListAccomplish(userId);
    }

    public List<Invoice> getListConfirm(int userId){
        return invoiceDAO.getListConfirm(userId);
    }

    public List<Invoice> getListDeliver(int userId){
        return invoiceDAO.getListDeliver(userId);
    }

    public List<Invoice> getListPayment(int userId){
        return invoiceDAO.getListPayment(userId);
    }

    public List<Invoice> getListCancel(int userId){
        return invoiceDAO.getListCancel(userId);
    }

    //detail invoice
    public List<InvoiceItem> getDetailInvoice(int invoiceId){
        return  invoiceDAO.getDetailInvoice(invoiceId);
    }

    //cancel invoice
    public Boolean cancelInvoice(int invoiceId){
        return invoiceDAO.cancelInvoice(invoiceId);
    }

    //order
    public Invoice addInvoice(int userId,String name, String phone, String address, Long totalPrice){
        Customer customer = accountDAO.getUser(userId);
        Invoice invoice = new Invoice();

        invoice.setCustomer(customer);
        invoice.setName(name);
        invoice.setPhone(phone);
        invoice.setAddress(address);

        Date date = Date.valueOf(LocalDate.now());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,4);

        java.util.Date dateformat = calendar.getTime();
        String result = String.valueOf(dateformat);
        if(result.startsWith("Sun")){
            calendar.add(Calendar.DATE,1);
        }
        dateformat = calendar.getTime();
        Date deliveryDate = new Date(dateformat.getTime());

        invoice.setBuyDate(date);
        invoice.setDeliveryDate(deliveryDate);
        invoice.setTotalPrice(totalPrice);
        invoice.setEmployee(employeeDAO.getEmployee(1));
        invoice.setInvoiceStatus(invoiceStatusDAO.getStatus(1));
        invoice.setActive(1);

        invoiceDAO.addInvoice(invoice);
        return invoice;
    }
    public void updateProduct(InvoiceRequest invoiceRequest){
        for(ProductInCart productInCart: invoiceRequest.getListProInCart()) {
            Product product = productDAO.getProduct(productInCart.getProductId());
            product.setQuantity(product.getQuantity()-productInCart.getQuantityCart());
            productDAO.updateProduct(product);
        }
    }

    public void reloadQuantityProduct(int invoiceId){
        List<InvoiceItem> invoiceItemList = getDetailInvoice(invoiceId);
        for(InvoiceItem productInCart: invoiceItemList) {
            Product product = productDAO.getProduct(productInCart.getProduct().getProductId());
            product.setQuantity(product.getQuantity()+productInCart.getQuantity());
            productDAO.updateProduct(product);
        }
    }
    public Boolean addInvoiceDetail (InvoiceRequest invoiceRequest) {
        try {
            Invoice invoice = addInvoice(invoiceRequest.getUserId(),invoiceRequest.getName(),invoiceRequest.getPhone(),invoiceRequest.getAddress(),invoiceRequest.getTotalPrice());
            for (ProductInCart productInCart : invoiceRequest.getListProInCart()) {
                InvoiceItem invoiceItem = new InvoiceItem();
                Product product = productDAO.getProduct(productInCart.getProductId());
                InvoiceItemKey ik = new InvoiceItemKey();
                ik.setInvoiceId(invoice.getInvoiceId());
                ik.setProductId(product.getProductId());
                invoiceItem.setId(ik);
                invoiceItem.setInvoice(invoice);
                invoiceItem.setProduct(product);
                invoiceItem.setQuantity(productInCart.getQuantityCart());
                invoiceDetailDAO.addInvoiceItem(invoiceItem);
            }
            return true;
        }catch (Exception e) {
            System.out.println("Loi" + e);
        }
        return false;
    }

}
