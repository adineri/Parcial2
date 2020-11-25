package com.mayab.calidad.doubles;

import java.util.HashMap;

public class fakeAlumnoDAOOracle implements DataAccessObject {

	
	public HashMap<String, Alumno> database = new HashMap<String, Alumno>();
	
	@Override
	public int addAlumno(Alumno a) {
		database.put(a.getId(), a);
		return 1;
	}

	@Override
	public int deleteAlumno(String id) {
		database.remove(id);
		return 1;
	}

	@Override
	public int updatePromedio(String id, float nuevoPromedio) {
		Alumno alumno = database.get(id);
		alumno.setPromedio(nuevoPromedio);
		return 1;
	}

	@Override
	public int getNumeroAlumnos() {
		return database.size();
	}

	@Override
	public int getAlumno(String id) {
		return 1;
	}

}
