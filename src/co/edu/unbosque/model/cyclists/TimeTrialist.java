package co.edu.unbosque.model.cyclists;

import co.edu.unbosque.helper.ValidationsCyclist;

/**
 * Esta clase representa a un ciclista contrarelojista, heredando las características de la clase `Cyclist`.
 * Un ciclista contrarelojista se especializa en carreras contrarreloj, donde se busca recorrer una distancia en el menor tiempo posible.
 */
public class TimeTrialist extends Cyclist {

    /**
     * Velocidad máxima alcanzada por el ciclista en una prueba contrarreloj (kilómetros por hora).
     */
    private int speedMaximum;
    /**
     * Estado del ciclista (por ejemplo, en forma, lesionado).
     */
    private String state;

    /**
     * Constructor de la clase `TimeTrialist`.
     *
     * @param name            Nombre del ciclista.
     * @param bodyStructure   Contextura física del ciclista.
     * @param cadencePedaling Cadencia de pedaleo del ciclista.
     * @param speedMaximum    Velocidad máxima alcanzada por el ciclista en una prueba contrarreloj (kilómetros por hora).
     * @param state           Estado del ciclista (por ejemplo, en forma, lesionado).
     * @param cedula          Cédula de identidad del ciclista.
     * @param experience      Años de experiencia del ciclista.
     * @param email           Correo electrónico del ciclista.
     * @param password        Contraseña del ciclista.
     *                        <p>
     *                        La velocidad máxima se valida utilizando métodos estáticos de la clase `ValidationsCyclist`.
     */
    public TimeTrialist(String name,
                        String bodyStructure,
                        String cadencePedaling,
                        int speedMaximum,
                        String state,
                        long cedula,
                        int experience,
                        String email,
                        String password) {
        super(name, bodyStructure, cadencePedaling, cedula, experience, email, password);

        ValidationsCyclist.verifySpeedMax(speedMaximum);
        this.speedMaximum = speedMaximum;

        this.state = state;
    }

    /**
     * Este método abstracto se hereda de la clase `Cyclist` y debe ser implementado para definir la especialidad del ciclista contrarelojista.
     * En este caso, la implementación podría detallar cómo el ciclista aborda una prueba contrarreloj.
     */
    @Override
    public void specialty() {

    }

    /**
     * Método getter para la velocidad máxima alcanzada por el ciclista en una prueba contrarreloj.
     *
     * @return La velocidad máxima alcanzada por el ciclista en una prueba contrarreloj (kilómetros por hora).
     */
    public int getSpeedMaximum() {
        return speedMaximum;
    }

    /**
     * Método setter para la velocidad máxima alcanzada por el ciclista en una prueba contrarreloj.
     *
     * @param speedMaximum La nueva velocidad máxima a asignar al ciclista (kilómetros por hora).
     *                     La velocidad máxima se valida antes de actualizar el valor del atributo.
     */
    public void setSpeedMaximum(int speedMaximum) {
        ValidationsCyclist.verifySpeedMax(speedMaximum);
        this.speedMaximum = speedMaximum;
    }

    /**
     * Método getter para el estado del ciclista.
     *
     * @return El estado del ciclista (por ejemplo, en forma, lesionado).
     */
    public String getState() {
        return state;
    }

    /**
     * Método setter para el estado del ciclista.
     *
     * @param state El nuevo estado a asignar al ciclista.
     */
    public void setState(String state) {
        this.state = state;
    }
}
