package com.example.obspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ObSpringdatajpaApplication.class, args);

		ApplicationContext context = SpringApplication.run(ObSpringdatajpaApplication.class, args);
		CocheRepository repository = context.getBean(CocheRepository.class);

		System.out.println("find");

		//almacenar coche
		Coche toyota = new Coche(null, "Toyota", "Prius", 2010);
		repository.save(toyota);

		// recuperar un coche por id
		System.out.println("El numero de coche es: "+ repository.count());

		//recuperar coche por id
		System.out.println(repository.findAll());
	}

}
