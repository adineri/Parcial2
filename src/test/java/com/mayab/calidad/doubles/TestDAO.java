package com.mayab.calidad.doubles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDAO {
	
	private static fakeAlumnoDAOOracle fake;
	private static Alumno alumno;
	
	@Before
	public  void init() {
		fake = new fakeAlumnoDAOOracle();
		alumno = new Alumno("Andres", 23, 9.9f, "andres.abimeri23@gmail.com", "00348164");
		fake.addAlumno(alumno);
	}

	
	@Test
	public void testAdd() {
		int after = fake.database.size();
		assertEquals(1, after);
	}
	
	@Test
	public void testDelete() {
		fake.deleteAlumno("00348164");
		int after = fake.database.size();
		assertEquals(0, after);
	}
	
	@Test
	public void testUpdate() {
		fake.updatePromedio("00348164", 7.0f);
		float promedio = fake.database.get("00348164").getPromedio();
		assertEquals(promedio, 7.0f, .2f);
	};
	
	@Test
	public void testGet() {
		int cantidad = fake.getNumeroAlumnos();
		assertEquals(1, cantidad);
	}
	
}
