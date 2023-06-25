package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Materiales;
import modelos.MaterialesIntitucionales;
import modelos.Propuesta;

public class MaterialDAO {
	private String url="jdbc:mysql://localhost:3306/esi";
	private String usuario="root";
	private String pass="pola1610";
	
	public void añadirint(MaterialesIntitucionales x) {
		Connection c = null;
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql="INSERT INTO `esi`.`material`(`titulo`,`descripcion`,`fuente`,`enlace`,`procedencia`,`prioridad`,`categoria_id_categoria`,`numero_Material`) VALUES(?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt= c.prepareStatement(sql);
			pstmt.setString(1, x.getTitulo());
			pstmt.setString(2, x.getDescripcion());
			pstmt.setString(3, x.getFuente());
			pstmt.setString(4, x.getEnlace());
			pstmt.setString(5, x.getProcedencia());
			pstmt.setInt(6, x.isPrioritario());
			pstmt.setInt(7, x.getCategoria());
			pstmt.setInt(8, x.getNumMaterial());
			pstmt.executeUpdate();
		} catch(SQLException d) {d.printStackTrace();} 
		finally {
		try {
			c.close();
		}
		catch(SQLException d){
			d.printStackTrace();
		}	}
		
		
	}
		
		public void añadir(Materiales x) {
			Connection c = null;
			try {
				c=DriverManager.getConnection(url, usuario, pass);
				String sql="INSERT INTO `esi`.`material`(`titulo`,`descripcion`,`fuente`,`enlace`,`prioridad`,`categoria_id_categoria`,`numero_Material`) VALUES(?,?,?,?,?,?,?);";
				PreparedStatement pstmt= c.prepareStatement(sql);
				pstmt.setString(1, x.getTitulo());
				pstmt.setString(2, x.getDescripcion());
				pstmt.setString(3, x.getFuente());
				pstmt.setString(4, x.getEnlace());
				pstmt.setInt(5, x.isPrioritario());
				pstmt.setInt(6, x.getCategoria());
				pstmt.setInt(7, x.getNumMaterial());
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
			String sql="DELETE FROM `esi`.`material`WHERE `numero_Material` = ?;";
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
	
	public void actualizarint(MaterialesIntitucionales x,int num) {
		Connection c = null;
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql="UPDATE `esi`.`material`SET ``titulo` = ?,`descripcion` = ?,`fuente` = ?,`enlace` = ?,`procedencia` = ?,`prioridad` = ?,`categoria_id_categoria` = ? WHERE `numero_Material` = ?";
			PreparedStatement pstmt= c.prepareStatement(sql);
			pstmt.setString(1, x.getTitulo());
			pstmt.setString(2, x.getDescripcion());
			pstmt.setString(3, x.getFuente());
			pstmt.setString(4, x.getEnlace());
			pstmt.setString(5, x.getProcedencia());
			pstmt.setInt(6, x.isPrioritario());
			pstmt.setInt(7, x.getCategoria());
			pstmt.setInt(8, x.getNumMaterial());
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
	public void actualizar(Materiales x,int num) {
		Connection c = null;
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql="UPDATE `esi`.`material`SET `titulo` = ?,`descripcion` = ?,`fuente` = ?,`enlace` = ?,`prioridad` = ?,`categoria_id_categoria` = ? WHERE `numero_Material` = ?";
			PreparedStatement pstmt= c.prepareStatement(sql);
			pstmt.setString(1, x.getTitulo());
			pstmt.setString(2, x.getDescripcion());
			pstmt.setString(3, x.getFuente());
			pstmt.setString(4, x.getEnlace());
			pstmt.setInt(5, x.isPrioritario());
			pstmt.setInt(6, x.getCategoria());
			pstmt.setInt(7, x.getNumMaterial());
			pstmt.executeUpdate();
		} catch(SQLException d) {d.printStackTrace();} 
		finally {
		try {
			c.close();
		}
		catch(SQLException d){
			d.printStackTrace();
		}	
		}}
	
	public ArrayList<Materiales> consultaPro(){
		Connection c =null;
		ArrayList<Materiales> a = new ArrayList<Materiales>();
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql = "SELECT `material`.`id_material`,`material`.`titulo`, `material`.`descripcion`,`material`.`fuente`,`material`.`enlace`,`material`.`procedencia`,`material`.`prioridad`,`material`.`categoria_id_categoria`,`material`.`numero_Material`FROM `esi`.`material`;";
			Statement stmt=c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				Materiales n = new Materiales();
				n.setTitulo(rs.getString("titulo"));
				n.setDescripcion(rs.getString("descripcion"));;
				n.setFuente(rs.getString("fuente"));;
				n.setEnlace(rs.getString("enlace"));
				n.setPrioritario(rs.getInt("prioridad"));
				n.setCategoria(rs.getInt("categoria_id_categoria"));
				n.setNumMaterial(rs.getInt("numero_Material"));
				a.add(n);
			}
		} catch(SQLException d) {d.printStackTrace();} 
		finally {
		try {
			c.close();
		}
		catch(SQLException d){
			d.printStackTrace();
		}	
		}
		return a;
	}
	public int consultaID()
	{
		Connection c =null;
		int a = 0;
		try {
			c=DriverManager.getConnection(url, usuario, pass);
			String sql ="SELECT id_material FROM `esi`.`material`;";
			Statement stmt=c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
			a = rs.getInt("id_material");
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
