package controlador;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class panelImagen extends JPanel {
	

	public panelImagen() {
	
		this.setSize(684, 800);//Tamaño del JFrame
	}
	
	
	//Dibuja la imagen en el JFrame
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		
			ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/UntitledFondo (2).png"));
			g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
			setOpaque(false);
			super.paintComponent(g);
		
	}
}
