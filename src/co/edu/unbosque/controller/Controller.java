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

import co.edu.unbosque.view.Window;

/**
 *
 */
public class Controller implements ActionListener {
	private Window view;
	
	public Controller() {
		view = new Window();
		
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
			view.getRoot().getAuthLayout().getPagesContainer().getEntry().getSignInButton().addActionListener(this);
			view.getRoot().getAuthLayout().getPagesContainer().getEntry().getRegisterButton().addActionListener(this);
		}
		
		if (view.getRoot().getAuthLayout().getPagesContainer().getSignIn() != null) {
			view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getSignInButton().addActionListener(this);
			view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getSignUpButton().addActionListener(this);
		}
		
		if (view.getRoot().getAuthLayout().getPagesContainer().getSignUp() != null) {
			view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRole().getSelector().addActionListener(this);
			view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getSignInButton().addActionListener(this);
			view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getSignUpButton().addActionListener(this);
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
				validateSignUpRoleForm();
    			setListeners();
    		}
		}
    	
    	// Manejo de eventos para pagina de inicio de sesión
    	if (view.getRoot().getAuthLayout().getPagesContainer().getSignIn() != null) {    		
    		if (command.equals("Form_SignIn")) {
    			// Validar usuario
    			//-- Obtener la info
    			String user = view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getUser().getText();
    			String password = view.getRoot().getAuthLayout().getPagesContainer().getSignIn().getPassword().getText();
    			
    			// Si falla la validación se envía el mensaje
    			
    			// Si no se procede a insertar el dashboard con el contexto del usuario
    		} else if (command.equals("Form_SignUp")) {
    			view.getRoot().getAuthLayout().getPagesContainer().insertRegistrationForm();   
				validateSignUpRoleForm();
    			setListeners();
    		}
		}
		
    	
    	// Manejo de eventos para pagina de registro
		if (view.getRoot().getAuthLayout().getPagesContainer().getSignUp() != null) {		
			if(command.equals("Form_SignUp_Role_Selection")) {
				validateSignUpRoleForm();
			} else if (command.equals("Form_SignIn")) {
				System.out.println("Holaa");
				view.getRoot().getAuthLayout().getPagesContainer().insertLoginForm();
    			setListeners();
    			
    		} else if (command.equals("Form_SignUp")) {
    			// Validar Creación de usuario usuario
    			
    			// Si falla la validación se envía el mensaje
    			
    			// Si no se procede a insertar el dashboard con el contexto del usuario
    		}
		}    	
    }
    
    public void validateSignUpRoleForm() {
    	if (view.getRoot().getAuthLayout().getPagesContainer().getSignUp() != null) {
    		String selectedRole = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRole().getSelector().getSelectedItem().toString();
    		
    		switch (selectedRole) {
    		case "Director":
    			view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().insertDirectorsForm();
    			break;
    		case "Masajista":
    			view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().insertMassageTherapistsForm();
    			break;
    		case "Ciclista":
    			view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().insertCyclistForm();
    			break;
    		default: 
    			break;
    		}    		
    	}
    	
    }

}
