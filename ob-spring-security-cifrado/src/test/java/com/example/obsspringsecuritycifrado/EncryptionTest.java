package com.example.obsspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * BCrypt que genera su propio salt de 16 bytes.
     *
     * El resultado de cifrar con bcrypt sera un String de 60 caracteres:
     *
     * $a versión
     * $10 fuerza (valor que va de 4 a 31, por defecto vale 10)
     * Los 22 siguientes caracteres son el salt generado
     */
    @Test
    void bcryptTest(){

        BCryptPasswordEncoder passworwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passworwordEncoder.encode("admin");
        System.out.println(hashedPassword);

        //comprobamos si son iguales
        boolean matches = passworwordEncoder.matches("adminn", "$2a$10$r9RNErjEon63Jf67tyql/OlKoH5NcK5h4n23f1cXEdKhQg4mE/iXS");
        System.out.println(matches);
    }

    @Test
    void bcryptCheckMultiplePasswords(){

        BCryptPasswordEncoder passworwordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 10; i++) {
            System.out.println(passworwordEncoder.encode("admin"));
        }
    }

    /**
     * otro tipo de cifrado
     */
    @Test
    void pbkdf2(){
        Pbkdf2PasswordEncoder passworwordEncoder = new  Pbkdf2PasswordEncoder();
        for (int i = 0; i < 30; i++) {
            System.out.println(passworwordEncoder.encode("admin"));
        }

    }


    @Test
    void argon(){
        Argon2PasswordEncoder passworwordEncoder = new  Argon2PasswordEncoder();
        for (int i = 0; i < 30; i++) {
            System.out.println(passworwordEncoder.encode("admin"));
        }

    }

    @Test
    void scrypt(){
       SCryptPasswordEncoder passworwordEncoder = new  SCryptPasswordEncoder();
        for (int i = 0; i < 30; i++) {
            System.out.println(passworwordEncoder.encode("admin"));
        }
    }

    @Test
    void springPasswordEncoders(){

        String idForEncode = "brypt";

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("argon2", new Argon2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt",encoders);

        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);

    }

}
