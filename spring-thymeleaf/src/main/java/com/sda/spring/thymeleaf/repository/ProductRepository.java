package com.sda.spring.thymeleaf.repository;

import com.sda.spring.thymeleaf.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// var 1: hibernate implementation: session
// var 2: jpa implementation: entity manager
// var 3: spring data implementation: extend Repository
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // derived query
    List<Product> findAll();

}
