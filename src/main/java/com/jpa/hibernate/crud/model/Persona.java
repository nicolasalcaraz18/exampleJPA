package com.jpa.hibernate.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;

    /**
     * constructor por defecto es necesario para que JPA pueda instanciar la entidad
     * sin parámetros cuando consulta la base de datos
     * o realiza operaciones. Si no encuentra un constructor sin parámetros, se produce un error.
     */
    public Persona (){

    }
    public Persona(Long id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
