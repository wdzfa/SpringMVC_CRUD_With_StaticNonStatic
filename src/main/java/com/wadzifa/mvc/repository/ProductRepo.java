package com.wadzifa.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wadzifa.mvc.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{
    
    List<Product> findByNameContains(String keyword);
}
