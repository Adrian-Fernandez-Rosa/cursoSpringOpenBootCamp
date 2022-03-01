VIDEO 1 ::. INTRODUCCION
Los beans son objetos de java normales que spring va a tener conocimientos de ellos (pojo).

documentacion de beans https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-basics

podemos notar que hay un ejemplo de xml de beans para copiar y pegar 

lo hemos modificado: 

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="calculatorService" class="com.example.CalculatorService">
    </bean>



</beans>

y se añadio en la carpeta resources llamado beans.xml


1.2.2. Crear una instancia de un contenedor

La ruta o rutas de ubicación suministrado a un ApplicationContextconstructor son cadenas de recursos que permiten los metadatos de configuración de 
carga del contenedor desde una variedad de recursos externos, como como el sistema de archivos local, Java CLASSPATH, y así.

clase servicio:
package com.example;

public class CalculatorService {

    public CalculatorService(){
        System.out.println("Ejecutando constructor CalculatorService");
    }

    public String holaMundo(){
        return "Hola mundo!";
    }
}


---
clase main

   public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CalculatorService calculadora = (CalculatorService) context.getBean("calculatorService");

        String texto = calculadora.holaMundo();
        System.out.println(texto);


        CalculatorService calculadora2 = (CalculatorService) context.getBean("calculatorService");
        System.out.println(texto);
		//Notar que el constructor se ejecuta solo una vez porque spring utiliza el patron singleton
		
    }