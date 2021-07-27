package com.example.HolaSpring.dao;

import com.example.HolaSpring.domain.Persona;
import org.springframework.data.repository.CrudRepository;

//                                                 clase, id de la clase
public interface PersonaDao extends CrudRepository<Persona, Long> {
    
    
}
