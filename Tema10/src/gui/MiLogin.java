package gui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MiLogin extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JTextField jtusr, jtpwd;
	JLabel lusr, lpwd;
	JButton b;
	JPanel cont,  fusr, fpwd;	
	
	public MiLogin(){	
			super("Identificación");//llama al constructor de JFrame
			iniciar();
			this.setSize(400, 200);
			//indico la posición
			this.setLocation(500, 250);
			this.setResizable(false);
			MiLogin.setDefaultLookAndFeelDecorated(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);	
	}
	
	private void iniciar(){
		cont= (JPanel) getContentPane();		
		login(); //inicia la etiqueta y JtextField del nombre
		pwd();	 //inicia la etiqueta y JtextField de la password
		b= new JButton("ACEPTAR");
		b.setMnemonic('A');//Al darle a alt+A provoca el botón aceptar.
		b.setMargin(new Insets(10, 20, 10, 20)); //tamaño del botón
		b.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!jtusr.getText().equals("a")){	
							jtusr.setText("Identificador incorrecto");
						}else if(!jtpwd.getText().equals("a")){	
							jtpwd.setText("Contraseña incorrecta");
						}else{
							lusr.setVisible(false);
							lpwd.setVisible(false);
							jtusr.setVisible(false);
							jtpwd.setVisible(false);
							b.setVisible(false);
							fpwd.add(new JLabel("Bienvenido " + jtusr.getText()));
						}				
					}//actionPerformed				
				}//clase anónima
				);//addActionListener
		
		cont.add(fusr, BorderLayout.NORTH);	//colocamos los elementos en vertical
		cont.add(fpwd, BorderLayout.CENTER);
		cont.add(b, BorderLayout.SOUTH);		
	}
	
	private void login() {
		fusr= new JPanel();
		lusr= new JLabel("Nombre de usuario:");
		fusr.add(lusr);
		jtusr= new JTextField("",20);
		jtusr.setEditable(true);
		fusr.add(lusr);
		fusr.add(jtusr);
	}
	
	private void pwd() {
		fpwd= new JPanel();
		lpwd= new JLabel("Contraseña");
		jtpwd= new JPasswordField("",20);
		jtpwd.setEditable(true);
		fpwd.add(lpwd);
		fpwd.add(jtpwd);
	}

	public static void main(String[] args) {
		new MiLogin();
	}

}//class