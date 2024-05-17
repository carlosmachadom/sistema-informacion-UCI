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

public class SelectorInput extends JPanel{
	private String[] selectorOptions;
	private JComboBox<String> selector;
	private String selectorLabel;
	private String command;
	
	public SelectorInput(String selectorLabel, String[] selectorOptions, String command) {
		this.selectorOptions = selectorOptions;
		this.selectorLabel = selectorLabel;
		this.command = command;
		initializeInput();
	}
	
	public void initializeInput() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0,0,0,0));
        setBackground(ColorPalette.getTransparent());
        insertComponents();
        setVisible(true);
	}
	
	public void insertComponents() {
		JPanel labelContainer = new JPanel();
		labelContainer.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		labelContainer.setBorder(new EmptyBorder(0,0,0,0));
		labelContainer.setBackground(ColorPalette.getTransparent());
        JLabel label = new JLabel(selectorLabel);
        label.setFont(FontSystem.getH3());
        label.setForeground(ColorPalette.getMainBlack());
        label.setBorder(new EmptyBorder(0,0,0,0));
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

	public JComboBox<String> getSelector() {
		return selector;
	}
}
