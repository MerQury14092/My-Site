package com.merqury.mysite.models.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Responce {
    public static final Responce OK = new Responce(200, "OK");
    public static final Responce NOT_FOUND = new Responce(404, "Not found");
    public static final Responce FORBIDDEN = new Responce(403, "Forbidden");

    private int responce_code;
    private String responce_text;
}
