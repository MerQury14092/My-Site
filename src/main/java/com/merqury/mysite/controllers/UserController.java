package com.merqury.mysite.controllers;

import com.merqury.mysite.models.User;
import com.merqury.mysite.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }

    @PostMapping("/signup/create")
    public String signup(String username, String email, String password){
        userService.addUser(new User(username, email, password));
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login/in")
    public String login(String email, String password){
        User user = userService.validate(email, password);
        if(user == null)
            return "redirect:/error";
        return "redirect:/";
    }
}
