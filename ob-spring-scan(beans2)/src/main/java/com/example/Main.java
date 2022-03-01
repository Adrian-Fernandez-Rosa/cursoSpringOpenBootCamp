package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // OPCION 2. Recibir un objeto de Spring (la opcion 1 es usar new CalculatorService();
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");


        String texto = calculadora.holaMundo();
        System.out.println(texto);

        //SE PUEDE VOLVER A OBTENER
        //OJO, se recupera el mismo objeto ya que spring utiliza singleton
        Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
        texto = calculadora.holaMundo();
        System.out.println(texto);

        //CONCEPTO 2 EJEMPLO 2: Cargar un bean dentro de otro bean
        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holaMundo());


        //CONCEPTO 3: scope o alcance
        // los beans por defecto son singleton, se puede cambiar a prototype modificando beans.xml(una de tantas)
       


    }
}
