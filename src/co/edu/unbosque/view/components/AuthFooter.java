package co.edu.unbosque.view.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AuthFooter extends JPanel{
	public AuthFooter() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBorder(new EmptyBorder(40,40,40,40));
		setBackground(new Color(255,245,248));
		
		initializeComponents();
		
		setVisible(true);
	}
	
	public void initializeComponents() {    	
    	JLabel textoPiePagina = new JLabel("Union cicliste internationale");
    	Font fontTextoPiePagina = new Font("Arial", Font.BOLD, 18);
    	textoPiePagina.setFont(fontTextoPiePagina);
    	textoPiePagina.setForeground(new Color(0, 34, 77));
    	
    	add(textoPiePagina);
	}
}
