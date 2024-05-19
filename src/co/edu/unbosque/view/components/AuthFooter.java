package co.edu.unbosque.view.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * La clase <code>AuthFooter</code> es un componente personalizado de <code>JPanel</code> que 
 * representa el pie de página en la interfaz de autenticación.
 * <p>
 * Este pie de página muestra un texto centrado con un diseño específico.
 * </p>
 */
public class AuthFooter extends JPanel{
	
	/**
     * Constructor de la clase <code>AuthFooter</code>.
     * <p>
     * Configura el diseño, el borde, el color de fondo y llama al método 
     * <code>initializeComponents</code> para añadir y configurar los componentes del pie de página.
     * </p>
     */
	public AuthFooter() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBorder(new EmptyBorder(24,40,24,40));
		setBackground(new Color(255,245,248));
		
		initializeComponents();
		
		setVisible(true);
	}
	
	/**
     * Inicializa y añade los componentes del pie de página.
     * <p>
     * Este método crea una etiqueta con un texto específico, 
     * configura su fuente y color, y la añade al panel.
     * </p>
     */
	public void initializeComponents() {    	
    	JLabel textoPiePagina = new JLabel("Union cicliste internationale");
    	Font fontTextoPiePagina = new Font("Arial", Font.BOLD, 18);
    	textoPiePagina.setFont(fontTextoPiePagina);
    	textoPiePagina.setForeground(new Color(0, 34, 77));
    	
    	add(textoPiePagina);
	}
}
