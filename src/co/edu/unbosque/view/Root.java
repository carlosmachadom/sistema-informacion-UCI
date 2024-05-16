package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Root extends JPanel {
	private LoginLayout authLayout;
	private AppLayout dashboard;
	
	public Root() {
		setLayout(new BorderLayout());
		
		setVisible(true);
	}
	
	public void insertAuthLogic() {
    	removeAllComponents();
    	reRenderApp();
    	authLayout = new LoginLayout(); // Crea una instancia del Layout para autenticación
        add(authLayout, BorderLayout.CENTER); // Agrega el LayoutPrincipal al centro de la ventana
        reRenderApp();
    }
    
    public void insertAppLogic() {
    	removeAllComponents();
    	reRenderApp();
    	dashboard = new AppLayout(); // Crea una instancia del Layout para autenticación
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

	public LoginLayout getAuthLayout() {
		return authLayout;
	}

	public void setAuthLayout(LoginLayout authLayout) {
		this.authLayout = authLayout;
	}

	public AppLayout getDashboard() {
		return dashboard;
	}

	public void setDashboard(AppLayout dashboard) {
		this.dashboard = dashboard;
	}
}
