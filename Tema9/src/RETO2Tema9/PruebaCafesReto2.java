package RETO2Tema9;


/**
 * @descrition Clase para probar la clase cafes
 * @author Laura
 * @date 9/4/2015
 * @version 1.0
 * @license GPLv3
 */

public class PruebaCafesReto2 {

	public static void main(String[] args) {
	
			
			CafesReto2 miCafe = new CafesReto2();
			System.out.println("Contenido de la tabla CAFES:");
			miCafe.verTabla();
			//miCafe.actualizarVentasCafe("Colombian", 888);
			//miCafe.buscarCafe("Colombian");
			//miCafe.borrarCafe("Espresso");
			//miCafe.insertarCafe("Etiope", 150, 10, 0, 0);
			//miCafe.insertarCafe("Costa Rica", 101, 12, 0, 0);
			System.out.println();
			miCafe.buscarCafeProv(101);
	}
}
