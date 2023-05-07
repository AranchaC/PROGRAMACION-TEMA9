package RETO1Tema9;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *  @descrition Clase que prueba la conexi�n a una BD utilizando la clase Driver Manager
 *	@author Laura
 *  @date 8/4/2015
 *  @version 1.0
 *  @license GPLv3
 */

public class PruebaUtilidades {
	
	 /* TODO: Para que funcione hay que instalar el driver mysql
	  * 1. Ejecutar el .msi que hay en la carpeta software
	  * 2. El .jar del driver se ubica en C:\Program Files (x86)\MySQL\MySQL Connector J
	  * 3. Ir a propiedades del proyecto --> Java Build Path --> libaries --> Add External Jar --> Incluir el .jar anterior
	  * 4. Al ejecutar en Run as --> Run Configuration --> arguments --> Tema3\tema3\transparencias\mysql-properties.xml
	  * 5. En mysql-properties.xml ir cambiando el nombre de la BD en los ejercicios seg�n la que queramos usar
	  */
	
	final static String RUTA_XML = "mysql-properties.xml";
	 public static void main(String[] args) {
		    Utilidades myConexionDriverManager;
		    Connection myConnection = null;
		    File fich = new File(RUTA_XML);
		    
		    if (fich.exists()) {
			    try {
			    	System.out.println("Reading properties file " + RUTA_XML);
			        myConexionDriverManager = new Utilidades(RUTA_XML);
				    myConnection = myConexionDriverManager.getConnection();   

			    } catch (SQLException e) {
			    	e.printStackTrace(System.err);
			    } catch (Exception e) {
			      e.printStackTrace(System.err);
			    } finally {
			      Utilidades.closeConnection(myConnection);
			    }

		    } else {
		    	System.out.println();
		      /*try {
		        System.out.println("Reading properties file " + args[0]);
		        myConexionDriverManager = new Utilidades(args[0]);
		      } catch (Exception e) {
		        System.err.println("Problem reading properties file " + args[0]);
		        e.printStackTrace();
		        return;
		      }*/
		    }//else


		  }

}


