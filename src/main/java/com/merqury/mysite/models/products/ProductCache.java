package com.merqury.mysite.models.products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
//@Entity
//@Table(name = "products_cache")
@AllArgsConstructor
@NoArgsConstructor
public class ProductCache {
    //@Id
    private long            id;
    private long            price,
                            lastId;
    private LocalDateTime   dateOfCreate;
    private String          title,
                            description,
                            city,
                            author,
                            urlToImage;

    public ProductCache(Product prod){
        this.lastId = prod.getId();
        this.title = prod.getTitle();
        this.description = prod.getDescription();
        this.author = prod.getAuthor();
        this.city = prod.getCity();
        this.dateOfCreate = LocalDateTime.of(
                prod.getDateOfCreated().toLocalDate(),
                prod.getDateOfCreated().toLocalTime()
        );
        this.price = prod.getPrice();
        this.urlToImage = prod.getUrlToImage();
    }
}
