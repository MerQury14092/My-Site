package com.merqury.mysite.repositories;

import com.merqury.mysite.models.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByAuthor(String author);
}
