package com.jpa.hibernate.crud.service;

import com.jpa.hibernate.crud.model.Persona;
import com.jpa.hibernate.crud.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements  IPersonaService{

    @Autowired
    private IPersonaRepository iPersonaRepository;


    @Override
    public List<Persona> getPersonas() {
        return iPersonaRepository.findAll();
    }

    @Override
    public void savePerson(Persona person) {
        this.iPersonaRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        this.iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPerson(Long id) {
        return this.iPersonaRepository.findById(id).orElse(null);
    }

    @Override
    public void editPerson(Long idOriginal, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        Persona persona = this.findPerson(idOriginal);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setEdad(nuevaEdad);

        this.savePerson(persona);
    }
}
