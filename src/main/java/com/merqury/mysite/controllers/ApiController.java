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
        String ip = service.getIP();
        if(ip.equals("194.87.234.38"))
            ip = "merqury.fun";
        model.addAttribute("ip", ip);
        return "apidoc";
    }
}
