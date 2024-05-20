/**
 *
 */
package co.edu.unbosque.model.cyclists;

import co.edu.unbosque.helper.ValidationsGenerics;
import co.edu.unbosque.interfaces.CyclistInterface;
import co.edu.unbosque.model.user.User;

import java.time.LocalTime;
import java.util.UUID;

/**
 * Esta clase abstracta representa a un ciclista en general.
 * Define las características básicas de un ciclista y hereda de la clase `User`.
 * los métodos de esta clase abstracta.
 */
public class Cyclist extends User {
    /**
     * Identificador del ciclista
     */
    private final UUID id;
    /**
     * Nombre de ciclista
     */
    private String name;
    /**
     * Tiempo en carrera
     */
    private LocalTime timeRice;
    /**
     * Corpulencia
     */
    private String bodyStructure;
    /**
     * Cadencia de pedaleo del ciclista
     */
    private String cadencePedaling;

    /**
     * Constructor de la clase `Cyclist`.
     *
     * @param name            Nombre del ciclista.
     * @param bodyStructure   Contextura física del ciclista.
     * @param cadencePedaling Cadencia de pedaleo del ciclista.
     * @param CC          Cédula de identidad del ciclista.
     * @param experience      Años de experiencia del ciclista.
     * @param email           Correo electrónico del ciclista.
     * @param password        Contraseña del ciclista.
     */
    public Cyclist(String name,
                   String bodyStructure,
                   String cadencePedaling,
                   long CC,
                   int experience,
                   String email,
                   String password) {
        super(CC, experience, email, password);
        ValidationsGenerics.verifyNameOrNationalityOrCountry(name);
        this.name = name;

        id = UUID.randomUUID();
        timeRice = LocalTime.of(0, 0, 0);

        this.bodyStructure = bodyStructure;
        this.cadencePedaling = cadencePedaling;
    }

    /**
     * Este método es abstracto y debe ser implementado por las clases hijas
     * para definir la especialidad de cada tipo de ciclista.
     */
    //@Override
    //abstract public void specialty();

    /**
     * Método getter para el identificador único del ciclista (UUID).
     *
     * @return El UUID del ciclista.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Método getter para el nombre del ciclista.
     *
     * @return El nombre del ciclista.
     */
    public String getName() {
        return name;
    }

    /**
     * Método setter para el nombre del ciclista.
     *
     * <p>Este método valida el nombre utilizando el método estático `ValidationsCyclist.verifyName(String name)`.
     * Si la validación falla, se imprime un mensaje de error en la salida estándar de error y el nombre no se cambia.</ p>
     *
     * @param name El nuevo nombre a asignar al ciclista. El nombre debe cumplir con un formato específico
     *             (posiblemente letras y espacios) definido en la clase `ValidationsCyclist`.
     */
    public void setName(String name) {
        ValidationsGenerics.verifyNameOrNationalityOrCountry(name);
        this.name = name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1);
    }

    /**
     * Método getter para el tiempo que tarda el ciclista en comer durante una carrera (LocalTime).
     *
     * @return El tiempo que tarda el ciclista en comer (LocalTime).
     */
    public LocalTime getTimeRice() {
        return timeRice;
    }

    /**
     * Método setter para el tiempo que tarda el ciclista en comer durante una carrera (LocalTime).
     *
     * @param timeRice El nuevo tiempo para comer que se asignará al ciclista.
     */
    public void setTimeRice(LocalTime timeRice) {
        this.timeRice = timeRice;
    }

    /**
     * Método getter para la contextura física del ciclista.
     *
     * @return La contextura física del ciclista (String).
     */
    public String getBodyStructure() {
        return bodyStructure;
    }

    /**
     * Método setter para la contextura física del ciclista.
     *
     * @param bodyStructure La nueva contextura física a asignar al ciclista (String).
     */
    public void setBodyStructure(String bodyStructure) {
        this.bodyStructure = bodyStructure;
    }

    /**
     * Método getter para la cadencia de pedaleo del ciclista.
     *
     * @return La cadencia de pedaleo del ciclista (String).
     */
    public String getCadencePedaling() {
        return cadencePedaling;
    }

    /**
     * Método setter para la cadencia de pedaleo del ciclista.
     *
     * @param cadencePedaling La nueva cadencia de pedaleo a asignar al ciclista (String).
     */
    public void setCadencePedaling(String cadencePedaling) {
        this.cadencePedaling = cadencePedaling;
    }
}
