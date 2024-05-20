package co.edu.unbosque.view.components;

import java.awt.BorderLayout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * TableBody es un JPanel que representa el cuerpo de una tabla personalizada.
 * Contiene los datos a mostrar en la tabla y se encarga de organizarlos en filas y columnas.
 * 
 * @param <T> El tipo de objeto que se mostrará en la tabla.
 */
public class TableBody<T> extends JPanel {
	private ArrayList<T> data;
	private List<String> headers;
	
    /**
     * Crea un nuevo cuerpo de tabla con los datos proporcionados.
     * 
     * @param list La lista de objetos que se mostrarán en la tabla.
     */
	public TableBody(ArrayList<T> list) {
		this.data = list;
		
		if (list.size() > 0) {
            this.headers = getKeys(list.get(0));
        }

		
		setLayout(new BorderLayout());
		
		initializeComponents();
		
		setVisible(true);
	}
    
	//TODO
	public void initializeComponents() {
		
    }
	
	
    /**
     * Inserta el encabezado de la tabla en la parte superior del cuerpo de la tabla.
     */
	public void insertHeader() {
		TableHeader h = new TableHeader(headers);
		add(h, BorderLayout.NORTH);
	}
    /**
     * Inserta el cuerpo de la tabla, donde se muestran los datos, en el área principal del cuerpo de la tabla.
     * Este método debe ser implementado por subclases para definir cómo se organizan y muestran los datos.
     */
	public void insertBody() {
		JPanel mainContent = new JPanel();
		
	}
	
    /**
     * Obtiene los nombres de los campos (claves) de un objeto.
     * 
     * @param obj El objeto del que se obtendrán los nombres de los campos.
     * @return Una lista de cadenas que contiene los nombres de los campos del objeto.
     */
    public static <T> List<String> getKeys(T obj) {
        List<String> keys = new ArrayList<>();
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            keys.add(field.getName());
        }

        return keys;
    }
    
    /**
     * Obtiene los valores de los campos de un objeto.
     * 
     * @param obj El objeto del que se obtendrán los valores de los campos.
     * @return Un array de objetos que contiene los valores de los campos del objeto.
     */
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
