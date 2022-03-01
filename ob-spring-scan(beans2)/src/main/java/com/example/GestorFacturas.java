package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    // 1. Atributos
    Calculadora calculadora;


    // 2. Constructores //de esta forma y sin usar autowired en el atributo facilita el testing.
    public GestorFacturas(Calculadora calculadora){
        System.out.println("Ejectutando constructor gestorFacturas");
        this.calculadora = calculadora;
    }
}
