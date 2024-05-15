/**
 *
 */
package co.edu.unbosque.model;

import co.edu.unbosque.helper.ValidationsCyclist;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Esta clase representa un equipo de ciclismo en el sistema.
 */
public class Squad {

    /**
     * Nombre del equipo.
     */
    private String name;
    /**
     * Tiempo que tardó el equipo en completar la carrera (inicializado en 00:00:00).
     */
    private LocalTime raceTime;

    /**
     * País de origen del equipo (opcional).
     */
    private String country;

    /**
     * Lista de ciclistas que conforman el equipo (máximo 8 ciclistas).
     */
    private ArrayList<Cyclist> platoon;

    /**
     * Constructor de la clase `Squad`.
     *
     * @param name    Nombre del equipo.
     * @param country País de origen del equipo (opcional).
     *                <p>
     *                Se valida el nombre del equipo utilizando métodos estáticos de la clase `ValidationsCyclist`.
     */
    public Squad(String name, String country) {
        ValidationsCyclist.verifyName(name);
        this.name = name;
        this.raceTime = LocalTime.of(0, 0, 0);
        
        if(country != null) {
        	this.country = country;        	
        } else {
        	this.country = null;        	
        }
        
        platoon = new ArrayList<>(8);
    }

    /**
     * Método getter para el nombre del equipo.
     *
     * @return El nombre del equipo.
     */
    public String getName() {
        return name;
    }

    /**
     * Método setter para el nombre del equipo.
     *
     * @param name El nuevo nombre a asignar al equipo.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método getter para el tiempo que tardó el equipo en completar la carrera.
     *
     * @return El tiempo que tardó el equipo en completar la carrera (formato LocalTime).
     */
    public LocalTime getRaceTime() {
        return raceTime;
    }

    /**
     * Método setter para el tiempo que tardó el equipo en completar la carrera.
     *
     * @param raceTime El nuevo tiempo a asignar al equipo por completar la carrera (formato LocalTime).
     */
    public void setRaceTime(LocalTime raceTime) {
        this.raceTime = raceTime;
    }

    /**
     * Método getter para el país de origen del equipo.
     *
     * @return El país de origen del equipo (opcional).
     */
    public String getCountry() {
        return country;
    }

    /**
     * Método setter para el país de origen del equipo.
     *
     * @param country El nuevo país de origen a asignar al equipo (opcional).
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Método getter para la lista de ciclistas del equipo.
     *
     * @return La lista de ciclistas que conforman el equipo (máximo 8 ciclistas).
     */
    public ArrayList<Cyclist> getPlatoon() {
        return platoon;
    }

    /**
     * Método setter para la lista de ciclistas del equipo.
     *
     * @param platoon La nueva lista de ciclistas a asignar al equipo (máximo 8 ciclistas).
     */
    public void setPlatoon(ArrayList<Cyclist> platoon) {
        this.platoon = platoon;
    }
}
