package com.jpa.hibernate.crud.service;

import com.jpa.hibernate.crud.model.Persona;
import java.util.List; //no me lo importo automaticamente, lo tuve que hacer de forma manual.
public interface IPersonaService {

    List<Persona>getPersonas();

    void savePerson(Persona person);

    void deletePerson(Long id);

    Persona findPerson (Long id);

    void editPerson (Long idOriginal,String nuevoNombre,String nuevoApellido,
                     int nuevaEdad);

    void editPerson(Persona per);
}
