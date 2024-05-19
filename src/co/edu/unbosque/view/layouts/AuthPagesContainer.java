package co.edu.unbosque.view.layouts;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.unbosque.view.pages.Home;
import co.edu.unbosque.view.pages.auth.LoginForm;
import co.edu.unbosque.view.pages.auth.RegistrationForm;
import co.edu.unbosque.view.utils.ColorPalette;

/**
 * El contenedor AuthPagesContainer es un JPanel que gestiona la inserción y el
 * cambio de páginas dentro de la interfaz de autenticación.
 */
public class AuthPagesContainer extends JPanel {
	private Home entry;
	private LoginForm signIn;
	private RegistrationForm signUp;

	/**
	 * Constructor para inicializar el contenedor de páginas de autenticación.
	 * Establece el diseño y el tamaño máximo.
	 */
	public AuthPagesContainer() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(ColorPalette.getMainWhite());
		setMaximumSize(new Dimension(720, Integer.MAX_VALUE)); // Establecer ancho fijo y altura flexible
	}

	/**
	 * Devuelve la dimensión preferida del contenedor, con un ancho fijo.
	 *
	 * @return La dimensión preferida con ancho fijo y altura flexible.
	 */
	@Override
	public Dimension getPreferredSize() {
		// Ajustar el tamaño preferido solo en función del ancho fijo
		return new Dimension(720, super.getPreferredSize().height);
	}

	/**
	 * Inserta la página de inicio en el contenedor.
	 */
	public void insertHome() {
		removeAllComponents();
		reRenderComponents();

		// Insertar Home
		entry = new Home();
		add(entry);

		reRenderComponents();
	}

	/**
	 * Inserta el formulario de inicio de sesión en el contenedor.
	 */
	public void insertLoginForm() {
		removeAllComponents();
		reRenderComponents();

		// Insertar signIn
		signIn = new LoginForm();
		add(signIn);

		reRenderComponents();
	}

	/**
	 * Inserta el formulario de registro en el contenedor.
	 */
	public void insertRegistrationForm() {
		removeAllComponents();
		reRenderComponents();

		// Insertar signUp
		signUp = new RegistrationForm();
		add(signUp);

		reRenderComponents();
	}

	/**
	 * Elimina todos los componentes del contenedor.
	 */
	public void removeAllComponents() {
		removeAll();
	}

	/**
	 * Vuelve a renderizar el contenedor.
	 */
	public void reRenderComponents() {
		revalidate();
		repaint();
	}

	/**
	 * Obtiene la página de inicio.
	 *
	 * @return La página de inicio.
	 */
	public Home getEntry() {
		return entry;
	}

	/**
	 * Obtiene el formulario de inicio de sesión.
	 *
	 * @return El formulario de inicio de sesión.
	 */
	public LoginForm getSignIn() {
		return signIn;
	}

	/**
	 * Obtiene el formulario de registro.
	 *
	 * @return El formulario de registro.
	 */
	public RegistrationForm getSignUp() {
		return signUp;
	}
}
