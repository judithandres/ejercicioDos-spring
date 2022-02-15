package com.ejercicio.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ejercicio.spring.entity.Departamento;
import com.ejercicio.spring.service.DepartamentoService;


@RestController
@RequestMapping("/api")
public class DepartamentoController {

	@Autowired
	private DepartamentoService servicio;
	
	@GetMapping("/departamentos")
	public List<Departamento> departamento() {
		return servicio.findAll();
		
	}
	
	//----------------------------------------------------------------------------------------------------------------------------
		//READ DEPARTAMENTOS
		
		@GetMapping("/departamentos/{id}")
		public ResponseEntity<?> departamentoShow(@PathVariable Long id){
			Departamento departamento = null;
			Map<String, Object> response = new HashMap<>();
			
			try {
				departamento = servicio.findById(id);
			} catch (DataAccessException e) {
				response.put("Mensaje", "Error al realizar consulta a la base de datos :(");
				response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if (departamento == null) {
				response.put("Mensaje, ","El departamento con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
			
		}
		

		//INSERTAR CLIENTE
		
		@PostMapping("/departamentos")
		public ResponseEntity<?> saveDepartamento(@RequestBody Departamento departamento) {
			Departamento departamentoNew = null;
			Map<String, Object> response = new HashMap<>();
			
			try {
				departamentoNew = servicio.save(departamento);
			} catch (DataAccessException e) {
				response.put("Mensaje", "Error al realizar insert a la base de datos :(");
				response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("Mensaje","El cliente ha sido creado correctamente :D");
			response.put("Departamento", departamentoNew);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		}
		
		//----------------------------------------------------------------------------------------------------------------------------
		
		// DELETE COMPRAR
		
		@DeleteMapping("/departamentos/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<?> deleteDepartamento(@PathVariable  Long id) {
			Departamento departamentoBorrado= servicio.findById(id);
			Map<String, Object> response = new HashMap<>();
			
			try {	
				
				if (departamentoBorrado == null) {
					response.put("Mensaje, ","El departamento con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				}
				
				servicio.delete(id);
				
			}
				catch (DataAccessException e) {
				response.put("Mensaje", "Error al borrar en la base de datos :(");
				response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage())); 
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			
			response.put("Mensaje","El departamento ha sido borrado :D");
			response.put("Departamento", departamentoBorrado);
			 
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		
		//ACTUALIZAR DEPARTAMENTOS
		
		
				@PutMapping("/departamentos/{id}")
				public ResponseEntity<?> updateDepartamento(@RequestBody Departamento departamento, @PathVariable Long id) {
					
					Departamento departamentoUpdate = servicio.findById(id);
					Map<String, Object> response = new HashMap<>();
					
					try {
						
						departamentoUpdate.setNombre(departamento.getNombre());
						departamentoUpdate.setUbicacion(departamento.getUbicacion());
					
						
						servicio.save(departamentoUpdate);
						
					} catch (DataAccessException e) {
						response.put("Mensaje", "Error al actualizar en la base de datos :(");
						response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage())); 
						
						return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					}
					
					response.put("Mensaje","El departamento ha sido actualizado :D");
					response.put("Departamento", departamentoUpdate);
					
					return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
				}
				
}
