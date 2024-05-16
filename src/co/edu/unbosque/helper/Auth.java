package co.edu.unbosque.helper;

import co.edu.unbosque.model.persistence.LogIn;
import co.edu.unbosque.util.AutenticationError;
import co.edu.unbosque.util.TokenSchema;

/**
 * This class provides functionalities related to user authentication and authorization.
 * It utilizes the `LogIn` class for persistence of access tokens and the `TokenSchema` class for token generation.
 */
public class Auth {
    /**
     * An instance of the `LogIn` class used for managing access tokens.
     */
    private static LogIn logIn;

    /**
     * Constructor for the `Auth` class.
     * Initializes the `logIn` instance and calls its `helthCheck` method to ensure proper file existence.
     */
    public Auth() {
        logIn = new LogIn();
        logIn.helthCheck();
    }

    /**
     * Generates and stores an access token for a user.
     *
     * @param email    The email address of the user.
     * @param password The user's password.
     */
    public void generateAccessToken(String email, String password) {
        String token = TokenSchema.createUserToken(email, password);
        logIn.writeFile(token);
    }

    /**
     * Verifies if a user is logged in based on the email and password.
     *
     * @param email    The email address of the user.
     * @param password The user's password.
     */
    public void verifyIsLogged(String email, String password) {
        String accessToken = logIn.readFile();
        try {
            if (!accessToken.contains(email) || !accessToken.contains(password)) {
                throw new AutenticationError("El usuario o la contraseña es incorrecta");
            }
        } catch (AutenticationError err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Verifies if the currently logged in user has authorization (e.g., role of "director") to perform an action.
     */
    public void verifyAuthorizationUser() {
        String accessToken = logIn.readFile();
        try {
            if (!accessToken.contains("director")) {
                throw new AutenticationError("El usuario no tiene permisos de ejecucion");
            }
        } catch (AutenticationError err) {
            System.out.println(err.getMessage());
        }
    }
}
