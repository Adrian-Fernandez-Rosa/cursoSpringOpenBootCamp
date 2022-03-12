package com.ejercicio.sesion9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/*/*").permitAll()
                .antMatchers("/api/*").hasRole("ADMIN")
                .antMatchers("/api/*").hasRole("USER")
                .antMatchers("/mensaje").permitAll()
                //lo que recibe es una expresión, para que haga match para que acepte URL con determinado formato para que acepte sin contraseña
                //se puede duplicar
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();

    }


    @Override //permite modificar sistema de autenticación, en este caso , customizamos usuario desde aquí
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth     // enable in memory based authentication with a user named
                // "user" and "admin"
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("1234")).roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
