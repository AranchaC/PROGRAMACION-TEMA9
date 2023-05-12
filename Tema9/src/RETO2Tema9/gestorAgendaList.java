package RETO2Tema9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gestorAgendaList {

		private static Scanner entrada = new Scanner(System.in);
		
		public static void main(String[] args) {
			
			BD_Agenda agenda = new BD_Agenda();

			int opcion = 0;
			while ( (opcion=menuPrincipal(true))!=0) {
				switch (opcion) {
				case 1:
					agenda.listaContactos();
					System.out.println();
					break;
				case 2:
					Contacto nuevo = Contacto.deTeclado(entrada);
					if (nuevo!=null) agenda.escribeContacto(nuevo);
					System.out.println();
					break;
				case 3:
					Contacto borrar = Contacto.deTeclado(entrada);
					agenda.borraContacto(borrar); 
					System.out.println();

				}	
			}

			System.out.println("Bye bye ...");
		} // main

		public static int menuPosicion(int maxPosicion) {
			int pos;
			do {
				pos = dameEntero("Dime posición entre 1 y " + maxPosicion + ": ");
			} while (pos<=0 || pos > maxPosicion);
			return pos;
		} // menúPosición

		public static int menuPrincipal(boolean opcionBorrar) {
			final int MAX_OPTION = 3;
			int opcion;
			String textoMenu = "MENÚ PRINCIPAL:\n"
					+ "0. SALIR\n"
					+ "1. LISTAR CONTACTOS ORDENADOS\n"
					+ "2. NUEVO CONTACTO\n";
			if (opcionBorrar) {
				textoMenu += "3. BORRAR CONTACTO\n";
			}
			// Pide opción hasta que de una válida:
			do {
				System.out.println(textoMenu);
				opcion = dameEntero("Entre opción: ");
			} while( opcion<0 || opcion > MAX_OPTION);
			return opcion;
		} // menúPrincipal

		public static int dameEntero(String prompt) {
			int opcion;
			String input;
			do {
				System.out.print(prompt);
				input = entrada.nextLine();
				try {
					opcion = Integer.parseInt(input);
				}
				catch(Exception e) {
					opcion = -1;
				}
			} while (opcion<0);
			return opcion;
		} // dameEntero

	

}
