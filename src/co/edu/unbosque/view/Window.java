package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {
	private Root root;	

    /**
     * Constructor de la clase VistaVentana.
     * Configura la ventana principal con título, tamaño, diseño y componentes iniciales.
     */
    public Window() {
        super();
        setTitle("Union cicliste internationale system"); // Establece el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        getContentPane().setLayout(new BorderLayout()); // Establece el layout principal como BorderLayout
        setMinimumSize(new Dimension(1440, 960)); // Establece el tamaño mínimo de la ventana
        setMaximumSize(new Dimension(1440, 960)); // Establece el tamaño mínimo de la ventana
        setResizable(false); // Permite redimensionar la ventana
        //ImageIcon favicon = new ImageIcon("images" + File.separator + "Paviment_forecast.png");
        //setIconImage(favicon.getImage());
        
        initializeComponents();             
        
        pack();
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true); // Hace visible la ventana
    }
    
    public void initializeComponents() {
        root = new Root(); // Crea una instancia del LayoutPrincipal
        getContentPane().add(root, BorderLayout.CENTER); // Agrega el LayoutPrincipal al centro de la ventana
    }

	public Root getRoot() {
		return root;
	}

	public void setRoot(Root root) {
		this.root = root;
	}
}
