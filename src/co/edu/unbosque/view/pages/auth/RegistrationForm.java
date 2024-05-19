package co.edu.unbosque.view.pages.auth;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import co.edu.unbosque.view.components.SelectorInput;
import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * RegistrationForm representa la interfaz gráfica de registro de usuario, que
 * incluye la selección de rol y la entrada de datos correspondientes.
 */
public class RegistrationForm extends JPanel {
	private SelectorInput role;
	private RegistrationFormRoleBasedFormRenderer roleFormsContainer;
	private ButtonGeneral signInButton;
	private ButtonGeneral signUpButton;

	/**
	 * Constructor de RegistrationForm. Inicializa los componentes y establece la
	 * visibilidad del formulario.
	 */
	public RegistrationForm() {
		setLayout(new BorderLayout());
		setBackground(ColorPalette.getMainWhite());
		initializeComponents();
		setVisible(true);
	}

	/**
	 * Inicializa y agrega todos los componentes del formulario.
	 */
	public void initializeComponents() {
		insertHeader();
		insertMainContent();
		insertFooter();
	}

	/**
	 * Inserta el encabezado del formulario de registro.
	 */
	public void insertHeader() {
		AuthHeader header = new AuthHeader();
		add(header, BorderLayout.NORTH);
	}

	/**
	 * Inserta el contenido principal del formulario de registro.
	 */
	public void insertMainContent() {
		// Crear un contenedor principal para centrar verticalmente el contenido
		JPanel wrapperPanel = new JPanel(new GridBagLayout());
		wrapperPanel.setBackground(ColorPalette.getMainWhite());

		// Crear el contenido principal (mainContent)
		JPanel mainContent = new JPanel();
		mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
		mainContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainContent.setBackground(ColorPalette.getMainWhite());

		JLabel titleLabel = new JLabel("Registrate");
		titleLabel.setFont(FontSystem.getLargeTitle());
		titleLabel.setForeground(ColorPalette.getMainBlack());
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel subTitleLabel = new JLabel(
				"<html><p style='text-align: center;'>Forma parte de la élite del ciclismo y lleva <br/>tu rendimiento al siguiente nivel.</p><html>");
		subTitleLabel.setFont(FontSystem.getLargeParagraph());
		subTitleLabel.setForeground(ColorPalette.getMainBlack());
		subTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		String[] roles = { "Director", "Masajista", "Ciclista" };
		role = new SelectorInput("Selecciona una opción:", roles, "Form_SignUp_Role_Selection");
		role.getSelector().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if (command.equals("Form_SignUp_Role_Selection")) {
					validateRoleForm();
				}
			}        	
        });
        
        role.setAlignmentX(Component.CENTER_ALIGNMENT);      
        
        roleFormsContainer = new RegistrationFormRoleBasedFormRenderer();
        roleFormsContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
        validateRoleForm();
        
        
        signUpButton = new ButtonGeneral(
    		"Registrarse", 
    		"Registration_Form_SignUp", 
    		ColorPalette.getMainRed(), 
    		ColorPalette.getMainWhite()
        );
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        signInButton = new ButtonGeneral(
    		"Iniciar Sesión", 
    		"Registration_Form_SignIn", 
    		ColorPalette.getMainBlack(), 
    		ColorPalette.getMainWhite()
        );
        signInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        
        // Agregar componentes al mainContent
        mainContent.add(titleLabel);
        mainContent.add(subTitleLabel);        
        mainContent.add(Box.createVerticalStrut(8));
        mainContent.add(role);
        mainContent.add(Box.createVerticalStrut(8));
        mainContent.add(roleFormsContainer);
        mainContent.add(Box.createVerticalStrut(16));
        mainContent.add(signUpButton);
        mainContent.add(Box.createVerticalStrut(16));
        mainContent.add(signInButton);
        
        
        // Agregar mainContent al wrapperPanel con GridBagConstraints para centrar verticalmente
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Establecer peso vertical para centrar
        
        wrapperPanel.add(mainContent, gbc);
        
        // Agregar wrapperPanel al centro de este panel (CenteredMainContentPanel)
        add(wrapperPanel, BorderLayout.CENTER);

	}

	/**
	 * Inserta el pie de página del formulario de registro.
	 */
	public void insertFooter() {
		AuthFooter footer = new AuthFooter();
		add(footer, BorderLayout.SOUTH);
	}

	/**
	 * Valida y muestra el formulario correspondiente al rol seleccionado.
	 */
	public void validateRoleForm() {
		String selectedRole = role.getSelector().getSelectedItem().toString();

		switch (selectedRole) {
		case "Director":
			roleFormsContainer.insertDirectorsForm();
			break;
		case "Masajista":
			roleFormsContainer.insertMassageTherapistsForm();
			break;
		case "Ciclista":
			roleFormsContainer.insertCyclistForm();
			break;
		default:
			break;
		}
	}

	/**
	 * Obtiene el componente SelectorInput para seleccionar el rol.
	 * 
	 * @return SelectorInput el selector de rol.
	 */
	public SelectorInput getRole() {
		return role;
	}

	/**
	 * Obtiene el botón de "Iniciar Sesión".
	 * 
	 * @return ButtonGeneral el botón de "Iniciar Sesión".
	 */
	public ButtonGeneral getSignInButton() {
		return signInButton;
	}

	/**
	 * Obtiene el botón de "Registrarse".
	 * 
	 * @return ButtonGeneral el botón de "Registrarse".
	 */
	public ButtonGeneral getSignUpButton() {
		return signUpButton;
	}

	/**
	 * Obtiene el contenedor para los formularios basados en rol.
	 * 
	 * @return RegistrationFormRoleBasedFormRenderer el contenedor de formularios.
	 */
	public RegistrationFormRoleBasedFormRenderer getRoleFormsContainer() {
		return roleFormsContainer;
	}
}
