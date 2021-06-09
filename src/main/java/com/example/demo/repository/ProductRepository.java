package com.example.demo.repository;

import com.example.demo.domain.Product;

public interface ProductRepository {

    Iterable<Product> findAll();
    Product findOne(String id);
    Product save(Product product);


}
