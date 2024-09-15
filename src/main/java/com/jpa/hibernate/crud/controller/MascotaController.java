package com.jpa.hibernate.crud.controller;

import com.jpa.hibernate.crud.model.Mascota;
import com.jpa.hibernate.crud.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService interMascota;

    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas(){
        return this.interMascota.getMascotas();
    }

    @PostMapping("/mascotas/crear")
    public String createMascota(@RequestBody Mascota mascota){
        this.interMascota.saveMascota(mascota);
        return "Mascota creada";
    }

    @DeleteMapping("/mascotas/borrar/{id}")
    public String deleteMascota(@PathVariable Long id){
        this.interMascota.deleteMascota(id);
        return "Mascota borrada";
    }

    @PutMapping("/mascotas/editar/{id}")
    public Mascota editMascota(@PathVariable Long id,
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                                @RequestParam(required = false, name = "especie")String nuevaEspecie,
                                @RequestParam(required = false, name = "raza")String nuevaRaza,
                               @RequestParam(required = false, name ="color")String nuevoColor){
        this.interMascota.editMascota(id,nuevoNombre,nuevaEspecie,nuevaRaza,nuevoColor);
        return this.interMascota.findMascota(id);
    }

}
