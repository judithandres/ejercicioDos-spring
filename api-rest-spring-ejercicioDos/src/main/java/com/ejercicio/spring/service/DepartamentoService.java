package com.ejercicio.spring.service;

import java.util.List;

import com.ejercicio.spring.entity.Departamento;

public interface DepartamentoService {

	//GUARDAR EN ARRAYLIST EL DEPARTAMENTO
	public List<Departamento> findAll();
	
	//BUSCAR ID
	public Departamento findById(Long id);
	
	//GUARDAR DEPARTAMENTO PARA ACTUALIZAR/INSERTAR
	public Departamento save(Departamento departamento);
	
	//BORAR ARTICULO
		public void delete (Long id);
}
