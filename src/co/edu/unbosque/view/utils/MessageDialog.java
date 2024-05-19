package co.edu.unbosque.view.utils;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MessageDialog {
    // Muestra un mensaje de información
    public static void showInfoDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    // Muestra un mensaje de advertencia
    public static void showWarningDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    // Muestra un mensaje de error
    public static void showErrorDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Muestra un mensaje de pregunta
    public static void showQuestionDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Pregunta", JOptionPane.QUESTION_MESSAGE);
    }

    // Muestra un mensaje sencillo sin icono
    public static void showPlainDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Mensaje", JOptionPane.PLAIN_MESSAGE);
    }
    
    // Muestra un mensaje de éxito
    public static void showSuccessDialog(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}
