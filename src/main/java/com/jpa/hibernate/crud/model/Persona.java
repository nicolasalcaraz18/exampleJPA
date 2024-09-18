package com.jpa.hibernate.crud.model;

import ch.qos.logback.core.util.COWArrayList;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany
    private List<Mascota> listaMascotas; // recordar instanciar la lista (arraylist)

    /**
     * constructor por defecto es necesario para que JPA pueda instanciar la entidad
     * sin parámetros cuando consulta la base de datos
     * o realiza operaciones. Si no encuentra un constructor sin parámetros, se produce un error.
     */
    public Persona (){

    }
    public Persona(Long id, String nombre, String apellido, int edad, Mascota mascota,List<Mascota>listaMascotas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.listaMascotas = listaMascotas;
    }
}
