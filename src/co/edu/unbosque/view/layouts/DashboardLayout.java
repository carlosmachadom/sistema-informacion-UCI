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
 * DashboardLayout es un JPanel que actúa como el contenedor principal del 
 * tablero, organizando los componentes principales como el encabezado, 
 * el menú y el contenedor de páginas.
 */
public class DashboardLayout extends JPanel {
	private DashboardPagesContainer pagesContainer;
	private DashboardMenu menuContainer;
	private DashboardHeader header;
	private String role;
	private String user;
	
/**
 * Construye un nuevo DashboardLayout con un BorderLayout y 
 * configuraciones iniciales.
 */
	public DashboardLayout(String user, String role) {
		this.user = user;
		this.role = role;
		
		initializeHeader();
	}
	
	public void initializeHeader() {
		setLayout(new BorderLayout());
		
		initializeComponents();
		
		setVisible(true);		
	}
	
    /**
     * Inicializa y agrega los componentes principales al DashboardLayout.
     */
	public void initializeComponents() {
		header = new DashboardHeader(user, role);
		
		menuContainer = new DashboardMenu();

		pagesContainer = new DashboardPagesContainer();
		
		add(header, BorderLayout.NORTH);
		add(menuContainer, BorderLayout.WEST);
		add(pagesContainer, BorderLayout.CENTER);
	}

	public DashboardPagesContainer getPagesContainer() {
		return pagesContainer;
	}

	public DashboardMenu getMenuContainer() {
		return menuContainer;
	}

	public DashboardHeader getHeader() {
		return header;
	}
}
