package co.edu.unbosque.view.pages.auth;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.components.NumericInput;
import co.edu.unbosque.view.components.PasswordInput;
import co.edu.unbosque.view.components.SelectorInput;
import co.edu.unbosque.view.components.TextInput;
import co.edu.unbosque.view.utils.ColorPalette;

/**
 * RegistrationFormRoleBasedFormRenderer representa el contenedor que renderiza
 * formularios basados en el rol seleccionado durante el registro.
 */
public class RegistrationFormRoleBasedFormRenderer extends JPanel {
	private TextInput email;
	private TextInput dni;
	private PasswordInput password;
	private NumericInput yearsOfexperience;
	private SelectorInput cyclistExpertise;
	private TextInput ciclistNames;
	private TextInput ciclistLastNames;
	private TextInput nationality;

	/**
	 * Constructor de RegistrationFormRoleBasedFormRenderer. Configura el diseño y
	 * la apariencia del panel.
	 */
	public RegistrationFormRoleBasedFormRenderer() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(ColorPalette.getMainWhite());
		setVisible(true);
	}

	/**
	 * Inserta el formulario específico para el rol de Director.
	 */
	public void insertDirectorsForm() {
		removeAllComponents();
		reRenderComponents();

		dni = new TextInput("Cédula:");
		dni.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(dni);
		add(Box.createVerticalStrut(8));

		nationality = new TextInput("Nacionalidad:");
		nationality.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(nationality);
		add(Box.createVerticalStrut(8));

		yearsOfexperience = new NumericInput("Experienca (Años):");
		yearsOfexperience.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(yearsOfexperience);
		add(Box.createVerticalStrut(8));

		email = new TextInput("Correo Electrónico:");
		email.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(email);
		add(Box.createVerticalStrut(8));

		password = new PasswordInput("Contraseña:", 20);
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(password);

		reRenderComponents();
	}

	/**
	 * Inserta el formulario específico para el rol de Masajista.
	 */
	public void insertMassageTherapistsForm() {
		removeAllComponents();
		reRenderComponents();

		dni = new TextInput("Cédula:");
		dni.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(dni);
		add(Box.createVerticalStrut(8));

		yearsOfexperience = new NumericInput("Experienca (Años):");
		yearsOfexperience.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(yearsOfexperience);
		add(Box.createVerticalStrut(8));

		email = new TextInput("Correo Electrónico:");
		email.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(email);
		add(Box.createVerticalStrut(8));

		password = new PasswordInput("Contraseña:", 20);
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(password);

		reRenderComponents();
	}

	/**
	 * Inserta el formulario específico para el rol de Ciclista.
	 */
	public void insertCyclistForm() {
		removeAllComponents();
		reRenderComponents();

		// Crear un panel intermedio con GridLayout
		JPanel gridPanel = new JPanel(new GridLayout(3, 2, 8, 8));
		gridPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		gridPanel.setBackground(ColorPalette.getTransparent());


		ciclistNames = new TextInput("Nombres:");
		gridPanel.add(ciclistNames);

		ciclistLastNames = new TextInput("Apellidos:");
		gridPanel.add(ciclistLastNames);
		
		yearsOfexperience = new NumericInput("Experienca (Años):");
		gridPanel.add(yearsOfexperience);

		dni = new TextInput("Cédula:");
		gridPanel.add(dni);

		email = new TextInput("Correo Electrónico:");
		gridPanel.add(email);

		password = new PasswordInput("Contraseña:", 20);
		gridPanel.add(password);

		// Agregar el panel intermedio al layout principal
		add(gridPanel);

		reRenderComponents();
	}

	/**
	 * Elimina todos los componentes del panel.
	 */
	public void removeAllComponents() {
		removeAll();
	}

	/**
	 * Vuelve a renderizar los componentes del panel.
	 */
	public void reRenderComponents() {
		revalidate();
		repaint();
	}

	/**
	 * Obtiene el campo de entrada de correo electrónico.
	 * 
	 * @return TextInput el campo de correo electrónico.
	 */
	public TextInput getEmail() {
		return email;
	}

	/**
	 * Obtiene el campo de entrada de DNI.
	 * 
	 * @return TextInput el campo de DNI.
	 */
	public TextInput getDni() {
		return dni;
	}

	/**
	 * Obtiene el campo de entrada de años de experiencia.
	 * 
	 * @return NumericInput el campo de años de experiencia.
	 */
	public NumericInput getYearsOfexperience() {
		return yearsOfexperience;
	}

	/**
	 * Obtiene el campo de entrada de contraseña.
	 * 
	 * @return PasswordInput el campo de contraseña.
	 */
	public PasswordInput getPassword() {
		return password;
	}

	/**
	 * Obtiene el selector de especialidad del ciclista.
	 * 
	 * @return SelectorInput el selector de especialidad.
	 */
	public SelectorInput getCyclistExpertise() {
		return cyclistExpertise;
	}

	/**
	 * Obtiene el campo de entrada de nombres del ciclista.
	 * 
	 * @return TextInput el campo de nombres del ciclista.
	 */
	public TextInput getCiclistNames() {
		return ciclistNames;
	}

	/**
	 * Obtiene el campo de entrada de apellidos del ciclista.
	 * 
	 * @return TextInput el campo de apellidos del ciclista.
	 */
	public TextInput getCiclistLastNames() {
		return ciclistLastNames;
	}

	/**
	 * Obtiene el campo de entrada de nacionalidad.
	 * 
	 * @return TextInput el campo de nacionalidad.
	 */
	public TextInput getNationality() {
		return nationality;
	}
}
