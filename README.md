<h1 align="center">SpringFramework Open Bootcamp</h1>
<p align="left">A continuación, verán distintos conceptos de proyectos/ejemplos Spring que aprendí en openbootcamp</p>
<p align="left">hago repaso de spring Framework y Spring boot, pero en esta ocasión con el contenido de OpenBootCamp </p>
<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/introduccion" 
 target="_blank">BEANS </a></h3>
<p align="left">
-Es un ejemplo usando inyección de dependencias a traves de un archivo xml.          
</p>
  
          

<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/ob-spring-scan(beans2)" 
 target="_blank"> COMPONENT-SCAN </a></h3>
<p align="left">
-Es un ejemplo usando component scan en el xml.          
</p>          



<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/ob-springdatajpa" 
 target="_blank"> introducción JPA usando H2 </a></h3>
<p align="left">
- En esta primera parte de la sesión aprenderás lo que es Spring Data, verás una introducción a JPA, dependencias y introducción a las queries.       
</p>          

<h6 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/Ejercicio1Sesion3" 
 target="_blank"> Ejercicio 1:  </a></h3>
 <p align="left">Crear proyecto maven con la dependencia spring-context y crear una clase Saludo con un método imprimirSaludo que imprima un texto por consola.
Crear el archivo beans.xml con un bean para la clase Saludo.
Obtener el bean desde el método main y ejecutar el método imprimirSaludo.</p>

<h6 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/Ejercicio2Sesion3" 
 target="_blank"> Ejercicio 2:  </a></h3>
 <p align="left">Crear la clase NotificationService, con un método que imprima un saludo.
Crear una clase UserService que tenga un atributo de clase NotificationService.
Utilizar la anotación @Component en cada clase.
Habilitar el escaneo de clases en el archivo beans.xml
Desde el método main, probar a obtener el bean UserService y ejecutar el método imprimirSaludo que tiene asociado el atributo de tipo NotificationService. De forma similar a la realizada en clase.</p>


<h6 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/Ejercicio3Sesion3" 
 target="_blank"> Ejercicio 3:  </a></h3>
 <p align="left">Crear un proyecto Spring Boot con las dependencias:
    Spring Data JPA
    H2
</p>
<hr />
<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/ob-rest-datajpa2" 
 target="_blank"> API REST  </a></h3>
<p align="left">
- aplicaciones REST con Spring Boot,  un repaso a los servicios REST.
 USO DE @RequestBody, @RequestHeader, @RestController, ResponseEntity
</p>          

<h6 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/ejercitacionSesion6" 
 target="_blank"> Ejercicitación sesión 6:  </a></h3>
 <p align="left">
Crear una clase HelloController que sea un controlador REST.
Dentro de la clase crear un método que retorne un saludo.
Probar que retorna el saludo desde el navegador y desde Postman.

Dentro de la misma app crear las clases necesarias para trabajar con "ordenadores":
 * Laptop (entidad)
 * LaptopRepository (repositorio)
 * LaptopController (controlador)

Desde LaptopController crear un método que devuelva una lista de objetos Laptop.
Probar que funciona desde Postman.
Los objetos Laptop se pueden insertar desde el método main de la clase principal.

Crear un método en LaptopController que reciba un objeto Laptop enviado en formato JSON desde Postman y persistirlo en la base de datos.

Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.
</p>
<hr/>


