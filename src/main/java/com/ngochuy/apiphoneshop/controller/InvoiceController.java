package com.ngochuy.apiphoneshop.controller;

import com.ngochuy.apiphoneshop.entities.Invoice;
import com.ngochuy.apiphoneshop.entities.InvoiceItem;
import com.ngochuy.apiphoneshop.payload.BadResponse;
import com.ngochuy.apiphoneshop.payload.InvoiceRequest;
import com.ngochuy.apiphoneshop.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    //order
    @PostMapping(value = "/invoices",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> addInvoiceDetail(@RequestBody InvoiceRequest invoiceRequest){
        boolean result = invoiceService.addInvoiceDetail(invoiceRequest);
        if(result){
            invoiceService.updateProduct(invoiceRequest);
            return ResponseEntity.ok(new BadResponse(1));
        }else{
        return ResponseEntity.ok(new BadResponse(0));
        }
    }

    //all invoice
    @GetMapping(value = "/invoices",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getAllInvoices(@RequestHeader(value = "userId") int userId){
        List<Invoice> list = invoiceService.getAllInvoices(userId);
        return list;
    }

    //list invoice by status
    @GetMapping(value = "/confirm",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListConfirm(@RequestHeader(value = "userId") int userId){
        List<Invoice> list = invoiceService.getListConfirm(userId);
        return list;
    }

    @GetMapping(value = "/delivery",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListDeliver(@RequestHeader(value = "userId") int userId){
        List<Invoice> list = invoiceService.getListDeliver(userId);
        return list;
    }

    @GetMapping(value = "/payment",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListPayment(@RequestHeader(value = "userId") int userId){
        List<Invoice> list = invoiceService.getListPayment(userId);
        return list;
    }

    @GetMapping(value = "/accomplish",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListAccomplish(@RequestHeader(value = "userId") int userId){
        List<Invoice> list = invoiceService.getListAccomplish(userId);
        return list;
    }

    @GetMapping(value = "/cancel",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListCancel(@RequestHeader(value = "userId") int userId){
        List<Invoice> list = invoiceService.getListCancel(userId);
        return list;
    }

    //detail invoice
    @GetMapping(value = "/invoiceDetail",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<InvoiceItem> getDetailInvoice(@RequestHeader(value = "invoiceId") int invoiceId){
        List<InvoiceItem> list = invoiceService.getDetailInvoice(invoiceId);
        return list;
    }
}
