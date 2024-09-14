package com.jpa.hibernate.crud.repository;

import com.jpa.hibernate.crud.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository /*mapeamos como repositorio
la interface extiende de Jparepository (maneja repositorios JPA)
em los parámetros (generics) deben ir: la clase a persistir, tipo de dato de su ID.
 */
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

}
