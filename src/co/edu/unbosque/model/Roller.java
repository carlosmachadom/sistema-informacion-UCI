package co.edu.unbosque.model;

public class Roller extends Cyclist {

    private double cadenceSpeed;

    public Roller(String name,
                  String bodyStructure,
                  String cadencePedaling,
                  double cadenceSpeed,
                  long cedula,
                  int experience,
                  String email,
                  String password) {
        super(name, bodyStructure, cadencePedaling, cedula, experience, email, password);
        this.cadenceSpeed = cadenceSpeed;
    }

    @Override
    public void specialty() {

    }

    public double getCadenceSpeed() {
        return cadenceSpeed;
    }

    public void setCadenceSpeed(double cadenceSpeed) {
        this.cadenceSpeed = cadenceSpeed;
    }
}
