package co.edu.unbosque.view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * La clase <code>ButtonGeneral</code> es un componente personalizado de
 * <code>JPanel</code> que encapsula un botón con estilos y comportamientos
 * específicos.
 * <p>
 * Este botón se puede personalizar con diferentes textos, comandos de acción,
 * colores de fondo y colores de texto.
 * </p>
 */
public class ButtonGeneral extends JPanel {
	
	private JButton button;
	private String buttonText;
	private String command;
	private Color buttonColor;
	private Color textColor;

	/**
	 * Constructor para crear un <code>ButtonGeneral</code> con los parámetros
	 * especificados.
	 * 
	 * @param buttonText  El texto que se mostrará en el botón.
	 * @param command     El comando de acción que se asignará al botón.
	 * @param buttonColor El color de fondo del botón.
	 * @param textColor   El color del texto del botón.
	 */
	public ButtonGeneral(String buttonText, String command, Color buttonColor, Color textColor) {
		this.buttonText = buttonText;
		this.command = command;
		this.buttonColor = buttonColor;
		this.textColor = textColor;

		initializeButton();
	}

	/**
	 * Inicializa el botón configurando su diseño y añadiendo componentes.
	 */
	public void initializeButton() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(ColorPalette.getTransparent());

		insertComponents();

		setVisible(true);
	}

	/**
	 * Inserta y configura el componente del botón dentro del panel.
	 */
	public void insertComponents() {
		button = new JButton(buttonText);
		button.setFocusPainted(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setFont(FontSystem.getH4());
		button.setForeground(textColor);
		button.setBorder(new EmptyBorder(12, 16, 12, 16));
		button.setBackground(buttonColor);
		button.setActionCommand(command);
		add(button, BorderLayout.CENTER);
	}

	/**
	 * Obtiene el botón encapsulado en este panel.
	 * 
	 * @return El botón de tipo <code>JButton</code>.
	 */
	public JButton getButton() {
		return button;
	}
}
