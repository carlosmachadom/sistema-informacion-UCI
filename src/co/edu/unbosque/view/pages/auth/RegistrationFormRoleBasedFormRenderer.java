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

public class RegistrationFormRoleBasedFormRenderer extends JPanel{
	private TextInput email;
	private TextInput dni;
	private PasswordInput password;
	private NumericInput yearsOfexperience;
	private SelectorInput cyclistExpertise; 
	private TextInput ciclistNames;
	private TextInput ciclistLastNames;
	private TextInput nationality;
	
	public RegistrationFormRoleBasedFormRenderer() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0,0,0,0));
        setBackground(ColorPalette.getMainWhite());
        setVisible(true);
	}
	
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
        
        yearsOfexperience  = new NumericInput("Experienca (Años):");
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
	
	public void insertMassageTherapistsForm() {
		removeAllComponents();
		reRenderComponents();
		
		dni = new TextInput("Cédula:");
        dni.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(dni);
        add(Box.createVerticalStrut(8));
        
        yearsOfexperience  = new NumericInput("Experienca (Años):");
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
	
	public void insertCyclistForm() {
		removeAllComponents();
		reRenderComponents();		
		
		// Crear un panel intermedio con GridLayout
	    JPanel gridPanel = new JPanel(new GridLayout(4, 2, 8, 8));
	    gridPanel.setBorder(new EmptyBorder(0,0,0,0));
	    gridPanel.setBackground(ColorPalette.getTransparent());
	    
	    String[] cyclistTypes = {"Gregario", "Clasicomaniaco", "Relojista", "Escalador", "Corredor", "Rodador"};
	    cyclistExpertise = new SelectorInput("Especialidad:", cyclistTypes, "Form_SignUp_Expertise_Selection");
	    gridPanel.add(cyclistExpertise);
	    
	    yearsOfexperience  = new NumericInput("Experienca (Años):");
	    gridPanel.add(yearsOfexperience);
	    
	    ciclistNames = new TextInput("Nombres:");
	    gridPanel.add(ciclistNames);
	    
	    ciclistLastNames = new TextInput("Apellidos:");
	    gridPanel.add(ciclistLastNames);
	    
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
	
	public void removeAllComponents() {
		removeAll();
	}
	
	public void reRenderComponents() {
		revalidate();
		repaint();
	}

	public TextInput getEmail() {
		return email;
	}

	public TextInput getDni() {
		return dni;
	}

	public NumericInput getYearsOfexperience() {
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

	public TextInput getNationality() {
		return nationality;
	}
}
