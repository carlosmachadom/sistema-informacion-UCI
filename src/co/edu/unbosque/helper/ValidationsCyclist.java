package co.edu.unbosque.helper;

import co.edu.unbosque.util.ParserStringError;

import java.util.regex.Matcher;

/**
 * Esta clase proporciona métodos estáticos para validar la información de un
 * ciclista. Utiliza la clase `Setup` para compilar expresiones regulares y el
 * objeto `Matcher` para verificar el formato y el rango de valores permitidos.
 */
public class ValidationsCyclist {
	/**
	 * Variable Matcher validacion del Regex
	 */
	private static Matcher match;

	/**
	 * Valida el formato del nombre de un ciclista. Solo se permiten letras
	 * mayúsculas y minúsculas y espacios.
	 *
	 * @param name El nombre del ciclista a validar.
	 * @throws ParserStringError Si el nombre no cumple con el formato permitido
	 *                           (letras mayúsculas y minúsculas y espacios).
	 */
	public static boolean verifyName(String name) {
		match = Setup.compiler("^[A-Za-z ]+$", name);
		boolean flag = false;
		try {
			if (!match.matches()) {
				flag = false;
				throw new ParserStringError("Formato no valido");
			} else {
				flag = true;
			}

		} catch (ParserStringError err) {
			System.out.println("err = " + err.getMessage());
		}
		return flag;
	}

	/**
	 * Valida la velocidad máxima de un ciclista. La velocidad máxima debe ser un
	 * número entero mayor o igual a 0.
	 *
	 * @param speedMaximum La velocidad máxima del ciclista a validar.
	 * @throws ParserStringError Si la velocidad máxima no es un número entero mayor
	 *                           o igual a 0.
	 */
	public static boolean verifySpeedMax(int speedMaximum) {
		match = Setup.compiler("^[0-9]*$", String.valueOf(speedMaximum));
		boolean flag = false;
		try {
			if (speedMaximum < 0) {
				flag = false;
				throw new ParserStringError("Debe ser mayor a 0");
			}
			else if(!match.matches()) {
				flag = false;
				throw new ParserStringError("Formato no valido");
			}else {
				flag = true;
			}
		} catch (ParserStringError err) {
			System.out.println("err = " + err.getMessage());
		}
		return flag;
	}

	/**
	 * Valida el grado de inclinación de una subida. El grado de inclinación debe
	 * ser un número entero entre 0 y 360 (grados).
	 *
	 * @param climbingGrade El grado de inclinación de la subida a validar.
	 * @throws ParserStringError Si el grado de inclinación no es un número entero
	 *                           entre 0 y 360 (grados).
	 */
	public static boolean verifyClimbingGrade(int climbingGrade) {
		boolean flag = false;
		try {
			if (climbingGrade > 360) {
				flag = false;
				throw new ParserStringError("Los grados no puede ser mayores a 360");
			}else if (climbingGrade < 0) {
				flag = false;
				throw new ParserStringError("Los grados no puede ser menores a 0");
			}
			else {
				flag = true;
			}
		} catch (ParserStringError err) {
			System.out.println("err = " + err.getMessage());
		}
		return flag;
	}

	/**
	 * Valida la aceleración en subida de un ciclista. La aceleración en subida debe
	 * ser un número decimal mayor o igual a 0.
	 *
	 * @param accelerationUphill La aceleración en subida del ciclista a validar.
	 * @throws ParserStringError Si la aceleración en subida no es un número decimal
	 *                           mayor o igual a 0.
	 */
	public static boolean verifyAccelerationUphill(double accelerationUphill) {
		match = Setup.compiler("^[0-9]+(\\.[0-9]{1,})?$", String.valueOf(accelerationUphill));
		boolean flag = false;
		try {
			if (accelerationUphill < 0) {
				flag = false;
				throw new ParserStringError("La acceleracion debe ser mayor a 0");
			}
			else if (!match.matches()) {
				flag = false;
				throw new ParserStringError("Formato no valido");
			}else{
				flag = true;
			}
		} catch (ParserStringError err) {
			System.out.println("err = " + err.getMessage());
		}
		return flag;
	}
}
