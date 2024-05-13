package co.edu.unbosque.util;

/**
 * This class represents a custom exception that is thrown when there is an invalid login attempt.
 * It extends the `Exception` class from the Java `java.lang` package.
 */
public class PerserInvalidLogin extends Exception {
    /**
     * Constructor for the `PerserInvalidLogin` exception.
     *
     * @param message The error message describing the reason for the invalid login.
     */
    public PerserInvalidLogin(String message) {
        super(message);
    }
}
