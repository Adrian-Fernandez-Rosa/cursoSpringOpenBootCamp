package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entidades.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    //buscar un solo libro segun su id
    /*
    public Book findOneById(Long id){

        return bookRepository.findById(id);
    }

     */


    //crear un nuevo libro


    // actualizar un libro existente

    //borrar un libro
}
