package com.jpa.hibernate.crud.repository;

import com.jpa.hibernate.crud.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long>{

}
