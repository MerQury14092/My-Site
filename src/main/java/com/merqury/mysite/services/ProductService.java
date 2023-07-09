package com.merqury.mysite.services;

import java.util.ArrayList;
import java.util.List;

import com.merqury.mysite.models.products.Product;
import com.merqury.mysite.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private long ID;

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
        if(product.getDescription() == null || product.getDescription().equals(""))
            product.setDescription("No description");
        if(product.getUrlToImage() == null || product.getUrlToImage().equals(""))
            product.setUrlToImage("https://t4.ftcdn.net/jpg/04/99/93/31/360_F_499933117_ZAUBfv3P1HEOsZDrnkbNCt4jc3AodArl.jpg");
        repository.save(product);
    }

    public Product getProductById(long id){
        return repository.findById(id).orElse(null);
    }

    public void rmProduct(long id){
        if(id == 0)
            return;
        repository.deleteById(id);
    }

    public void changeProduct(long id, Product newProduct){
        Product base = repository.findById(id).orElse(null);
        Product.concatenate(base, newProduct);
        repository.flush();
    }

}
