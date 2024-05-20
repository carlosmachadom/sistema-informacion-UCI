package co.edu.unbosque.view.layouts;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.pages.Detail;
import co.edu.unbosque.view.pages.Profile;
import co.edu.unbosque.view.pages.Race;
import co.edu.unbosque.view.pages.TablePage;
import co.edu.unbosque.view.utils.ColorPalette;

/**
 * DashboardPagesContainer es un JPanel que actúa como contenedor para varias
 * páginas en el panel de control. Permite la inserción y eliminación dinámica
 * de diferentes componentes de página.
 */
public class DashboardPagesContainer extends JPanel {
	private TablePage tablePage;
	private Race race;
	private Detail detail;	
	private Profile profile;
	
    /**
     * Construye un nuevo DashboardPagesContainer con un BorderLayout y
     * configuraciones iniciales.
     */
	public DashboardPagesContainer() {
		setLayout(new BorderLayout());
        setBackground(ColorPalette.getMainGray());
        setBorder(new EmptyBorder(40,40,40,40));
        setVisible(true);
    }	
	
    /**
     * Inserta el componente MassageTherapistsList en el contenedor.
     */
    public void insertList(String[][] list, String[] headers, String tableName) {
        removeAllComponents();
        reRenderComponents();
        tablePage = new TablePage(list, headers, tableName);
        add(tablePage, BorderLayout.CENTER);
        reRenderComponents();
    }
    
    /**
     * Inserta el componente Race en el contenedor.
     */
    public void insertRace() {
        removeAllComponents();
        reRenderComponents();
        race = new Race();
        add(race, BorderLayout.CENTER);
        reRenderComponents();
    }
    
    /**
     * Inserta el componente Profile en el contenedor.
     */
    public void insertDetail(String title, String[][] data) {
        removeAllComponents();
        reRenderComponents();
        detail = new Detail(title, data);
        add(detail, BorderLayout.CENTER);
        reRenderComponents();
    }
    
    
    public void insertProfile(String title, String[][] data) {
    	removeAllComponents();
    	reRenderComponents();
    	profile = new Profile(title, data);
    	add(profile, BorderLayout.CENTER);
    	reRenderComponents();
    }
    
    /**
     * Elimina todos los componentes del contenedor.
     */
	public void removeAllComponents() {
		removeAll();
	}
    /**
     * Revalida y repinta el contenedor para reflejar los cambios.
     */
	public void reRenderComponents() {
		revalidate();
		repaint();
	}	
	
	public TablePage getTablePage() {
		return tablePage;
	}

	public Detail getProfile() {
		return detail;
	}
}
