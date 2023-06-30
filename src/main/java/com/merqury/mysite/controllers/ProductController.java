package com.merqury.mysite.controllers;

import com.merqury.mysite.models.Product;
import com.merqury.mysite.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

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
    @PreAuthorize("hasAuthority('post:read')")
    public String getProductInfo(Model model, @PathVariable String id){
        Product res = productService.getProductById(parseId(id));
        if(res == null) {
            return "redirect:/error";
        }
        model.addAttribute("product", res);
        return "prod";
    }

    @PostMapping("/prod/create")
    @PreAuthorize("hasAuthority('post:add')")
    public String addProduct(Product product){
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/prod/create/page")
    @PreAuthorize("hasAuthority('post:add')")
    public String createPage(Product product){
        return "createPage";
    }


    @PostMapping("/prod/delete/{idStr}")
    @PreAuthorize("hasAuthority('post:rm')")
    public String deleteProduct(@PathVariable String idStr){
        long id = parseId(idStr);
        if(id != 0)
            productService.rmProduct(id);
        return "redirect:/";
    }

    @GetMapping("/prod/buy/{idStr}")
    public String buy(@PathVariable String idStr){
        long id = parseId(idStr);
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }

    public static long parseId(String id){
        id = id.replace("%C2%A0","");
        StringBuilder number = new StringBuilder();
        for(char a : id.toCharArray()){
            if(Character.isDigit(a))
                number.append(a);
        }
        return Long.parseLong(number.toString());
    }
}
