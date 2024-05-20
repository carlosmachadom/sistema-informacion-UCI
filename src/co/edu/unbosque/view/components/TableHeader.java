package co.edu.unbosque.view.components;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * TableHeader es un JPanel que representa el encabezado de una tabla
 * personalizada. Contiene una lista de nombres de columnas que se muestran como
 * encabezados de la tabla.
 */
public class TableHeader extends JPanel {
	private List<String> headers;

	/**
	 * Crea un nuevo encabezado de tabla con los nombres de columna proporcionados.
	 * 
	 * @param headers La lista de nombres de columna para mostrar como encabezados
	 *                de la tabla.
	 */
	public TableHeader(List<String> headers) {
		this.headers = headers;

		setLayout(new GridLayout(1, headers.size()));
		setBackground(ColorPalette.getMainBlack());
		setBorder(new EmptyBorder(0, 0, 0, 0));

		initializeComponents();

		setVisible(true);
	}

	/**
	 * Inicializa los componentes del encabezado de la tabla, creando una sección
	 * para cada nombre de columna.
	 */
	public void initializeComponents() {
		for (int i = 0; i < headers.size(); i++) {
			String h = headers.get(i);
			JPanel section = getSection(h);
			add(section);
		}
	}

	/**
	 * Crea una sección del panel para un nombre de columna específico.
	 * 
	 * @param d El nombre de la columna que se mostrará en la sección del
	 *          encabezado.
	 * @return Un JPanel que contiene el nombre de la columna.
	 */
	public JPanel getSection(String d) {
		JPanel section = new JPanel();
		section.setBackground(ColorPalette.getMainBlack());
		section.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel text = new JLabel(d);
		text.setFont(FontSystem.getH2());
		text.setForeground(ColorPalette.getMainWhite());

		section.add(text);
		return section;
	}
}
