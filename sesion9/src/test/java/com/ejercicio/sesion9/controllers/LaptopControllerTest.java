package com.ejercicio.sesion9.controllers;

import com.ejercicio.sesion9.entities.Laptop;
import io.swagger.annotations.ApiOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate TestRestTemplate; //gracias a este lograremos testeos http

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+ port);
        this.TestRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }
/*
    @Test //caso para laptop no existente
    void findOneById() {

        ResponseEntity<Laptop> response =
                TestRestTemplate.getForEntity("/api/laptops/5", Laptop.class);

        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.OK , response.getStatusCode());
    }

 */
/*
    @Test
    void findAll() {

        ResponseEntity<Laptop[]> response =
                TestRestTemplate.getForEntity("/api/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK , response.getStatusCode()); //test sobre respuesta http
        assertEquals(200 , response.getStatusCodeValue()); //más especifico con numero

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());

    }

    @Test
    void createLaptop() {

        //creando cabecera
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json= """
                {     
                  "marca": "MSI",
                  "procesador": "core !3",
                  "ram": 8,
                  "sistemaOperativo": "Windows 11"
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<Laptop> response = TestRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

       // assertEquals(2L, result.getId());
       // assertEquals("core !3", result.getProcesador());


    }
    */
}