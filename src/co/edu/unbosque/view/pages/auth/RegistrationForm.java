/**
 * 
 */
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
import co.edu.unbosque.view.components.SelectorInput;
import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * 
 */
public class RegistrationForm extends JPanel{
	private SelectorInput role; 
	private RegistrationFormRoleBasedFormRenderer roleFormsContainer;
	private JButton signInButton;
	private JButton signUpButton;
	
	public RegistrationForm() {
		setLayout(new BorderLayout());
		setBackground(ColorPalette.getMainWhite());
		initializeComponents();
		setVisible(true);
	}
	
	public void initializeComponents() {
		insertHeader();
		insertMainContent();
		insertFooter();
	}
	
	public void insertHeader() {
		AuthHeader header = new AuthHeader();
		add(header, BorderLayout.NORTH);
	}		
	
	public void insertMainContent() {
		// Crear un contenedor principal para centrar verticalmente el contenido
        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setBackground(ColorPalette.getTransparent());
        
        // Crear el contenido principal (mainContent)
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainContent.setBackground(ColorPalette.getTransparent());
        
        JLabel titleLabel = new JLabel("Registrate");
        titleLabel.setFont(FontSystem.getLargeTitle());
        titleLabel.setForeground(ColorPalette.getMainBlack());
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subTitleLabel = new JLabel("<html><p style='text-align: center;'>Comienza tu camino con equipos <br/>de alto rendimiento</p><html>");
        subTitleLabel.setFont(FontSystem.getLargeParagraph());
        subTitleLabel.setForeground(ColorPalette.getMainBlack());
        subTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        String[] roles = {"Director", "Masajista", "Ciclista"};
        role = new SelectorInput("Selecciona una opción:", roles, "Form_SignUp_Role_Selection");
        role.setAlignmentX(Component.CENTER_ALIGNMENT);      
        
        roleFormsContainer = new RegistrationFormRoleBasedFormRenderer();
        roleFormsContainer.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        JPanel signUpButtonContainer = new JPanel();
        signUpButtonContainer.setLayout(new BorderLayout());
        signUpButtonContainer.setBorder(new EmptyBorder(0,0,0,0));
        signUpButtonContainer.setBackground(ColorPalette.getTransparent());
        signUpButton = new JButton("Registrarse");
        signUpButton.setFocusPainted(false);
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton.setFont(FontSystem.getH4());
        signUpButton.setForeground(ColorPalette.getMainWhite());
        signUpButton.setBorder(new EmptyBorder(12, 16, 12, 16));
        signUpButton.setBackground(ColorPalette.getMainRed());
        signUpButton.setActionCommand("Form_SignUp");
        signUpButtonContainer.add(signUpButton, BorderLayout.CENTER);
        
        JPanel signInButtonContainer = new JPanel();
        signInButtonContainer.setLayout(new BorderLayout());
        signInButtonContainer.setBorder(new EmptyBorder(0,0,0,0));
        signInButtonContainer.setBackground(ColorPalette.getTransparent());
        signInButton = new JButton("Iniciar Sesión");
        signInButton.setFont(FontSystem.getH4());
        signInButton.setForeground(ColorPalette.getMainWhite());
        signInButton.setBorder(new EmptyBorder(12, 16, 12, 16));
        signInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signInButton.setBackground(ColorPalette.getMainBlack());
        signInButton.setActionCommand("Form_SignIn");
        signInButtonContainer.add(signInButton, BorderLayout.CENTER); 
       
        
        // Agregar componentes al mainContent
        mainContent.add(titleLabel);
        mainContent.add(subTitleLabel);        
        mainContent.add(Box.createVerticalStrut(8));
        mainContent.add(role);
        mainContent.add(Box.createVerticalStrut(8));
        mainContent.add(roleFormsContainer);
        mainContent.add(Box.createVerticalStrut(16));
        mainContent.add(signUpButtonContainer);
        mainContent.add(Box.createVerticalStrut(16));
        mainContent.add(signInButtonContainer);
        
        
        // Agregar mainContent al wrapperPanel con GridBagConstraints para centrar verticalmente
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Establecer peso vertical para centrar
        
        wrapperPanel.add(mainContent, gbc);
        
        // Agregar wrapperPanel al centro de este panel (CenteredMainContentPanel)
        add(wrapperPanel, BorderLayout.CENTER);
	}
	
	public void insertFooter() {
		AuthFooter footer = new AuthFooter();
		add(footer, BorderLayout.SOUTH);
	}

	public SelectorInput getRole() {
		return role;
	}

	public JButton getSignInButton() {
		return signInButton;
	}

	public JButton getSignUpButton() {
		return signUpButton;
	}

	public RegistrationFormRoleBasedFormRenderer getRoleFormsContainer() {
		return roleFormsContainer;
	}
}
