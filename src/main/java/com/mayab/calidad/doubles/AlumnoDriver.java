package com.mayab.calidad.doubles;

public class AlumnoDriver {

	public static void main(String[] args) {
		AlumnoDAOOracle driver = new AlumnoDAOOracle();
		Alumno alumno1 = new Alumno("Andres", 23, 9.5f, "andres@gmail.com", "20");
		driver.addAlumno(alumno1);
	}

}
