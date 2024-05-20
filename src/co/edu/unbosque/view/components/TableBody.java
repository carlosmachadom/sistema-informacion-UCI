package co.edu.unbosque.view.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * TableBody es un JPanel que representa el cuerpo de una tabla personalizada.
 * Contiene los datos a mostrar en la tabla y se encarga de organizarlos en filas y columnas.
 * 
 * @param <T> El tipo de objeto que se mostrará en la tabla.
 */
public class TableBody extends JPanel {
	private JPanel mainContent;
	private String[][] data;
	private String[] headers;
	
    /**
     * Crea un nuevo cuerpo de tabla con los datos proporcionados.
     * 
     * @param list La lista de objetos que se mostrarán en la tabla.
     */
	public TableBody(String[][] data, String[] headers) {
		this.data = data;
		this.headers = headers;

		
		setLayout(new BorderLayout());
		
		initializeComponents();
		
		setVisible(true);
	}
    
	//TODO
	public void initializeComponents() {
		insertBody();
    }
	
    /**
     * Inserta el cuerpo de la tabla, donde se muestran los datos, en el área principal del cuerpo de la tabla.
     * Este método debe ser implementado por subclases para definir cómo se organizan y muestran los datos.
     */
	public void insertBody() {
		mainContent = new JPanel(new GridLayout(data.length, headers.length));
		
		if (data.length > 0) {
			for (int i = 0; i < data.length; i++) {
				String[] row = data[i];
				
				TableRow rowTable = new TableRow(row, headers);
				mainContent.add(rowTable);
			}
		}	
		
		add(mainContent, BorderLayout.CENTER);	
	}

	public JPanel getMainContent() {
		return mainContent;
	}
}
