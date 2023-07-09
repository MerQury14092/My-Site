package com.merqury.mysite.models.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long            id;
    private String          title,
                            description,
                            city,
                            author;
    private int             price;
    private LocalDateTime   dateOfCreated;
    private String          urlToImage;

    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }

    public static void concatenate(Product base, Product src){
        if(src.title != null)
            if(!src.title.isEmpty() && !base.title.equals(src.title))
                base.title = src.title;

        if(src.description != null)
            if(!src.description.isEmpty() && !base.description.equals(src.description))
                base.description = src.description;

        if(src.city != null)
            if(!src.city.isEmpty() && !base.city.equals(src.city))
                base.city = src.city;

        if(src.author != null)
            if(!src.author.isEmpty() && !base.author.equals(src.author))
                base.author = src.author;

        if(src.urlToImage != null)
            if(!src.urlToImage.isEmpty() && !base.urlToImage.equals(src.urlToImage))
                base.urlToImage = src.urlToImage;

        if(src.price != base.price)
            base.price = src.price;
    }
}
