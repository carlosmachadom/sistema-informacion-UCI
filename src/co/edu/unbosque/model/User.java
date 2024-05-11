/**
 * 
 */
package co.edu.unbosque.model;

import co.edu.unbosque.helper.ValidationsUser;

/**
 * 
 */
public class User {

    private long cedula;

    private int experience;

    private String email;

    private String password;

    public User(long cedula, int experience, String email, String password) {
        ValidationsUser.verifyEmail(email);
        this.email = email;
        this.password = password;
        this.cedula = cedula;
        ValidationsUser.verifyExperience(experience);
        this.experience = experience;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
