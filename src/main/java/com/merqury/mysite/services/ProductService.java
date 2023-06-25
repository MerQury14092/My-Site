package com.merqury.mysite.services;

import java.util.ArrayList;
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

    public List<List<Product>> getProductsInTriangles(){
        List<Product> all = repository.findAll();
        List<List<Product>> res = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            List<Product> tmp = new ArrayList<>();
            switch (i % 3){
                case 0 -> {
                    tmp = new ArrayList<>(3);
                    res.add(tmp);
                    tmp.add(all.get(i));
                }
                case 1, 2 ->
                    tmp.add(all.get(i));
            }
        }
        return res;
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
