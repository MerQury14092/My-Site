package com.merqury.mysite.services;

import java.util.List;

import com.merqury.mysite.models.Product;
import com.merqury.mysite.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private int ID;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public void addProduct(Product product){
        repository.save(product);
    }

    public Product getProductById(int id){
        return repository.findById((long) id).orElse(null);
    }

    public void rmProduct(long id){
        repository.deleteById(id);
    }

}
