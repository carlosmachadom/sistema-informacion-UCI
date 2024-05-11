package co.edu.unbosque.model;

public class Sprinter extends Cyclist {

    private int springSpeed;

    private int potency;

    public Sprinter(String name,
                    String bodyStructure,
                    String cadencePedaling,
                    int springSpeed,
                    int potency,
                    long cedula,
                    int experience,
                    String email,
                    String password) {
        super(name, bodyStructure, cadencePedaling, cedula, experience, email, password);
        this.springSpeed = springSpeed;
        this.potency = potency;
    }

    @Override
    public void specialty() {

    }

    public int getSpringSpeed() {
        return springSpeed;
    }

    public void setSpringSpeed(int springSpeed) {
        this.springSpeed = springSpeed;
    }

    public int getPotency() {
        return potency;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }
}
