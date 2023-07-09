package com.merqury.mysite.controller;

import com.merqury.mysite.models.auth.User;
import com.merqury.mysite.models.products.Product;
import com.merqury.mysite.models.api.Response;
import com.merqury.mysite.services.ProductService;
import com.merqury.mysite.services.UserService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/prod")
public class RestProductController {
    private ProductService service;
    private UserService userService;

    @GetMapping
    public List<Product> productList(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return service.getProductById(id);
    }

    @PostMapping
    public Response addProduct(@RequestBody Product prod, @PathParam("") String token){
        User user = userService.getByToken(token);
        if(user == null)
            return Response.UNAUTHORIZED;
        if(prod.getTitle() == null)
            return new Response(400, "Bad Request: title must not be null");
        if(prod.getCity() == null)
            return new Response(400, "Bad Request: city must not be null");
        if(prod.getPrice() < 0)
            return new Response(400, "Bad Request: price must be positive");
        prod.setAuthor(user.getUsername());
        service.addProduct(prod);
        return new Response(200, "OK");
    }

    @PutMapping("/{id}")
    public Response changeProduct(@RequestBody Product product, @PathVariable long id, @PathParam("") String token){
        User user = userService.getByToken(token);
        if(user == null)
            return Response.UNAUTHORIZED;
        if(id == 0)
            return Response.FORBIDDEN;
        Product real = service.getProductById(id);
        if(real == null)
            return Response.NOT_FOUND;
        if(!user.getUsername().equals(real.getAuthor()))
            return Response.FORBIDDEN;
        service.changeProduct(id, product);
        return Response.OK;
    }

    @DeleteMapping("/{id}")
    public Response rmProduct(@PathVariable long id, @PathParam("") String token){
        User user = userService.getByToken(token);
        if(user == null)
            return Response.UNAUTHORIZED;
        if(id == 0)
            return Response.FORBIDDEN;
        Product product = service.getProductById(id);
        if(product == null)
            return Response.NOT_FOUND;
        if(!user.getUsername().equals(product.getAuthor()))
            return Response.FORBIDDEN;
        service.rmProduct(id);
        return Response.OK;
    }
}
