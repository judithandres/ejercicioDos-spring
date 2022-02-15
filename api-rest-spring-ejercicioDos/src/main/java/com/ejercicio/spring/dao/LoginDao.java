package com.ejercicio.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ejercicio.spring.entity.Login;


@Repository
public interface LoginDao extends CrudRepository<Login, Long> {

	@Query("SELECT u FROM Login u WHERE u.dni = ?1 and u.contraseña = ?2")
	public Login findDni(String dni, String contraseña);
	
	
	
	
	
}
