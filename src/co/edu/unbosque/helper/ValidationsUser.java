package co.edu.unbosque.helper;

import co.edu.unbosque.util.ParserStringError;
import co.edu.unbosque.util.PerserInvalidLogin;

import java.util.regex.Matcher;

/**
 * Esta clase proporciona métodos estáticos para validar información de un
 * usuario. Utiliza la clase `Setup` para compilar expresiones regulares y el
 * objeto `Matcher` para verificar el formato de los datos del usuario.
 */
public class ValidationsUser {
	/**
	 * Variable Matcher validacion del Regex
	 */
	private static Matcher match;

	/**
     * Valida el formato del número de cédula de un usuario.
     * El número de cédula debe ser un número entero.
     *
     * @param CC El número de cédula a validar.
     * @throws ParserStringError Si el número de cédula no cumple con el formato especificado.
     */
    public static void verifyCC(long CC) {
        match = Setup.compiler("^[0-9]{7,10}$", String.valueOf(CC));
        try {
            if (!match.matches()) {
                throw new ParserStringError("Formato no valido Cedula");
            }
        } catch (ParserStringError err) {
            System.out.println("err = " + err.getMessage());
        }
    }

    /**
     * Valida el formato del correo electrónico de un usuario.
     * Un correo electrónico válido debe seguir el formato estándar de correo electrónico:
     * nombreUsuario@dominio.com (el nombre de usuario puede contener letras, números y algunos caracteres especiales)
     *
     * @param email El correo electrónico a validar.
     * @throws PerserInvalidLogin Si el correo electrónico no cumple con el formato
     *                            estándar de correo electrónico.
     */
    public static void verifyEmail(String email) {
        match = Setup.compiler("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|edu|org|net|gov|co)$", email);
        try {
            if (!match.matches()) {
                throw new PerserInvalidLogin("Formato no valido Email");
            }
        } catch (PerserInvalidLogin err) {
            System.out.println("err = " + err.getMessage());
        }
    }

    /**
     * Valida el formato del nivel de experiencia de un usuario.
     * El nivel de experiencia debe ser un número entero no negativo.
     *
     * @param experience El nivel de experiencia a validar.
     * @throws ParserStringError Si el nivel de experiencia no es un número entero no negativo.
     */
    public static void verifyExperience(int experience) {
        match = Setup.compiler("^[0-9]*$", String.valueOf(experience));
        try {
            if (!match.matches()) {
                throw new ParserStringError("Formato no valido Experiencia");
            }
        } catch (ParserStringError err) {
            System.out.println("err = " + err.getMessage());
        }
    }

    /**
<<<<<<< HEAD
     * 
     * @param password
=======
     * Valida el formato de la contraseña de un usuario.
     * La contraseña debe tener al menos 8 caracteres e incluir al menos una letra,
     * un dígito y un carácter especial.
     *
     * @param password La contraseña a validar.
     * @throws ParserStringError Si la contraseña no cumple con el formato especificado.
>>>>>>> branch 'main' of https://github.com/carlosmachadom/sistema-informacion-UCI.git
     */
    public static void verifyPassword(String password) {
        match = Setup.compiler("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}$", password);
        try {
            if (!match.matches()) {
                throw new ParserStringError("Formato no valido Contraseña");
            }
        } catch (ParserStringError err) {
            System.out.println("err = " + err.getMessage());
        }
    }
}
