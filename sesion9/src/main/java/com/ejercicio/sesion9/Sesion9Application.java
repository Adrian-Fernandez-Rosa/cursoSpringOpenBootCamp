package com.ejercicio.sesion9;

import com.ejercicio.sesion9.entities.Laptop;
import com.ejercicio.sesion9.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class Sesion9Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Sesion9Application.class, args);

		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "ASUS","Intel i9 12700",4,"Windows 10");
		Laptop laptop2 = new Laptop(null, "LENOVO","Intel i3 4200",8,"Windows 10");


		repository.save(laptop1);
		repository.save(laptop2);


	}

}
