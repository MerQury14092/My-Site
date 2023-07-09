package com.merqury.mysite.models.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    public static final Response OK = new Response(200, "OK");
    public static final Response NOT_FOUND = new Response(404, "Not found");
    public static final Response FORBIDDEN = new Response(403, "Forbidden");
    public static final Response UNAUTHORIZED = new Response(401, "Unauthorized");

    private int response_code;
    private String response_text;
}
