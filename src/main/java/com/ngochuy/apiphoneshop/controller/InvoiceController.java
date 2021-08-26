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
    public List<Invoice> getAllInvoices(@RequestParam(value = "userId") int userId){
        return invoiceService.getAllInvoices(userId);
    }

    //list invoice by status
    @GetMapping(value = "/confirm",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListConfirm(@RequestParam(value = "userId") int userId){
        return invoiceService.getListConfirm(userId);
    }

    @GetMapping(value = "/delivery",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListDeliver(@RequestParam(value = "userId") int userId){
        return invoiceService.getListDeliver(userId);
    }

    @GetMapping(value = "/payment",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListPayment(@RequestParam(value = "userId") int userId){
        return invoiceService.getListPayment(userId);
    }

    @GetMapping(value = "/accomplish",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListAccomplish(@RequestParam(value = "userId") int userId){
        return invoiceService.getListAccomplish(userId);
    }

    @GetMapping(value = "/cancel",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getListCancel(@RequestParam(value = "userId") int userId){
        return invoiceService.getListCancel(userId);
    }

    //detail invoice
    @GetMapping(value = "/invoiceDetail",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<InvoiceItem> getDetailInvoice(@RequestParam(value = "invoiceId") int invoiceId){
        return invoiceService.getDetailInvoice(invoiceId);
    }

    //cancel invoice
    @PostMapping(value = "/cancelInvoice",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> cancelInvoice(@RequestParam(value = "invoiceId") int invoiceId){
        boolean result = invoiceService.cancelInvoice(invoiceId);
        if(result){
            return ResponseEntity.ok(new BadResponse(1));
        }else{
            return ResponseEntity.ok(new BadResponse(0));
        }
    }
}
