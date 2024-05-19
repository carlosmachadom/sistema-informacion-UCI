package co.edu.unbosque.view.components;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

public class TableRow extends JPanel{
	private ButtonGeneral buttonDelete;
	private ButtonGeneral buttonDetails;
	private String[] data;
	private String[] headers;
	
	public TableRow(String[] data, String[] headers) {
		this.data = data;
		this.headers = headers;
		
		setLayout(new GridLayout(1, data.length));
		setBackground(ColorPalette.getMainWhite());
		setBorder(new EmptyBorder(0,0,0,0));
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		for (int i = 0;  i < headers.length; i++) {
			String d = data[i];
			String h = headers[i];
			
			if (!h.equals("Detalle") || !h.equals("Eliminar")) {
				JPanel section = getSection(d);
				add(section);
			} else if(h.equals("Detalle")) {
				buttonDetails = new ButtonGeneral(
						"Detalles", 
						"Details_Element="+data[0], 
						ColorPalette.getMainBlack(), 
						ColorPalette.getMainWhite()
						);
				
				JPanel buttonDetailsSection = getButtonSeccion(buttonDetails);
				add(buttonDetailsSection);				
			} else if (h.equals("Eliminar")) {
				buttonDelete = new ButtonGeneral(
						"Eliminar", 
						"Delete_Element="+data[0], 
						ColorPalette.getMainBlack(), 
						ColorPalette.getMainWhite()
						);
				
				JPanel buttonDeletesection = getButtonSeccion(buttonDelete);
				add(buttonDeletesection);				
			}
		}
	}
	
	public JPanel getSection(String d) {
		JPanel section = new JPanel();
		section.setBackground(ColorPalette.getMainWhite());
		section.setBorder(new EmptyBorder(10,10,10,10));
		
		JLabel text = new JLabel(d);
		text.setFont(FontSystem.getH2());
		text.setForeground(ColorPalette.getMainBlack());
		
		section.add(text);		
		return section;
	}
	
	public JPanel getButtonSeccion(ButtonGeneral boton) {
		JPanel section = new JPanel();
		section.setBackground(ColorPalette.getMainWhite());
		section.setBorder(new EmptyBorder(10,10,10,10));
		section.add(boton);
		return section;
	}

	public ButtonGeneral getButtonDelete() {
		return buttonDelete;
	}

	public ButtonGeneral getButtonDetails() {
		return buttonDetails;
	}
}
