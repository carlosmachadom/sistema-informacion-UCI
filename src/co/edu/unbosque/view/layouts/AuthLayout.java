/**
 * 
 */
package co.edu.unbosque.view.layouts;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.unbosque.view.components.AuthBackground;

/**
 * 
 */
public class AuthLayout extends JPanel {
	private AuthPagesContainer pagesContainer;
	
	public AuthLayout() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		initializeComponents();
		
		setVisible(true);
	}
	
	public void initializeComponents() {
		pagesContainer = new AuthPagesContainer();
		
		JPanel contenedorImagen = new AuthBackground();
		
		add(pagesContainer);
		add(contenedorImagen);
	}

	public AuthPagesContainer getPagesContainer() {
		return pagesContainer;
	}
}
