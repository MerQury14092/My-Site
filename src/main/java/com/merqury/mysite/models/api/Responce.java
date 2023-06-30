package com.merqury.mysite.models.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Responce {
    private int responce_code;
    private String responce_text;
}
