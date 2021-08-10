package com.example.HolaSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "rol")
@Data
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//identity para porque la llave es te tipo autoincremental
    private Long idRol;
    
    @NotEmpty
    private String nombre;
}
