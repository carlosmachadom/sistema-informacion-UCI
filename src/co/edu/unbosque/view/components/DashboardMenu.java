package co.edu.unbosque.view.components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;

/**
 * La clase DashboardMenu representa el menú lateral en el panel de control.
 * Proporciona opciones de navegación y acciones para diferentes tipos de
 * usuarios.
 */
public class DashboardMenu extends JPanel {
	private ButtonGeneral logOutButton;
	private ButtonGeneral profileButton;

	private ButtonGeneral squadsListButton;
	private ButtonGeneral cyclistListButton;
	private ButtonGeneral therapistsListButton;
	private ButtonGeneral directorsListButton;
	private ButtonGeneral raceRecordButton;
	private ButtonGeneral raceButton;

	/**
	 * Constructor de la clase DashboardMenu. Inicializa y configura los componentes
	 * del menú.
	 */
	public DashboardMenu() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(24, 40, 24, 40));
		setBackground(ColorPalette.getMainWhite());

		insertsMenuDirector();

		setVisible(true);
	}

	/**
	 * Inserta las opciones de menú para un director.
	 */
	public void insertsMenuDirector() {
		JPanel mainContent = new JPanel();
		mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
		mainContent.setBackground(ColorPalette.getTransparent());
		Dimension maxSize = new Dimension(Integer.MAX_VALUE, 400);
		mainContent.setMaximumSize(maxSize);

		squadsListButton = new ButtonGeneral("Equipos", "Team_DashboardMenu", ColorPalette.getMainBlack(),
				ColorPalette.getMainWhite());

		squadsListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(squadsListButton);
		mainContent.add(Box.createVerticalStrut(8));

		cyclistListButton = new ButtonGeneral("Ciclistas registrados", "Cyclists_DashboardMenu",
				ColorPalette.getMainBlack(), ColorPalette.getMainWhite());

		cyclistListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(cyclistListButton);
		mainContent.add(Box.createVerticalStrut(8));

		therapistsListButton = new ButtonGeneral("Masagistas registrados", "Therapists_DashboardMenu",
				ColorPalette.getMainBlack(), ColorPalette.getMainWhite());

		therapistsListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(therapistsListButton);
		mainContent.add(Box.createVerticalStrut(8));

		directorsListButton = new ButtonGeneral("Directores registrados", "Directors_DashboardMenu",
				ColorPalette.getMainBlack(), ColorPalette.getMainWhite());

		directorsListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(directorsListButton);
		mainContent.add(Box.createVerticalStrut(8));

		raceRecordButton = new ButtonGeneral("Registro de carreras", "raceRecors_DashboardMenu",
				ColorPalette.getMainBlack(), ColorPalette.getMainWhite());

		raceRecordButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(raceRecordButton);
		mainContent.add(Box.createVerticalStrut(8));

		raceButton = new ButtonGeneral("Iniciar carrera", "race_DashboardMenu", ColorPalette.getMainBlack(),
				ColorPalette.getMainWhite());

		raceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(raceButton);

		// Agregar wrapperPanel al centro de este panel (CenteredMainContentPanel)
		add(mainContent);
		add(Box.createVerticalGlue());
		insertProfileSection();
	}

	/**
	 * Inserta la sección de perfil y cierre de sesión en el menú.
	 */
	public void insertProfileSection() {
		JPanel mainContent = new JPanel();
		mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
		mainContent.setBackground(ColorPalette.getTransparent());
		Dimension maxSize = new Dimension(Integer.MAX_VALUE, 200); // Altura fija de 150 píxeles
		mainContent.setMaximumSize(maxSize);

		profileButton = new ButtonGeneral("Perfil", "Profile_DashboardMenu", ColorPalette.getMainBlack(),
				ColorPalette.getMainWhite());

		profileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(profileButton);
		mainContent.add(Box.createVerticalStrut(8));

		logOutButton = new ButtonGeneral("Cerrar sesion", "LogOut_DashboardMenu", ColorPalette.getMainBlack(),
				ColorPalette.getMainWhite());

		logOutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(logOutButton);

		add(mainContent);
	}

	// TODO
	public void insertsMenuCyclist() {

	}

	// TODO
	public void insertsMenuTherapist() {

	}

	/**
	 * Devuelve el botón para cerrar sesión.
	 * 
	 * @return El botón para cerrar sesión.
	 */

	public ButtonGeneral getLogOutButton() {
		return logOutButton;
	}

	/**
	 * Devuelve el botón para acceder al perfil.
	 * 
	 * @return El botón para acceder al perfil.
	 */
	public ButtonGeneral getProfileButton() {
		return profileButton;
	}

	/**
	 * Devuelve el botón para listar los equipos.
	 * 
	 * @return El botón para listar los equipos.
	 */
	public ButtonGeneral getSquadsListButton() {
		return squadsListButton;
	}

	/**
	 * Devuelve el botón para listar los ciclistas.
	 * 
	 * @return El botón para listar los ciclistas.
	 */
	public ButtonGeneral getCyclistListButton() {
		return cyclistListButton;
	}

	/**
	 * Devuelve el botón para listar los masajistas.
	 * 
	 * @return El botón para listar los masajistas.
	 */
	public ButtonGeneral getTherapistsListButton() {
		return therapistsListButton;
	}

	/**
	 * Devuelve el botón para listar los directores.
	 * 
	 * @return El botón para listar los directores.
	 */
	public ButtonGeneral getDirectorsListButton() {
		return directorsListButton;
	}

	/**
	 * Devuelve el botón para acceder al registro de carreras.
	 * 
	 * @return El botón para acceder al registro de carreras.
	 */
	public ButtonGeneral getRaceRecordButton() {
		return raceRecordButton;
	}

	/**
	 * Devuelve el botón para iniciar una carrera.
	 * 
	 * @return El botón para iniciar una carrera.
	 */
	public ButtonGeneral getRaceButton() {
		return raceButton;
	}
}
