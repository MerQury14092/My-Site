package com.merqury.mysite.controllers.rest;

import com.merqury.mysite.controllers.ProductController;
import com.merqury.mysite.models.products.Product;
import com.merqury.mysite.models.api.Responce;
import com.merqury.mysite.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/prod")
public class RestProductController {
    private ProductService service;

    @GetMapping("/")
    public List<Product> productList(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return service.getProductById(id);
    }

    @PostMapping("/")
    public Responce addProduct(@RequestBody Product prod){
        if(prod.getTitle() == null)
            return new Responce(400, "Bad Request: title must not be null");
        if(prod.getCity() == null)
            return new Responce(400, "Bad Request: city must not be null");
        if(prod.getPrice() < 0)
            return new Responce(400, "Bad Request: price must be positive");
        if(prod.getAuthor() == null)
            return new Responce(400, "Bad Request: author must not be null");
        service.addProduct(prod);
        return new Responce(200, "OK");
    }

    @PutMapping("/{idStr}")
    public Responce changeProduct(@RequestBody Product product, @PathVariable String idStr){
        long id = ProductController.parseId(idStr);
        if(id == 0)
            return new Responce(403, "Forbidden");
        Product real = service.getProductById(id);
        if(real == null)
            return new Responce(404, "Not Found");
        service.changeProduct(id, product);
        return new Responce(200, "OK");
    }

    @DeleteMapping("/{id}")
    public Responce rmProduct(@PathVariable long id){
        if(id == 0)
            return new Responce(403, "Forbidden");
        Product product = service.getProductById(id);
        if(product == null)
            return new Responce(404, "Not found");
        service.rmProduct(id);
        return new Responce(200, "OK");
    }
}
