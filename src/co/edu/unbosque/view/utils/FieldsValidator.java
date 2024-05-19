package co.edu.unbosque.view.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldsValidator {
	// Expresiones regulares para validar nombres y correos electrónicos
	private static final String TEXT_REGEX = "^[\\p{L} .'-]+$";
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|edu|org|net|gov|co)$";
	private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}$";
	private static final String CC_REGEX = "^[0-9]{7,10}$";

	// Compilar las expresiones regulares en patrones
	private static final Pattern TEXT_PATTERN = Pattern.compile(TEXT_REGEX);
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
	private static final Pattern CC_PATTERN = Pattern.compile(CC_REGEX);

	// Método para validar nombres y apellidos
	public static boolean isValidText(String text) {
		boolean response = true;
		boolean validString = isValidString(text);

		if (validString) {
			Matcher matcher = TEXT_PATTERN.matcher(text);

			if (matcher.matches()) {
				response = true;
			} else {
				response = false;
			}

		} else {
			response = false;
		}

		return response;
	}

	// Método para validar correos electrónicos
	public static boolean isValidEmail(String email) {
		boolean response = true;
		boolean validString = isValidString(email);

		if (validString) {
			Matcher matcher = EMAIL_PATTERN.matcher(email);

			if (matcher.matches()) {
				response = true;
			} else {
				response = false;
			}

		} else {
			response = false;
		}

		return response;
	}

	// Método para validar correos electrónicos
	public static boolean isValidPassword(String password) {
		boolean response = true;
		boolean validString = isValidString(password);

		if (validString) {
			Matcher matcher = PASSWORD_PATTERN.matcher(password);

			if (matcher.matches()) {
				response = true;
			} else {
				response = false;
			}

		} else {
			response = false;
		}

		return response;
	}

	public static boolean isValidString(String str) {
		boolean response = true;

		if (str == null || str.isEmpty()) {
			response = false;
		}

		return response;
	}

	public static boolean isValidCC(String cc) {
		boolean response = true;
		boolean validString = isValidString(cc);

		if (validString) {
			Matcher matcher = CC_PATTERN.matcher(cc);
			if (matcher.matches()) {
				response = true;
			} else {
				response = false;
			}
		} else {
			response = false;
		}
		return response;
	}
}
