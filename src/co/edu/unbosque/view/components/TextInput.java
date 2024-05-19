package co.edu.unbosque.view.components;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * La clase TextInput es un componente personalizado de JPanel que encapsula un
 * JTextField con una etiqueta descriptiva.
 * 
 * Este componente está diseñado para ser reutilizable y personalizable,
 * permitiendo establecer una etiqueta y un campo de texto.
 */
public class TextInput extends JPanel {
	private JTextField input;
	private String fieldLabel;

	/**
	 * Constructor para crear un TextInput con los parámetros especificados.
	 *
	 * @param fieldLabel La etiqueta descriptiva para el campo de texto.
	 */
	public TextInput(String fieldLabel) {
		this.fieldLabel = fieldLabel;
		initializeInput();
	}

	/**
	 * Inicializa el componente de texto configurando su diseño y añadiendo
	 * componentes.
	 */
	public void initializeInput() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(ColorPalette.getTransparent());
		insertComponents();
		setVisible(true);
	}

	/**
	 * Inserta y configura los componentes del campo de texto y su etiqueta dentro
	 * del panel.
	 */
	public void insertComponents() {
		JPanel labelContainer = new JPanel();
		labelContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		labelContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelContainer.setBackground(ColorPalette.getTransparent());
		JLabel label = new JLabel(fieldLabel);
		label.setFont(FontSystem.getH3());
		label.setForeground(ColorPalette.getMainBlack());
		label.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelContainer.add(label);

		input = new JTextField();
		input.setFont(FontSystem.getLargeParagraph());
		input.setForeground(ColorPalette.getMainBlack());
		input.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(ColorPalette.getMainBlack()),
				new EmptyBorder(8, 8, 8, 8)));
		input.setAlignmentX(Component.CENTER_ALIGNMENT);

		add(labelContainer);
		add(input);
	}

	/**
	 * Obtiene el campo de texto encapsulado en este panel.
	 *
	 * @return El campo de texto de tipo JTextField.
	 */
	public JTextField getInput() {
		return input;
	}
}
