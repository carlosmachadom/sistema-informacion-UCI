package co.edu.unbosque.view.pages.auth;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.components.PasswordInput;
import co.edu.unbosque.view.components.SelectorInput;
import co.edu.unbosque.view.components.TextInput;
import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

public class RegistrationFormRoleBasedFormRenderer extends JPanel{
	private JTextField email;
	private JTextField dni;
	private PasswordInput password;
	private JTextField yearsOfexperience;
	private SelectorInput cyclistExpertise; 
	private TextInput ciclistNames;
	private TextInput ciclistLastNames;
	
	public RegistrationFormRoleBasedFormRenderer() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0,0,0,0));
        setBackground(ColorPalette.getTransparent());
        setVisible(true);
	}
	
	public void insertCommonFields() {        
        password = new PasswordInput("Contraseña:", 20);
        password.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(password);
	}
	
	public void insertDirectorsForm() {
		removeAllComponents();
		reRenderComponents();
		
		insertCommonFields();
		
		reRenderComponents();
	}
	
	public void insertMassageTherapistsForm() {
		removeAllComponents();
		reRenderComponents();
		
		insertCommonFields();
		
		reRenderComponents();
	}
	
	public void insertCyclistForm() {
		removeAllComponents();
		reRenderComponents();		
	    
		String[] cyclistTypes = {"Gregario", "Clasicomaniaco", "Relojista", "Escalador", "Corredor", "Rodador"};
		cyclistExpertise = new SelectorInput("Selecciona su especialidad:", cyclistTypes, "Form_SignUp_Expertise_Selection");
		cyclistExpertise.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(cyclistExpertise);
		add(Box.createVerticalStrut(8));
		
		ciclistNames = new TextInput("Nombres:");
		ciclistNames.setAlignmentX(Component.CENTER_ALIGNMENT); 
        add(ciclistNames);
        add(Box.createVerticalStrut(8));
        
        ciclistLastNames = new TextInput("Apellidos:");
        ciclistLastNames.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(ciclistLastNames);
        add(Box.createVerticalStrut(8));
		
		insertCommonFields();
		
		reRenderComponents();
	}
	
	public void removeAllComponents() {
		removeAll();
	}
	
	public void reRenderComponents() {
		revalidate();
		repaint();
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getDni() {
		return dni;
	}

	public JTextField getYearsOfexperience() {
		return yearsOfexperience;
	}
	
	public PasswordInput getPassword() {
		return password;
	}

	public SelectorInput getCyclistExpertise() {
		return cyclistExpertise;
	}

	public TextInput getCiclistNames() {
		return ciclistNames;
	}

	public TextInput getCiclistLastNames() {
		return ciclistLastNames;
	}
}
