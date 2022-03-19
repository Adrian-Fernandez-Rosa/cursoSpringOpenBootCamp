
## Medidas de seguridad en Spring

## CSRF

* Cross-Site Request Forgery:

 Falsificación de solicitudes entre sitios.
 
Es un ataque que hace que el usuario final ejecute acciones no deseadas en una app web en la que están autenticadas actualmente.

Mediante ingeniería social un atacante puede engañar a los usuarios de una app web para que ejecuten las acciones que elija el atacante.

CON JWT NO ES POSIBLE ESTE ATAQUE.

-----------------------------
```java

 @Override
    protected void configure(HttpSecurity http) throws Exception {
       // Por defecto si no se especifica nada entonces protección CSRF está habilitada.
            http
                    .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    //csrfTokenRepository se encarga de traer un csrftoken de las cabeceras (httpservlet)
                    //se genera csrf token se envia al cliente.
                    //CookieCsrfTokenRepository: persiste el token en una cookie llamada XSRF-TOKEN
                    //luego en sucesivas peticiones lo va a leer como X-XSRF-TOKEN
                    //es lo que se tiene agregar a postman si lo testeamos desde ahi
                            .and()
                // autorización de urls
                .authorizeRequests()
                .antMatchers("/hola").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().httpBasic();
    }

```

para mandar post a /users desde postman debemos
poner esto en el test

pm.environment.set("xsrf-token", decodeURIComponent(pm.cookies.get("XSRF-TOKEN")))

json:
``` json
{
"username": "admin",
"email": "admin@admin.com",
"password": "admin"
}

```

y crear la variable de entorno 

xsrf-token

No olvidar agregarlo al header {{xsrf-token}}

nota: csrf se suele usar en react y angular, pero tambíen podemos usarlo en thymeleaf

Al tener en Securityconfig: 

```Java 
 http
       .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

```

Se genera luego del form action:

```html

<input type="hidden" name="_csrf" value="776dcbef-0dff-465b-ac67-9780ecc389e6">

```

***nota al margen: en JSP si hay que usar variable.***

-----------------------------------------

## XSS

Secuencias de comandos entre sitios.

Se inyecta una secuencias de comandos malintencionados en un sitio web por lo general a través de un input para enviar código mailicioso.

* Control de caché.
* Opciones de tipo de contenido.
* Seguridad de transporte estricta de HTTP.
* Opciones X-Frame.
* Protección X-XSS.

Spring habilita por defecto todo este tipo de medidas.

## SQL Injection

```sql 
SELECT * FROM table WHERE name='" + name + "';"
```

El usuario nos puede atacar a través de los input de la suguiente forma:

```sql 
SELECT * FROM table WHERE name='" + 'Pepito or 1=1; DELETE * FROM users"
```

en jpa es spring que sanitiza la entrada.

Sanitizar la entrada a través de parámetros:

```java
Query query = em.createQuery("SELECT * FROM table where username = :username");
query.setParameter("username", "Pepito");
```

## Más información en:
https://owasp.org/www-project-top-ten/

