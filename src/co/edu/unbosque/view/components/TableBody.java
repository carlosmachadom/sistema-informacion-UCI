package co.edu.unbosque.view.components;

import java.awt.BorderLayout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class TableBody<T> extends JPanel {
	private ArrayList<T> data;
	private List<String> headers;
	
	public TableBody(ArrayList<T> list) {
		this.data = list;
		
		if (list.size() > 0) {
            this.headers = getKeys(list.get(0));
        }

		
		setLayout(new BorderLayout());
		
		initializeComponents();
		
		setVisible(true);
	}
    
	public void initializeComponents() {
		
    }
	
	
	public void insertHeader() {
		TableHeader h = new TableHeader(headers);
		add(h, BorderLayout.NORTH);
	}
	
	public void insertBody() {
		JPanel mainContent = new JPanel();
		
	}
	
	// Método para obtener las keys (nombres de los campos) de un objeto
    public static <T> List<String> getKeys(T obj) {
        List<String> keys = new ArrayList<>();
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            keys.add(field.getName());
        }

        return keys;
    }
    
    // Método para obtener los valores de un objeto
    public static <T> Object[] getValues(T obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        Object[] values = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                values[i] = fields[i].get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return values;
    }

}
