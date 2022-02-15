package com.ejercicio.spring.service;

import com.ejercicio.spring.entity.Login;

public interface LoginService {

	public Login findDni(String dni, String contraseña);
	
	
}
