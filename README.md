<h1 align="center">SpringFramework Open Bootcamp (repaso y reforzando conceptos)</h1>
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
<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/9ed776b4e837b31d3bc127088c7287deff898d11/ob-rest-datajpa2/src/main/java/com/example/obrestdatajpa" 
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
<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/233e7a59d0789c7a5f636de52530a1a06e4826c3/ob-rest-datajpa2" 
 target="_blank">COMPLETANDO Y MEJORANDO API REST  </a></h3>
<p align="left"> 
 Ahora devolvemos códigos de estado de respuesta HTTP y aplicamos algo de lógica básica, por ahora es repaso sin clases servicios.
 
</p>         

<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/ob-rest-datajpa2" 
 target="_blank">AGREGANDO SWAGGER  Y TESTING JUNIT BASICO A API REST </a></h3>
<p align="left"> 
Documentamos con SWAGGER usando:
 <ul>
  
  <li>@ApiIgnore</li>
<li> @ApiOperation</li>
<li>@ApiModel</li>
<li>@ApiModelProperty</li>
  </ul>


testing, algunos de los conceptos y anotaciones aplicadas:
<ul>
 <li>RestTemplateBuilder</li>
   <li>BeforeEach</li> 
 <li>Crear cabecera json</li>
 </ul>
</p>  
 
 <hr/>
 <h6 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/sesion9" 
 target="_blank"> Ejercicitación sesión 9:  </a></h3>
 <p align="left">
 <ul>
 <li>Implementar los métodos CRUD faltantes en el API REST de Laptop creada en ejercicios anteriores.</li>
 <li>Implementar swagger sobre el API REST de Laptop y verificar que funciona.</li>
 <li>Crear casos de test para el controlador de Laptop desde Spring Boot.</li>
  </ul>
 </p>
 
 <hr/>
 
<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/master/spring-deploy" 
 target="_blank">DEPLOY EN HEROKU </a></h3>
<p align="left"> 
Deploy básica java 17 heroku system.properties 
</p>


<h6 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/9a0160c2eb494fe86160034b173e16841a353e27/sesion9" 
 target="_blank">Ejercitación sesion 12 </a></h3>
<p align="left"> 
Probar a empaquetar la aplicación con maven package desde Intellij IDEA
Desde terminal en Intellij IDEA verificar que se se ejecuta correctamente con el comando:
java -jar target/spring-deploy-1.0.jar

Crear un perfil para dev y otro para test con una propiedad nueva que carguemos en el controlador.

Desplegar el API REST de Laptops en Heroku y verificar funcionamiento desde POSTMAN.
Añadir Spring Security sobre el proyecto API REST de Laptops y configurar 2 usuarios en memoria utilizando una clase WebSecurityConfig.
</p>

 <hr/>
 
<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/e99df7e873274a315e1d61f7a9d8d28af7159335/ob-spring-security-cifrado" 
 target="_blank">Teoría JWT </a></h3>
<p align="left"> 
Proyecto teórico donde se hace algunos tipos de cifrados mas teoría JWT en readme
</p>

<h3 align="left"><a href="https://github.com/Adrian-Fernandez-Rosa/cursoSpringOpenBootCamp/tree/ec6c44f15b32959d7afd44d7d46dd5dd6323e30c/ApirestPostgresqlApplication" 
 target="_blank">Spring security con JWT auth, DTO </a></h3>
<p align="left"> 
 Se aplico y configuro JWT como método de autenticación. Tambíen se uso de payLoad. 
 Swagger seguro.
 algo de teoría:
 
* <a href="https://www.devglan.com/spring-security/exception-handling-in-spring-security" target="_blank">exception handling in spring security </a>
 * <a href="https://www.devglan.com/spring-security/spring-boot-jwt-auth" target="_blank">Spring Boot Security Jwt Authentication </a>
</p>
