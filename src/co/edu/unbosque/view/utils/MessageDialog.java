package co.edu.unbosque.view.utils;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * Esta clase proporciona métodos estáticos para mostrar diferentes tipos de diálogos de mensajes.
 */
public class MessageDialog {
	/**
     * Muestra un mensaje de información.
     *
     * @param parentComponent el componente padre del diálogo.
     * @param message el mensaje a mostrar.
     */
    public static void showInfoDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un mensaje de advertencia.
     *
     * @param parentComponent el componente padre del diálogo.
     * @param message el mensaje a mostrar.
     */
    public static void showWarningDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Muestra un mensaje de error.
     *
     * @param parentComponent el componente padre del diálogo.
     * @param message el mensaje a mostrar.
     */
    public static void showErrorDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de pregunta.
     *
     * @param parentComponent el componente padre del diálogo.
     * @param message el mensaje a mostrar.
     */
    public static void showQuestionDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Pregunta", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Muestra un mensaje sencillo sin icono.
     *
     * @param parentComponent el componente padre del diálogo.
     * @param message el mensaje a mostrar.
     */
    public static void showPlainDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Mensaje", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Muestra un mensaje de éxito.
     *
     * @param parentComponent el componente padre del diálogo.
     * @param message el mensaje a mostrar.
     */
    public static void showSuccessDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}
