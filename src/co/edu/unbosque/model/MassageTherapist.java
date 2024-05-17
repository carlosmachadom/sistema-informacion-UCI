/**
 *
 */
package co.edu.unbosque.model;

/**
 * Esta clase representa a un fisioterapeuta del sistema.
 */
public class MassageTherapist extends User {
    /**
     * Constructor de la clase `MassageTherapist`.
     *
     * @param CC CC de identidad del fisioterapeuta.
     * @param experience Años de experiencia del fisioterapeuta.
     * @param email Correo electrónico del fisioterapeuta.
     * @param password Contraseña del fisioterapeuta.
     */
    public MassageTherapist(long CC, int experience, String email, String password) {
        super(CC, experience, email, password);
    }
}
