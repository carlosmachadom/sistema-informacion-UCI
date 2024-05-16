package co.edu.unbosque.util;

/**
 * Esta clase representa una excepción lanzada cuando ocurre un error de autenticación.
 * Se utiliza para indicar que el proceso de autenticación falló, por ejemplo, debido a credenciales incorrectas o falta de permisos.
 * <p>
 * Extiende la clase `Exception` para indicar que se trata de una condición excepcional.
 */
public class AutenticationError extends Exception {
    /**
     * Constructor para la clase `AutenticationError`.
     *
     * @param message El mensaje de error que describe el motivo de la excepción.
     */
    public AutenticationError(String message) {
        super(message);
    }
}
