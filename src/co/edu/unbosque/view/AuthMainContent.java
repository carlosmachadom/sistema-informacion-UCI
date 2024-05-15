package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class AuthMainContent extends JPanel {
	private Home entry;
	private LoginForm signIn;
	private RegistrationForm signUp;
	
	 public AuthMainContent() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(ColorPalette.getMainWhite());
        setMaximumSize(new Dimension(720, Integer.MAX_VALUE)); // Establecer ancho fijo y altura flexible
    }

    @Override
    public Dimension getPreferredSize() {
        // Ajustar el tamaño preferido solo en función del ancho fijo
        return new Dimension(720, super.getPreferredSize().height);
    }
	
	 public void insertHome() {
		removeAllComponents();
		reRenderComponents();
		
		// Insertar Home
		entry = new Home();
		add(entry);
		
		reRenderComponents();
	 }
	
	public void insertLoginForm() {
		removeAllComponents();
		reRenderComponents();
		
		// Insertar signIn
		signIn = new LoginForm();
		add(signIn);
		
		reRenderComponents();
	}
	
	public void insertRegistrationForm() {
		removeAllComponents();
		reRenderComponents();
		
		// Insertar signUp
		signUp = new RegistrationForm();
		add(signUp);
		
		reRenderComponents();
	}

	public void removeAllComponents() {
		removeAll();
	}
	
	public void reRenderComponents() {
		revalidate();
		repaint();
	}

	public Home getEntry() {
		return entry;
	}

	public LoginForm getSignIn() {
		return signIn;
	}

	public RegistrationForm getSignUp() {
		return signUp;
	}
}
