package co.edu.unbosque.view.components;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * Esta clase crea un componente personalizado de entrada numérica utilizando un JSpinner,
 * que permite al usuario seleccionar o ingresar valores numéricos dentro de un rango especificado.
 * El componente incluye una etiqueta y restringe el rango numérico de 0 a 100.
 */
@SuppressWarnings("serial")
public class NumericInput extends JPanel {
    private JSpinner input;
    private String fieldLabel;

    /**
     * Construye un nuevo componente NumericInput con la etiqueta asociada al input.
     *
     * @param fieldLabel La etiqueta para el campo de entrada numérica.
     */
    public NumericInput(String fieldLabel) {
        this.fieldLabel = fieldLabel;
        initializeInput();
    }

    /**
     * Inicializa el componente de entrada configurando el diseño y las propiedades visuales.
     */
    public void initializeInput() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setBackground(ColorPalette.getTransparent());
        insertComponents();
        setVisible(true);
    }

    /**
     * Inserta y configura los componentes de la entrada numérica, incluyendo la etiqueta
     * y el JSpinner, con un NumberFormatter para restringir la entrada a enteros no negativos.
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

        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100, 1); // Valor inicial, mínimo, máximo, paso
        input = new JSpinner(model);

        // Configuración del editor para evitar valores negativos
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(input, "0");
        input.setEditor(editor);
        JFormattedTextField textField = editor.getTextField();
        textField.setFont(FontSystem.getLargeParagraph());
        textField.setForeground(ColorPalette.getMainBlack());
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ColorPalette.getMainBlack()),
            new EmptyBorder(8, 8, 8, 8)
        ));
        textField.setBackground(ColorPalette.getSimpleWhite());

        // Establecer un formateador para el JFormattedTextField
        NumberFormatter formatter = (NumberFormatter) editor.getTextField().getFormatter();
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0); // Valor mínimo permitido
        formatter.setMaximum(100); // Valor máximo permitido
        formatter.setAllowsInvalid(false); // Evita valores inválidos

        add(labelContainer);
        add(input);
    }

    /**
     * Devuelve el componente JSpinner utilizado para la entrada numérica.
     *
     * @return El componente JSpinner.
     */
    public JSpinner getInput() {
        return input;
    }
}