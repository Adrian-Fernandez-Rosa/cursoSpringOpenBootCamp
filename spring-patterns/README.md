
## Patrones de diseño

No son código en sí, son una forma de estructurar el código con el objeto de resolver un 
problema común.

Patrones a explorar: 

* Plantilla (Template)
* Cadena de responsabilidad (Chain of responsibility)
* Estrategia (Strategy)
* Proxy
* Constructor (Builder)
* Observador (Observer)
* Decorador (Decorator)

## Tipos de patrones 

* **Creacionales**
  * Constructor (Builder)
* **Estructurales**
  * Proxy
  * Decorador
* **Comportamiento**
  * Template
  * Chain of responsibility
  * Strategy
  * Observer

## Objetivos generales

* Obtener bajo acoplamiento (se suele usar más clases abstractas que interfaces)
* Reutilización de código
* Flexibilidad 
* Escalabilidad
* Eficiencia
* Estándar de buenas prácticas
* Favorece el testing
* Mayor calidad

# Recursos de interés 

https://refactoring.guru/design-patterns/catalog

https://github.com/eugenp/tutorials/tree/master/patterns

https://www.baeldung.com/spring-framework-design-patterns

## 1. Patrón Plantilla 

* Desacoplar código 
* Reutilizar código

## 2. Patrón cadena de responsabilidad 

En Spring Security tenemos los filtros 

Objetivos:
* Reducir el acoplamiento
* Flexibilidad al permitir cambiar responsabilidad
* Componer objetos que en su totalidad resuelven una unidad de trabajo

A tener en cuenta: 

* Cada elemento de la cadena de responsabilidad (Manejador) tiene su propia implementación
* Cada manejador hace referencia al siguiente manejador
* No deberían formarse ciclos recursivos 


## 3. Patrón estrategia

Permite utilizar algoritmos de forma dinámica.

Ventajas:
* Cambiar un algoritmo o comportamiento en tiempo de ejecución (runtime)
* Clara separación de comportamientos, cada algoritmo representa una estrategia.
* Principios SOLID: principio Open Closed. Podemos introducir nuevas estrategias sin alterar el código original.

Desventajas:
* Se puede llegar a complicar al tener que introducir nuevas clases/ interfaces.
* Si los algoritmos no son muy distintos puede que no tenga sentido hacer tanto código.
* Los clientes que la utilizan tienen que ser consciente de la existencia de las diferentes estrategias.
* La programación funcional permite simplificar el uso del patrón estrategia al poder pasar comportamiento por parámetros.
  por lo que no haría falta crear nuevas clases evitando el uso del patrón estrategia.

## 4. Proxy

  Carga de objeto pesado: imágenes, conexiones a base de datos (contexto de persistencia).
  
  La carga de estos objetos se difiere todo lo posible..
  
Client --> Objeto

Client --> Proxy --> Objeto

Ejemplos: SessionFactory (Hibernate), EntityManagerFactory (JPA).

Ventajas:

* Permite gestionar el ciclo de vida del objeto pesado sin que el client tenga noción de ello.
* El proxy funciona incluso aunque el objeto pesado no haya sido inicializado o no este disponible.
* Principios SOLID: principio Open Closed. Podemos Introducir nuevos objetos pesados.

Desventajas:

* Diferir la carga de un objeto no siempre será lo mejor si se necesita de inmediato.
* Introducción de nuevas clases puede dar lugar a complejidad.


## 5. Builder

Cuando hay una clase con muchos atributos y necesitamos múltiples formas de crear objetos haciendo uso de constructores sobrecargados.


Tener todas las posibles combinaciones de constructores puede llegar a ser muy complejo de mantener.

Utiliza fluent programming style para lograr construir los objetos.
(Devolver `this` al final de cada método setter.)

Ventajas:
* Permite construir objeto paso a paso encadenando llamadas a métodos en una misma línea.
* Los mismos métodos permiten construir objetos cada vez con diferentes atributos sin necesidad de tner un constructor para cada manera de crearlos.
* Principios SOLID: principio SRP. Una sola responsabilidad al aislar la forma de construir el objeto a los clientes.

Desventajas:
* Requiere crear una nueva clase Builder lo cual puede añadir complejidad a la clase original.
