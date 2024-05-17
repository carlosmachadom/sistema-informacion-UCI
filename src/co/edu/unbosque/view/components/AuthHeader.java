package co.edu.unbosque.view.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AuthHeader extends JPanel {
	public AuthHeader() {
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setBorder(new EmptyBorder(40,40,40,40));
		setBackground(new Color(255,245,248));
		
		initializeComponents();
		
		setVisible(true);
	}
	
	public void initializeComponents() {
		ImageIcon iconPath = new ImageIcon("images" + File.separator + "isologo_uci.png");
        Image image = iconPath.getImage();
        Image scaled = image.getScaledInstance(60, 40, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);
        JLabel labelIcon = new JLabel(icon);	
		add(labelIcon);
	}
}
