package com.ejercicio.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ejercicio.spring.entity.Departamento;

@Repository
public interface DepartamentoDao extends CrudRepository<Departamento, Long>{

}
