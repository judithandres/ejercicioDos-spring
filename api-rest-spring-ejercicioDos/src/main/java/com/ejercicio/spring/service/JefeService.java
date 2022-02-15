package com.ejercicio.spring.service;

import java.util.List;
import com.ejercicio.spring.entity.Jefe;

public interface JefeService {

	//GUARDAR EN ARRAYLIST EL JEFE
	public List<Jefe> findAll();
	
	//BUSCAR ID
	public Jefe findById(Long id);
		
	//GUARDAR JEFE PARA ACTUALIZAR
	public Jefe save(Jefe empleado);
	
	//BORRAR JEFE
	public void delete (Long id);
}
