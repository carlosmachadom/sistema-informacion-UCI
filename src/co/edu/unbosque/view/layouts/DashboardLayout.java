/**
 * 
 */
package co.edu.unbosque.view.layouts;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import co.edu.unbosque.view.components.DashboardHeader;
import co.edu.unbosque.view.components.DashboardMenu;
import co.edu.unbosque.view.utils.ColorPalette;

/**
 * 
 */
public class DashboardLayout extends JPanel {
private DashboardPagesContainer pagesContainer;
private DashboardMenu menuContainer;
private DashboardHeader header;
	
	public DashboardLayout() {
		setLayout(new BorderLayout());
		
		initializeComponents();
		
		setVisible(true);
	}
	
	public void initializeComponents() {
		header = new DashboardHeader();
		
		menuContainer = new DashboardMenu();

		pagesContainer = new DashboardPagesContainer();
		
		add(header, BorderLayout.NORTH);
		add(menuContainer, BorderLayout.WEST);
		add(pagesContainer, BorderLayout.CENTER);
	}
}
