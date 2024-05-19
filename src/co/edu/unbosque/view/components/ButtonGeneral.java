package co.edu.unbosque.view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

public class ButtonGeneral extends JPanel {
	private JButton button;
	private String buttonText;
	private String command;
	private Color buttonColor;
	private Color textColor;
	
	public ButtonGeneral(String buttonText, String command, Color buttonColor, Color textColor) {
		this.buttonText = buttonText;
		this.command = command;
		this.buttonColor = buttonColor;
		this.textColor = textColor;
		
		initializeButton();		
	}	
	
	public void initializeButton() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0,0,0,0));
        setBackground(ColorPalette.getTransparent());
        
        insertComponents();
        
        setVisible(true);
	}
	
	public void insertComponents() {
        button = new JButton(buttonText);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(FontSystem.getH4());
        button.setForeground(textColor);
        button.setBorder(new EmptyBorder(12, 16, 12, 16));
        button.setBackground(buttonColor);
        button.setActionCommand(command);
        
        add(button, BorderLayout.CENTER);
	}

	public JButton getButton() {
		return button;
	}
}
