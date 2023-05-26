import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConImagen extends JPanel {
	private Image imagen;
	private String ruta = "foto.png";
	JLabel etiqueta;
	
	public static void main (String args[]) {
		PanelConImagen imagen = new PanelConImagen();
		imagen.paint(null);
	}
	
	public PanelConImagen() {
		try {
			imagen = ImageIO.read(new File(ruta));
			this.setSize(imagen.getWidth(null),imagen.getHeight(null));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		etiqueta = new JLabel("Hola");
		this.add(etiqueta);
		
	}
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(imagen.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH),0,0,null);
		//g.drawImage(imagen, 0, 0, null);
		super.paintComponents(g);  // para que pinte el resto de componentes !!!!  debir ir después del anterior
		//this.paintComponents(g);  // para que pinte el resto de componentes !!!!
	}
	
} // class PanelConImagen