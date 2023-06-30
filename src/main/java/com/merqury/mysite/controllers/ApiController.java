package com.merqury.mysite.controllers;

import com.merqury.mysite.services.GetIpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {
    GetIpService service;
    @GetMapping
    public String getApiDoc(Model model) throws IOException {
        model.addAttribute("ip", service.getIP());
        return "apidoc";
    }
}
