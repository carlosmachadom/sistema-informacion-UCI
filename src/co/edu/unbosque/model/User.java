/**
 *
 */
package co.edu.unbosque.model;

import co.edu.unbosque.helper.ValidationsUser;

/**
 * Esta clase representa a un usuario del sistema.
 */
public class User {
    /**
     * Cédula de identidad del usuario.
     */
    private long cedula;
    /**
     * Años de experiencia del usuario.
     */
    private int experience;
    /**
     * Correo electrónico del usuario.
     */
    private String email;
    /**
     * Contraseña del usuario.
     */
    private String password;

    /**
     * Constructor de la clase `User`.
     *
     * @param cedula     Cédula de identidad del usuario.
     * @param experience Años de experiencia del usuario.
     * @param email      Correo electrónico del usuario.
     * @param password   Contraseña del usuario.
     *                   <p>
     *                   La validación del correo electrónico y la experiencia se realiza dentro del constructor.
     */
    public User(long cedula, int experience, String email, String password) {
        ValidationsUser.verifyEmail(email);
        this.email = email;
        this.password = password;
        this.cedula = cedula;
        ValidationsUser.verifyExperience(experience);
        this.experience = experience;
    }

    /**
     * Método getter para la cédula de identidad del usuario.
     *
     * @return La cédula de identidad del usuario.
     */
    public long getCedula() {
        return cedula;
    }

    /**
     * Método setter para la cédula de identidad del usuario.
     *
     * @param cedula La nueva cédula de identidad a asignar al usuario.
     */
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    /**
     * Método getter para los años de experiencia del usuario.
     *
     * @return Los años de experiencia del usuario.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Método setter para los años de experiencia del usuario.
     *
     * @param experience Los nuevos años de experiencia a asignar al usuario.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Método getter para el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método setter para el correo electrónico del usuario.
     *
     * @param email El nuevo correo electrónico a asignar al usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método getter para la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método setter para la contraseña del usuario.
     *
     * @param password La nueva contraseña a asignar al usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
