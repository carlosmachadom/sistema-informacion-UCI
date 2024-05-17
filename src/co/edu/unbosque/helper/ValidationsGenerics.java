package co.edu.unbosque.helper;

import co.edu.unbosque.util.ParserStringError;

import java.util.regex.Matcher;

public class ValidationsGenerics {
    /**
     * Variable Matcher  validacion del Regex
     */
    private static Matcher match;

    public static void verifyNameOrNationalityOrCountry(String name) {
        match = Setup.compiler("^[a-zA-Z ]+$", name);
        try {
            if (!match.matches()) {
                throw new ParserStringError("Formato no valido (Invalid format)");
            }
        } catch (ParserStringError err) {
            System.out.println("err = " + err.getMessage());
        }
    }
}
