/**
 * 
 */
package co.edu.unbosque.view.layouts;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import co.edu.unbosque.view.utils.ColorPalette;

/**
 * 
 */
public class DashboardLayout extends JPanel {
private JPanel pagesContainer;
private JPanel menuContainer;
private JPanel header;
private JPanel footer;
	
	public DashboardLayout() {
		setLayout(new BorderLayout());
		
		initializeComponents();
		
		setVisible(true);
	}
	
	public void initializeComponents() {
		header = new JPanel();
		header.setBackground(ColorPalette.getMainPurple());
		
		menuContainer = new JPanel();
		menuContainer.setBackground(ColorPalette.getMainGray());

		pagesContainer = new JPanel();
		pagesContainer.setBackground(ColorPalette.getMainWhite());

		footer = new JPanel();
		footer.setBackground(ColorPalette.getMainBlack());
		
		add(header, BorderLayout.NORTH);
		add(menuContainer, BorderLayout.WEST);
		add(pagesContainer, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
	}
}
