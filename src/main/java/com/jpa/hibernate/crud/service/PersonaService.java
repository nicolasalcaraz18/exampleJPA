package com.jpa.hibernate.crud.service;

import com.jpa.hibernate.crud.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    @Autowired
    private IPersonaRepository iPersonaRepository;


}
