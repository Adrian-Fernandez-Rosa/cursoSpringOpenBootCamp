package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(ObRestDatajpaApplication.class, args);

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);

		BookRepository repository = context.getBean(BookRepository.class);

		// Almacenar libro
		Book book1 = new Book
				(null,
				"cronica de una muerte anunciada",
						"Gabriel Garcia Marquez",
						289,
						3200D,
						LocalDate.of(1975,12,1),
						true);

		Book book2 = new Book
				(null,
						"Martin Fierro",
						"Jose Hernandez",
						224,
						7200D,
						LocalDate.of(1872,12,1),
						true);

		repository.save(book1);
		repository.save(book2);

		// Recuperar todos los libros

		repository.findAll().forEach(e -> System.out.println(e));

		// Borrar libro

		//repository.deleteById(1L);

		System.out.println("Cantidad actual de libros "+ repository.count());

	}

}
