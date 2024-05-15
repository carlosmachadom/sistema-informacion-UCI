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
		view.getRoot().getAuthLayout().getMainContent().insertHome();
	}
	
	public void setListeners() {
		if (view.getRoot().getAuthLayout().getMainContent().getEntry() != null) {
			view.getRoot().getAuthLayout().getMainContent().getEntry().getSignInButton().addActionListener(this);
			view.getRoot().getAuthLayout().getMainContent().getEntry().getRegisterButton().addActionListener(this);
		}
		
		if (view.getRoot().getAuthLayout().getMainContent().getSignIn() != null) {
			//view.getRoot().getAuthLayout().getMainContent().getEntry().getSignInButton().addActionListener(this);
			//view.getRoot().getAuthLayout().getMainContent().getEntry().getRegisterButton().addActionListener(this);
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
			//view.getRoot().getAuthLayout().getMainContent().getEntry().getSignInButton().addActionListener(this);
			//view.getRoot().getAuthLayout().getMainContent().getEntry().getRegisterButton().addActionListener(this);
		}
		
    	
    	// Manejo de eventos para pagina de registro
		if (view.getRoot().getAuthLayout().getMainContent().getSignUp() != null) {
			//view.getRoot().getAuthLayout().getMainContent().getEntry().getSignInButton().addActionListener(this);
			//view.getRoot().getAuthLayout().getMainContent().getEntry().getRegisterButton().addActionListener(this);
		}    	
    }

}
