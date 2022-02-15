package com.ejercicio.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.spring.entity.Jefe;

@Repository
public interface JefeDao extends CrudRepository<Jefe, Long> {

}
