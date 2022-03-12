package com.ejercicio.sesion9.controllers;

import com.ejercicio.sesion9.entities.Laptop;
import com.ejercicio.sesion9.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Value("${app.message}")
    String message;

    private LaptopRepository laptopRepository;

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/mensaje")
    @ApiOperation("Devuelve un mensaje")
    public String mensaje(){
        return message;
    }

    @GetMapping("/api/laptops")
    @ApiOperation("Devuelve todas las laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

 /*   @PostMapping("/api/laptops")
    public Laptop saveLaptop(@RequestBody Laptop laptop){

        return laptopRepository.save(laptop);
    }

  */
    @ApiOperation("Busca laptop por clave primaría ID")
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if(laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();

        //anotación 4502301294014 in host

    }

    /**
     * Método POST,
     * @param laptop
     * @return
     */

     @PostMapping("/api/laptops")
     @ApiOperation("crea laptop")
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop){
        if(laptop.getId() !=null){
            log.warn("trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
     }

     @PutMapping("/api/laptops")
     @ApiOperation("Actualiza laptop y devuelvo string")
    public ResponseEntity<String> update(@RequestBody Laptop laptop){

         if(laptop.getId() == null){ // Si no tiene ide es porque no es para update
             log.warn("Trying to update a non existent laptop");
             return ResponseEntity.badRequest().build();
         }
         if(!laptopRepository.existsById(laptop.getId())){
             log.warn("Trying to update a non existent laptop");
             return ResponseEntity.notFound().build(); //404
         }
         Laptop result = laptopRepository.save(laptop);
         return ResponseEntity.ok("successfully upgraded laptop.");

     }


        //borrar una laptop
        @DeleteMapping("/api/laptops/{id}")
        @ApiOperation("Elimino Laptop por id")
        public ResponseEntity<Laptop> delete(@PathVariable Long id){

         if(!laptopRepository.existsById(id)){
                log.warn("Trying to delete a non existent laptop");
                return ResponseEntity.notFound().build(); //404
         }
         laptopRepository.deleteById(id);
         return ResponseEntity.noContent().build();
            //204 tod0 ok y el contenido y el contenido ya no esta disponible
        }


        @DeleteMapping("/api/laptops")
        @ApiOperation("elimino todas las Laptops")
        public ResponseEntity<Laptop> deleteAll(){
         log.info("REST Request for DELETING all laptops");
         laptopRepository.deleteAll();
         return ResponseEntity.noContent().build(); //204

        }




}
