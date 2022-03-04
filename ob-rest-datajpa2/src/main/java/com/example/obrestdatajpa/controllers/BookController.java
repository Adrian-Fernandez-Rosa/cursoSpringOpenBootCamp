package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entidades.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
       this.bookRepository = bookRepository;
    }

    //CRUD sobre la entidad Book

    //buscar todos los libros

    /**
     * http://localhost:8080/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    //buscar un libro segun su id
    /*
    @GetMapping("/api/books/{id}")
    public Book findOneById(@PathVariable Long id){ //recordar que Path... vincula con la url
        //normalmente se devuelve response entity
        Optional<Book> bookOpt = bookRepository.findById(id);

        return bookOpt.orElse(null);
    }
 */

    /**
     * Request
     * Response
     * @param id
     * @return
     */
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){ //recordar que Path... vincula con la url
        //normalmente se devuelve response entity
        Optional<Book> bookOpt = bookRepository.findById(id);

         if(bookOpt.isPresent())
             return ResponseEntity.ok(bookOpt.get());
         else
             return ResponseEntity.notFound().build();
         //Construye response entity 404

        // return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }





    //crear un nuevo libro

    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        //@RequestBody  extrae la información de la petición y cargala en un parametro de tipo libro

        System.out.println(headers.get("User-Agent"));
        return bookRepository.save(book);
    }

    // actualizar un libro existente

    //borrar un libro
}
