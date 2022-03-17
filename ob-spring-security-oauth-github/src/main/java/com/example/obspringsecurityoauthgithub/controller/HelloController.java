package com.example.obspringsecurityoauthgithub.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //mvc
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/page1")
    public String page2(
            Model model,
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client, //podemos acceder a los datos del usuario del github
            @AuthenticationPrincipal OAuth2User user
    ){
        model.addAttribute("clientName", client.getClientRegistration().getClientName());
        model.addAttribute("userName", user.getName());
        model.addAttribute("userAttributes", user.getAttributes());

        // model.addAttribute("message", "Hola desde MVC!!");
        return "pagina1";
    }

    @GetMapping("/page2")
    public String page1(Model model){
        model.addAttribute("message", "Hola desde MVC!!");
        return "pagina11";
    }


}
