package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelos.Materiales;
import modelos.Propuesta;

public class ProMatDAO {
	private String url="jdbc:mysql://localhost:3306/esi";
	private String usuario="root";
	private String pass="pola1610";
	
	public void añadir(Propuesta x,int a) {
		Connection c = null;
		try {
			PropuestaDAO pro =new PropuestaDAO();
			MaterialDAO mat= new MaterialDAO();
			c=DriverManager.getConnection(url, usuario, pass);
			String sql="INSERT INTO `esi`.`propuesta_has_material`(`propuesta_id_propuesta`,`propuesta_numero_Propuesta`,`material_id_material`,`material_numero_Material`)VALUES(?,?,?,?);";
			PreparedStatement pstmt= c.prepareStatement(sql);
			pstmt.setInt(1,pro.consultaID());
			pstmt.setInt(2,x.getNumPropuesta());
			pstmt.setInt(3, a);
			pstmt.setInt(4, mat.consultaID());
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
