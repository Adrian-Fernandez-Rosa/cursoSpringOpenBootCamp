package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookRepository bookRepository;

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    public BookController(BookRepository bookRepository) {
       this.bookRepository = bookRepository;
    }

    //CRUD sobre la entidad Book

    //buscar todos los libros

    /**
     * http://localhost:8080/api/books
     * @return libros
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
    @ApiOperation("Buscar un libro por clave primaria id Long")
    public ResponseEntity<Book> findOneById(@ApiParam("Clave primaria tipo long") @PathVariable Long id){ //recordar que Path... vincula con la url
        //normalmente se devuelve response entity
        Optional<Book> bookOpt = bookRepository.findById(id);

         if(bookOpt.isPresent())
             return ResponseEntity.ok(bookOpt.get());
         else
             return ResponseEntity.notFound().build();
         //Construye response entity 404

        // return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    /**
     * Método POST, recordar no hay conflicto de URL porque el otro es get
     * @param book
     * @param headers
     * @return
     */
    @ApiIgnore //ignoramos el método para que no se incluya en swagger
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        //@RequestBody  extrae la información de la petición y cargala en un parametro de tipo libro
        if(book.getId() != null){
            log.warn("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }

        Book result = bookRepository.save(book);
        System.out.println(headers.get("User-Agent"));
       return ResponseEntity.ok(result);
        // return bookRepository.save(book);
    }

    /**
     *     actualizar un libro existente
     *     para actualizar datos se utiliza put
     * los @RequestBody anotación nos permite recuperar el cuerpo de la solicitud. Luego podemos
     * devolverlo como una cadena o deserializarlo en un objeto Java antiguo simple (POJO).
      */
    @PutMapping("/api/books")
    public ResponseEntity<Book>  udpate(@RequestBody Book book){

    if(book.getId() == null){ //si no tiene id es porque que hay que crearlo y no actualizarlo
        log.warn("Trying to update a non existent book");
        return ResponseEntity.badRequest().build();
    }
    if(!bookRepository.existsById(book.getId())){
        log.warn("Trying to update a non existent book");
        return ResponseEntity.notFound().build(); //404
    }

        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    //borrar un libro
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){


        if(!bookRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build(); //404
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
      //204 todo ok y el contenido y el contenido ya no esta disponible

    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("REST Request for Deleting all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
