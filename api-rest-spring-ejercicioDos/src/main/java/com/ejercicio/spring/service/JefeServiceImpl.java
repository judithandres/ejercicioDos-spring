package com.ejercicio.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ejercicio.spring.dao.JefeDao;
import com.ejercicio.spring.entity.Jefe;

@Service
public class JefeServiceImpl implements JefeService{

	@Autowired
	private JefeDao jefeDao;
	
	//LEER JEFES

	@Override
	@Transactional(readOnly = true)
	public List<Jefe> findAll() {
		return (List<Jefe>) jefeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Jefe findById(Long id) {
		return  jefeDao.findById(id).orElse(null);
	}

	
	//MODIFICAR JEFES
		@Override
		public Jefe save(Jefe jefe) {
			return jefeDao.save(jefe);
		}
	
	//BORRAR JEFES
	@Override
	public void delete(Long id) {
		jefeDao.deleteById(id);
	}
}
