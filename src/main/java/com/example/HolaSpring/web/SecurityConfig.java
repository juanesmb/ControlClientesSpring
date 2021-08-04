package com.example.HolaSpring.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
Clase para la configuración de la seguridad de la aplicación
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    /*
        Método para agregar y personalizar los usuarios a utilizar para hacer login. esto desactiva el usuario por default
    */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        //método para crear usuarios en memoria
        auth.inMemoryAuthentication() 
                .withUser("admin")
                    .password("{noop}123")//se agrega {noop} para no ecriptar la contraseña
                    .roles("ADMIN","USER")
                .and()
                .withUser("juanesmb")
                    .password("{noop}123")
                    .roles("USER")
                ;           
    }
    
    /*
        método para restringir las URLs de la aplicación web según el rol del usuario
    */
    
}
