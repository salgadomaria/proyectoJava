package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelos.Jornadas;
import modelos.Materiales;



public class MatJorDAO {
	private String url="jdbc:mysql://localhost:3306/esi";
	private String usuario="root";
	private String pass="pola1610";
	
	public void añadir(Jornadas x,Materiales a) {
		Connection c = null;
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql="INSERT INTO `esi`.`jornada_has_material`(`jornada_numero_Jornada`,`material_numero_Material`)VALUES(?,?);";
			PreparedStatement pstmt= c.prepareStatement(sql);
			pstmt.setInt(1,x.getNumJor());
			pstmt.setInt(2, a.getNumMaterial());
			pstmt.executeUpdate();
		} catch(SQLException d) {d.printStackTrace();} 
		finally {
		try {
			c.close();
		}
		catch(SQLException d){
			d.printStackTrace();
		}	
		
		
	}
}
}
