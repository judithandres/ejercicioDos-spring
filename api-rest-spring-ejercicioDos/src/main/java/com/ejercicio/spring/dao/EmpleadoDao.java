package com.ejercicio.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ejercicio.spring.entity.Empleado;

@Repository
public interface EmpleadoDao extends CrudRepository<Empleado, Long> {

}
