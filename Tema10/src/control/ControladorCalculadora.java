package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaCalculadora;

public class ControladorCalculadora implements ActionListener {
	protected String num1="";
	protected String num2="";
	protected String operador="";
	protected boolean esperandoPrimerOperando=true;
	protected double total=0;
	protected VentanaCalculadora vista;
	
	public void registraVista(VentanaCalculadora vista) {
		this.vista = vista;
	}
	
	
	public void actionPerformed(ActionEvent e){
		String texto=e.getActionCommand();
		if(texto.matches("[0-9.]"))
		{
			if(esperandoPrimerOperando)
			{
				num1=num1+texto;
				vista.setDisplay(num1);
			}
			else
			{
				num2=num2+texto;
				vista.setDisplay(num2);
			}
		}
		
		// TO-DO: implementar resta, división y multiplicación
		// avanzado: encadenamiento de operaciones
		switch (texto) {
		case "+":
			esperandoPrimerOperando=false;
			operador="+";
			break;
		case "C":
			vista.setDisplay("");
			esperandoPrimerOperando=true;
			num1="";
			num2="";
			total=0;
			break;
		case "=":
			switch(operador){
			case "+":
				total=Double.parseDouble(num1)+Double.parseDouble(num2);
				vista.setDisplay( ""+total );
				break;
			}
			esperandoPrimerOperando=true;
			num1="";
			num2="";
			operador="";
			break;
		} // case
	} // ActionEvent
	
} // class
