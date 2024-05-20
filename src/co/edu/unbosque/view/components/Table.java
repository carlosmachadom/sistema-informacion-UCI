package co.edu.unbosque.view.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;

/**
 * La clase Table representa una tabla en la interfaz de usuario.
 * Esta clase proporciona métodos para crear y gestionar una tabla con un botón para crear elementos y un encabezado.
 *
 * @param <T> El tipo de datos que contendrá la tabla.
 */
public class Table<T> extends JPanel {
	private ButtonGeneral buttonCreate;
    private ArrayList<T> list;
    private String[] headers;

    /**
     * Constructor de la clase Table.
     *
     * @param list    La lista de elementos que se mostrarán en la tabla.
     * @param headers Los encabezados de la tabla.
     */
    public Table(ArrayList<T> list, String[] headers) {
        this.list = list;
        this.headers = headers;
        initializeTable();
    }
    
    /**
     * Inicializa la tabla.
     * Este método configura el diseño y los componentes de la tabla.
     */
    public void initializeTable() {
    	setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(ColorPalette.getTransparent());
        initializeComponents();
        setVisible(true);
    }
    /**
     * Inicializa los componentes de la tabla.
     * Este método se llama desde initializeTable() para crear los componentes principales de la tabla.
     */
    public void initializeComponents() {
    	insertTableCreatorHeader();
    	insertTable();
    }
    /**
     * Inserta la tabla en el contenedor principal.
     * Este método crea el cuerpo de la tabla y lo agrega al contenedor principal.
     */
    public void insertTable() {    	
    	// Crear un contenedor principal para centrar verticalmente el contenido
        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setBackground(ColorPalette.getTransparent());
        
     // Crear el contenido principal (mainContent)
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainContent.setBackground(ColorPalette.getTransparent());
        
        // Insertar rows
        
        insertHeaderTable();
    	
     // Agregar mainContent al wrapperPanel con GridBagConstraints para centrar verticalmente
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Establecer peso vertical para centrar
        
        wrapperPanel.add(mainContent, gbc);
        
        // Agregar wrapperPanel al centro de este panel (CenteredMainContentPanel)
        add(wrapperPanel, BorderLayout.CENTER);
    }
    
    /**
     * Inserta el encabezado de la tabla en la parte superior.
     * Este método crea un botón para crear nuevos elementos y lo agrega en la parte superior de la tabla.
     */
    public void insertTableCreatorHeader() {
    	JPanel seccionBotonCrear = new JPanel();
    	seccionBotonCrear.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	seccionBotonCrear.setBorder(new EmptyBorder(20,20,20,20));
    	
    	buttonCreate = new ButtonGeneral(
    		"Crear nuevo equipo", 
    		"CreateTeam_TeamListScreen", 
    		ColorPalette.getMainBlack(), 
    		ColorPalette.getMainWhite()
		);
    	
    	seccionBotonCrear.add(buttonCreate);
    	
    	add(seccionBotonCrear, BorderLayout.NORTH);
    }
    
    //TODO
    public void insertHeaderTable() {
    	
    }
    
    /**
     * Inserta el cuerpo de la tabla en el contenedor principal.
     *
     * @param lista La lista de elementos que se mostrarán en el cuerpo de la tabla.
     */
    public void insertBodyTable(ArrayList<T> lista) {
    	TableBody body = new TableBody(lista);
		
		JScrollPane scrollArea = new JScrollPane(
			body,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
		);

		scrollArea.setBorder(new EmptyBorder(0,0,0,0));
    }
}
