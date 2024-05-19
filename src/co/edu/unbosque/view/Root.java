package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import co.edu.unbosque.view.layouts.AuthLayout;
import co.edu.unbosque.view.layouts.DashboardLayout;

/**
 * Esta clase es el panel raíz de la aplicación, encargado de gestionar los
 * layouts de autenticación y del dashboard. Permite cambiar dinámicamente entre
 * estos dos layouts según el estado de la aplicación.
 */
@SuppressWarnings("serial")
public class Root extends JPanel {
	private AuthLayout authLayout;
	private DashboardLayout dashboard;

	/**
	 * Constructor de la clase Root. Configura el panel principal con un
	 * BorderLayout.
	 */
	public Root() {
		setLayout(new BorderLayout());

		setVisible(true);
	}

	/**
	 * Método para insertar la lógica de autenticación. Crea y agrega el layout de
	 * autenticación al panel.
	 */
	public void insertAuthLogic() {
		removeAllComponents();
		reRenderApp();
		authLayout = new AuthLayout(); // Crea una instancia del Layout para autenticación
		add(authLayout, BorderLayout.CENTER); // Agrega el LayoutPrincipal al centro de la ventana
		reRenderApp();
	}

	/**
	 * Método para insertar la lógica de la aplicación (dashboard). Crea y agrega el
	 * layout del dashboard al panel.
	 */
	public void insertAppLogic() {
		removeAllComponents();
		reRenderApp();
		dashboard = new DashboardLayout(); // Crea una instancia del Layout para autenticación
		add(dashboard, BorderLayout.CENTER); // Agrega el LayoutPrincipal al centro de la ventana
		reRenderApp();
	}

	/**
	 * Método para remover todos los componentes del panel.
	 */
	public void removeAllComponents() {
		removeAll();
	}

	/**
	 * Método para revalidar y repintar el panel.
	 */
	public void reRenderApp() {
		revalidate();
		repaint();
	}

	/**
	 * Obtiene el layout de autenticación.
	 *
	 * @return el layout de autenticación
	 */
	public AuthLayout getAuthLayout() {
		return authLayout;
	}

	/**
	 * Establece el layout de autenticación.
	 *
	 * @param authLayout el layout de autenticación a establecer
	 */
	public void setAuthLayout(AuthLayout authLayout) {
		this.authLayout = authLayout;
	}

	/**
	 * Obtiene el layout del tablero.
	 *
	 * @return el layout del tablero
	 */
	public DashboardLayout getDashboard() {
		return dashboard;
	}

	/**
	 * Establece el layout del tablero.
	 *
	 * @param dashboard el layout del tablero a establecer
	 */
	public void setDashboard(DashboardLayout dashboard) {
		this.dashboard = dashboard;
	}
}
