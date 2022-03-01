
VIDEO 2 ::. Spring Beans 

En esta sesión aprenderás sobre Spring Beans, lo que son los Beans, una introducción al IoC, configuración de Beans, Beans scopes.


documentación oficial
https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-xml-import


veamos el código actual

ESTE ES NUESTRO XML LLAMADO beans.xml que se ubica en la carpeta resource, recordar que copiamos y pegamos de la 
documentación oficial (https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-basics)

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="calculadora" class="com.example.Calculadora">
    </bean>

    <bean id="gestorFacturas" class="com.example.GestorFacturas">
        <constructor-arg name="calculadora" value="calculadora" /> 
		// en value va  cualquier nombre, el name va el nombre igual a como se llame en el codigo, ejemplo atributo de la 
		// clase gestorFacturas
		
    </bean>



</beans>

------------------------------------------------------------------------------------------------------------------
clase calculadora 

package com.example;

public class Calculadora {

    public Calculadora(){
        System.out.println("Ejecutando constructor CalculatorService");
    }

    public String holaMundo(){
        return "Hola mundo!";
    }
}
------------------------------------------------------------------------------------------------------------------
clase gestorFacturas

package com.example;

public class GestorFacturas {

    // 1. Atributos
    Calculadora calculadora;

    // 2. Constructores
    public GestorFacturas(Calculadora calculadora){
        System.out.println("Ejectutando constructor gestorFacturas");
        this.calculadora = calculadora;
    }
}


-------------------
hemos tenido un error debido al beans.xml 

hemos tenido que reemplazar value por ref porque hace referencia a un bean

 <bean id="calculadora" class="com.example.Calculadora">
    </bean>
	//cargar bean dentro de otro bean
    <constructor-arg name="calculadora" ref="calculadora" />
	
	value sirve para indicar valor 
	
	
	usar xml tiene sus ventajas 
	
--------------------------------------------------------------------------	
	archivo beans.xml completo 
	
	
	<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="calculadora" class="com.example.Calculadora">
    </bean>

    <bean id="gestorFacturas" class="com.example.GestorFacturas">
        <constructor-arg name="calculadora" ref="calculadora" />
        <constructor-arg name="nombre" value="Facturator 3000" />

    </bean>



</beans>
---

ejemplo añadiendo scope
 <bean id="calculadora" class="com.example.Calculadora" scope="prototype"> //el scope por defecto es singleton
    </bean>
	
	
----------------------------------------
PARTE 2 AÑADIENDO SCAN AUTOMATICO PARA BEANS

CREAMOS UN PROYECTO SIMILAR PERO CON EL SIGUIENTE beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">


    <context:component-scan base-package="com.example" />


</beans>

pero no termina ahi, debemos usar anotacion @Component 

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
	