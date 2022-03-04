package com.ejercitacionSesion6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String holaMundo(){
        return "buenos días";
    }
}
