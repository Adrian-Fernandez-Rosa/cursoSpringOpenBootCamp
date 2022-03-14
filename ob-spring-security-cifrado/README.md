Teoría por @alansastre
## Cifrado

Es el proceso de codificar la información de su representación original (texto plano)
a texto cifrado, de manera que solamente pueda ser descifrado utilizando una clave.


Historia del cifrado: 

1. Almacenar contraseñas de texto plano.
2. Almacenar contraseñas cifradas con función hash.
3. Almacenar contraseñas cifradas con función hash + salt("agregado dimanico en el hash").
4. Almacenar contraseñas cifradas con una función adaptativa + factor de trabajo.


La seguridad se gana haciendo que la validación de contraseñas sea costosas computacionalmente.

## Algoritmos en Spring Security

* BCrypt
* PBKDF2
* scrypt
* argon2

<hr>
## JWT

https://jwt.io/introduction

Es un estándar abierto que permite transmitir información entre dos pares:
## Funcionamiento Session

1. Cliente envia una petición a un servidor (/api/login)
2. Servidor valida username y password, si NO son válidos devolverá una respuesta 401 unauthorized
3. Servidor valida username y password, si SI son validos entonces se almacena el usuario en session.
4. Se genera una cookie en el Cliente. 
5. En próximas peticiones se comprueba que el cliente está en session.

Desventajas:

* La información de la session se almacenta en el servidor, lo cual consume recursos.


## funcionamiento JWT

1. Cliente envia una petición a un servidor (/api/login)
2. Servidor valida username y password, si NO son válidos devolverá una respuesta 401 unauthorized
3. Servidor valida username y password, si SI son validos entonces genera un token JWT utiliza una secret key.
4. Servidor devuelve el token JWT generado al Cliente.
5. Cliente envia peticiones a los endpoints REST del servidor utilizando el token JWT en las cabeceras.
6. Servidor valida el token JWT en cada petición y si es correcto permite el acceso a los datos.


Ventajas:

* El token se almacena en el Cliente.

Desventajas:

* El token está en el navegador, no podríamos invalidarlo antes de la fecha de expiración asignada cuando se creó
  * Lo que se realiza es dar la opción de logout, lo cual simplemente borra el token.

## Estructura del token JWT

3 partes separadas por un punto (.) y codificadas en base 64 cada una:

1. Header

``` json 
{
    "alg": "HS512",
    "typ": "JWT"
}

```

2. Payload (información, datos del usuario, no sensibles)

```json 
{
    "name": "Adrian",
    "admin": true
}

```

3. Signatura (genera el token)

```
HMACKSHA256{
base64UrlEncode(header) + "." + base64UrlEncode(payload). secret 
}

```

Ejemplo del token generado: 

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

El User-Agent envia el token JWT en las cabeceras:

```
Authorization: Bearer <token>
```

## Configuración Spring

Crear proyecto Spring Boot con:

* Spring Security
* Spring Web 
* Spring boot devtools 
* Spring Data JPA 
* PostgreSQL 
* Dependencia JWT (se añade manualmente en pom.xml)

```xml
    <dependency> 
        <groupId> io.jsonwebtoken</groupId>
        <artifactId>jjwt </artifactId>
        <version>0.9.1</version>
     </dependency>

```