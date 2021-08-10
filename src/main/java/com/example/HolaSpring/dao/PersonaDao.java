package com.example.HolaSpring.dao;

import com.example.HolaSpring.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

//                                                 clase, id de la clase
public interface PersonaDao extends JpaRepository<Persona, Long> {
    
    
}
