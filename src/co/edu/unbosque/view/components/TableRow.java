package co.edu.unbosque.view.components;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * TableRow es un JPanel que representa una fila en una tabla personalizada.
 * Esta fila puede contener datos y botones para eliminar y mostrar detalles.
 */
public class TableRow extends JPanel {
	private ButtonGeneral buttonDelete;
	private ButtonGeneral buttonDetails;
	private String[] data;
	private String[] headers;

	/**
	 * Crea una nueva fila de tabla con los datos y encabezados proporcionados.
	 * 
	 * @param data    Los datos que se mostrarán en la fila.
	 * @param headers Los encabezados correspondientes a los datos.
	 */
	public TableRow(String[] data, String[] headers) {
		this.data = data;
		this.headers = headers;

		setLayout(new GridLayout(1, data.length));
		setBackground(ColorPalette.getMainWhite());
		setBorder(new EmptyBorder(0, 0, 0, 0));

		inicializarComponentes();

		setVisible(true);
	}

	/**
	 * Inicializa los componentes de la fila, incluyendo los botones de detalles y
	 * eliminar.
	 */
	public void inicializarComponentes() {
		for (int i = 0; i < headers.length; i++) {
			String d = data[i];
			String h = headers[i];

			if (!h.equals("Detalle") || !h.equals("Eliminar")) {
				JPanel section = getSection(d);
				add(section);
			} else if (h.equals("Detalle")) {
				buttonDetails = new ButtonGeneral("Detalles", "Details_Element=" + data[0], ColorPalette.getMainBlack(),
						ColorPalette.getMainWhite());

				JPanel buttonDetailsSection = getButtonSeccion(buttonDetails);
				add(buttonDetailsSection);
			} else if (h.equals("Eliminar")) {
				buttonDelete = new ButtonGeneral("Eliminar", "Delete_Element=" + data[0], ColorPalette.getMainBlack(),
						ColorPalette.getMainWhite());

				JPanel buttonDeletesection = getButtonSeccion(buttonDelete);
				add(buttonDeletesection);
			}
		}
	}

	/**
	 * Crea una sección del panel para un dato específico.
	 * 
	 * @param d El dato que se mostrará en la sección.
	 * @return Un JPanel que contiene el dato.
	 */
	public JPanel getSection(String d) {
		JPanel section = new JPanel();
		section.setBackground(ColorPalette.getMainWhite());
		section.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel text = new JLabel(d);
		text.setFont(FontSystem.getH2());
		text.setForeground(ColorPalette.getMainBlack());

		section.add(text);
		return section;
	}

	/**
	 * Crea una sección del panel para un botón específico.
	 * 
	 * @param boton El botón que se mostrará en la sección.
	 * @return Un JPanel que contiene el botón.
	 */
	public JPanel getButtonSeccion(ButtonGeneral boton) {
		JPanel section = new JPanel();
		section.setBackground(ColorPalette.getMainWhite());
		section.setBorder(new EmptyBorder(10, 10, 10, 10));
		section.add(boton);
		return section;
	}

	/**
	 * Obtiene el botón de eliminar.
	 * 
	 * @return El botón de eliminar.
	 */
	public ButtonGeneral getButtonDelete() {
		return buttonDelete;
	}

	/**
	 * Obtiene el botón de detalles.
	 * 
	 * @return El botón de detalles.
	 */
	public ButtonGeneral getButtonDetails() {
		return buttonDetails;
	}
}
