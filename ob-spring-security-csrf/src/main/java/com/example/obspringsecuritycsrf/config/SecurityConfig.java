package com.example.obspringsecuritycsrf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("password")).roles(("USER"))
                .and()
                .withUser("admin")
                .password(encoder.encode("password")).roles("USER","ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
