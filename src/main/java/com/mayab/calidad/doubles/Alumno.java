package com.mayab.calidad.doubles;

public class Alumno {
	
	private String id;
	private String nombre;
	private int edad;
	private float promedio;
	private String email;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Alumno(String nombre, int edad, float calificacion, String email, String id) {
		this.nombre = nombre;
		this.edad = edad;
		this.promedio = calificacion;
		this.email = email;
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPromedio() {
		return promedio;
	}
	public void setPromedio(float calificacion) {
		this.promedio = calificacion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
