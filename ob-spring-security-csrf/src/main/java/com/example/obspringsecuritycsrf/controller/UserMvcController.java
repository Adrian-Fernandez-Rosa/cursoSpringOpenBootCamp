package com.example.obspringsecuritycsrf.controller;

import com.example.obspringsecuritycsrf.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//template
public class UserMvcController {


    @GetMapping("/")
    public String getForm(Model model){

        model.addAttribute("user", new UserDTO());
        return "user-form";
    }

    @PostMapping("/users")
    public String save(@ModelAttribute UserDTO user){ //@ModelAttribute obtener datos de un form y cargarlo al objeto
        System.out.println(user);
        return "exito";

    }

}
