package co.edu.unbosque.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase proporciona un método utilitario para compilar una expresión regular
 * y devolver un objeto {@link Matcher} para una cadena dada.
 */
public class Setup {
    /**
     * Compila una expresión regular y crea un objeto {@link Matcher} para
     * comparar la cadena proporcionada con el patrón compilado.
     *
     * @param REGEX La expresión regular que se va a compilar.
     * @param type  La cadena que se comparará con el patrón compilado.
     * @return Un objeto {@link Matcher} que se puede utilizar para encontrar coincidencias
     * de la expresión regular en la cadena dada.
     * @throws IllegalArgumentException Si la expresión regular REGEX proporcionada no es válida.
     */
    public static Matcher compiler(String REGEX, String type) {
        Pattern pattern = Pattern.compile(REGEX);
        return pattern.matcher(type);
    }
}