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

import co.edu.unbosque.model.Users;
import co.edu.unbosque.view.Window;

/**
 *
 */
public class Controller implements ActionListener {
	private Window view;
	private Users userAuh;
	// private Session // Carga los datos necesarios // Nombre // Correo
	// private boolean isLogged;
	
	public Controller() {
		view = new Window();
		userAuh = new Users();
		
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
    		if (command.equals("Form_SignIn")) {
    			// Validar usuario
    			String user = view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getUser().getInput().getText();
    			char[] password = view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getPassword().getInput().getPassword();
    			// String passwordString = new String(password);
    			// Arrays.fill(password, ' ');
    			
    			// Si falla la validación se envía el mensaje
    			
    			// Si no se procede a insertar el dashboard con el contexto del usuario
    		} else if (command.equals("Form_SignUp")) {
    			view.getRoot().getAuthLayout().getPagesContainer().insertRegistrationForm();
    			setListeners();
    		}
		}
		
    	
    	// Manejo de eventos para pagina de registro
		if (view.getRoot().getAuthLayout().getPagesContainer().getSignUp() != null) {		
			if (command.equals("Form_SignIn")) {
				view.getRoot().getAuthLayout().getPagesContainer().insertLoginForm();
    			setListeners();    			
    		} else if (command.equals("Form_SignUp")) {
    			String currentRole = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRole().getSelector().getSelectedItem().toString();
    			createNewUser(currentRole);
    		}
		}    	
    }
    
    public void createNewUser(String role) {
    	if (role.equals("Director")) {
    		//String dni = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String nationality = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String experience = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String email = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String password = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    	}
    	
    	if (role.equals("Masajista")) {
    		//String dni = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String experience = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String email = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String password = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    	}
    	
    	if (role.equals("Ciclista")) {
    		//String specialization = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String experience = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String names = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String lastNames = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String dni = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String email = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    		//String password = view.getRoot().getAuthLayout().getPagesContainer().getSignUp();
    	}
    }
    
    public void login() {
    	
    }
}
