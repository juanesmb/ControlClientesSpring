package com.example.HolaSpring.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/*
    Clase Listener que tiene como función la internacionalización de la web page en términos de idioma
*/
@Configuration //anotación para registrar la clase como un bean y ser considerada en el contenedor de spring
public class WebConfig implements WebMvcConfigurer{
    
    /*
        método para establecer el lenguaje por default
    */
    @Bean //anotación que permite crear una instacia del objeto declarado y agregarlo al contenedor de spring
    public LocaleResolver localeResolver()
    {
        var slr = new SessionLocaleResolver(); //clase para poder configurar el manejo de múltiples idiomas
        slr.setDefaultLocale(new Locale("es")); //estableciendo el lenguaje por default
        return slr;
    }
    
    /*
        Método para modificar dinámicamente el lenguaje con el que estamos trabajando
    */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor()
    {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");//especificamos parámetro a utilizar para cambiar de lenguaje. en este caso "lang"
        return lci;
    }
    
    /*
        Método para registrar interceptor.
    */
    @Override
    public void addInterceptors(InterceptorRegistry registro)
    {
        registro.addInterceptor(localeChangeInterceptor());
    }
    
}
