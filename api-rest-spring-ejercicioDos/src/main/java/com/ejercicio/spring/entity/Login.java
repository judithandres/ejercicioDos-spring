package com.ejercicio.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login implements Serializable {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, unique=true)
	private String dni;
	
	@Column(nullable=false, unique=true)
	private String contraseña;

	
	
	//GETTERS Y SETTERS
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public String getDni() {return dni;}
	public void setDni(String dni) {this.dni = dni;}
	public String getContraseña() {return contraseña;}
	public void setContraseña(String contraseña) {this.contraseña = contraseña;}
	
	
	private static final long serialVersionUID = 1L;

	
	
}
