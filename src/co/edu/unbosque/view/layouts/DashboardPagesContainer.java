package co.edu.unbosque.view.layouts;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.pages.CyclistsList;
import co.edu.unbosque.view.pages.DirectorsList;
import co.edu.unbosque.view.pages.MassageTherapistsList;
import co.edu.unbosque.view.pages.Profile;
import co.edu.unbosque.view.pages.Race;
import co.edu.unbosque.view.pages.RaceRecords;
import co.edu.unbosque.view.pages.TeamsList;
import co.edu.unbosque.view.utils.ColorPalette;

/**
 * DashboardPagesContainer es un JPanel que actúa como contenedor para varias
 * páginas en el panel de control. Permite la inserción y eliminación dinámica
 * de diferentes componentes de página.
 */
public class DashboardPagesContainer extends JPanel {
	private TeamsList teams;
	private DirectorsList directors;
	private MassageTherapistsList therapists;
	private CyclistsList cyclists;
	private Race race;
	private RaceRecords raceRecors;
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
     * Inserta el componente TeamsList en el contenedor.
     */
	public void insertTeamsList() {
        removeAllComponents();
        reRenderComponents();
        teams = new TeamsList();
        add(teams, BorderLayout.CENTER);
        reRenderComponents();
    }
    /**
     * Inserta el componente DirectorsList en el contenedor.
     */
    public void insertDirectorsList(String[][] list, String[] headers, String tableName) {
        removeAllComponents();
        reRenderComponents();
        directors = new DirectorsList(list, headers, tableName);
        add(directors, BorderLayout.CENTER);
        reRenderComponents();
    }
    /**
     * Inserta el componente MassageTherapistsList en el contenedor.
     */
    public void insertTherapistsList() {
        removeAllComponents();
        reRenderComponents();
        therapists = new MassageTherapistsList();
        add(therapists, BorderLayout.CENTER);
        reRenderComponents();
    }
    /**
     * Inserta el componente CyclistsList en el contenedor.
     */
    public void insertCyclistsList() {
        removeAllComponents();
        reRenderComponents();
        cyclists = new CyclistsList();
        add(cyclists, BorderLayout.CENTER);
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
     * Inserta el componente RaceRecords en el contenedor.
     */
    public void insertRaceRecords() {
        removeAllComponents();
        reRenderComponents();
        raceRecors = new RaceRecords();
        add(raceRecors, BorderLayout.CENTER);
        reRenderComponents();
    }
    /**
     * Inserta el componente Profile en el contenedor.
     */
    public void insertProfile() {
        removeAllComponents();
        reRenderComponents();
        profile = new Profile();
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
	public TeamsList getTeams() {
		return teams;
	}
	public DirectorsList getDirectors() {
		return directors;
	}
	public MassageTherapistsList getTherapists() {
		return therapists;
	}
	public CyclistsList getCyclists() {
		return cyclists;
	}
	public Race getRace() {
		return race;
	}
	public RaceRecords getRaceRecors() {
		return raceRecors;
	}
	public Profile getProfile() {
		return profile;
	}
}
