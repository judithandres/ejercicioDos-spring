package com.ejercicio.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.spring.dao.DepartamentoDao;
import com.ejercicio.spring.entity.Departamento;


@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoDao departamentoDao;

	
	@Override
	public List<Departamento> findAll() {
		return (List<Departamento>) departamentoDao.findAll();
	}

	@Override
	public Departamento findById(Long id) {
		return  departamentoDao.findById(id).orElse(null);	
	}

	//MODIFICAR/INSERTAR DEPARTAMENTOS

	@Override
	public Departamento save(Departamento departamento) {
		return departamentoDao.save(departamento);
	}
	//BORRAR DEPARTAMENTOS

	@Override
	public void delete(Long id) {
		departamentoDao.deleteById(id);	
	}
}
