package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Propuesta;

public class PropuestaDAO {
	private String url="jdbc:mysql://localhost:3306/esi";
	private String usuario="root";
	private String pass="pola1610";
	
	public void añadir(Propuesta x) {
		Connection c = null;
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql="insert into esi.propuesta(`origen`,`autor`,`fecha`,`decripcion`,`motivacion`,`titulo`,`estado`,`motivo_cancelacion`,`Categoria_id_categoria1`,`numero_Propuesta`) Values(?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt= c.prepareStatement(sql);
			pstmt.setString(1,x.getOrigen());
			pstmt.setString(2,x.getAutor());
			pstmt.setString(3,x.getFecha());
			pstmt.setString(4,x.getDescripcion());
			pstmt.setString(5,x.getMotivo());
			pstmt.setString(6,x.getTitulo());
			pstmt.setString(7,"Pendiente");
			pstmt.setString(8,null);
			pstmt.setInt(9,x.getCategoria());
			pstmt.setInt(10, x.getNumPropuesta());
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
	
	public void actualizar(Propuesta x,int num) {
		Connection c = null;
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql="UPDATE `esi`.`propuesta`SET `origen` = ?,`autor` = ?,`fecha` =?,`decripcion` =?,`motivacion` = ?,`titulo` = ?,`estado` = ?,`motivo_cancelacion` = ?,`Categoria_id_categoria1` = ? WHERE `numero_Propuesta` = ?;";
			PreparedStatement pstmt= c.prepareStatement(sql);
			pstmt.setString(1,x.getOrigen());
			pstmt.setString(2,x.getAutor());
			pstmt.setString(3,x.getFecha());
			pstmt.setString(4,x.getDescripcion());
			pstmt.setString(5,x.getMotivo());
			pstmt.setString(6,x.getTitulo());
			pstmt.setString(7,x.getEstado());
			pstmt.setString(8,x.getMotivoCance());
			pstmt.setInt(9,x.getCategoria());
			pstmt.setInt(10,num);
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

	public void borrar(int num) {
		Connection c = null;
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql="DELETE FROM `esi`.`propuesta`WHERE `numero_Propuesta` = ?;";
			PreparedStatement pstmt= c.prepareStatement(sql);
			pstmt.setInt(1,num);
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
	
	public ArrayList<Propuesta> consultaPro(){
		Connection c =null;
		ArrayList<Propuesta> a = new ArrayList<Propuesta>();
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql ="SELECT `propuesta`.`id_propuesta`,`propuesta`.`origen`,`propuesta`.`autor`,`propuesta`.`fecha`,`propuesta`.`decripcion`,`propuesta`.`motivacion`,`propuesta`.`titulo`,`propuesta`.`estado`,`propuesta`.`motivo_cancelacion`,`propuesta`.`Categoria_id_categoria1`,`propuesta`.`numero_propuesta` FROM `esi`.`propuesta`;";
			Statement stmt=c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				/*origen,categoria,autor,fecha, titulo, descripcion, motivo, estado, numPropuesta*/
				Propuesta n = new Propuesta(rs.getString("origen"), rs.getString("autor"), rs.getString("fecha"), rs.getString("decripcion"), rs.getString("motivacion"), rs.getString("titulo"),rs.getString("estado"), rs.getInt("Categoria_id_categoria1"), rs.getInt("numero_Propuesta"));
				
				a.add(n);
			}
		} catch(SQLException d) {d.printStackTrace();} 
		try {
			c.close();
		}
		catch(SQLException d){
			d.printStackTrace();
		}	
		
		return a;
	}
	
	public int consultaID()
	{
		Connection c =null;
		int a = 0;
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql ="SELECT id_propuesta FROM `esi`.`propuesta`;";
			Statement stmt=c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
			a = rs.getInt("id_propuesta");
		}}
		catch(SQLException d) {d.printStackTrace();} 
		try {
			c.close();
		}
		catch(SQLException d){
			d.printStackTrace();
		}	
		return a;
	}
	
	
}

