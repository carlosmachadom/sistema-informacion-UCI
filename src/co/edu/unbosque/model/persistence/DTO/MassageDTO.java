package co.edu.unbosque.model.persistence.DTO;

import java.io.Serial;
import java.io.Serializable;

/**
 * Clase que representa un DTO (Data Transfer Object) para el director de la aplicación.
 */
public class MassageDTO implements Serializable {
    /**
     * ID de versión serializable para asegurar compatibilidad entre versiones al serializar/deserializar el objeto.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * Cédula de ciudadanía del usuario.
     */
    private long CC;
    /**
     * Experiencia del usuario (campo que podría usarse en la aplicación).
     */
    private int experience;
    /**
     * Correo electrónico del usuario.
     */
    private String email;
    /**
     * Contraseña del usuario (se recomienda no transmitir esta información en un DTO por motivos de seguridad).
     */
    private String password;

    /**
     * Obtiene la cédula de ciudadanía del usuario.
     *
     * @return La cédula de ciudadanía del usuario.
     */
    public long getCC() {
        return CC;
    }

    /**
     * Establece la cédula de ciudadanía del usuario.
     *
     * @param CC La cédula de ciudadanía del usuario.
     */
    public void setCC(long CC) {
        this.CC = CC;
    }

    /**
     * Obtiene la experiencia del usuario.
     *
     * @return La experiencia del usuario (campo que podría usarse en la aplicación).
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Establece la experiencia del usuario.
     *
     * @param experience La experiencia del usuario.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario (se recomienda no transmitir esta información en un DTO por motivos de seguridad).
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password La contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
