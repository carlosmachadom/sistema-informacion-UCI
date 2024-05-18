/**
 *
 */
package co.edu.unbosque.controller;

/**
 *
 */

import java.awt.event.ActionEvent;

/**
 *
 */
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Users;
import co.edu.unbosque.model.persistence.DTO.UserDTO;
import co.edu.unbosque.view.Window;
import co.edu.unbosque.view.utils.NumberConverter;
import co.edu.unbosque.view.utils.StringFieldsValidator;

/**
 *
 */
public class Controller implements ActionListener {
	private Window view;
	private Users userAuth;
	// private Session // Carga los datos necesarios // Nombre // Correo
	// private boolean isLogged;
	
	public Controller() {
		view = new Window();
		userAuth = new Users();
		
		run();
	}
	
	public void run() {
		initialState();
		setListeners();
	}
	
	public void initialState() {
		view.getRoot().insertAuthLogic();
		view.getRoot().getAuthLayout().getPagesContainer().insertHome();
	}
	
	public void setListeners() {
		if (view.getRoot().getAuthLayout().getPagesContainer().getEntry() != null) {
			view.getRoot().getAuthLayout().getPagesContainer().getEntry().getSignInButton().getButton().addActionListener(this);
			view.getRoot().getAuthLayout().getPagesContainer().getEntry().getRegisterButton().getButton().addActionListener(this);
		}
		
		if (view.getRoot().getAuthLayout().getPagesContainer().getSignIn() != null) {
			view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getSignInButton().getButton().addActionListener(this);
			view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getSignUpButton().getButton().addActionListener(this);
		}
		
		if (view.getRoot().getAuthLayout().getPagesContainer().getSignUp() != null) {
			view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getSignInButton().getButton().addActionListener(this);
			view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getSignUpButton().getButton().addActionListener(this);
		}
	}

    @Override
    public void actionPerformed(ActionEvent e) {
    	String command = e.getActionCommand();
    	validateAction(command);
    }
    
    public void validateAction(String command) {
    	
    	// Manejo de eventos para pagina de inicio
    	if (view.getRoot().getAuthLayout().getPagesContainer().getEntry() != null) {
    		if (command.equals("Home_SignIn")) {
    			view.getRoot().getAuthLayout().getPagesContainer().insertLoginForm();
    			setListeners();
    		} else if (command.equals("Home_SignUp")) {
    			view.getRoot().getAuthLayout().getPagesContainer().insertRegistrationForm();
    			setListeners();
    		}
		}
    	
    	// Manejo de eventos para pagina de inicio de sesión
    	if (view.getRoot().getAuthLayout().getPagesContainer().getSignIn() != null) {    		
    		if (command.equals("Login_Form_SignIn")) {
    			// Validar usuario
    			String user = view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getUser().getInput().getText();
    			char[] password = view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getPassword().getInput().getPassword();
    			// String passwordString = new String(password);
    			// Arrays.fill(password, ' ');
    			
    			// Si falla la validación se envía el mensaje
    			
    			// Si no se procede a insertar el dashboard con el contexto del usuario
    		} else if (command.equals("Login_Form_SignUp")) {
    			view.getRoot().getAuthLayout().getPagesContainer().insertRegistrationForm();
    			setListeners();
    		}
		}
		
    	
    	// Manejo de eventos para pagina de registro
		if (view.getRoot().getAuthLayout().getPagesContainer().getSignUp() != null) {		
			if (command.equals("Registration_Form_SignIn")) {
				view.getRoot().getAuthLayout().getPagesContainer().insertLoginForm();
    			setListeners();    			
    		} else if (command.equals("Registration_Form_SignUp")) {
    			String currentRole = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRole().getSelector().getSelectedItem().toString();
    			createNewUser(currentRole);
    		}
		}    	
    }
    
    public void createNewUser(String role) {
    	String dni = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getDni().getInput().getText();
    	Object experience = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getYearsOfexperience().getInput().getValue();
		String email = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getEmail().getInput().getText();
		char[] password = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getPassword().getInput().getPassword();
		
		UserDTO newUser = new UserDTO();
		boolean isValidUser = true;

		// Agregando Cedula al DTO
		if (StringFieldsValidator.isValidString(dni)) {
			try {
				long cc = NumberConverter.convertToLong(dni);
				newUser.setCC(cc);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ingreso de datos no valido: Este campo solo acepta numeros.", "Error", JOptionPane.ERROR_MESSAGE);
				isValidUser = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ingreso de datos no valido: El campo de CC no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
			isValidUser = false;
		}
		
		// Agregando email al DTO
		if (StringFieldsValidator.isValidEmail(email)) {
			newUser.setEmail(email);
		} else {
			JOptionPane.showMessageDialog(null, "Error: Email no valido", "Error", JOptionPane.ERROR_MESSAGE);
			isValidUser = false;
		}
		
		// Agregando experiencia al DTO
		if (experience != null) {
			Number xp = (Number) experience;
			newUser.setExperience(xp.intValue());
		} else {
			JOptionPane.showMessageDialog(null, "Ingreso de datos no valido: El campo de experiencia no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
			isValidUser = false;
		}
		
		// Agregar experiencia al DTO
		if (password != null && password.length > 0) {
			String passwordString = new String(password);
			
			if (StringFieldsValidator.isValidPassword(passwordString)) {
				newUser.setPassword(passwordString);
			} else {
				JOptionPane.showMessageDialog(null, "La contraseña debe cumplir con los siguientes requisitos:\n"
						+ "1. Al menos 8 caracteres de longitud.\n"
						+ "2. Contener al menos un dígito (0-9).\n"
						+ "3. Contener al menos una letra mayúscula o minúscula (a-z, A-Z).\n"
						+ "4. Contener al menos un carácter especial, como !@#$%^&", "Error", JOptionPane.ERROR_MESSAGE);
				isValidUser = false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ingreso de datos no valido: El campo contraseña no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
			isValidUser = false;
		}
		
		if (isValidUser) {
			System.out.println(newUser.toString());
			boolean userCreated = userAuth.add(newUser);
//			
//			if (userCreated) {
//				boolean roleCreated = false;
//				
//				switch (role) {				
//				case "Director":
//					String nationality = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getNationality().getInput().getText();
//					//Crear DTO Director y agregar
//					
//					break;
//				case "Masajista": 
//					// Crear Masajista DTO y agregar
//					break;
//				case "Ciclista":
//					// Crear Ciclista DTO y agregar
//					String specialization = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getCyclistExpertise().getSelector().getSelectedItem().toString();
//					String names = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getCiclistLastNames().getInput().getText();
//					String lastNames = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getCiclistLastNames().getInput().getText();
//					break;
//				default:
//					break;
//				}
				
//				if (roleCreated) {
//					//Iniciar sesión
//				}
//			} else {
//				JOptionPane.showMessageDialog(null, "Error: El usuario ingresado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
//				return;
//			}
		}
    }
    
    public void login() {
    	
    }
}
