package com.example.HolaSpring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * Clase para 
 */
public class EncriptarPassword {
    public static void main(String[] args) {
        String password = "123";
        System.out.println("password: " + password);
        System.out.println("password encriptado: " + encriptarPassword(password));
    }
    
    public static String encriptarPassword(String password)
    {
        var encoder = new BCryptPasswordEncoder(); //Clase de spring utilizada para encriptar passwords
        return encoder.encode(password);
    }
}
