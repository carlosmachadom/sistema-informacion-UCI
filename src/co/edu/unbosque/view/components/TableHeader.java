package co.edu.unbosque.view.components;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

public class TableHeader extends JPanel {
	private List<String> headers;
	
	public TableHeader(List<String> headers) {
		this.headers = headers;
		
		setLayout(new GridLayout(1, headers.size()));
		setBackground(ColorPalette.getMainBlack());
		setBorder(new EmptyBorder(0,0,0,0));
		
		initializeComponents();
		
		setVisible(true);
	}
	
	public void initializeComponents() {
		for (int i = 0;  i < headers.size(); i++) {
			String h = headers.get(i);			
			JPanel section = getSection(h);
			add(section);
		}
	}
	
	public JPanel getSection(String d) {
		JPanel section = new JPanel();
		section.setBackground(ColorPalette.getMainBlack());
		section.setBorder(new EmptyBorder(10,10,10,10));
		
		JLabel text = new JLabel(d);
		text.setFont(FontSystem.getH2());
		text.setForeground(ColorPalette.getMainWhite());
		
		section.add(text);		
		return section;
	}
}
