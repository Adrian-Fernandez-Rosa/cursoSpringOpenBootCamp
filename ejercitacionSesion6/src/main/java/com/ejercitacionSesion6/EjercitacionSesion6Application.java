package com.ejercitacionSesion6;

import com.ejercitacionSesion6.entity.Laptop;
import com.ejercitacionSesion6.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercitacionSesion6Application {

	public static void main(String[] args) {
		//SpringApplication.run(EjercitacionSesion6Application.class, args);

		ApplicationContext context = SpringApplication.run(EjercitacionSesion6Application.class, args);

		LaptopRepository repository = context.getBean(LaptopRepository.class);

		//Crear y almacenar Laptop
		Laptop laptop1 = new Laptop(null, "ASUS","Intel i9 12700",4,"Windows 10");
		Laptop laptop2 = new Laptop(null, "LENOVO","Intel i3 4200",8,"Windows 10");

		repository.save(laptop1);
		repository.save(laptop2);

	}

}
