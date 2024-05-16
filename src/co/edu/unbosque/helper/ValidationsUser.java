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
	 * Valida el formato del correo electrónico de un usuario. Un correo electrónico
	 * válido debe seguir el formato estándar de correo electrónico:
	 * nombreUsuario@dominio.com (el nombre de usuario puede contener letras,
	 * números y algunos caracteres especiales)
	 *
	 * @param email El correo electrónico a validar.
	 * @return boolean - retorna un flag para verificar si fue exitoso el proceso
	 * @throws PerserInvalidLogin Si el correo electrónico no cumple con el formato
	 *                            estándar de correo electrónico.
	 */
	public static boolean verifyEmail(String email) {
		match = Setup.compiler("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$", email);
		boolean flag = false;
		try {
			if (!match.matches()) {
				flag = false;
				throw new PerserInvalidLogin("Formato no valido (Invalid format)");
			} else {
				flag = true;
			}
		} catch (PerserInvalidLogin err) {
			System.out.println("err = " + err.getMessage());
		}
		return flag;
	}

	/**
	 * Valida el formato del nivel de experiencia de un usuario. El nivel de
	 * experiencia debe ser un número entero no negativo.
	 *
	 * @param experience El nivel de experiencia a validar.
	 * @return boolean - retorna un flag para verificar si fue exitoso el proceso
	 * @throws ParserStringError Si el nivel de experiencia no es un número entero
	 *                           no negativo.
	 */
	public static boolean verifyExperience(int experience) {
		match = Setup.compiler("^[0-9]*$", String.valueOf(experience));
		boolean flag = false;
		try {
			if (!match.matches()) {
				flag = false;
				throw new ParserStringError("Formato no valido (Invalid format)");
			}else {
				flag = true;
			}
		} catch (ParserStringError err) {
			System.out.println("err = " + err.getMessage());
		}
		return flag;
	}
}
