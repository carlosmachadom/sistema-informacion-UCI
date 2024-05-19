package co.edu.unbosque.view.components;

import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * La clase <code>AuthBackground</code> es un componente personalizado de
 * <code>JPanel</code> que permite establecer una imagen de fondo para la
 * autenticación en la aplicación.
 * <p>
 * Esta clase sobrescribe el método <code>paint</code> de <code>JPanel</code>
 * para dibujar una imagen de fondo, utilizando un archivo de imagen ubicado en
 * el directorio <code>images</code>.
 * </p>
 */
@SuppressWarnings("serial")
public class AuthBackground extends JPanel {
	
	/**
     * Constructor de la clase <code>AuthBackground</code>.
     * <p>
     * Inicializa el panel y lo hace visible.
     * </p>
     */
	public AuthBackground() {
		setVisible(true);
	}

	/**
     * Sobrescribe el método <code>paint</code> de <code>JPanel</code> para dibujar una imagen de fondo.
     * <p>
     * La imagen se escala para ajustarse al tamaño del panel. El panel se establece como no opaco
     * para permitir que otros componentes se dibujen sobre la imagen de fondo.
     * </p>
     *
     * @param g El objeto <code>Graphics</code> utilizado para dibujar la imagen de fondo.
     */
	@Override
	public void paint(Graphics g) {
		ImageIcon imagenFondo = new ImageIcon("images" + File.separator + "home_background_uci.jpg");
		g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen de fondo

		setOpaque(false); // Hace el panel transparente
		super.paint(g); // Llama al método paint de la superclase JPanel
	}
}
