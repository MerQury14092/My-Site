package com.merqury.mysite.controllers;

import com.merqury.mysite.enums.Role;
import com.merqury.mysite.models.auth.User;
import com.merqury.mysite.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final UserRepository repository;
    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/success")
    public String successPage(){
        return "auth/success";
    }

    @PostMapping("/registration")
    public String register(String username, String email, String password){
        User usr = repository.findByEmail(email).orElse(null);
        if(usr != null)
            return "redirect:/error";
        repository.save(new User(
                0,
                username,
                email,
                passwordEncoder().encode(password),
                true,
                LocalDateTime.now(),
                Role.ROLE_USER
        ));
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String registerPage(){
        return "registration";
    }

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
