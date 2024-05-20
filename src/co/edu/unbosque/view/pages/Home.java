package co.edu.unbosque.view.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.components.AuthFooter;
import co.edu.unbosque.view.components.AuthHeader;
import co.edu.unbosque.view.components.ButtonGeneral;
import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * Esta clase define la clase Home, que representa la página de inicio de la
 * aplicación de gestión de la Union Cicliste Internationale.
 */
public class Home extends JPanel {
	private ButtonGeneral signInButton;
	private ButtonGeneral registerButton;

	/**
	 * Constructor de Home. Configura el diseño y la apariencia del panel principal
	 * de la página de inicio.
	 */
	public Home() {
		setLayout(new BorderLayout());
		setBackground(ColorPalette.getMainWhite());

		initializeComponents();
		setVisible(true);
	}

	/**
	 * Inicializa y agrega los componentes principales de la página de inicio.
	 */
	public void initializeComponents() {
		insertHeader();
		insertMainContent();
		insertFooter();
	}

	/**
	 * Inserta el encabezado de la página de inicio.
	 */
	public void insertHeader() {
		AuthHeader header = new AuthHeader();
		add(header, BorderLayout.NORTH);
	}

	/**
	 * Inserta el contenido principal de la página de inicio.
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

		JLabel titleLabel = new JLabel("Bienvenido");
		titleLabel.setFont(FontSystem.getLargeTitle());
		titleLabel.setForeground(ColorPalette.getMainBlack());

		JLabel subTitleLabel = new JLabel(
				"<html><p style='text-align: center;'>Sistema de gestión de la <br/><span style='font-weight: bold;color: #FF204E;'>Union Cicliste Internationale</span></p><html>");
		subTitleLabel.setFont(FontSystem.getLargeParagraph());
		subTitleLabel.setForeground(ColorPalette.getMainBlack());

		JLabel signInLabel = new JLabel("¿Ya tienes cuenta?");
		signInLabel.setFont(FontSystem.getExtraLargeParagraph());
		signInLabel.setForeground(ColorPalette.getMainBlack());

		signInButton = new ButtonGeneral("Iniciar Sesión", "Home_SignIn", ColorPalette.getMainRed(),
				ColorPalette.getMainWhite());

		JLabel registerLabel = new JLabel("¿Eres nuevo?");
		registerLabel.setFont(FontSystem.getExtraLargeParagraph());

		registerButton = new ButtonGeneral("Registrarse", "Home_SignUp", ColorPalette.getMainBlack(),
				ColorPalette.getMainWhite());

		// Agregar componentes al mainContent
		mainContent.add(Box.createVerticalStrut(8));
		mainContent.add(titleLabel);
		mainContent.add(Box.createVerticalStrut(4));
		mainContent.add(subTitleLabel);
		mainContent.add(Box.createVerticalStrut(16));
		mainContent.add(signInLabel);
		mainContent.add(Box.createVerticalStrut(8));
		mainContent.add(signInButton);
		mainContent.add(Box.createVerticalStrut(16));
		mainContent.add(registerLabel);
		mainContent.add(Box.createVerticalStrut(8));
		mainContent.add(registerButton);

		// Centrar componentes horizontalmente dentro de mainContent
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		subTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		signInLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		signInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		registerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

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
	 * Inserta el pie de página de la página de inicio.
	 */
	public void insertFooter() {
		AuthFooter footer = new AuthFooter();
		add(footer, BorderLayout.SOUTH);
	}

	/**
	 * Obtiene el botón de iniciar sesión.
	 * 
	 * @return ButtonGeneral el botón de iniciar sesión.
	 */
	public ButtonGeneral getSignInButton() {
		return signInButton;
	}

	/**
	 * Obtiene el botón de registrarse.
	 * 
	 * @return ButtonGeneral el botón de registrarse.
	 */
	public ButtonGeneral getRegisterButton() {
		return registerButton;
	}
}
