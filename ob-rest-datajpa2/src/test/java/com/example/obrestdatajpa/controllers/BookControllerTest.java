package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entities.Book;
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

//Tutor @Alex Torrentí
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate TestRestTemplate; //gracias a este llamaremos test http

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        //PODEMOS GENERARLE setUp Method que es para tener tod0 preparado antes de testear el metodo
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+ port);
        this.TestRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hello() {
        ResponseEntity<String> response = TestRestTemplate.getForEntity("/hola", String.class);

        assertEquals(HttpStatus.OK , response.getStatusCode()); //test sobre respuesta http
        assertEquals(200 , response.getStatusCodeValue()); //más especifico con umero

        assertEquals("Hola mundo!", response.getBody());
    }

    @Test
    void findAll() {

        ResponseEntity<Book[]> response =
        TestRestTemplate.getForEntity("/api/books", Book[].class);

        assertEquals(HttpStatus.OK , response.getStatusCode()); //test sobre respuesta http
        assertEquals(200 , response.getStatusCodeValue()); //más especifico con umero

        List<Book> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
        //faltan cosas para que devuelva libros. INCOMPLETO
    }

    @Test //CASO PARA LIBRO QUE NO EXISTE
    void findOneById() {

        ResponseEntity<Book> response =
                TestRestTemplate.getForEntity("/api/books/1", Book.class);

        assertEquals(HttpStatus.NOT_FOUND , response.getStatusCode());

    }

    @Test
    void create() {

        //CREANDO CABECERA
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "title": "libro creado de Spring test",
                    "author": "Elsa Isabel Bornemann",
                    "pages": 14,
                    "price": 100.0,
                    "releaseDate": "1999-11-30",
                    "online": true
                }
                
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        //
        ResponseEntity<Book> response = TestRestTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);
        //url donde se apunta, tipo de método http, el request y lo que no va a devolver

        Book result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("libro creado de Spring test", result.getTitle());

    }
}