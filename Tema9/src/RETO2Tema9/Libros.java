package RETO2Tema9;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;



public class Libros {
	private static final String SELECT_QUERY_ASC = 
			"select * from libros order by titulo asc";
	private static final String INSERT_QUERY = 
			"insert into libros values (?,?,?,?,?,?)";
	private static final String DELETE_QUERY = 
			"delete from libros where isbn = ?";
	private static final String UPDATE_COPIAS_QUERY = 
			"update libros set copias = ? where isbn = ?";
	
	public void verCatalogoAsc() {
		try (Connection con = new UtilidadesLibros().getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_QUERY_ASC);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getInt("isbn")+", "+
						rs.getString("titulo")+", "+
						rs.getString("autor")+", "+
						rs.getString("editorial")+", "+
						rs.getInt("paginas")+", "+
						rs.getInt("copias")+", ");				
			}//while

		} catch (SQLException | IOException e) {
			System.err.println(e.getMessage());
		}
	}//verCatalogo
	
	public void insertLibro(int isbn, String titulo, String autor, 
			String editorial, int paginas, int copias ) {
		try (Connection con = new UtilidadesLibros().getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setInt(1, isbn);
			stmt.setString(2, titulo);
			stmt.setString(3, autor);
			stmt.setString(4, editorial);
			stmt.setInt(5, paginas);
			stmt.setInt(6, copias);
			stmt.executeUpdate();
			System.out.println("Libro añadido: "+ isbn + ", "+titulo);
		} catch (SQLException | IOException e) {
			System.err.println(e.getMessage());
		} 			
	}//insertLibro
	
	public void deleteLibro(int isbn) {
		try (Connection con = new UtilidadesLibros().getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETE_QUERY);
			stmt.setInt(1, isbn);
			stmt.executeUpdate();
			System.out.println("Libro borrado con isbn: "+isbn);
			} catch (SQLException | IOException e) {
				System.err.println(e.getMessage());
			}
		
	}//delete
	
	public void updateCopias (int copiasNew, int isbnNew) {
		try (Connection con = new UtilidadesLibros().getConnection()){
			PreparedStatement stmt = con.prepareStatement(UPDATE_COPIAS_QUERY);
			stmt.setInt(1, copiasNew);
			stmt.setInt(2, isbnNew);
			stmt.executeUpdate();
		} catch (SQLException | IOException e) {
			System.err.println(e.getMessage());
		}
	}//updateCopias

}
