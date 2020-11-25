package com.mayab.calidad.doubles;

public class fakeAlumnoDAOOracle implements DataAccessObject {

	@Override
	public int addAlumno(Alumno a) {
		return 1;
	}

	@Override
	public int deleteAlumno(String id) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int updatePromedio(String id, float nuevoPromedio) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getNumeroAlumnos() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getAlumno(String id) {
		// TODO Auto-generated method stub
		return 1;
	}

}
