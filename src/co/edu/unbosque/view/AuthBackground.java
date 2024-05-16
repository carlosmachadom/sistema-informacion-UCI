package co.edu.unbosque.view;

import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AuthBackground extends JPanel {	
	public AuthBackground() {
		setVisible(true);
	}
	
	@Override
    public void paint(Graphics g) {
        ImageIcon imagenFondo = new ImageIcon("images" + File.separator + "home_background_uci.jpg");
        g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen de fondo

        setOpaque(false); // Hace el panel transparente
        super.paint(g); // Llama al método paint de la superclase JPanel 
    }
}
