package com.example.obspringsecurityjwtroles.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {

        // Puede crear su propia respuesta aquí para manejar la respuesta denegada de acceso a nivel de método.
        //método similar al del controlador de credenciales incorrectas anterior.
        System.out.println("Ejecutando CustomAccessDeniedHandler");
        response.setStatus(HttpStatus.FORBIDDEN.value()); //403 prohibido
        response.setContentType("application/json");
        Map<String, Object> data = new HashMap<>();
        data.put("timestamp", new Date());
        data.put("status",HttpStatus.FORBIDDEN.value());
        data.put("message", "Access Denied, login again!");
        data.put("path", request.getRequestURL().toString());
        data.put("pd", "Have a good day :)");

        OutputStream out = response.getOutputStream();
        /*
        response.getOutputStream()
        Devuelve un ServletOutputStream adecuado para escribir datos binarios en la respuesta. El contenedor de servlets no codifica los datos binarios.
        Llamar a flush() en ServletOutputStream confirma la respuesta. Se puede llamar a este método o a getWriter para escribir el cuerpo, no a ambos.
         */
        ObjectMapper mapper = new ObjectMapper(); //dependencia jackson
        mapper.writeValue(out, data);
        /*
        ObjectMapper proporciona funcionalidad para leer y escribir JSON, ya sea hacia y desde POJO básicos (Plain Old Java Objects),
        o hacia y desde un modelo de árbol JSON de uso general (JsonNode), así como funciones relacionadas para realizar conversiones.
        También es altamente personalizable para trabajar con diferentes estilos de contenido JSON y para admitir conceptos de objetos más avanzados,
        como polimorfismo e identidad de objetos. ObjectMapper también actúa como una fábrica para clases más avanzadas de ObjectReader y ObjectWriter.
         Mapper (y ObjectReaders, ObjectWriters que construye) usará instancias de JsonParser y JsonGenerator para implementar la lectura/escritura real de JSON.
         Tenga en cuenta que aunque la mayoría de los métodos de lectura y escritura se exponen a través de esta clase, parte de la funcionalidad
         solo se expone a través de ObjectReader y ObjectWriter: específicamente, la lectura/escritura de secuencias de valores más largas
         solo está disponible a través de ObjectReader.readValues(InputStream) y ObjectWriter.writeValues (Salida de corriente).
         */


        out.flush();

    }

}