
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class HolaMundoSwing {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Hola Mundo");
			ventana.setSize(400, 100);//da tamaño inicial, pero una vez que tenga layout, se puede quitar.
			ventana.setLocation(500, 500);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setVisible(true);
		
			
		JLabel lbl = new JLabel("Etiqueta");
		JButton but1 = new JButton("botón 1");
		JButton but2 = new JButton("botón 2");
		
		but1.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lbl.setText("Pulsado el botón 1");						
					}			
				});
		
		but2.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lbl.setText("Pulsado el botón 2");						
					}			
				});
		
		ventana.getContentPane().setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		ventana.add(lbl);
		ventana.add(but1);
		ventana.add(but2);
		/*lbl.setBounds(10,10,10,10);
		but1.setBounds(10,50,210,10);
		but2.setBounds(10,100,310,10);*/
		ventana.pack();
		

	}

}
