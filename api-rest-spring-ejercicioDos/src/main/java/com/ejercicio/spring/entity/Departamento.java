package com.ejercicio.spring.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="departamentos")
public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String ubicacion;
	
	//GETTERS Y SETTERS

	public long getId() {return id;}

	public void setId(long id) {this.id = id; }

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getUbicacion() {return ubicacion;}

	public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}
	
	
	
}
