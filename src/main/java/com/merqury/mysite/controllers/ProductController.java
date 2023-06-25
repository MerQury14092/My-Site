package com.merqury.mysite.controllers;

import com.merqury.mysite.models.Image;
import com.merqury.mysite.models.Product;
import com.merqury.mysite.models.User;
import com.merqury.mysite.services.ProductService;
import com.merqury.mysite.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public String products(Model model){
        model.addAttribute("products", productService.getProducts());
        return "products";
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
    public String addProduct(String title, String description, int price, String city, String author, MultipartFile file){
        Image image;
        if(!file.isEmpty()){
            image = toImageEntity(file);
            image.setPreviewImage(true);
        }
        if(title.length() < 500 && description.length() < 1500 && city.length() < 100 && author.length() < 100)
            productService.addProduct(new Product(title, description, city, author, price, 0));
        return "redirect:/";
    }

    private Image toImageEntity(MultipartFile file) {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setSize(image.getSize());
        image.setBytes(image.getBytes());
        image.setContentType(image.getContentType());
        return image;
    }

    @PostMapping("/prod/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        if(id == 0)
            return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        if(id == 1)
            return "redirect:https://www.youtube.com/watch?v=aS-lYda-BO8";
        if(id == 123)
            return "redirect:/";
        productService.rmProduct(id);
        return "redirect:/";
    }

    @GetMapping("/prod/buy/{id}")
    public String buy(@PathVariable long id){

        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }
}
