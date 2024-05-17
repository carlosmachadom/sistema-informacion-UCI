package co.edu.unbosque.model.cyclists;

import co.edu.unbosque.helper.ValidationsCyclist;

/**
 * Esta clase representa a un ciclista de tipo "Clasicómano".
 * Hereda de la clase base `Cyclist` e incluye una propiedad adicional
 * para almacenar la cantidad de clásicas ganadas.
 */
public class Classicomaniac extends Cyclist {
    /**
     * Variable cuantas clasicos ah ganado
     */
    private int classicsWon;

    /**
     * Constructor de la clase `Classicomaniac`.
     *
     * @param name            Nombre del ciclista.
     * @param bodyStructure   Contextura física del ciclista.
     * @param cadencePedaling Cadencia de pedaleo del ciclista.
     * @param classicsWon     Cantidad de clásicas ganadas por el ciclista.
     * @param CC              Cédula de identidad del ciclista.
     * @param experience      Años de experiencia del ciclista.
     * @param email           Correo electrónico del ciclista.
     * @param password        Contraseña del ciclista.
     */
    public Classicomaniac(
            String name,
            String bodyStructure,
            String cadencePedaling,
            int classicsWon,
            long CC,
            int experience,
            String email,
            String password) {
        super(name, bodyStructure, cadencePedaling, CC, experience, email, password);
        ValidationsCyclist.verifySpeedMaxOrClassicsWon(classicsWon);
        this.classicsWon = classicsWon;
    }

    /**
     * Este método se hereda de la clase base `Cyclist` pero no se implementa
     * ninguna funcionalidad específica para ciclistas Clasicómanos.
     * Se puede sobrescribir en el futuro para definir una especialidad
     * particular de este tipo de ciclista.
     */
    @Override
    public void specialty() {
        // No implementado
    }

    /**
     * Obtiene la cantidad de clásicas ganadas por el ciclista Clasicómano.
     *
     * @return La cantidad de clásicas ganadas.
     */
    public int getClassicsWon() {
        return classicsWon;
    }

    /**
     * Establece la cantidad de clásicas ganadas por el ciclista Clasicómano.
     *
     * @param classicsWon La nueva cantidad de clásicas ganadas.
     */
    public void setClassicsWon(int classicsWon) {
        ValidationsCyclist.verifySpeedMaxOrClassicsWon(classicsWon);
        this.classicsWon = classicsWon;
    }
}
