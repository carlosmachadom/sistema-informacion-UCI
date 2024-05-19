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

public class DashboardHeader extends JPanel {
	public DashboardHeader() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));		
		setBorder(new EmptyBorder(24,40,24,40));
		setBackground(ColorPalette.getMainWhite());
		
		initializeComponents();
		
		setVisible(true);
	}
	
	public void initializeComponents() {
		insertIcon();
        add(Box.createHorizontalGlue());
        insertRightPanel();
	}
	
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
        userInfo.add(new JLabel("User id"));
        userInfo.add(new JLabel("User role"));
        add(userInfo);
    }
}
