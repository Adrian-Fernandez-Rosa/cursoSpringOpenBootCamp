package com.ejercicio.sesion9.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggeerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any()) //construya doc sobre todas las rutas
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot API REST",
                "Library api rest docs",
                "1.0",
                "https://www.linkedin.com/in/adrian-fernandez-rosa/",
                new Contact("Adrián","https://www.linkedin.com/in/adrian-fernandez-rosa/", "adrianfr2011@gmail.com" ),
                "MIT",
                "noHay",
                Collections.EMPTY_LIST);
    }
}
