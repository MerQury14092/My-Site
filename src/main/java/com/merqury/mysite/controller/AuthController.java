package com.merqury.mysite.controller;

import com.merqury.mysite.models.api.Response;
import com.merqury.mysite.models.auth.User;
import com.merqury.mysite.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    public AuthController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/token")
    public Response getToken(@PathParam("") String username,
                           @PathParam("") String password){
        String token = userService.getToken(username, password);
        return token==null?(new Response(400, "Bad credentials")):(new Response(200, token));
    }

    @GetMapping("/whois")
    public String getUsername(@PathParam("") String token){
        User user = userService.getByToken(token);

        if(user == null)
            return "no user";

        return user.getUsername();
    }

    @PostMapping("/registration")
    public Response registration(@RequestBody User user){
        boolean register = userService.register(user.getUsername(), user.getPassword());
        return register? Response.OK:(new Response(400, "user already exists"));
    }
}
