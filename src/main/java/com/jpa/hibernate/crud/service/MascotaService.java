package com.jpa.hibernate.crud.service;

import com.jpa.hibernate.crud.model.Mascota;
import com.jpa.hibernate.crud.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository iMascotaRepository;

    @Override
    public List<Mascota> getMascotas() {
        return this.iMascotaRepository.findAll();
    }

    @Override
    public void saveMascota(Mascota mascota) {
        this.iMascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {
        this.iMascotaRepository.deleteById(id);
    }

    @Override
    public Mascota findMascota(Long id) {
        return this.iMascotaRepository.findById(id).orElse(null);
    }

    @Override
    public void editMascota(Long idOriginal, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        Mascota m = this.findMascota(idOriginal);
        m.setNombre(nuevoNombre);
        m.setEspecie(nuevaEspecie);
        m.setRaza(nuevaRaza);
        m.setColor(nuevoColor);

        this.saveMascota(m); // recordar guardar la instancia.
    }

}
