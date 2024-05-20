package co.edu.unbosque.model.cyclists;

/**
 * Esta clase representa a un ciclista de pista, heredando las características de la clase `Cyclist`.
 * Un ciclista de pista se especializa en carreras en velódromos.
 */
public class Roller extends Cyclist {
    /**
     * Cadencia de velocidad del ciclista (revoluciones por minuto).
     */
    private double cadenceSpeed;

    /**
     * Constructor de la clase `Roller`.
     *
     * @param name            Nombre del ciclista.
     * @param bodyStructure   Contextura física del ciclista.
     * @param cadencePedaling Cadencia de pedaleo del ciclista.
     * @param cadenceSpeed    Cadencia de velocidad del ciclista (revoluciones por minuto).
     * @param CC              Cédula de identidad del ciclista.
     * @param experience      Años de experiencia del ciclista.
     * @param email           Correo electrónico del ciclista.
     * @param password        Contraseña del ciclista.
     */
    public Roller(String name,
                  String bodyStructure,
                  String cadencePedaling,
                  double cadenceSpeed,
                  long CC,
                  int experience,
                  String email,
                  String password) {
        super(name, bodyStructure, cadencePedaling, CC, experience, email, password);
        this.cadenceSpeed = cadenceSpeed;
    }

    /**
     * Este método abstracto se hereda de la clase `Cyclist` y debe ser implementado para definir la especialidad del ciclista de pista.
     * En este caso, la implementación podría detallar cómo el ciclista corre en el velódromo.
     */
//    @Override
//    public void specialty() {
//
//    }

    /**
     * Método getter para la cadencia de velocidad del ciclista.
     *
     * @return La cadencia de velocidad del ciclista (revoluciones por minuto).
     */
    public double getCadenceSpeed() {
        return cadenceSpeed;
    }

    /**
     * Método setter para la cadencia de velocidad del ciclista.
     *
     * @param cadenceSpeed La nueva cadencia de velocidad a asignar al ciclista (revoluciones por minuto).
     */
    public void setCadenceSpeed(double cadenceSpeed) {
        this.cadenceSpeed = cadenceSpeed;
    }
}
