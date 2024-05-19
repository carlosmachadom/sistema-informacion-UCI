package co.edu.unbosque.view.components;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * La clase SelectorInput es un componente personalizado de JPanel que encapsula
 * un JComboBox con una etiqueta descriptiva.
 * 
 * Este componente está diseñado para ser reutilizable y personalizable,
 * permitiendo establecer una etiqueta, opciones de selección y un comando de
 * acción.
 */
public class SelectorInput extends JPanel {
	private String[] selectorOptions;
	private JComboBox<String> selector;
	private String selectorLabel;
	private String command;

	/**
	 * Constructor para crear un SelectorInput con los parámetros especificados.
	 *
	 * @param selectorLabel   La etiqueta descriptiva para el selector.
	 * @param selectorOptions Las opciones disponibles en el selector.
	 * @param command         El comando de acción asociado al selector.
	 */
	public SelectorInput(String selectorLabel, String[] selectorOptions, String command) {
		this.selectorOptions = selectorOptions;
		this.selectorLabel = selectorLabel;
		this.command = command;
		initializeInput();
	}

	/**
	 * Inicializa el componente de selección configurando su diseño y añadiendo
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
	 * Inserta y configura los componentes del selector y su etiqueta dentro del
	 * panel.
	 */
	public void insertComponents() {
		JPanel labelContainer = new JPanel();
		labelContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		labelContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelContainer.setBackground(ColorPalette.getTransparent());
		JLabel label = new JLabel(selectorLabel);
		label.setFont(FontSystem.getH3());
		label.setForeground(ColorPalette.getMainBlack());
		label.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelContainer.add(label);
		selector = new JComboBox<String>(selectorOptions);
		selector.setFont(FontSystem.getLargeParagraph());
		selector.setForeground(ColorPalette.getMainBlack());
		selector.setBorder(BorderFactory.createLineBorder(ColorPalette.getMainBlack()));
		selector.setActionCommand(command);
		selector.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(labelContainer);
		add(selector);
	}

	/**
	 * Obtiene el selector encapsulado en este panel.
	 *
	 * @return El selector de tipo JComboBox.
	 */
	public JComboBox<String> getSelector() {
		return selector;
	}
}
