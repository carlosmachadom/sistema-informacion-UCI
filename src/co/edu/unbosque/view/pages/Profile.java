package co.edu.unbosque.view.pages;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.components.ButtonGeneral;
import co.edu.unbosque.view.components.TextInput;
import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

public class Profile extends JPanel {
	private String title;
	private String[][] data;
	private ButtonGeneral update;
	private ButtonGeneral delete;
	
	public Profile(String title, String[][] data) {
		this.title = title;
		this.data = data;
		
		setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(ColorPalette.getMainWhite());
        initializeComponents();
        setVisible(true);
	}
	
	public void initializeComponents() {
		insertTitle();
		insertBody();
		insertButtons();
	}
	
	public void insertTitle() {
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(ColorPalette.getMainWhite());
		panelTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
		panelTitle.setBorder(new EmptyBorder(40,40,40,40));
		
		JLabel titulo = new JLabel("Perfil " + title);
		titulo.setFont(FontSystem.getLargeTitle());
		titulo.setForeground(ColorPalette.getMainBlack());
		
		panelTitle.add(titulo);
		add(panelTitle, BorderLayout.NORTH);
	}
	
	public void insertBody() {
		// Crear un contenedor principal para centrar verticalmente el contenido
		JPanel wrapperPanel = new JPanel(new GridBagLayout());
		wrapperPanel.setBackground(ColorPalette.getTransparent());

		// Crear el contenido principal (mainContent)
		JPanel mainContent = new JPanel();
		mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
		mainContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainContent.setBackground(ColorPalette.getTransparent());
		
		if (data.length > 0) {
			for (int i = 0; i < data.length; i++) {
				String row[] = data[i];
				
				if (row[0] != null && row[0] != null) {
					TextInput r = new TextInput(row[0]);
					r.getInput().setText(row[1]);
		            r.setAlignmentX(Component.CENTER_ALIGNMENT);
		            mainContent.add(r);
		            mainContent.add(Box.createVerticalStrut(8));
		        }				
			}
		}		
		
		// Agregar mainContent al wrapperPanel con GridBagConstraints para centrar
		// verticalmente
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.weighty = 1.0; // Establecer peso vertical para centrar

		wrapperPanel.add(mainContent, gbc);

		// Agregar wrapperPanel al centro de este panel (CenteredMainContentPanel)
		add(wrapperPanel, BorderLayout.CENTER);
	}
	
	public void insertButtons() {
		JPanel mainContent = new JPanel();
		mainContent.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainContent.setBackground(ColorPalette.getMainWhite());
		Dimension maxSize = new Dimension(Integer.MAX_VALUE, 400);
		mainContent.setMaximumSize(maxSize);

		update = new ButtonGeneral("Actualizar mis datos", "Update_ProfilePage",
				ColorPalette.getMainBlack(), ColorPalette.getMainWhite());

		update.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(update);
		mainContent.add(Box.createVerticalStrut(8));
		
		delete = new ButtonGeneral("Eliminar mi cuenta", "Delete_ProfilePage",
				ColorPalette.getMainRed(), ColorPalette.getMainWhite());
		
		delete.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainContent.add(delete);
		mainContent.add(Box.createVerticalStrut(8));
		
		// Agregar wrapperPanel al centro de este panel (CenteredMainContentPanel)
		add(mainContent, BorderLayout.SOUTH);
	}
}
