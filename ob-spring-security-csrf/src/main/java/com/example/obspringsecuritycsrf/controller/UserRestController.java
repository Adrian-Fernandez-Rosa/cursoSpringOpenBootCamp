package com.example.obspringsecuritycsrf.controller;

import com.example.obspringsecuritycsrf.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    //url permit all
    @GetMapping("/api/hola")
    public String hola(){
        return "Hola mundo";
    }

    //url autenticada
    @GetMapping("/api/adios")
    public String adios(){
        return "adios mundo";
    }


    @PostMapping("/api/users")
    public String save(@RequestBody UserDTO user){
        System.out.println(user);
        return "OK";

    }

}
