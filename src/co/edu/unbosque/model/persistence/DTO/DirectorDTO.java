package co.edu.unbosque.model.persistence.DTO;

import java.io.Serial;
import java.io.Serializable;

/**
 * Clase que representa un Data Transfer Object (DTO) para un director.
 * Esta clase es serializable y se utiliza para transferir datos de un director entre diferentes capas de la aplicación.
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
     * Obtiene la cédula de ciudadanía del usuario.
     * @return la cédula de ciudadanía.
     */
    public long getCC() {
        return CC;
    }

    /**
     * Establece la cédula de ciudadanía del usuario.
     * @param CC la nueva cédula de ciudadanía.
     */
    public void setCC(long CC) {
        this.CC = CC;
    }

    /**
     * Obtiene la experiencia del usuario.
     * @return la experiencia del usuario.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Establece la experiencia del usuario.
     * @param experience la nueva experiencia del usuario.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return el correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email el nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return la contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password la nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la nacionalidad del director.
     * @return la nacionalidad del director.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Establece la nacionalidad del director.
     * @param nationality la nueva nacionalidad del director.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
