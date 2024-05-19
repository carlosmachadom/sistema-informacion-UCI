package co.edu.unbosque.view.pages.auth;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.components.AuthFooter;
import co.edu.unbosque.view.components.AuthHeader;
import co.edu.unbosque.view.components.ButtonGeneral;
import co.edu.unbosque.view.components.PasswordInput;
import co.edu.unbosque.view.components.SelectorInput;
import co.edu.unbosque.view.components.TextInput;
import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * La clase LoginForm representa el formulario de inicio de sesión en la
 * interfaz de autenticación.
 */
public class LoginForm extends JPanel {
	private TextInput user;
	private PasswordInput password;
	private ButtonGeneral signInButton;
	private ButtonGeneral signUpButton;

	/**
	 * Constructor para inicializar el formulario de inicio de sesión.
	 */
	public LoginForm() {
		setLayout(new BorderLayout());
		setBackground(ColorPalette.getMainWhite());
		initializeComponents();
		setVisible(true);
	}

	/**
	 * Inicializa los componentes del formulario de inicio de sesión.
	 */
	public void initializeComponents() {
		insertHeader();
		insertMainContent();
		insertFooter();
	}

	/**
	 * Inserta el encabezado del formulario de inicio de sesión.
	 */
	public void insertHeader() {
		AuthHeader header = new AuthHeader();
		add(header, BorderLayout.NORTH);
	}

	/**
	 * Inserta el contenido principal del formulario de inicio de sesión.
	 */
	public void insertMainContent() {
		// Crear un contenedor principal para centrar verticalmente el contenido
		JPanel wrapperPanel = new JPanel(new GridBagLayout());
		wrapperPanel.setBackground(ColorPalette.getTransparent());

		// Crear el contenido principal (mainContent)
		JPanel mainContent = new JPanel();
		mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
		mainContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainContent.setBackground(ColorPalette.getTransparent());

		JLabel titleLabel = new JLabel("Inicia Sesión");
		titleLabel.setFont(FontSystem.getLargeTitle());
		titleLabel.setForeground(ColorPalette.getMainBlack());
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel subTitleLabel = new JLabel(
				"<html><p style='text-align: center;'>La mejor forma de administrar equipos <br/>de alto rendimiento</p><html>");
		subTitleLabel.setFont(FontSystem.getLargeParagraph());
		subTitleLabel.setForeground(ColorPalette.getMainBlack());
		subTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		user = new TextInput("Usuario:");
		user.setAlignmentX(Component.CENTER_ALIGNMENT);

		password = new PasswordInput("Contraseña:", 20);
		password.setAlignmentX(Component.CENTER_ALIGNMENT);

		signInButton = new ButtonGeneral("Iniciar Sesión", "Form_SignIn", ColorPalette.getMainRed(),
				ColorPalette.getMainWhite());
		signInButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		signUpButton = new ButtonGeneral("Registrarse", "Form_SignUp", ColorPalette.getMainBlack(),
				ColorPalette.getMainWhite());
		signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Agregar componentes al mainContent
		mainContent.add(titleLabel);
		mainContent.add(subTitleLabel);
		mainContent.add(Box.createVerticalStrut(8));
		mainContent.add(user);
		mainContent.add(Box.createVerticalStrut(8));
		mainContent.add(password);
		mainContent.add(Box.createVerticalStrut(16));
		mainContent.add(signInButton);
		mainContent.add(Box.createVerticalStrut(16));
		mainContent.add(signUpButton);

		// Agregar mainContent al wrapperPanel con GridBagConstraints para centrar
		// verticalmente
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.weighty = 1.0; // Establecer peso vertical para centrar

		wrapperPanel.add(mainContent, gbc);

		// Agregar wrapperPanel al centro de este panel (CenteredMainContentPanel)
		add(wrapperPanel, BorderLayout.CENTER);
	}

	/**
	 * Inserta el pie de página del formulario de inicio de sesión.
	 */
	public void insertFooter() {
		AuthFooter footer = new AuthFooter();
		add(footer, BorderLayout.SOUTH);
	}

	/**
	 * Obtiene el campo de entrada de usuario.
	 *
	 * @return El campo de entrada de usuario.
	 */
	public TextInput getUser() {
		return user;
	}

	/**
	 * Obtiene el campo de entrada de contraseña.
	 *
	 * @return El campo de entrada de contraseña.
	 */
	public PasswordInput getPassword() {
		return password;
	}

	/**
	 * Obtiene el botón de inicio de sesión.
	 *
	 * @return El botón de inicio de sesión.
	 */
	public ButtonGeneral getSignInButton() {
		return signInButton;
	}

	/**
	 * Obtiene el botón de registro.
	 *
	 * @return El botón de registro.
	 */
	public ButtonGeneral getSignUpButton() {
		return signUpButton;
	}
}
