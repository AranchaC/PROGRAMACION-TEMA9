package RETO1Tema9;


/**
 * @descrition Clase para probar la clase cafes
 * @author Laura
 * @date 9/4/2015
 * @version 1.0
 * @license GPLv3
 */

public class PruebaCafes {

	public static void main(String[] args) {
	
			
			Cafes miCafe = new Cafes();
			System.out.println("\nContenido de la tabla CAFES:");
			miCafe.verTabla();
			miCafe.actualizarVentasCafe("Colombian", 888);
			//miCafe.buscarCafe("Colombian");
			//miCafe.borrarCafe("Espresso");
	}
}
