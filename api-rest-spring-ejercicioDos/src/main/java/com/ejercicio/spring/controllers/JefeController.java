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
import com.ejercicio.spring.entity.Jefe;
import com.ejercicio.spring.service.JefeService;

@RestController
@RequestMapping("/api")
public class JefeController {

	@Autowired
	private JefeService servicio;
	
	@GetMapping("/jefes")
	public List<Jefe> jefe() {
		return servicio.findAll();
		
	}
	
	//----------------------------------------------------------------------------------------------------------------------------
	
		//READ EMPLEADOS
		
		@GetMapping("/jefes/{id}")
		public ResponseEntity<?> jefeShow(@PathVariable Long id){
			Jefe jefe = null;
			Map<String, Object> response = new HashMap<>();
			
			try {
				jefe = servicio.findById(id);
			} catch (DataAccessException e) {
				response.put("Mensaje", "Error al realizar consulta a la base de datos :(");
				response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if (jefe == null) {
				response.put("Mensaje, ","El jefe ID: ".concat(id.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Jefe>(jefe, HttpStatus.OK);	
		}
	
		//----------------------------------------------------------------------------------------------------------------------------
		
		
		//INSERTAR JEFES
		
		@PostMapping("/jefes")
		public ResponseEntity<?> saveJefe(@RequestBody Jefe jefe) {
			Jefe jefeNew = null;
			Map<String, Object> response = new HashMap<>();
			
			try {
				jefeNew = servicio.save(jefe);
			} catch (DataAccessException e) {
				response.put("Mensaje", "Error al realizar insert a la base de datos :(");
				response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("Mensaje","El jefe ha sido creado correctamente :D");
			response.put("Jefe", jefeNew);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		}
		
		
		//----------------------------------------------------------------------------------------------------------------------------
		
		// DELETE JEFES
		
		@DeleteMapping("/jefes/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<?> deleteJefe(@PathVariable  Long id) {
			Jefe jefeBorrado= servicio.findById(id);
			Map<String, Object> response = new HashMap<>();
			
			try {	
				
				if (jefeBorrado == null) {
					response.put("Mensaje, ","El jefe ID: ".concat(id.toString().concat(" no existe en la base de datos")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				}
				
				servicio.delete(id);
				
			}
				catch (DataAccessException e) {
				response.put("Mensaje", "Error al borrar en la base de datos :(");
				response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage())); 
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			response.put("Mensaje","El jefe ha sido borrado :D");
			response.put("Jefe", jefeBorrado);
			 
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		
		//----------------------------------------------------------------------------------------------------------------------------
		
		
		//ACTUALIZAR JEFES
		
		@PutMapping("/jefes/{id}")
		public ResponseEntity<?> updateJefe(@RequestBody Jefe jefe, @PathVariable Long id) {
			
			Jefe jefeUpdate = servicio.findById(id);
			Map<String, Object> response = new HashMap<>();
			
			try {
				jefeUpdate.setDni(jefe.getDni());
				jefeUpdate.setNombre(jefe.getNombre());
				jefeUpdate.setSalario(jefe.getSalario());
				jefeUpdate.setTelefono(jefe.getTelefono());
				jefeUpdate.setDepartamento(jefe.getDepartamento());
				
				servicio.save(jefeUpdate);
				
			} catch (DataAccessException e) {
				response.put("Mensaje", "Error al actualizar en la base de datos :(");
				response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage())); 
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("Mensaje","El jefe ha sido actualizado :D");
			response.put("Jefe", jefeUpdate);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		}
		
		
		
		
		
		
}
