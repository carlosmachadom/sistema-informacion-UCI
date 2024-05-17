package co.edu.unbosque.model.persistence.DTO;

public class DirectorDTO {
    /**
     * Cédula de ciudadanía del usuario.
     */
    private long CC;
    /**
     * Experiencia del usuario (campo que podría usarse en la aplicación).
     */
    private int experience;
    /**
     * Correo electrónico del usuario.
     */
    private String email;
    /**
     * Contraseña del usuario (se recomienda no transmitir esta información en un DTO por motivos de seguridad).
     */
    private String password;
    /**
     * Nacionalidad del director.
     */
    private String nationality;

    public long getCC() {
        return CC;
    }

    public void setCC(long CC) {
        this.CC = CC;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
