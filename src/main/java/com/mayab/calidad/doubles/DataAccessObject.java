package com.mayab.calidad.doubles;

import java.util.HashMap;

public interface DataAccessObject {
	public int addAlumno(Alumno a);
	public int deleteAlumno(String id);
	public int updatePromedio(String id, float nuevoPromedio);
	public int getNumeroAlumnos();
	public int getAlumno(String id);
}
