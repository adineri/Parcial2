package com.mayab.calidad.dbunit;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;
import java.io.InputStream;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.junit.Before;
import org.junit.Test;

import com.mayab.calidad.doubles.Alumno;
import com.mayab.calidad.doubles.AlumnoDAOOracle;

public class TestAlumnoDAOOracle extends DBTestCase{


	public TestAlumnoDAOOracle() {
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "oracle.jdbc.driver.OracleDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:oracle:thin:@localhost:1522:xe");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "dbunit");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "dbunit");

	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		//InputStream xmlFile = getClass().getResourceAsStream("/resources/alumnoInit.xml");
		return new FlatXmlDataSetBuilder().build(new File("src/resources/alumnoInit.xml"));

	}

	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		IDatabaseConnection con = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(con, getDataSet());
		}
		finally {
			con.close();
		}
	}
	

	
	/*@Test
	public void testInsert() {
		Alumno alumno1 = new Alumno("Andres", 23, 9.5f, "andres@gmail.com", "2");
		AlumnoDAOOracle dao = new AlumnoDAOOracle();
		dao.addAlumno(alumno1);
		
		
		try{
			IDataSet databaseDataSet = getConnection().createDataSet();
			ITable actualTable = databaseDataSet.getTable("alumnos");
			//InputStream xmlFile =  getClass().getResourceAsStream("/resources/alumnoInit.xml");
			//IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(xmlFile);
			IDataSet expectedDataSet =  new FlatXmlDataSetBuilder().build(new File("src/resources/insert_results.xml"));
			ITable expectedTable = expectedDataSet.getTable("alumnos");
			// Assert actual database table match expected table
			Assertion.assertEquals(expectedTable, actualTable);
		}catch(Exception e){
			System.out.println(e.getMessage());

		}
	}*/

	@Test
	public void testInsertCount() {
		Alumno alumno1 = new Alumno("Andres", 23, 9.5f, "andres@gmail.com", "2");
		AlumnoDAOOracle dao = new AlumnoDAOOracle();
		try {
			IDatabaseConnection con = getConnection();
			int actualRows = con.getRowCount("alumnos");
			dao.addAlumno(alumno1);
			assertEquals(actualRows+1, con.getRowCount("alumnos"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		AlumnoDAOOracle dao = new AlumnoDAOOracle();
		try {
			

			IDatabaseConnection con = getConnection();
			int actualRows = con.getRowCount("alumnos");
			dao.deleteAlumno("1");
			assertEquals(actualRows-1, con.getRowCount("alumnos"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() {
		AlumnoDAOOracle dao = new AlumnoDAOOracle();
		try {
			IDatabaseConnection con = getConnection();
			dao.updatePromedio("1", 9.9f);
			
			IDataSet databaseDataSet = getConnection().createDataSet();
			ITable actualTable = databaseDataSet.getTable("alumnos");
			IDataSet expectedDataSet =  new FlatXmlDataSetBuilder().build(new File("src/resources/updateExpected.xml"));
			ITable expectedTable = expectedDataSet.getTable("alumnos");
			
			//ITable actualData = getConnection().createQueryTable("resultado", "SELECT * FROM alumno");
			Assertion.assertEquals(expectedTable, actualTable);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRetrieve() {
		AlumnoDAOOracle dao = new AlumnoDAOOracle();
		try {
			IDatabaseConnection con = getConnection();
			IDataSet databaseDataSet = getConnection().createDataSet();
			ITable actualTable = databaseDataSet.getTable("alumnos");
			ITable queryData = getConnection().createQueryTable("result_alumno", "SELECT * FROM alumnos");
			

			Assertion.assertEquals(queryData, actualTable);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

