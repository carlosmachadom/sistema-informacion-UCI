package co.edu.unbosque.helper;

import co.edu.unbosque.model.persistence.LogIn;
import co.edu.unbosque.util.AutenticationError;
import co.edu.unbosque.util.FileHandler;
import co.edu.unbosque.util.TokenSchema;

/**
 * Esta clase proporciona funcionalidades relacionadas con la autenticación y autorización de usuarios.
 * Utiliza la clase `LogIn` para la persistencia de los tokens de acceso y la clase `TokenSchema` para la generación de tokens.
 */
public class Auth {
	/**
     * Una instancia de la clase `LogIn` utilizada para gestionar los tokens de acceso.
     */
    private static LogIn logIn;

    /**
     * Constructor de la clase `Auth`.
     * Inicializa la instancia `logIn` y llama a su método `helthCheck` para asegurar la existencia adecuada del archivo.
     */
    public Auth() {
        logIn = new LogIn();
    }

    /**
     * Genera y almacena un token de acceso para un usuario.
     *
     * @param email    La dirección de correo electrónico del usuario.
     * @param password La contraseña del usuario.
     */
    public void generateAccessToken(String email, String password) {
        String token = TokenSchema.createUserToken(email, password);
        logIn.writeFile(token);
    }

    /**
     * Verifica si un usuario ha iniciado sesión basado en su correo electrónico y contraseña.
     *
     * @param email    La dirección de correo electrónico del usuario.
     * @param password La contraseña del usuario.
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
     * Verifica si el usuario actualmente conectado tiene autorización (por ejemplo, rol de "director") para realizar una acción.
     */
    public void verifyAuthorizationDirector() {
        String accessToken = logIn.readFile();
        try {
            if (!accessToken.contains("director")) {
                throw new AutenticationError("El usuario no tiene permisos de ejecucion");
            }
        } catch (AutenticationError err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Desconecta al usuario actual eliminando el archivo de sesión.
     * <p>
     * Se utiliza para cerrar la sesión del usuario y eliminar la información de autenticación almacenada en un archivo.
     * <p>
     * **Precaución:** Este método elimina permanentemente el archivo de sesión. Asegúrate de que el usuario haya terminado su actividad antes de llamar a este método.
     */
    public void disconnectUser() {
        String file = FileHandler.getFilepath() + logIn.getFile();
        FileHandler.deleteFile(file);
    }
}
