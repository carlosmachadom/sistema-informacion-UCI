package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import co.edu.unbosque.view.layouts.AuthLayout;
import co.edu.unbosque.view.layouts.DashboardLayout;

@SuppressWarnings("serial")
public class Root extends JPanel {
	private AuthLayout authLayout;
	private DashboardLayout dashboard;
	
	public Root() {
		setLayout(new BorderLayout());
		
		setVisible(true);
	}
	
	public void insertAuthLogic() {
    	removeAllComponents();
    	reRenderApp();
    	authLayout = new AuthLayout(); // Crea una instancia del Layout para autenticación
        add(authLayout, BorderLayout.CENTER); // Agrega el LayoutPrincipal al centro de la ventana
        reRenderApp();
    }
    
    public void insertAppLogic() {
    	removeAllComponents();
    	reRenderApp();
    	dashboard = new DashboardLayout(); // Crea una instancia del Layout para autenticación
        add(dashboard, BorderLayout.CENTER); // Agrega el LayoutPrincipal al centro de la ventana
        reRenderApp();
    }
    
    public void removeAllComponents() {
    	removeAll();
    }
    
    public void reRenderApp() {
    	revalidate();
    	repaint();
    }

	public AuthLayout getAuthLayout() {
		return authLayout;
	}

	public void setAuthLayout(AuthLayout authLayout) {
		this.authLayout = authLayout;
	}

	public DashboardLayout getDashboard() {
		return dashboard;
	}

	public void setDashboard(DashboardLayout dashboard) {
		this.dashboard = dashboard;
	}
}
