package co.edu.unbosque.util;

import co.edu.unbosque.model.cyclists.Cyclist;
import co.edu.unbosque.model.Director;
import co.edu.unbosque.model.MassageTherapist;
import co.edu.unbosque.model.User;

/**
 * Esta clase de utilidad proporciona métodos para generar tokens de usuario basados en el tipo de usuario
 * (ciclista, masajista o director).
 */

public class TokenSchema {
    /**
     * El usuario actualmente autenticado en el sistema. Se utiliza para generar tokens que
     * identifican el tipo de usuario autenticado.
     */
    private static User user;

    /**
     * Genera un esquema de token basado en el correo electrónico, la contraseña y el tipo de usuario.
     *
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @param type     El tipo de usuario ("cyclist", "massage", "director").
     * @return El esquema del token generado en el formato "email:password@type".
     */
    private static String schema(String email, String password, String type) {
        return email + ":" + password + "@" + type;
    }

    /**
     * Genera un token de usuario basado en el correo electrónico, la contraseña y el tipo de usuario
     * almacenado en el atributo `user`.
     * <p>
     * Si el usuario autenticado no coincide con ninguno de los tipos admitidos (ciclista, masajista, director),
     * el método devuelve `null`.
     *
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @return El token del usuario generado en el formato "email:password@type", o `null` si el tipo de usuario
     * no es válido.
     */
    public static String createUserToken(String email, String password) {
        String token = null;
        if (user instanceof Cyclist) token = schema(email, password, "cyclist");

        if (user instanceof MassageTherapist) token = schema(email, password, "massage");

        if (user instanceof Director) token = schema(email, password, "director");

        return token;
    }

    /**
     * Recupera el usuario actualmente autenticado almacenado en el atributo `user`.
     *
     * @return El usuario autenticado.
     */
    public static User getUser() {
        return user;
    }

    /**
     * Establece el usuario actualmente autenticado en el sistema.
     *
     * @param user El usuario que se desea establecer como autenticado.
     */
    public static void setUser(User user) {
        TokenSchema.user = user;
    }
}
