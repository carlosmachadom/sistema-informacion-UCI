package co.edu.unbosque.view.utils;
/**
 * Esta clase proporciona métodos para convertir cadenas a diferentes tipos numéricos.
 */
public class NumberConverter {
	/**
     * Convierte una cadena a un entero.
     *
     * @param str la cadena que se convertirá a entero.
     * @return el valor entero resultante.
     * @throws NumberFormatException si la cadena no se puede convertir a un entero.
     */
	public static int convertToInt(String str) throws NumberFormatException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Failed to convert to int: " + e.getMessage());
        }
    }

	/**
     * Convierte una cadena a un valor largo.
     *
     * @param str la cadena que se convertirá a valor largo.
     * @return el valor largo resultante.
     * @throws NumberFormatException si la cadena no se puede convertir a un valor largo.
     */
    public static long convertToLong(String str) throws NumberFormatException {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Failed to convert to long: " + e.getMessage());
        }
    }
    /**
     * Convierte una cadena a un valor flotante.
     *
     * @param str la cadena que se convertirá a valor flotante.
     * @return el valor flotante resultante.
     * @throws NumberFormatException si la cadena no se puede convertir a un valor flotante.
     */
    public static float convertToFloat(String str) throws NumberFormatException {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Failed to convert to float: " + e.getMessage());
        }
    }
    /**
     * Convierte una cadena a un valor doble.
     *
     * @param str la cadena que se convertirá a valor double.
     * @return el valor doble resultante.
     * @throws NumberFormatException si la cadena no se puede convertir a un valor doble.
     */
    public static double convertToDouble(String str) throws NumberFormatException {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Failed to convert to double: " + e.getMessage());
        }
    }
}
