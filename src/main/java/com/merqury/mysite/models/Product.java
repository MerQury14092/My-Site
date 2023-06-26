package com.merqury.mysite.models;

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
}
