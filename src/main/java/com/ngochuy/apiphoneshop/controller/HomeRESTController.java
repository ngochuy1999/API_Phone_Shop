package com.ngochuy.apiphoneshop.controller;

import com.ngochuy.apiphoneshop.entities.Product;
import com.ngochuy.apiphoneshop.entities.Provider;
import com.ngochuy.apiphoneshop.entities.Slide;
import com.ngochuy.apiphoneshop.service.ProductService;
import com.ngochuy.apiphoneshop.service.ProviderService;
import com.ngochuy.apiphoneshop.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class HomeRESTController {
    @Autowired
    private SlideService slideService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProviderService providerService;

    @GetMapping(value = "/slides",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Slide> getAllSlides(){
        List<Slide> list = slideService.getAllSlides();
        return list;
    }

    @GetMapping(value = "/products",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Product> getAllProducts(){
        List<Product> list = productService.getAllProducts();
        return list;
    }
    @GetMapping(value = "/products/{productId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Product getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }

    @PostMapping(value = "/products",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Product addProduct(@RequestBody Product product){
        System.out.println("(Service Side) Creating acc with accId: "+ product.getProductId());
        return productService.addProduct(product);
    }

//    @RequestMapping(value = "/roles",method = RequestMethod.PUT,
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public Role updateRole(@RequestBody Role role){
//        System.out.println("(Service Side) Editing employee with roleId: "+ role.getRoleId());
//        return roleService.updateRole(role);
//    }

    @DeleteMapping(value = "/products/{productId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String deleteproduct(@PathVariable("productId") int productId){
        System.out.println("(Service Side) Deleting acc with id: "+ productId);
        productService.deleteProduct(productId);
        return "delete successful";
    }

    @GetMapping(value = "/brands",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Provider> getAllProviders(){
        List<Provider> list = providerService.getAllProviders();
        return list;
    }

    @GetMapping(value = "/getByBrand")
    @ResponseBody
    public List<Product> getByBrand(@RequestParam(value = "filter") String filter) {
        List<Product> list = providerService.getProductByBrand(filter);
        return list;
    }
}
