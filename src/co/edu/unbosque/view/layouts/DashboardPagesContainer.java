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

public class DashboardPagesContainer extends JPanel {
	private TeamsList teams;
	private DirectorsList directors;
	private MassageTherapistsList therapists;
	private CyclistsList cyclists;
	private Race race;
	private RaceRecords raceRecors;
	private Profile profile;	
	
	
	public DashboardPagesContainer() {
		setLayout(new BorderLayout());
        setBackground(ColorPalette.getMainGray());
        setBorder(new EmptyBorder(40,40,40,40));
        setVisible(true);
    }	
	
	public void insertTeamsList() {
        removeAllComponents();
        reRenderComponents();
        teams = new TeamsList();
        add(teams, BorderLayout.CENTER);
        reRenderComponents();
    }

    public void insertDirectorsList() {
        removeAllComponents();
        reRenderComponents();
        directors = new DirectorsList();
        add(directors, BorderLayout.CENTER);
        reRenderComponents();
    }

    public void insertTherapistsList() {
        removeAllComponents();
        reRenderComponents();
        therapists = new MassageTherapistsList();
        add(therapists, BorderLayout.CENTER);
        reRenderComponents();
    }

    public void insertCyclistsList() {
        removeAllComponents();
        reRenderComponents();
        cyclists = new CyclistsList();
        add(cyclists, BorderLayout.CENTER);
        reRenderComponents();
    }

    public void insertRace() {
        removeAllComponents();
        reRenderComponents();
        race = new Race();
        add(race, BorderLayout.CENTER);
        reRenderComponents();
    }

    public void insertRaceRecords() {
        removeAllComponents();
        reRenderComponents();
        raceRecors = new RaceRecords();
        add(raceRecors, BorderLayout.CENTER);
        reRenderComponents();
    }

    public void insertProfile() {
        removeAllComponents();
        reRenderComponents();
        profile = new Profile();
        add(profile, BorderLayout.CENTER);
        reRenderComponents();
    }
	
	public void removeAllComponents() {
		removeAll();
	}
	
	public void reRenderComponents() {
		revalidate();
		repaint();
	}
}
