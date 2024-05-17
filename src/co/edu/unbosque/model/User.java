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
    private final long CC;
    /**
     * Años de experiencia del usuario.
     */
    private int experience;
    /**
     * Correo electrónico del usuario.
     */
    private final String email;
    /**
     * Contraseña del usuario.
     */
    private String password;

    /**
     * Constructor de la clase `User`.
     *
     * @param CC         Cédula de identidad del usuario.
     * @param experience Años de experiencia del usuario.
     * @param email      Correo electrónico del usuario.
     * @param password   Contraseña del usuario.
     *                   <p>
     *                   La validación del correo electrónico y la experiencia se realiza dentro del constructor.
     */
    public User(long CC, int experience, String email, String password) {
        ValidationsUser.verifyEmail(email);
        this.email = email;
        ValidationsUser.verifyPassword(password);
        this.password = password;
        ValidationsUser.verifyCC(CC);
        this.CC = CC;
        ValidationsUser.verifyExperience(experience);
        this.experience = experience;
    }

    /**
     * Método getter para la cédula de identidad del usuario.
     *
     * @return La cédula de identidad del usuario.
     */
    public long getCC() {
        return CC;
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
        ValidationsUser.verifyExperience(experience);
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
        ValidationsUser.verifyPassword(password);
        this.password = password;
    }
}
