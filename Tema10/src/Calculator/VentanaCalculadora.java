package Calculator;

import java.awt.event.*;

import javax.swing.*;

public class VentanaCalculadora extends JFrame implements ActionListener {
	final static int NUM_BOTONES = 16;
	final static int ANCHO_DISPLAY = 15;
	JPanel panel;
	JButton botones[];
	JTextField display;
	
	public VentanaCalculadora() {
		panel = new JPanel();
		botones = new JButton[NUM_BOTONES];
		display = new JTextField("0",ANCHO_DISPLAY);
		for (int i=0; i<10; i++) {
			botones[i] = new JButton(i+"");
		}//for
		
		botones[10] = new JButton("+");
		botones[11] = new JButton("-");
		botones[12] = new JButton("*");
		botones[13] = new JButton("/");
		botones[14] = new JButton("=");
		botones[15] = new JButton("C");
		
		panel.add(display);
		for (int i=0; i<botones.length; i++) {
			panel.add(botones[i]);
			botones[i].addActionListener(this);
		}//for
		
		this.setLocation(500,500);

		this.setTitle("Calculadora");
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();//una vea que ha cogido los componentes los visualiza
		this.setSize(180,240);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String txtButon = e.getActionCommand();
		switch (txtButon) {
		case  "0","1","2","3","4","5","6","7","8","9":
			String txtLabel = display.getText();
			if (txtLabel.equals("0")) {
				display.setText(txtButon);
			} else {
				display.setText(txtLabel + txtButon);
			}
			break;
		case "C":
			display.setText("0");
			break;
		}//case
		
		

		//e.getActionCommand();devuelve el texto del botón.
		
		
	}//action

}
