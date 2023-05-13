package RETO2Tema9;
//USUARIO SQL CLASE: arancha2
//pass sql clase: arancha2*DAW

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @descrition
 * @author Laura
 * @date 9/4/2015
 * @version 1.0
 * @license GPLv3
 */

public class CafesReto2 {
	private static final String SELECT_CAFES_QUERY = 
			"select CAF_NOMBRE, PROV_ID, PRECIO, VENTAS, TOTAL from CAFES";
	private static final String UPDATE_VENTAS_CAFE = 
			"update CAFES set VENTAS = ? where CAF_NOMBRE = ?";
	private static final String SEARCH_CAFE = 
			"select * from CAFES where CAF_NOMBRE = ?";
	private static final String DELETE_CAFE = 
			"delete from CAFES where CAF_NOMBRE = ?";
	private static final String INSERT_CAFE = 
			"insert into CAFES VALUES (?, ?, ?, ?, ?)";
	private static final String SEARCH_CAFE_PROV =
			"select * from CAFES, proveedores where CAFES.PROV_ID= ?"
			+ " and CAFES.PROV_ID=proveedores.PROV_ID";
	private static final String SEARCH_PROV =
			"select * from CAFES where PROV_ID= ?";
	
	/**
	 * Metodo que muestra por pantalla los datos de la tabla cafes
	 * 
	 * @param con
	 * @throws SQLException
	 */
	public void verTabla() {
		try (Connection con = new Utilidades1().getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_CAFES_QUERY);
			//Para consulta de tabla falsa para ej de la pag 14.
			//PreparedStatement stmt = con.prepareStatement("select * from CAFECITOS");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getString("CAF_NOMBRE")+", "+
						rs.getInt("PROV_ID")+", "+
						rs.getFloat("PRECIO")+", "+
						rs.getInt("VENTAS")+", "+
						rs.getInt("TOTAL"));
			}//while

		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
		} 
	}//verTabla

	public void actualizarVentasCafe(String cafe, int ventas) {
		try (Connection con = new Utilidades1().getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE_VENTAS_CAFE);
			stmt.setFloat(1, ventas);
			stmt.setString(2, cafe);
			stmt.executeUpdate();
		} catch (IOException e) {
			System.err.println(e.getMessage());			
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);			
		} 
	}//actualizarVentas
	
	public void buscarCafe(String cafe) {
		try (Connection con = new Utilidades1().getConnection()){
			PreparedStatement stmt = con.prepareStatement(SEARCH_CAFE);
			stmt.setString(1, cafe);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("Café encontrado: "+
						rs.getString("CAF_NOMBRE")+", "+
						rs.getInt("PROV_ID")+", "+
						rs.getFloat("PRECIO")+", "+
						rs.getInt("VENTAS")+", "+
						rs.getInt("TOTAL")+", ");
			}//if
			else {
				System.out.println("No se encuentra el café: "+ cafe);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
		} 
	}//buscarCafes
	
	public void borrarCafe (String cafe) {
		try (Connection con = new Utilidades1().getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETE_CAFE);
			stmt.setString(1, cafe);
			stmt.executeUpdate();
			System.out.println("Café borrado: "+cafe);
		}catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
		} 
	}//borrarCafe
	
	public void insertarCafe (String nombre, int id, float precio, 
			int ventas, int total) {
		try (Connection con = new Utilidades1().getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT_CAFE);
			stmt.setString(1, nombre);
			stmt.setInt(2, id);
			stmt.setFloat(3, precio);
			stmt.setInt(4, ventas);
			stmt.setInt(5, total);
			stmt.executeUpdate();
			System.out.println("Café añadido: "+nombre);
		}catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
		} 
	}//insertarCafe
	
	public void buscarCafeProv(int provId) {
		try (Connection con = new Utilidades1().getConnection()){
			PreparedStatement stmt = con.prepareStatement(SEARCH_PROV);
			stmt.setInt(1, provId);	
			ResultSet rs = stmt.executeQuery();
						
			if ( rs.next() ) {
				System.out.println("- Cafés del proeveedor "+ provId+": \n"+
						rs.getString("CAF_NOMBRE")+", "+
						rs.getInt("PROV_ID")+", "+
						rs.getFloat("PRECIO")+", "+
						rs.getInt("VENTAS")+", "+
						rs.getInt("TOTAL"));
			}//if
			else {
				System.out.println("No se encuentra prov "+provId);
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			Utilidades1.printSQLException(sqle);
		} 
	}//buscarCafes
	
	/*"- Datos del proveedor "+provId+": \n"+
	rs.getInt("PROV_ID")+", "+
	rs.getString("PROV_NOMBRE")+", "+
	rs.getString("CALLE")+", "+
	rs.getString("CIUDAD")+", "+
	rs.getString("PAIS")+", "+
	rs.getInt("CP"));*/
}
