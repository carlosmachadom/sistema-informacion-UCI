package co.edu.unbosque.model;

/**
 * Esta clase representa a un ciclista sprinter, heredando las características de la clase `Cyclist`.
 * Un ciclista sprinter se especializa en carreras cortas donde se requiere爆发力 (bāofā lì - potencia explosiva)
 * y alta velocidad punta.
 */
public class Sprinter extends Cyclist {
    /**
     * Velocidad punta del ciclista en un sprint (kilómetros por hora).
     */
    private int springSpeed;
    /**
     * Potencia del ciclista (watts).
     */
    private int potency;

    /**
     * Constructor de la clase `Sprinter`.
     *
     * @param name            Nombre del ciclista.
     * @param bodyStructure   Contextura física del ciclista.
     * @param cadencePedaling Cadencia de pedaleo del ciclista.
     * @param springSpeed     Velocidad punta del ciclista en un sprint (kilómetros por hora).
     * @param potency         Potencia del ciclista (watts).
     * @param cedula          Cédula de identidad del ciclista.
     * @param experience      Años de experiencia del ciclista.
     * @param email           Correo electrónico del ciclista.
     * @param password        Contraseña del ciclista.
     */
    public Sprinter(String name,
                    String bodyStructure,
                    String cadencePedaling,
                    int springSpeed,
                    int potency,
                    long cedula,
                    int experience,
                    String email,
                    String password) {
        super(name, bodyStructure, cadencePedaling, cedula, experience, email, password);
        this.springSpeed = springSpeed;
        this.potency = potency;
    }

    /**
     * Este método abstracto se hereda de la clase `Cyclist` y debe ser implementado para definir la especialidad del ciclista sprinter.
     * En este caso, la implementación podría detallar cómo el ciclista realiza un sprint.
     */
    @Override
    public void specialty() {

    }

    /**
     * Método getter para la velocidad punta del ciclista en un sprint.
     *
     * @return La velocidad punta del ciclista en un sprint (kilómetros por hora).
     */
    public int getSpringSpeed() {
        return springSpeed;
    }

    /**
     * Método setter para la velocidad punta del ciclista en un sprint.
     *
     * @param springSpeed La nueva velocidad punta a asignar al ciclista en un sprint (kilómetros por hora).
     */
    public void setSpringSpeed(int springSpeed) {
        this.springSpeed = springSpeed;
    }

    /**
     * Método getter para la potencia del ciclista.
     *
     * @return La potencia del ciclista (watts).
     */
    public int getPotency() {
        return potency;
    }

    /**
     * Método setter para la potencia del ciclista.
     *
     * @param potency La nueva potencia a asignar al ciclista (watts).
     */
    public void setPotency(int potency) {
        this.potency = potency;
    }
}
