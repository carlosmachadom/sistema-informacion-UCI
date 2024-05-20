package co.edu.unbosque.view.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * El panel que contiene la cabecera del panel de control.
 */
public class DashboardHeader extends JPanel {
	private String user;
	private String role;
	
	/**
	 * Constructor para inicializar la cabecera del panel de control.
	 */
	public DashboardHeader(String user, String role) {
		this.user = user;
		this.role = role;
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new EmptyBorder(24, 40, 24, 40));
		setBackground(ColorPalette.getMainWhite());

		initializeComponents();

		setVisible(true);
	}

	/**
	 * Inicializa los componentes de la cabecera.
	 */
	public void initializeComponents() {
		insertIcon();
		add(Box.createHorizontalGlue());
		insertRightPanel();
	}

	/**
	 * Inserta el icono en la cabecera.
	 */
	public void insertIcon() {
		ImageIcon iconPath = new ImageIcon("images" + File.separator + "isologo_uci.png");
		Image image = iconPath.getImage();
		Image scaled = image.getScaledInstance(60, 40, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaled);
		JLabel labelIcon = new JLabel(icon);
		add(labelIcon);
	}

	public void insertRightPanel() {
		JPanel userInfo = new JPanel();
		userInfo.setLayout(new BoxLayout(userInfo, BoxLayout.Y_AXIS));
		userInfo.setBackground(ColorPalette.getTransparent());
		
		JLabel userLabel = new JLabel(user);
		userLabel.setFont(FontSystem.getH4());
		userLabel.setForeground(ColorPalette.getMainBlack());
		
		JLabel roleLabel = new JLabel(role);
		roleLabel.setFont(FontSystem.getH6());
		roleLabel.setForeground(ColorPalette.getMainBlack());
		
		userInfo.add(userLabel);
		userInfo.add(roleLabel);
		add(userInfo);
	}

	public String getUser() {
		return user;
	}

	public String getRole() {
		return role;
	}
}
