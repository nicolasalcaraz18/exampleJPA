package com.jpa.hibernate.crud.controller;

import com.jpa.hibernate.crud.model.Persona;
import com.jpa.hibernate.crud.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {


    @Autowired //se inyecta la interfaz, ya qué en susodicha se realizara cualquier agregado o modificación
    private IPersonaService interPersona;

    /**
     * Endpoint para obtener todas las personas.
     * @return lista de personas
     */
    @GetMapping("/personas/traer")
    public List<Persona>getPersonas(){
        return this.interPersona.getPersonas(); // habian explicado en la facultad que devolver una lista como tal era un peligro.
    }

    /**
     * savePerson podría retornar un boolean, mediante eso modificar el String a retornar
     */
    @PostMapping("/personas/crear")
    public String createStudent (@RequestBody Persona person){
        this.interPersona.savePerson(person);
        return "Persona creada correctamente";
    }

    // lo mismo que el anterior, la forma de hacer que el mensaje sea dinamico.
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        this.interPersona.deletePerson(id);
        return "La persona fue eliminada correctamente";
    }


    /**
     *required: request param tiene la posibilidad de incluir algunas indicaciones para los parámetros
     * que se reciben en las solicitudes. Required permite identificar si un parámetro que recibimos es obligatorio(true) o no (false)
     * Recordar que Hibernate no permite cambiar el valor del identificador de una entidad una vez
     * que ha sido persisitida.
     */
    @PutMapping("personas/editar/{id_modificar}") // el endpoint capaz está mal.
    public Persona editPersona(@PathVariable Long id_modificar,
                               @RequestParam(required = false, name = "nombre")String nuevoNombre,
                               @RequestParam(required = false, name = "apellido")String nuevoApellido,
                               @RequestParam(required = false, name = "edad")int nuevaEdad) {
        this.interPersona.editPerson(id_modificar,nuevoNombre,nuevoApellido,nuevaEdad);

        return this.interPersona.findPerson(id_modificar);
    }

}
