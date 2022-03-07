package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;

/**
 * clase de ejemplo para testing
 */
public class BookPriceCalculator {

    public double calculatePrice(Book book){
        double price = book.getPrice();

        if(book.getPages() > 300){
            price += 5;
        }

        price += 2.99;
        return price;

    }
}
