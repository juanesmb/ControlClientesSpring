
package com.example.HolaSpring.web;

import com.example.HolaSpring.domain.Persona;
import com.example.HolaSpring.service.PersonaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user)
    {
        var personas = personaService.listarPersonas();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona)
    {
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) //etiqueta para validar errores recibidos por el objeto persona
    {
        if(errores.hasErrors()){
            return "modificar";
        }
        
        this.personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model)
    {
        persona = this.personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }
    
    //@GetMapping("/eliminar/{idPersona}") 1er mapeo para peticion por path
    @GetMapping("/eliminar") //2do mapeo para peticion por query paramether
    public String eliminar(Persona persona )
    {
         this.personaService.eliminar(persona);
        return "redirect:/";
    }
    
}
