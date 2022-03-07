package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {
        Book book = new Book(4L,"El señor de los anillos", "Author", 1000, 49.99, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // ejecutando comportamiento a testear
        double price = calculator.calculatePrice(book);
        System.out.println(price);
        // comporbaciones aserciones
        assertTrue(price>0);
       assertEquals(57.980000000000004,price);
    }
}