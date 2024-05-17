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
		view.getRoot().getAuthLayout().getMainContent().insertHome();
	}
	
	public void setListeners() {
		if (view.getRoot().getAuthLayout().getMainContent().getEntry() != null) {
			view.getRoot().getAuthLayout().getMainContent().getEntry().getSignInButton().addActionListener(this);
			view.getRoot().getAuthLayout().getMainContent().getEntry().getRegisterButton().addActionListener(this);
		}
		
		if (view.getRoot().getAuthLayout().getMainContent().getSignIn() != null) {
			view.getRoot().getAuthLayout().getMainContent().getSignIn().getSignInButton().addActionListener(this);
			view.getRoot().getAuthLayout().getMainContent().getSignIn().getSignUpButton().addActionListener(this);
		}
		
		if (view.getRoot().getAuthLayout().getMainContent().getSignUp() != null) {
			//view.getRoot().getAuthLayout().getMainContent().getEntry().getSignInButton().addActionListener(this);
			//view.getRoot().getAuthLayout().getMainContent().getEntry().getRegisterButton().addActionListener(this);
		}
	}

    @Override
    public void actionPerformed(ActionEvent e) {
    	String command = e.getActionCommand();
    	validateAction(command);
    }
    
    public void validateAction(String command) {
    	
    	// Manejo de eventos para pagina de inicio
    	if (view.getRoot().getAuthLayout().getMainContent().getEntry() != null) {
    		if (command.equals("Home_SignIn")) {
    			view.getRoot().getAuthLayout().getMainContent().insertLoginForm();
    			setListeners();
    		} else if (command.equals("Home_SignUp")) {
    			view.getRoot().getAuthLayout().getMainContent().insertRegistrationForm();    			
    			setListeners();
    		}
		}
    	
    	// Manejo de eventos para pagina de inicio de sesión
    	if (view.getRoot().getAuthLayout().getMainContent().getSignIn() != null) {    		
    		if (command.equals("Form_SignIn")) {
    			// Validar usuario
    			//-- Obtener la info
    			String role = view.getRoot().getAuthLayout().getMainContent().getSignIn().getRole().getSelectedItem().toString();
    			String user = view.getRoot().getAuthLayout().getMainContent().getSignIn().getUser().getText();
    			String password = view.getRoot().getAuthLayout().getMainContent().getSignIn().getPassword().getText();
    			
    			// Si falla la validación se envía el mensaje
    			
    			
    			// Si no se procede a insertar el dashboard con el contexto del usuario
    		} else if (command.equals("Form_SignUp")) {
    			view.getRoot().getAuthLayout().getMainContent().insertRegistrationForm();    			
    			setListeners();
    		}
		}
		
    	
    	// Manejo de eventos para pagina de registro
		if (view.getRoot().getAuthLayout().getMainContent().getSignUp() != null) {
			if (command.equals("Form_SignIn")) {
				view.getRoot().getAuthLayout().getMainContent().insertLoginForm();
    			setListeners();
    			
    		} else if (command.equals("Form_SignUp")) {
    			// Validar Creación de usuario usuario
    			
    			// Si falla la validación se envía el mensaje
    			
    			// Si no se procede a insertar el dashboard con el contexto del usuario
    		}
		}    	
    }

}
