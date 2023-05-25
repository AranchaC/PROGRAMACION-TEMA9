package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Modal_V1 extends JFrame {
	private static final long serialVersionUID = -2303722472169092794L;
	private static final int NUM_BOT = 6;
	private JButton[] botones;
	private final static String[] textoBotones = {
			"Mensaje de error",
			"Mensaje informativo",
			"¿Quieres salir de la aplicación?",
			"Lo aceptas?",
			"Quieres salir (SI/NO)?",
			"Selección múltiple"
	};
	
	public Modal_V1() {	
		super("Ventanas modales");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,500);
		//indico la posición
		this.setLocation(500,250);
		iniciar();
	}
	
	private void iniciar() {
		GridLayout gl= new GridLayout(NUM_BOT,1);
		Container cont= getContentPane();
		cont.setLayout(gl);
		
		botones= new JButton[NUM_BOT];
		
		for(int i=0;i<NUM_BOT;i++) {
			botones[i]= new JButton(""+(i+1));
			botones[i].setBackground(Color.cyan);
			botones[i].addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							modal(e.getActionCommand());
						}	
					}
			);
			cont.add(botones[i]);	
		}//for		
	} // iniciar
	
	private void modal(String comm) {
		switch(comm) {
			case "1": 
				JOptionPane.showMessageDialog(
						this,// La ventana padre.
						textoBotones[0],//El mensaje.
						"Error", // Título de la ventana de diálogo.
						JOptionPane.ERROR_MESSAGE// El tipo de mensaje							
				);
				break;
			case "2":
				JOptionPane.showMessageDialog(
						this,
						textoBotones[1], 
						"Info", 
						JOptionPane.INFORMATION_MESSAGE);
					 // JOptionPane.WARNING_MESSAGE);
				 	 // JOptionPane.PLAIN_MESSAGE);
				break;
			case "3":
				int op1 = 
				JOptionPane.showConfirmDialog(
						this, 
						textoBotones[2], 
						"Aviso",
						JOptionPane.YES_NO_OPTION, //Configuración del mensaje
						JOptionPane.INFORMATION_MESSAGE);
				
					switch(op1) {
						case JOptionPane.YES_OPTION: 
							System.exit(0); // tratar SI
						case JOptionPane.NO_OPTION:
							break;
							// no hace nada
						case JOptionPane.CLOSED_OPTION:
							 break;
							 // no hace nada
						default: break; // esta opción nunca debería alcanzarse
				}
				break;
			case "4":
				int op2 = JOptionPane.showConfirmDialog(
						this,
						textoBotones[3],
						"Aviso",
						JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.WARNING_MESSAGE);
				switch(op2) {
				case JOptionPane.YES_OPTION: 
					System.exit(0); // tratar SI
				case JOptionPane.NO_OPTION:
					break;
					// no hace nada
				case JOptionPane.CLOSED_OPTION:
					 break;
					 // no hace nada
				case JOptionPane.CANCEL_OPTION:
					break;
				default: break; // esta opci�n nunca deber�a alcanzarse
				}
				break;	
			case "5":
				String resp = JOptionPane.showInputDialog(
						this,
						textoBotones[4],
						"Petición", 
						JOptionPane.QUESTION_MESSAGE
						);
				if (resp!=null)
					switch(resp.toLowerCase()) {
						case "SI": 
							System.exit(0);
						default: break; //volver	
					}
				break;
			case "6":
				String[] nuevosBotones = {"Boton A", "Boton B", "Boton C", "Boton D"};
				int res = JOptionPane.showOptionDialog( 
						this,  // con null da la opción de abortar (x en ventana para cerrar)
						textoBotones[5],
						"Pulsa un botón",
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.QUESTION_MESSAGE,
						null, 
						nuevosBotones,
						nuevosBotones[0]);
				switch (res) {
					case 0:
					case 1:
					case 2:
					case 3: JOptionPane.showMessageDialog(
								this,
								"Pulsaste el botón " + nuevosBotones[res],
								"Aviso", 
								JOptionPane.PLAIN_MESSAGE				
							);
							break;
					default: JOptionPane.showMessageDialog(
							this,
							"¿Qué carajo has hecho?",
							"Aviso", 
							JOptionPane.PLAIN_MESSAGE				
							);
							break;
				}
				break;
			default:
				break;
		} // switch
	}//modal
	
	

	public static void main(String[] args) {
		JFrame app= new Modal_V1();
		app.setVisible(true);
		

	}//main
	
	

}//class