package RETO1Tema9;
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

public class Cafes {

	// Consultas a realizar en BD
	private static final String SELECT_CAFES_QUERY = "select CAF_NOMBRE, PROV_ID, PRECIO, VENTAS, TOTAL from CAFES";
	// En una consulta parametrizada ponemos interrogaciones en los valores que
	// a�n desconocemos
	private static final String UPDATE_VENTAS_CAFE = "update CAFES set VENTAS = ? where CAF_NOMBRE = ?";
	//para buscar
	private static final String SEARCH_CAFE = "select * from CAFES where CAF_NOMBRE = ?";
	//consulta para borrar
	private static final String DELETE_CAFE = "delete from CAFES where CAF_NOMBRE = ?";
	//para insertar
	private static final String INSERT_CAFE = "insert into CAFES VALUES (?, ?, ?, ?, ?)";
	
	/**
	 * Metodo que muestra por pantalla los datos de la tabla cafes
	 * 
	 * @param con
	 * @throws SQLException
	 */
	public void verTabla() {
		/* Conexi�n a la Base de Datos */
		Connection con = null;
		/* Sentencia sql */
		Statement stmt = null;
		/* Conjunto de Resultados a obtener de la sentencia sql */
		ResultSet rs = null;
		try {
			con = new Utilidades1().getConnection();
			// Creaci�n de la sentencia
			stmt = con.createStatement();
			// Ejecuci�n de la consulta y obtenci�n de resultados en un
			// ResultSet
			rs = stmt.executeQuery(SELECT_CAFES_QUERY);

			// Recuperaci�n de los datos del ResultSet
			while (rs.next()) {
				String coffeeName = rs.getString("CAF_NOMBRE");
				int supplierID = rs.getInt("PROV_ID");
				float PRECIO = rs.getFloat("PRECIO");
				int VENTAS = rs.getInt("VENTAS");
				int total = rs.getInt("TOTAL");
				System.out.println(coffeeName + ", " + supplierID + ", "
						+ PRECIO + ", " + VENTAS + ", " + total);
			}

		} catch (IOException e) {
			// Error al leer propiedades
			// En una aplicaci�n real, escribo en el log y delego
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			// En una aplicaci�n real, escribo en el log y delego
			System.err.println(sqle.getMessage());
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades1.closeConnection(con);
				}
			} catch (SQLException sqle) {
				// En una aplicaci�n real, escribo en el log, no delego porque
				// es error al liberar recursos
			}
		}

	}

	/**
	 * M�todo que actualiza las ventas de un caf� con un PreparedStatement
	 * 
	 * @param cafe
	 * @param ventas
	 */
	public void actualizarVentasCafe(String cafe, int ventas) {

		/* Conexi�n a la Base de Datos */
		Connection con = null;
		/* Sentencia Preparada sql */
		PreparedStatement stmt = null;
		
		try {
			con = new Utilidades1().getConnection();

			// Creamos un objeto PreparedStatement pas�ndole nuestra consulta
			// parametrizada
			stmt = con.prepareStatement(UPDATE_VENTAS_CAFE);
			// Le damos valoes a los par�metros de la consulta, indicando n�mero
			// de par�metro
			// Y utilizando un m�todo adecuado seg�n el tipo de datos
			stmt.setFloat(1, ventas);
			stmt.setString(2, cafe);

			// m�todo executeUpdate para ejecutar inserciones, actualizaciones y
			// borrado de datos
			stmt.executeUpdate();
			

		} catch (IOException e) {
			// Error al leer propiedades
			// En una aplicaci�n real, escribo en el log y delego
			System.err.println(e.getMessage());
			
		} catch (SQLException sqle) {
			// En una aplicaci�n real, escribo en el log y delego
			System.err.println(sqle.getMessage());
			
		} finally {
			try {
				// Liberamos todos los recursos pase lo que pase

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					Utilidades1.closeConnection(con);
				}
			} catch (SQLException sqle) {
				// En una aplicaci�n real, escribo en el log, no delego porque
				// es error al liberar recursos
			}
		}//finally
	}//actualizarVentas
	
	public void buscarCafe(String cafe) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = new Utilidades1().getConnection();
			stmt = con.prepareStatement(SEARCH_CAFE);
			stmt.setString(1, cafe);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String coffeeName = rs.getString("CAF_NOMBRE");
				int supplierID = rs.getInt("PROV_ID");
				float PRECIO = rs.getFloat("PRECIO");
				int VENTAS = rs.getInt("VENTAS");
				int total = rs.getInt("TOTAL");
				System.out.println("Encontrado: "+coffeeName + ", " +
				supplierID + ", "+ PRECIO + ", " + VENTAS + ", " + total);
			}//if
		}catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		} 
	}//buscarCafe
	
	public void borrarCafe (String cafe) {
		Connection con = null;
		PreparedStatement stmt = null;
		//ResultSet rs = null;
		try {
			con = new Utilidades1().getConnection();
			stmt = con.prepareStatement(DELETE_CAFE);
			//rs = stmt.executeQuery(cafe);
			//String coffeeName = rs.getString("CAF_NOMBRE");
			stmt.setString(1, cafe);
			stmt.executeUpdate();
			System.out.println("Café borrado: "+cafe);;
		}catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		} 
	}//buscarCafe
	
	public void insertarCafe (String nombre, int id, float precio, 
			int ventas, int total) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = new Utilidades1().getConnection();
			stmt = con.prepareStatement(INSERT_CAFE);
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
			System.err.println(sqle.getMessage());
		} 
	}//insertarCafe
}
