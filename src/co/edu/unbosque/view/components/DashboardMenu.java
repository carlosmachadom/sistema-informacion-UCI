package co.edu.unbosque.view.components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;

public class DashboardMenu extends JPanel {
	private ButtonGeneral logOutButton;
	private ButtonGeneral profileButton;
	
	private ButtonGeneral squadsListButton;
	private ButtonGeneral cyclistListButton;
	private ButtonGeneral therapistsListButton;
	private ButtonGeneral directorsListButton;
	private ButtonGeneral raceRecordButton;
	private ButtonGeneral raceButton;
	
	public DashboardMenu() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
		setBorder(new EmptyBorder(24,40,24,40));		
		setBackground(ColorPalette.getMainWhite());
		
		insertsMenuDirector();
		
		setVisible(true);
	}
	
	public void insertsMenuDirector() {
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(ColorPalette.getTransparent());
        Dimension maxSize = new Dimension(Integer.MAX_VALUE, 400);
        mainContent.setMaximumSize(maxSize);
        
        squadsListButton = new ButtonGeneral(
    		"Equipos", 
    		"Team_DashboardMenu", 
    		ColorPalette.getMainBlack(), 
    		ColorPalette.getMainWhite()
        );
        
        squadsListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContent.add(squadsListButton);
        mainContent.add(Box.createVerticalStrut(8));

        cyclistListButton = new ButtonGeneral(
    		"Ciclistas registrados", 
    		"Cyclists_DashboardMenu", 
    		ColorPalette.getMainBlack(), 
    		ColorPalette.getMainWhite()
		);
        
        cyclistListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContent.add(cyclistListButton);
        mainContent.add(Box.createVerticalStrut(8));

        therapistsListButton = new ButtonGeneral(
    		"Masagistas registrados", 
    		"Therapists_DashboardMenu", 
    		ColorPalette.getMainBlack(), 
    		ColorPalette.getMainWhite()
		);
        
        therapistsListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContent.add(therapistsListButton);
        mainContent.add(Box.createVerticalStrut(8));

        directorsListButton = new ButtonGeneral(
    		"Directores registrados", 
    		"Directors_DashboardMenu", 
    		ColorPalette.getMainBlack(), 
    		ColorPalette.getMainWhite()
		);
        
        directorsListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContent.add(directorsListButton);
        mainContent.add(Box.createVerticalStrut(8));

        raceRecordButton = new ButtonGeneral(
    		"Registro de carreras", 
    		"raceRecors_DashboardMenu", 
    		ColorPalette.getMainBlack(), 
    		ColorPalette.getMainWhite()
		);
        
        raceRecordButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContent.add(raceRecordButton);
        mainContent.add(Box.createVerticalStrut(8));

        raceButton = new ButtonGeneral(
        		"Iniciar carrera", 
        		"race_DashboardMenu", 
        		ColorPalette.getMainBlack(), 
        		ColorPalette.getMainWhite()
        		);
        
        raceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContent.add(raceButton);    
        
        // Agregar wrapperPanel al centro de este panel (CenteredMainContentPanel)
        add(mainContent);        
        add(Box.createVerticalGlue());
        insertProfileSection();
	}
	
	public void insertProfileSection() {
		JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(ColorPalette.getTransparent());
        Dimension maxSize = new Dimension(Integer.MAX_VALUE, 200); // Altura fija de 150 píxeles
        mainContent.setMaximumSize(maxSize);
        
        profileButton = new ButtonGeneral(
    		"Perfil", 
    		"Profile_DashboardMenu", 
    		ColorPalette.getMainBlack(), 
    		ColorPalette.getMainWhite()
        );
        
        profileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContent.add(profileButton);
        mainContent.add(Box.createVerticalStrut(8));
        
        logOutButton = new ButtonGeneral(
    		"Cerrar sesion", 
    		"LogOut_DashboardMenu", 
    		ColorPalette.getMainBlack(), 
    		ColorPalette.getMainWhite()
        );
            
        logOutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContent.add(logOutButton);
        
        add(mainContent);
	}

	public void insertsMenuCyclist() {
		
	}
	
	public void insertsMenuTherapist() {
		
	}

	public ButtonGeneral getLogOutButton() {
		return logOutButton;
	}

	public ButtonGeneral getProfileButton() {
		return profileButton;
	}

	public ButtonGeneral getSquadsListButton() {
		return squadsListButton;
	}

	public ButtonGeneral getCyclistListButton() {
		return cyclistListButton;
	}

	public ButtonGeneral getTherapistsListButton() {
		return therapistsListButton;
	}

	public ButtonGeneral getDirectorsListButton() {
		return directorsListButton;
	}

	public ButtonGeneral getRaceRecordButton() {
		return raceRecordButton;
	}

	public ButtonGeneral getRaceButton() {
		return raceButton;
	}
}
