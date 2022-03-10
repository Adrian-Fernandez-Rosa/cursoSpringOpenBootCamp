
## Despliege de apps Spring Boot en Heroku

Crear archivo `system.properties` en el proyecto con el contenido:
```
    java.runtime.version=17
```


1. Se da por hecho de que git ya esta configurado:
    1. `git config --global user.name "Adrian-Fernandez-Rosa`
    2. `git config --globalr user.email adrianfr2011@gmail.com`
2. Subir el proyecto a GitHub desde Intellij IDEA desde la opción: VCS > Share project on GitHub.
3. Desde Heroku, crear app y elegir método GitHub y buscar el repositorio subido.
4. Si es proyecto simple habilitar deploy automático y ejecutar el Deploy.

### Se Aprendío a empaquetar con maven desde IntelliJ IDEA.

``` 
java -jar target/spring-deploy-1.0.jar 
```

* se creo un perfil para dev y otro para test con los application.properties.


