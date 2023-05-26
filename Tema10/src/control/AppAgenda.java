package control;

import java.io.File;
import java.io.IOException;
import vista.VistaAgenda;
import modelo.Agenda;
import modelo.Contacto;
import modelo.ES_Agenda;

public class AppAgenda {
	public static String ficheroAgenda = "agenda.csv";
	protected File fichero;
	protected Agenda agenda;
	protected VistaAgenda vista;
	
	public AppAgenda(String fileName) {
		fichero = new File(fileName);
		try {
			agenda = ES_Agenda.leeAgendaDeCsv(fichero);
		} catch (IOException e) {
			agenda = new Agenda();
		}
	} // constructor
	
	public void editarContacto(String nombre, String teléfono) {
		agenda.getContacto(nombre).setTeléfono(teléfono);
	} // editaContacto
	
	public Contacto borrarContacto(String nombre) {
		return agenda.borrarContacto(nombre);
	} // borrarContacto
	
	public Contacto añadirContacto(String nombre, String teléfono) {
		return agenda.addContacto(new Contacto(nombre,teléfono));
	} // añadirContacto
	
	
	
	public void rellenaVista() {
		vista.actualizaListado(agenda.getTodos());
	} // rellenaVista
	
	public boolean guardarFichero() {
		try {
			ES_Agenda.escribeAgendaEnCsv(fichero , agenda);
			return true;
		} catch (IOException e) {
			return false;
		}
	} // guardaFichero
	
	public void recargaFichero() {
		try {
			agenda = ES_Agenda.leeAgendaDeCsv(fichero);
		} catch (IOException e) {
			agenda = new Agenda();
		}
		vista.actualizaListado(agenda.getTodos());
	} // recargaFichero
	
	@Override
	public String toString() {
		return agenda.toCSV();
	} // toString
	
	public static void main(String[] args) {
		AppAgenda app = new AppAgenda(ficheroAgenda);
		app.vista = new VistaAgenda(app);
		app.rellenaVista();
	} // main

} // class
