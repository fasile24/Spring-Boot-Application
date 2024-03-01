package com.javatechie.springbootcrudexample.controller;

import com.javatechie.springbootcrudexample.entity.Product;
import com.javatechie.springbootcrudexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;


    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product>products){

        return service.saveProducts(products);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){

        return service.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){

        return service.getProducts();
    }


    @GetMapping("/productsByID/{id}")
    public Product findProductByID(@PathVariable int id){

        return service.getProductById(id);
    }

    @GetMapping("/productsByName/{name}")
    public Product findProductByName(@PathVariable String name){

        return service.getProductByName(name);
    }


    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){

        return service.update(product);
    }

   @DeleteMapping("/delete/{id}")
    public String deleteProductByID(@PathVariable int id){

        return service.deleteProductById(id);
    }



}

