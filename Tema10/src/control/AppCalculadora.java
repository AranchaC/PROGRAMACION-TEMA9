package control;

import vista.VentanaCalculadora;

public class AppCalculadora {
	public static void main(String args[] ) {
		ControladorCalculadora controlador = new ControladorCalculadora();
		VentanaCalculadora vistaCalculadora = new VentanaCalculadora(controlador);
		controlador.registraVista(vistaCalculadora);
		vistaCalculadora.mostrar();
	}
}
