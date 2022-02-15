package com.ejercicio.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.spring.dao.LoginDao;
import com.ejercicio.spring.entity.Login;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao service;
	
	@Override
	public Login findDni(String dni, String contraseña) {
		
		return service.findDni(dni, contraseña);
	}

}
