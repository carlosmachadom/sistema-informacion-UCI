/**
 * 
 */
package co.edu.unbosque.model;

/**
 * 
 */
public class Director extends User {

    private String nationality;


    public Director(String nationality,
                    long cedula,
                    int experience,
                    String email,
                    String password) {
        super(cedula, experience, email, password);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
