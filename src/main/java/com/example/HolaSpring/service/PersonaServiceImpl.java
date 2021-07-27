package com.example.HolaSpring.service;

import com.example.HolaSpring.dao.PersonaDao;
import com.example.HolaSpring.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//etiqueta que le permite a spring identificar que esta clase es una implementacion de la interfaz PersonaService y así poder instanciarla para implementarla
public class PersonaServiceImpl implements PersonaService 
{
    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly=true) //etiqueta para indicar que este método solo realiza lecturas en la base de datos. si ocurre un error se realiza un rollback o, si es exitoso, se realiza commit
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional//etiqueta para indicar que este método realiza lecturas y escrituras en la base de datos. si ocurre un error se realiza un rollback o, si es exitoso, se realiza commit
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly=true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
