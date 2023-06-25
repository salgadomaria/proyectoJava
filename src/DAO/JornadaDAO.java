package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Jornadas;

public class JornadaDAO {
	public class PropuestaDAO {
		private String url="jdbc:mysql://localhost:3306/esi";
		private String usuario="root";
		private String pass="pola1610";
		
		public void añadir(Jornadas x) {
			Connection c = null;
			try {
				c=DriverManager.getConnection(url, usuario, pass);
				String sql="insert into esi.jornada(`referente`,`objetivo`,`titulo`,`prioridad`,`numero_Jornada`) Values(?,?,?,?,?);";
				PreparedStatement pstmt= c.prepareStatement(sql);
				pstmt.setString(1,x.getReferente());
				pstmt.setString(2,x.getObjetivo());
				pstmt.setBoolean(3,x.isPrioridad());
				pstmt.setInt(4,x.getNumJor());
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
		
		public void actualizar(Jornadas x,int num) {
			Connection c = null;
			try {
				c=DriverManager.getConnection(url, usuario, pass);
				String sql="UPDATE `esi`.`jornada`SET `referente` = ?,`objetivo` = ?,`prioridad` =? WHERE `numero_Jornada` = ?;";
				PreparedStatement pstmt= c.prepareStatement(sql);
				pstmt.setString(1,x.getReferente());
				pstmt.setString(2,x.getObjetivo());
				pstmt.setBoolean(3,x.isPrioridad());
				pstmt.setInt(4,x.getNumJor());
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
				String sql="DELETE FROM `esi`.`jornada`WHERE `numero_Jornada` = ?;";
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
		
		public ArrayList<Jornadas> consultaPro(){
			Connection c =null;
			ArrayList<Jornadas> a = new ArrayList<Jornadas>();
			try {
				c=DriverManager.getConnection(url, usuario, pass);
				String sql ="SELECT `jornada`.`referente`,`jornada`.`objetivo`,`jornada`.`prioridad`,`jornada`.`numero_Jornada`FROM `esi`.`jornada`;";
				Statement stmt=c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				
				while(rs.next()) {
					/*origen,categoria,autor,fecha, titulo, descripcion, motivo, estado, numPropuesta*/
					Jornadas n = new Jornadas(rs.getString("refernte"), rs.getString("objetivo"),rs.getString("titulo"), rs.getBoolean("prioridad"), rs.getInt("numero_Jornada"));
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
		
		
		
	}
	}
