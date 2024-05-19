package co.edu.unbosque.model.persistence.DTO;

import java.io.Serial;
import java.io.Serializable;

/**
 * Clase que representa un DTO (Data Transfer Object) para el director de la aplicación.
 */
public class DirectorDTO implements Serializable {
    /**
     * ID de versión serializable para asegurar compatibilidad entre versiones al serializar/deserializar el objeto.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Cédula de ciudadanía del director.
     */
    private long CC;
    /**
     * Experiencia del director (campo que podría usarse en la aplicación).
     */
    private int experience;
    /**
     * Correo electrónico del director.
     */
    private String email;
    /**
     * Contraseña del director (se recomienda no transmitir esta información en un DTO por motivos de seguridad).
     */
    private String password;
    /**
     * Nacionalidad del director.
     */
    private String nationality;

    /**
     * Obtiene la cédula de ciudadanía del director.
     *
     * @return La cédula de ciudadanía del director.
     */
    public long getCC() {
        return CC;
    }

    /**
     * Establece la cédula de ciudadanía del director.
     *
     * @param CC La nueva cédula de ciudadanía del director.
     */
    public void setCC(long CC) {
        this.CC = CC;
    }

    /**
     * Obtiene la experiencia del director.
     *
     * @return La experiencia del director.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Establece la experiencia del director.
     *
     * @param experience La nueva experiencia del director.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Obtiene el correo electrónico del director.
     *
     * @return El correo electrónico del director.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del director.
     *
     * @param email El nuevo correo electrónico del director.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del director.
     *
     * @return La contraseña del director.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del director.
     *
     * @param password La nueva contraseña del director.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la nacionalidad del director.
     *
     * @return La nacionalidad del director.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Establece la nacionalidad del director.
     *
     * @param nationality La nueva nacionalidad del director.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
