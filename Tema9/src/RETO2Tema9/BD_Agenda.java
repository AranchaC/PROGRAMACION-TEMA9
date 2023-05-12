package RETO2Tema9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BD_Agenda  {
	private static final String SELECT_QUERY = 
			"select * from contactos";
	private static final String INSERT_QUERY = 
			"insert into contactos values (?,?)";
	private static final String DELETE_QUERY = 
			"delete from contactos where nombre = ? and telefono1 = ?";
	private static final String UPDATE_QUERY = 
			"update contactos set nombre = ?, telefono = ? where nombre = ?";

	public void listaContactos() {		
		try (Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/agenda","arancha2","arancha2*DAW")) {
			PreparedStatement stmt = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getString(1)+", "+
						rs.getInt(2));
			}//while			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}//leerContactos
	
	public void escribeContacto(Contacto contacto) {
		try (Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/agenda","arancha2","arancha2*DAW")) {
			PreparedStatement stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setString(1, contacto.getNombre());
			stmt.setString(2, contacto.getTelefono());
			stmt.executeUpdate();
			System.out.println("Contacto añadido: "+ contacto.getNombre()+
					", "+contacto.getTelefono());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}//escribeContacto
	
	public void borraContacto(Contacto contacto) {
		try (Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/agenda","arancha2","arancha2*DAW")) {
			PreparedStatement stmt = con.prepareStatement(DELETE_QUERY);
			stmt.setString(1, contacto.getNombre());
			stmt.setString(2, contacto.getTelefono());
			stmt.executeUpdate();
			System.out.println("Contacto borrado: "+ contacto.getNombre());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}//borraContacto

}
