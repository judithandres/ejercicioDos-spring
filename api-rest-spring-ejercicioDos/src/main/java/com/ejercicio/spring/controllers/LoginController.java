package com.ejercicio.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ejercicio.spring.entity.Jefe;
import com.ejercicio.spring.entity.Login;
import com.ejercicio.spring.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService servicio;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Login login) {
		Login loginNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			loginNew = servicio.findDni(login.getDni(), login.getContraseña());
			
			if(loginNew !=null) {
				
				response.put("Mensaje","El login es correcto");
				response.put("Login", loginNew);
			} else {
				response.put("Mensaje","El login no es correcto");
				response.put("Login", loginNew);
			}
			
		} catch (DataAccessException e) {
			response.put("Mensaje", "");
			response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
}
