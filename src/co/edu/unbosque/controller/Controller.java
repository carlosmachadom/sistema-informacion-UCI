package co.edu.unbosque.controller;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import co.edu.unbosque.model.Users;
import co.edu.unbosque.view.Window;

/**
 * Clase Controlador que maneja las interacciones entre la vista y el modelo,
 * y gestiona las acciones y eventos del usuario.
 */
public class Controller implements ActionListener {
	private Window view;
	private Users userAuh;
	// private Session // Carga los datos necesarios // Nombre // Correo
	// private boolean isLogged;
	
	/**
     * Constructor que inicializa la vista y el modelo de autenticación de usuario.
     */
	public Controller() {
		view = new Window();
		userAuh = new Users();
		
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
	}
	/**
     * Establece los listeners para los diferentes botones en la vista.
     */
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
    /**
     * Crea un nuevo usuario basado en el rol seleccionado.
     * 
     * @param role el rol seleccionado por el usuario
     */
    public void createNewUser(String role) {
    	if (role.equals("Director")) {
    		String dni = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getDni().getInput().getText();
    		String nationality = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getNationality().getInput().getText();
    		//String experience = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getYearsOfexperience().getInput();
    		//String email = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    		//String password = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    	}
    	
    	if (role.equals("Masajista")) {
    		//String dni = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getDni().getInput().getText();
    		//String experience = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    		//String email = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    		//String password = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    	}
    	
    	if (role.equals("Ciclista")) {
    		//String specialization = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    		//String experience = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    		//String names = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    		//String lastNames = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    		//String dni = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer().getDni().getInput().getText();
    		//String email = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    		//String password = view.getRoot().getAuthLayout().getPagesContainer().getSignUp().getRoleFormsContainer();
    	}
    }
    /**
     * Maneja el proceso de inicio de sesión.
     */
    public void login() {
    	
    }
}
