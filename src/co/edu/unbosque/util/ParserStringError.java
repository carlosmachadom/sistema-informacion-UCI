package co.edu.unbosque.util;

/**
 * Esta clase representa una excepción personalizada que se lanza cuando ocurre un error al analizar una cadena de texto.
 * Extiende la clase `Exception` del paquete Java `java.lang`.
 */
public class ParserStringError extends Exception {
    /**
     * Constructor de la excepción `ParserStringError`.
     *
     * @param message Mensaje de error que describe el problema ocurrido durante el análisis de la cadena.
     */
    public ParserStringError(String message) {
        super(message);
    }
}
