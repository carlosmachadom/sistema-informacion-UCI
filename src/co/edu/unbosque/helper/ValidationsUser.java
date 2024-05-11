package co.edu.unbosque.helper;

import co.edu.unbosque.util.ParserStringError;
import co.edu.unbosque.util.PerserInvalidLogin;

import java.util.regex.Matcher;

public class ValidationsUser {

    private static Matcher match;

    public static void verifyEmail(String email) {
        match = Setup.compiler("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$", email);
        try {
            if (!match.matches()) {
                throw new PerserInvalidLogin("Formato no valido");
            }
        } catch (PerserInvalidLogin err) {
            err.getMessage();
        }
    }

    public static void verifyExperience(int experience) {
        match = Setup.compiler("^[0-9]*$", String.valueOf(experience));
        try {
            if (!match.matches()) {
                throw new ParserStringError("Formato no valido");
            }
        } catch (ParserStringError err) {
            err.getMessage();
        }
    }
}
