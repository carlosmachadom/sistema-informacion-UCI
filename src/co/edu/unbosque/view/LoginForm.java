/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */
public class LoginForm extends JPanel{
	private JComboBox<String> role; 
	private JTextField user;
	private JTextField password;
	private JButton loginButton;
	
	public LoginForm() {
		setLayout(new BorderLayout());
		initializeComponents();
		setVisible(true);
	}
	
	public void initializeComponents() {
		insertHeader();
		insertMainContent();
		insertFooter();
	}
	
	public void insertHeader() {
		AuthHeader header = new AuthHeader();
		add(header, BorderLayout.NORTH);
	}		
	
	public void insertMainContent() {
		
	}
	
	public void insertFooter() {
		AuthFooter footer = new AuthFooter();
		add(footer, BorderLayout.SOUTH);
	}
}
