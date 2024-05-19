package co.edu.unbosque.view.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * La clase <code>AuthHeader</code> es un componente personalizado de <code>JPanel</code> que 
 * representa la cabecera en la interfaz de autenticación.
 * <p>
 * Este encabezado muestra un ícono específico y tiene un diseño personalizado.
 * </p>
 */
public class AuthHeader extends JPanel {
    /**
     * Constructor de la clase <code>AuthHeader</code>.
     * <p>
     * Configura el diseño, el borde, el color de fondo y llama al método 
     * <code>initializeComponents</code> para añadir y configurar los componentes del encabezado.
     * </p>
     */
	public AuthHeader() {
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setBorder(new EmptyBorder(24,40,24,40));
		setBackground(new Color(255,245,248));
		
		initializeComponents();
		
		setVisible(true);
	}
	
    /**
     * Inicializa y añade los componentes del encabezado.
     * <p>
     * Este método carga una imagen desde un archivo, la redimensiona, 
     * crea un icono y lo añade al panel como una etiqueta.
     * </p>
     */
	public void initializeComponents() {
		ImageIcon iconPath = new ImageIcon("images" + File.separator + "isologo_uci.png");
        Image image = iconPath.getImage();
        Image scaled = image.getScaledInstance(60, 40, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);
        JLabel labelIcon = new JLabel(icon);	
		add(labelIcon);
	}
}
