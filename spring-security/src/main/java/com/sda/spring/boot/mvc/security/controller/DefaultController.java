package com.sda.spring.boot.mvc.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// create controller with multiple endpoints
@Controller
public class DefaultController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // /admin
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    // /user
    @GetMapping("/user")
    public String user() {
        return "user";
    }


}
