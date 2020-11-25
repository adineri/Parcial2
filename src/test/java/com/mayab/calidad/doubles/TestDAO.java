package com.mayab.calidad.doubles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDAO {
	
	private static fakeAlumnoDAOOracle database;
	private static Alumno alumno;
	
	@Before
	public  void init() {
		database = new fakeAlumnoDAOOracle();
		alumno = new Alumno("Andres", 23, 9.9f, "andres.abimeri23@gmail.com", "00348164");
	}

	
	@Test
	public void testAdd() {
		int expectedResult = database.addAlumno(alumno);
		assertEquals(1, expectedResult);
	}
	
	@Test
	public void testDelete() {
		int expectedResult = database.deleteAlumno("00348164");
		assertEquals(1, expectedResult);
	}
	
	@Test
	public void testUpdate() {
		int expectedResult = database.updatePromedio("00348164", 9.9f);
		assertEquals(1, expectedResult);
	}
	
	@Test
	public void testGet() {
		int expectedResult = database.getAlumno("00348164");
		assertEquals(1, expectedResult);
	}

}
