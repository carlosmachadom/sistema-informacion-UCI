/**
 * 
 */
package co.edu.unbosque.view.pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.components.Table;
import co.edu.unbosque.view.utils.ColorPalette;
import co.edu.unbosque.view.utils.FontSystem;

/**
 * 
 */
//TODO
public class TablePage extends JPanel{
	private Table table;
	private String[][] list;
    private String[] headers;
    private String tableName;
	
	public TablePage(String[][] list, String[] headers, String tableName) {
		this.list = list;
        this.headers = headers;
        this.tableName = tableName;
		
		setLayout(new BorderLayout());
		setBackground(ColorPalette.getMainWhite());
		
		initiazeComponents();
		setVisible(true);
	}
	
	public void initiazeComponents() {
		insertTitle();
		insertTable();
	}	
	
	public void insertTitle() {
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(ColorPalette.getMainWhite());
		panelTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
		panelTitle.setBorder(new EmptyBorder(40,40,40,40));
		
		JLabel titulo = new JLabel("Lista de " + tableName);
		titulo.setFont(FontSystem.getLargeTitle());
		titulo.setForeground(ColorPalette.getMainBlack());
		
		panelTitle.add(titulo);
		add(panelTitle, BorderLayout.NORTH);
	}
	
	public void insertTable() {		
		table = new Table(list, headers, tableName);
		
		add(table, BorderLayout.CENTER);
	}

	public Table getTable() {
		return table;
	}
}
