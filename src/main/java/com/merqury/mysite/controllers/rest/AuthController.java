package com.merqury.mysite.controllers.rest;

import com.merqury.mysite.models.api.Responce;
import com.merqury.mysite.models.auth.User;
import com.merqury.mysite.security.UserDetailsServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiauth")
public class AuthController {
    private final UserDetailsServiceImpl userDetailsService;
    public AuthController(@Qualifier("userDetailsServiceImpl") UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/token")
    public String getToken(@PathParam("") String username,
                           @PathParam("") String password){
        String token = userDetailsService.getToken(username, password);
        return token==null?"Bad credentials":token;
    }

    @GetMapping("/whois")
    public String getUsername(@PathParam("") String token){
        User user = userDetailsService.getByToken(token);

        if(user == null)
            return "no user";

        return user.getToken();
    }

    @PostMapping("/registration")
    public Responce registration(@RequestBody User user){
        return Responce.FORBIDDEN;
    }
}
