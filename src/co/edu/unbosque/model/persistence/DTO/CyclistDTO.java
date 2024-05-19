package co.edu.unbosque.model.persistence.DTO;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Clase que representa un Data Transfer Object (DTO) para un ciclista.
 * Esta clase es serializable y se utiliza para transferir datos de un ciclista entre diferentes capas de la aplicación.
 */
public class CyclistDTO implements Serializable {
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
     * Identificador del ciclista
     */
    private UUID id;
    /**
     * Nombre de ciclista
     */
    private String name;
    /**
     * Tiempo en carrera
     */
    private LocalTime timeRice;
    /**
     * Corpulencia del ciclista.
     */
    private String bodyStructure;
    /**
     * Cadencia de pedaleo del ciclista
     */
    private String cadencePedaling;

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
     * Obtiene el identificador del ciclista.
     * @return el identificador del ciclista.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Establece el identificador del ciclista.
     * @param id el nuevo identificador del ciclista.
     * @return el identificador del ciclista.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del ciclista.
     * @return el nombre del ciclista.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del ciclista.
     * @param name el nuevo nombre del ciclista.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el tiempo en carrera del ciclista.
     * @return el tiempo en carrera del ciclista.
     */
    public LocalTime getTimeRice() {
        return timeRice;
    }

    /**
     * Establece el tiempo en carrera del ciclista.
     * @param timeRice el nuevo tiempo en carrera del ciclista.
     */
    public void setTimeRice(LocalTime timeRice) {
        this.timeRice = timeRice;
    }

    /**
     * Obtiene la corpulencia del ciclista.
     * @return la corpulencia del ciclista.
     */
    public String getBodyStructure() {
        return bodyStructure;
    }

    /**
     * Establece la corpulencia del ciclista.
     * @param bodyStructure la nueva corpulencia del ciclista.
     */
    public void setBodyStructure(String bodyStructure) {
        this.bodyStructure = bodyStructure;
    }

    /**
     * Obtiene la cadencia de pedaleo del ciclista.
     * @return la cadencia de pedaleo del ciclista.
     */
    public String getCadencePedaling() {
        return cadencePedaling;
    }

    /**
     * Establece la cadencia de pedaleo del ciclista.
     * @param cadencePedaling la nueva cadencia de pedaleo del ciclista.
     */
    public void setCadencePedaling(String cadencePedaling) {
        this.cadencePedaling = cadencePedaling;
    }
}
