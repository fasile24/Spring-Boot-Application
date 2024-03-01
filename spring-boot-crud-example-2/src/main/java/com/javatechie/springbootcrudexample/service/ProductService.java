package com.javatechie.springbootcrudexample.service;


import com.javatechie.springbootcrudexample.entity.Product;
import com.javatechie.springbootcrudexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    //post list of products
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //post product
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    //Get list of product
    public List<Product> getProducts(){
        return repository.findAll();
    }
   //Get product by id
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    //get product by name
    public Product getProductByName( String name){
        return repository.findByName(name);
    }

    public String deleteProductById(int id){
        repository.deleteById(id);
        return "Product deleted succesfully!!"+id;
    }


    public Product update(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }


}
