/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * 
 */
public class LoginLayout extends JPanel {
	private AuthMainContent mainContent;
	
	public LoginLayout() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		initializeComponents();
		
		setVisible(true);
	}
	
	public void initializeComponents() {
		mainContent = new AuthMainContent();
		
		JPanel contenedorImagen = new AuthBackground();
		
		add(mainContent);
		add(contenedorImagen);
	}

	public AuthMainContent getMainContent() {
		return mainContent;
	}

	public void setMainContent(AuthMainContent mainContent) {
		this.mainContent = mainContent;
	}
}
