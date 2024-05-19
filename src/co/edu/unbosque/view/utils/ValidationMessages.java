package co.edu.unbosque.view.utils;

public class ValidationMessages {

    // Mensaje para un campo obligatorio vacío
    public static String getRequiredFieldMessage(String fieldName) {
        return "El campo " + fieldName + " es obligatorio.";
    }

    // Mensaje para un formato de email inválido
    public static String getInvalidEmailMessage() {
        return "El formato del correo electrónico es inválido.";
    }

    // Mensaje para un número fuera de rango
    public static String getNumberOutOfRangeMessage(String fieldName, int min, int max) {
        return "El valor del campo " + fieldName + " debe estar entre " + min + " y " + max + ".";
    }

    // Mensaje para una longitud de texto fuera de rango
    public static String getTextLengthOutOfRangeMessage(String fieldName, int min, int max) {
        return "El campo " + fieldName + " debe tener entre " + min + " y " + max + " caracteres.";
    }

    // Mensaje para una contraseña débil
    public static String getWeakPasswordMessage() {
        return "La contraseña debe cumplir con los siguientes requisitos:\n"
        		+ "1. Al menos 8 caracteres de longitud.\n"
        		+ "2. Contener al menos un dígito (0-9).\n"
        		+ "3. Contener al menos una letra mayúscula o minúscula (a-z, A-Z).\n"
        		+ "4. Contener al menos un carácter especial, como !@#$%^&.";
    }

    // Mensaje para una confirmación de contraseña que no coincide
    public static String getPasswordMismatchMessage() {
        return "La confirmación de la contraseña no coincide.";
    }

    // Mensaje para un formato de número de teléfono inválido
    public static String getInvalidPhoneNumberMessage() {
        return "El formato del número de teléfono es inválido.";
    }

    // Mensaje para un valor no numérico en un campo que requiere números
    public static String getNotANumberMessage(String fieldName) {
        return "El campo " + fieldName + " debe contener solo números.";
    }

    // Mensaje para una fecha inválida
    public static String getInvalidDateMessage() {
        return "La fecha ingresada es inválida.";
    }

    // Mensaje para un formato de URL inválido
    public static String getInvalidUrlMessage() {
        return "El formato de la URL es inválido.";
    }

    // Mensaje para un valor que no cumple con un patrón específico
    public static String getPatternMismatchMessage(String fieldName, String patternDescription) {
        return "El campo " + fieldName + " debe coincidir con el siguiente patrón: " + patternDescription;
    }
    // Mensaje de éxito para el registro
    public static String getRegistrationSuccessMessage() {
        return "Registro exitoso. ¡Bienvenido!";
    }

    // Mensaje de éxito para el inicio de sesión
    public static String getLoginSuccessMessage() {
        return "Inicio de sesión exitoso. ¡Bienvenido de nuevo!";
    }
    
 // Mensaje para usuario ya existente
    public static String getUserAlreadyExistsMessage() {
        return "El usuario ya existe. Por favor, elige un nombre de usuario diferente.";
    }
}
