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


    @GetMapping(value = "/invoices",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Invoice> getAllInvoices(){
        List<Invoice> list = invoiceService.getAllInvoices();
        return list;
    }

    @GetMapping(value = "/invoiceDetail",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<InvoiceItem> getDetailInvoice(@RequestParam(value = "invoiceId") int invoiceId){
        List<InvoiceItem> list = invoiceService.getDetailInvoice(invoiceId);
        return list;
    }
}
