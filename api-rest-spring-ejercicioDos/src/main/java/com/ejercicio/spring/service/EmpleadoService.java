package com.ejercicio.spring.service;

import java.util.List;
import com.ejercicio.spring.entity.Empleado;

public interface EmpleadoService {

	//GUARDAR EN ARRAYLIST EL EMPLEADO
		public List<Empleado> findAll();

		//BUSCAR ID
		public Empleado findById(Long id);
		
		//GUARDAR EMPLEADO PARA ACTUALIZAR/INSERTAR
		public Empleado save(Empleado empleado);
		
		//BORRAR EMPLEADO
		public void delete (Long id);

}
