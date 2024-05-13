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
     * @param cedula Cédula de identidad del fisioterapeuta.
     * @param experience Años de experiencia del fisioterapeuta.
     * @param email Correo electrónico del fisioterapeuta.
     * @param password Contraseña del fisioterapeuta.
     */
    public MassageTherapist(long cedula, int experience, String email, String password) {
        super(cedula, experience, email, password);
    }
}
