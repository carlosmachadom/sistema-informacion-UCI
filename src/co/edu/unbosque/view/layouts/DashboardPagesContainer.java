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
	
		
	
	public void removeAllComponents() {
		removeAll();
	}
	
	public void reRenderComponents() {
		revalidate();
		repaint();
	}
}
