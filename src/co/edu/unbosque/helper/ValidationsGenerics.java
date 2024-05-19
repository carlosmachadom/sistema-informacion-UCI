package co.edu.unbosque.helper;

import co.edu.unbosque.util.ParserStringError;

import java.util.regex.Matcher;

/**
 * Esta clase proporciona métodos genéricos de validación de cadenas de texto.
 */
public class ValidationsGenerics {
    /**
     * Variable Matcher  validacion del Regex
     */
    private static Matcher match;

    /**
     * Verifica que una cadena cumpla con el formato de nombre, nacionalidad o país.
     * <p>
     * El formato aceptado es solo letras y espacios (^[a-zA-Z ]+$).
     * </p>
     * 
     * @param name La cadena a verificar.
     * @throws ParserStringError si la cadena no cumple con el formato especificado.
     */
    public static void verifyNameOrNationalityOrCountry(String name) {
        match = Setup.compiler("^[a-zA-Z ]+$", name);
        try {
            if (!match.matches()) {
                throw new ParserStringError("Formato no valido Nombre");
            }
        } catch (ParserStringError err) {
            System.out.println("err = " + err.getMessage());
        }
    }
}
