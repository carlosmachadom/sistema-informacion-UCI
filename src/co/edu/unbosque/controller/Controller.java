package co.edu.unbosque.controller;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.user.Users;
import co.edu.unbosque.model.cyclists.Cyclists;
import co.edu.unbosque.model.director.Directors;
import co.edu.unbosque.model.persistence.DTO.CyclistDTO;
import co.edu.unbosque.model.persistence.DTO.DirectorDTO;
import co.edu.unbosque.model.persistence.DTO.MassageDTO;
import co.edu.unbosque.model.persistence.DTO.UserDTO;
import co.edu.unbosque.model.therapist.MassageTherapists;
import co.edu.unbosque.view.Window;
import co.edu.unbosque.view.utils.MessageDialog;
import co.edu.unbosque.view.utils.NumberConverter;
import co.edu.unbosque.view.utils.StringFieldsValidator;
import co.edu.unbosque.view.utils.ValidationMessages;

/**
 * Clase Controlador que maneja las interacciones entre la vista y el modelo,
 * y gestiona las acciones y eventos del usuario.
 */
public class Controller implements ActionListener {
	private Window view;
	private Users userAuth;
	private Directors directorsList;
	private MassageTherapists therapistsList;
	private Cyclists cyclistsList;
	// private Session // Carga los datos necesarios // Nombre // Correo
	// private boolean isLogged;
	
	/**
     * Constructor que inicializa la vista y el modelo de autenticación de usuario.
     */
	public Controller() {
		view = new Window();
		userAuth = new Users();
		run();
	}
	 /**
     * Ejecuta la configuración inicial estableciendo el estado inicial y los listeners.
     */
	public void run() {
		initialState();
		setListeners();
	}
	/**
     * Establece el estado inicial de la vista.
     */
	public void initialState() {
		view.getRoot().insertAuthLogic();
		view.getRoot().getAuthLayout().getPagesContainer().insertHome();
		
		//view.getRoot().insertAppLogic();
	}
	/**
     * Establece los listeners para los diferentes botones en la vista.
     */
	public void setListeners() {
		if(view.getRoot().getAuthLayout() != null) {
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
	}

	/**
     * Maneja los eventos de acción desencadenados por el usuario.
     * 
     * @param e el evento ActionEvent desencadenado por la interacción del usuario
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	String command = e.getActionCommand();
    	validateAction(command);
    }
    /**
     * Valida el comando de acción y realiza la acción correspondiente.
     * 
     * @param command el comando a validar
     */
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
    			login();
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
    /**
     * Crea un nuevo usuario basado en el rol seleccionado.
     * 
     * @param role el rol seleccionado por el usuario
     */
	public void createNewUser(String role) {
    	String dni = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getDni().getInput().getText();
    	Object experience = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getYearsOfexperience().getInput().getValue();
		String email = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getEmail().getInput().getText();
		char[] password = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getPassword().getInput().getPassword();
		String nationality = null;
		String names = null;
		String lastNames = null;		
		
		
		UserDTO newUser = new UserDTO();
		DirectorDTO newDirector = null;
		CyclistDTO newCyclist = null;
		MassageDTO newTherapist = null; 
		
		if (role.equals("Director")) {
			newDirector = new DirectorDTO();
		}
		
		if (role.equals("Ciclista")) {
			newCyclist = new CyclistDTO();
		}
		
		if (role.equals("Masagista")) {
			newTherapist = new MassageDTO();
		}
		
		boolean isValidUser = true;
		
		if (role.equals("Ciclista") && newCyclist != null) {
			boolean validName = true;
			
			names = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getCiclistLastNames().getInput().getText();
			
			if(!StringFieldsValidator.isValidText(names)) {
				MessageDialog.showWarningDialog(null, ValidationMessages.getRequiredFieldMessage("Nombres"));
				validName = false;
			}

			lastNames = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getCiclistLastNames().getInput().getText();
			
			if(!StringFieldsValidator.isValidText(lastNames)) {
				MessageDialog.showWarningDialog(null, ValidationMessages.getRequiredFieldMessage("Apellidos"));
				validName = false;
			}
			
			if (validName) {
				newCyclist.setName(names + " " +lastNames);
			}
		}
		

		// Agregando Cedula al DTO
		if (StringFieldsValidator.isValidString(dni)) {
			try {
				long cc = NumberConverter.convertToLong(dni);
				newUser.setCC(cc);
				
				if (role.equals("Director") && newDirector != null) {
					newDirector.setCC(cc);
				}
				
				if (role.equals("Ciclista") && newCyclist != null) {
					newCyclist.setCC(cc);
				}
				
				if (role.equals("Masagista") && newTherapist != null) {
					newTherapist.setCC(cc);
				}
				
			} catch (NumberFormatException e) {
				MessageDialog.showWarningDialog(null, "Este campo solo acepta numeros");
				isValidUser = false;
			}
		} else {
			MessageDialog.showWarningDialog(null, ValidationMessages.getRequiredFieldMessage("Cédula"));
			isValidUser = false;
		}
		
		if (role.equals("Director") && newDirector != null) {
			nationality = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getNationality().getInput().getText();
			
			if(StringFieldsValidator.isValidText(nationality)) {
				newDirector.setNationality(nationality);
			} else {
				MessageDialog.showWarningDialog(null, ValidationMessages.getRequiredFieldMessage("Nacionalidad"));
				isValidUser = false;
			}
		}
		
		// Agregando email al DTO
		if (StringFieldsValidator.isValidEmail(email)) {
			newUser.setEmail(email);
			
			if (role.equals("Director") && newDirector != null) {
				newDirector.setEmail(email);
			}
			
			if (role.equals("Ciclista") && newCyclist != null) {
				newCyclist.setEmail(email);
			}
			
			if (role.equals("Masagista") && newTherapist != null) {
				newTherapist.setEmail(email);
			}			
		} else {
			MessageDialog.showWarningDialog(null, ValidationMessages.getRequiredFieldMessage("Correo electrónico"));
			isValidUser = false;
		}
		
		// Agregando experiencia al DTO
		if (experience != null) {
			Number xp = (Number) experience;
			newUser.setExperience(xp.intValue());
			
			if (role.equals("Director") && newDirector != null) {
				newDirector.setExperience(xp.intValue());
			}
			
			if (role.equals("Ciclista") && newCyclist != null) {
				newCyclist.setExperience(xp.intValue());
			}
			
			if (role.equals("Masagista") && newTherapist != null) {
				newTherapist.setExperience(xp.intValue());
			}	
		} else {
			MessageDialog.showWarningDialog(null, ValidationMessages.getRequiredFieldMessage("Experiencia"));
			isValidUser = false;
		}
		
		// Agregar experiencia al DTO
		if (password != null && password.length > 0) {
			String passwordString = new String(password);
			
			if (StringFieldsValidator.isValidPassword(passwordString)) {
				newUser.setPassword(passwordString);
				
				if (role.equals("Director") && newDirector != null) {
					newDirector.setPassword(passwordString);
				}		
				
				if (role.equals("Ciclista") && newCyclist != null) {
					newCyclist.setPassword(passwordString);
				}
				
				if (role.equals("Masagista") && newTherapist != null) {
					newTherapist.setPassword(passwordString);
				}	
			} else {
				MessageDialog.showWarningDialog(null, ValidationMessages.getWeakPasswordMessage());
				isValidUser = false;
			}
		} else {
			MessageDialog.showWarningDialog(null, ValidationMessages.getRequiredFieldMessage("Contraseña"));
			isValidUser = false;
		}
		
		if (isValidUser) {
			boolean userCreated = userAuth.add(newUser);
			
			if (userCreated) {
				boolean roleCreated = false;
				
				switch (role) {				
				case "Director":
					directorsList = new Directors();
					roleCreated = directorsList.add(newDirector);
					break;
				case "Masajista": 
					therapistsList = new MassageTherapists();
					roleCreated = therapistsList.add(newTherapist);
					break;
				case "Ciclista":
					cyclistsList = new Cyclists();
					roleCreated = cyclistsList.add(newCyclist);
					break;
				default:
					break;
				}
				
				if (roleCreated) {					
					MessageDialog.showSuccessDialog(null, ValidationMessages.getRegistrationSuccessMessage());
					view.getRoot().getAuthLayout().getPagesContainer().insertHome();
					setListeners();
				}
			} else {
				MessageDialog.showErrorDialog(null, ValidationMessages.getUserAlreadyExistsMessage());
				return;
			}
		}
    }
    /**
     * Maneja el proceso de inicio de sesión.
     */
    public void login() {    	
    	if (view.getRoot().getAuthLayout().getPagesContainer().getSignIn() != null) {
    		String user = view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getUser().getInput().getText();
    		char[] password = view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getPassword().getInput().getPassword();
    		
    		// String passwordString = new String(password);
    		// Arrays.fill(password, ' ');
    		
    		
    		
//    		if (password != null && password.length > 0) {
//    			String passwordString = new String(password);
//    			
//    			if (StringFieldsValidator.isValidPassword(passwordString)) {
//    				newUser.setPassword(passwordString);	
//    			} else {
//    				MessageDialog.showWarningDialog(null, ValidationMessages.getWeakPasswordMessage());
//    				isValidUser = false;
//    			}
//    		} else {
//    			MessageDialog.showWarningDialog(null, ValidationMessages.getRequiredFieldMessage("Contraseña"));
//    			isValidUser = false;
//    		}
//    		
    	}
    }
}
