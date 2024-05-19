package co.edu.unbosque.view.layouts;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.unbosque.view.components.AuthBackground;

/**
 * La clase AuthLayout es un JPanel que define el diseño principal de la
 * interfaz de autenticación.
 * 
 * Este diseño consta de un contenedor para las páginas de autenticación y un
 * fondo de imagen personalizado.
 */
public class AuthLayout extends JPanel {
	private AuthPagesContainer pagesContainer;

	/**
	 * Constructor para inicializar el diseño de autenticación.
	 */
	public AuthLayout() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		initializeComponents();

		setVisible(true);
	}

	/**
	 * Inicializa los componentes del diseño, incluyendo el contenedor de páginas y
	 * el fondo de imagen.
	 */
	public void initializeComponents() {
		pagesContainer = new AuthPagesContainer();

		JPanel contenedorImagen = new AuthBackground();

		add(pagesContainer);
		add(contenedorImagen);
	}

	/**
	 * Obtiene el contenedor de páginas de autenticación.
	 *
	 * @return El contenedor de páginas AuthPagesContainer.
	 */
	public AuthPagesContainer getPagesContainer() {
		return pagesContainer;
	}
}
