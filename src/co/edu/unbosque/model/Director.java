/**
 *
 */
package co.edu.unbosque.model;

/**
 * Esta clase representa a un director del sistema.
 */
public class Director extends User {
    /** Nacionalidad del director. */
    private String nationality;

    /**
     * Constructor de la clase `Director`.
     *
     * @param nationality Nacionalidad del director.
     * @param cedula Cédula de identidad del director.
     * @param experience Años de experiencia del director (en el contexto del sistema).
     * @param email Correo electrónico del director.
     * @param password Contraseña del director.
     */
    public Director(String nationality,
                    long cedula,
                    int experience,
                    String email,
                    String password) {
        super(cedula, experience, email, password);
        this.nationality = nationality;
    }

    /**
     * Método getter para la nacionalidad del director.
     * @return La nacionalidad del director.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Método setter para la nacionalidad del director.
     * @param nationality La nueva nacionalidad a asignar al director.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
