package co.edu.unbosque.view.utils;

/**
 * Esta clase proporciona mensajes de validación estáticos que se pueden utilizar en la interfaz de usuario.
 */
public class ValidationMessages {

	/**
     * Obtiene el mensaje para un campo obligatorio vacío.
     *
     * @param fieldName El nombre del campo que es obligatorio.
     * @return El mensaje indicando que el campo es obligatorio.
     */

    public static String getRequiredFieldMessage(String fieldName) {
        return "El campo " + fieldName + " es obligatorio.";
    }

    /**
     * Obtiene el mensaje para un formato de correo electrónico inválido.
     *
     * @return El mensaje indicando que el formato del correo electrónico es inválido.
     */
    public static String getInvalidEmailMessage() {
        return "El formato del correo electrónico es inválido.";
    }

    /**
     * Obtiene el mensaje para un número fuera de rango.
     *
     * @param fieldName El nombre del campo.
     * @param min       El valor mínimo permitido.
     * @param max       El valor máximo permitido.
     * @return El mensaje indicando que el valor está fuera de rango.
     */
    public static String getNumberOutOfRangeMessage(String fieldName, int min, int max) {
        return "El valor del campo " + fieldName + " debe estar entre " + min + " y " + max + ".";
    }

    /**
     * Obtiene el mensaje para una longitud de texto fuera de rango.
     *
     * @param fieldName El nombre del campo.
     * @param min       La longitud mínima permitida.
     * @param max       La longitud máxima permitida.
     * @return El mensaje indicando que la longitud del texto está fuera de rango.
     */
    public static String getTextLengthOutOfRangeMessage(String fieldName, int min, int max) {
        return "El campo " + fieldName + " debe tener entre " + min + " y " + max + " caracteres.";
    }

    /**
     * Obtiene el mensaje para una contraseña débil.
     *
     * @return El mensaje indicando los requisitos de una contraseña fuerte.
     */
    public static String getWeakPasswordMessage() {
        return "La contraseña debe cumplir con los siguientes requisitos:\n"
        		+ "1. Al menos 8 caracteres de longitud.\n"
        		+ "2. Contener al menos un dígito (0-9).\n"
        		+ "3. Contener al menos una letra mayúscula o minúscula (a-z, A-Z).\n"
        		+ "4. Contener al menos un carácter especial, como !@#$%^&.";
    }

    /**
     * Obtiene el mensaje para una confirmación de contraseña que no coincide.
     *
     * @return El mensaje indicando que la confirmación de la contraseña no coincide.
     */
    public static String getPasswordMismatchMessage() {
        return "La confirmación de la contraseña no coincide.";
    }

    /**
     * Obtiene el mensaje para un formato de número de teléfono inválido.
     *
     * @return El mensaje indicando que el formato del número de teléfono es inválido.
     */
    public static String getInvalidPhoneNumberMessage() {
        return "El formato del número de teléfono es inválido.";
    }

    /**
     * Obtiene el mensaje para un valor no numérico en un campo que requiere números.
     *
     * @param fieldName El nombre del campo.
     * @return El mensaje indicando que el campo debe contener solo números.
     */
    public static String getNotANumberMessage(String fieldName) {
        return "El campo " + fieldName + " debe contener solo números.";
    }

    /**
     * Obtiene el mensaje para una fecha inválida.
     *
     * @return El mensaje indicando que la fecha ingresada es inválida.
     */
    public static String getInvalidDateMessage() {
        return "La fecha ingresada es inválida.";
    }

    /**
     * Obtiene el mensaje para un formato de URL inválido.
     *
     * @return El mensaje indicando que el formato de la URL es inválido.
     */
    public static String getInvalidUrlMessage() {
        return "El formato de la URL es inválido.";
    }

    /**
     * Obtiene el mensaje para un valor que no cumple con un patrón específico.
     *
     * @param fieldName          El nombre del campo.
     * @param patternDescription La descripción del patrón requerido.
     * @return El mensaje indicando que el campo debe coincidir con el patrón especificado.
     */
    public static String getPatternMismatchMessage(String fieldName, String patternDescription) {
        return "El campo " + fieldName + " debe coincidir con el siguiente patrón: " + patternDescription;
    }
    /**
     * Obtiene el mensaje de éxito para el registro.
     *
     * @return El mensaje indicando que el registro fue exitoso.
     */
    public static String getRegistrationSuccessMessage() {
        return "Registro exitoso. ¡Bienvenido!";
    }

    /**
     * Obtiene el mensaje de éxito para el inicio de sesión.
     *
     * @return El mensaje indicando que el inicio de sesión fue exitoso.
     */
    public static String getLoginSuccessMessage() {
        return "Inicio de sesión exitoso. ¡Bienvenido de nuevo!";
    }
    
    /**
     * Obtiene el mensaje para usuario ya existente.
     *
     * @return El mensaje indicando que el usuario ya existe.
     */
    public static String getUserAlreadyExistsMessage() {
        return "El usuario ya existe. Por favor, elige un nombre de usuario diferente.";
    }
    /**
     * Obtiene el mensaje de éxito para el envío de correo.
     *
     * @return El mensaje indicando que el correo se ha enviado con éxito.
     */
    public static String getSuccessEmailSentMessage() {
        return "Se ha enviado un correo que contiene su usario";
    }

}
