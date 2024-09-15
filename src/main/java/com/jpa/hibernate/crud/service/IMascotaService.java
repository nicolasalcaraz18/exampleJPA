package com.jpa.hibernate.crud.service;

import com.jpa.hibernate.crud.model.Mascota;
import java.util.List;

public interface IMascotaService {
    List<Mascota> getMascotas();

    void saveMascota(Mascota mascota);

    void deleteMascota(Long id);

    Mascota findMascota (Long id);

    void editMascota (Long idOriginal,String nuevoNombre,String nuevaEspecie, String nuevaRaza,
                     String nuevoColor);

}
