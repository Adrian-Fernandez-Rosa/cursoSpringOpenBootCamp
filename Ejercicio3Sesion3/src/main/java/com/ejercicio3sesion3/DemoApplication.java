package com.ejercicio3sesion3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);

		ApplicationContext context =  SpringApplication.run(DemoApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		//Almacenar usuario
		User adrian = new User(null, "Adrián", "Fernández Rosa","010100100n");
		userRepository.save(adrian);

		//recuperar usuario


		System.out.println(userRepository.findById(1L).toString());

		System.out.println("-------------------------------------");
		//recuperar todos
		System.out.println(userRepository.findAll());


	}

}
