import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PruebaBotones {
	private static JFrame ventana;

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Prueba colorines");
		ventana.getContentPane().setLayout(new FlowLayout());
		JButton boton1 = new JButton("Verde");
		JButton boton2 = new JButton("Azul");
		JButton boton3 = new JButton("Rojo");
		ventana.add(boton1);
		ventana.add(boton2);
		ventana.add(boton3);
		ventana.setLocation(500, 250);
		ActionListener actuador = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cambiaColor(e.getActionCommand());				
				}};
				
		boton1.addActionListener(actuador);
		boton2.addActionListener(actuador);
		boton3.addActionListener(actuador);
		
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

	protected static void cambiaColor(String textoColor) {
		Color color = Color.black;
		switch(textoColor.toLowerCase()) {
		case "Verde" : color = Color.GREEN;	break;
		case "azul" : color = Color.BLUE; break;
		case "rojo" : color = Color.RED; break;
		}
		ventana.getContentPane().setBackground(color);
		
	}

}
