package com.mayab.calidad.doubles;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AlumnoDAOOracle implements DataAccessObject {

	public AlumnoDAOOracle() {
	}
	
	
	
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","dbunit","dbunit");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	 }  



	@Override
	public int addAlumno(Alumno a) {
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into alumnos (id, nombre, promedio, email, edad) values (?,?,?,?,?)");
			ps.setString(1, a.getId());
			ps.setString(2, a.getNombre());
			ps.setFloat(3, a.getPromedio());
			ps.setString(4, a.getEmail());
			ps.setInt(5, a.getEdad());
			int status = ps.executeUpdate();
			con.close();
			return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int deleteAlumno(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM alumnos WHERE id = ?");
			ps.setString(1, id);
			int status = ps.executeUpdate();
			con.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updatePromedio(String id, float nuevoPromedio) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE alumnos SET promedio = ? WHERE id = ?");
			ps.setFloat(1, nuevoPromedio);
			ps.setString(2, id);
			int status = ps.executeUpdate();
			con.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getNumeroAlumnos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAlumno(String id) {
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM alumnos where id = ?");
			ps.setString(1, id);
			int status = ps.executeUpdate();
			con.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
