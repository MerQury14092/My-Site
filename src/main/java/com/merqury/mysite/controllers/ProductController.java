package com.merqury.mysite.controllers;

import com.merqury.mysite.models.Product;
import com.merqury.mysite.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public String products(Model model){
        model.addAttribute("products", productService.getProducts());
        return "products_new";
    }

    @GetMapping("/prod/{id}")
    public String getProductInfo(Model model, @PathVariable int id){
        Product res = productService.getProductById(id);
        if(res == null) {
            return "redirect:/error";
        }
        model.addAttribute("product", res);
        return "prod";
    }

    @PostMapping("/prod/create")
    public String addProduct(Product product){

        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/prod/create/page")
    public String createPage(Product product){
        return "createPage";
    }


    @PostMapping("/prod/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        if(id != 0)
            productService.rmProduct(id);
        return "redirect:/";
    }

    @GetMapping("/prod/buy/{id}")
    public String buy(@PathVariable long id){

        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }
}
