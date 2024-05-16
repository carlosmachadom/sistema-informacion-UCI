package co.edu.unbosque.model.cyclists;

import co.edu.unbosque.helper.ValidationsCyclist;

/**
 * Esta clase representa a un ciclista escalador, heredando las características de la clase `Cyclist`.
 * Un ciclista escalador se especializa en subir montañas.
 */
public class Climber extends Cyclist {
    /**
     * Aceleración del ciclista en subida (metros por segundo al cuadrado).
     */
    private double accelerationUphill;
    /**
     * Pendiente máxima que puede subir el ciclista (grados).
     */
    private int climbingGrade;
    /**
     * Posición del ciclista en la competencia (por ejemplo, primer lugar).
     */
    private String position;

    /**
     * Constructor de la clase `Climber`.
     *
     * @param name               Nombre del ciclista.
     * @param bodyStructure      Contextura física del ciclista.
     * @param cadencePedaling    Cadencia de pedaleo del ciclista.
     * @param accelerationUphill Aceleración del ciclista en subida (metros por segundo al cuadrado).
     * @param climbingGrade      Pendiente máxima que puede subir el ciclista (grados).
     * @param position           Posición del ciclista en la competencia (por ejemplo, primer lugar).
     * @param cedula             Cédula de identidad del ciclista.
     * @param experience         Años de experiencia del ciclista.
     * @param email              Correo electrónico del ciclista.
     * @param password           Contraseña del ciclista.
     *                           <p>
     *                           La validación del grado de inclinación y la aceleración en subida se realiza dentro del constructor
     *                           utilizando métodos estáticos de la clase `ValidationsCyclist`.
     */
    public Climber(
            String name,
            String bodyStructure,
            String cadencePedaling,
            double accelerationUphill,
            int climbingGrade,
            String position,
            long cedula,
            int experience,
            String email,
            String password) {
        super(name, bodyStructure, cadencePedaling, cedula, experience, email, password);

        ValidationsCyclist.verifyClimbingGrade(climbingGrade);
        this.climbingGrade = climbingGrade;

        ValidationsCyclist.verifyAccelerationUphill(accelerationUphill);
        this.accelerationUphill = accelerationUphill;

        this.position = position;
    }

    /**
     * Este método abstracto se hereda de la clase `Cyclist` y debe ser implementado para definir la especialidad del ciclista escalador.
     * En este caso, la implementación podría detallar cómo el ciclista aborda las subidas.
     */
    @Override
    public void specialty() {

    }

    /**
     * Método getter para la aceleración del ciclista en subida.
     *
     * @return La aceleración del ciclista en subida (metros por segundo al cuadrado).
     */
    public double getAccelerationUphill() {
        return accelerationUphill;
    }

    /**
     * Método setter para la aceleración del ciclista en subida.
     *
     * @param accelerationUphill La nueva aceleración en subida a asignar al ciclista (metros por segundo al cuadrado).
     */
    public void setAccelerationUphill(double accelerationUphill) {
        this.accelerationUphill = accelerationUphill;
    }

    /**
     * Método getter para la pendiente máxima que puede subir el ciclista.
     *
     * @return La pendiente máxima que puede subir el ciclista (grados).
     */
    public int getClimbingGrade() {
        return climbingGrade;
    }

    /**
     * Método setter para la pendiente máxima que puede subir el ciclista.
     *
     * @param climbingGrade La nueva pendiente máxima a asignar al ciclista (grados).
     */
    public void setClimbingGrade(int climbingGrade) {
        this.climbingGrade = climbingGrade;
    }

    /**
     * Método getter para la posición del ciclista en la competencia.
     *
     * @return La posición del ciclista en la competencia (por ejemplo, primer lugar).
     */
    public String getPosition() {
        return position;
    }

    /**
     * Método setter para la posición del ciclista en la competencia.
     *
     * @param position La nueva posición a asignar al ciclista en la competencia.
     */
    public void setPosition(String position) {
        this.position = position;
    }
}
