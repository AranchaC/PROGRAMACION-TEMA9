package vista;
import javax.swing.*;
import javax.swing.border.LineBorder;

import control.ControladorCalculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;

public class VentanaCalculadora extends JFrame {
		protected final static int ANCHO_DISPLAY = 20;
		protected final static int NUM_BOTONES = 17;
		protected JPanel panel;
		protected JTextField display;
		protected JButton[] botones;
		protected ControladorCalculadora controlador;
		
		
		public String getDisplay() {
			return display.getText();
		}
		
		public void setDisplay(String texto) {
			display.setText(texto);
		}
		
		public VentanaCalculadora(ControladorCalculadora controlador)
		{
			this.controlador = controlador;
			this.setBackground(Color.white);
			this.setTitle("Calculadora");
			//indico la posición para colocar la calculadora en el centro.
			this.setLocation(500,250);
			panel = new JPanel();
			
			// TO-DO: añadir botones de resta, división y multiplicación
			// TO-DO: probar otro layout, quitando los setBounds y viendo posibilidades
			panel.setLayout(new FlowLayout());
			add(panel);
			//setLayout(new GridLayout(5,3));
			panel.setLayout(new BorderLayout());
			JPanel panelBotones = new JPanel();
			panel.add(panelBotones, BorderLayout.CENTER);
			
			display=new JTextField("",ANCHO_DISPLAY);
			
			botones = new JButton[NUM_BOTONES];
			
			for (int i=0; i<10; i++) {
				botones[i] = new JButton(i + "");
			}
			botones[10]=new JButton(".");
			botones[11]=new JButton("C");
				//pongo color al fondo y a la C:
				botones[11].setBackground(Color.red);
				botones[11].setForeground(Color.white);
				//botones[11].
			botones[12] = new JButton("=");
			botones[13]=new JButton("+");
			//añado botones -, *, /
			botones[14] = new JButton("-");
			botones[15] = new JButton("*");
			botones[16] = new JButton("/");

			
			//display.setBounds(50,20,205,50);
			//añado margen interno al campo de texto
			display.setMargin(new Insets(10,10,10,10));


			/*
			botones[1].setBounds(10,200,50,50);
			botones[2].setBounds(60,200,50,50);
			botones[3].setBounds(110,200,50,50);
			botones[13].setBounds(160,200,50,50);

			botones[4].setBounds(10,150,50,50);
			botones[5].setBounds(60,150,50,50);
			botones[6].setBounds(110,150,50,50);

			botones[7].setBounds(10,100,50,50);
			botones[8].setBounds(60,100,50,50);
			botones[9].setBounds(110,100,50,50);
			
			botones[0].setBounds(10,250,50,50);
			botones[10].setBounds(60,250,50,50);
			botones[11].setBounds(110,250,50,50);
			botones[12].setBounds(160,250,50,50);
			*/	
			
			panel.add(display, BorderLayout.NORTH);
			panel.setLocation(20, 15);
			for (JButton botón : botones) {
				panelBotones.add(botón);
				botón.addActionListener(controlador);
			}
			
			this.pack();
			
			
		} // constructor
		
		public void mostrar() {
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(300,400);
		}
		
		
} // class
	
