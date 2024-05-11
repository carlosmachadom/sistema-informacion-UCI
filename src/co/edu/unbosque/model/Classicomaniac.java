package co.edu.unbosque.model;

public class Classicomaniac extends Cyclist {

    private int classicsWon;

    public Classicomaniac(
            String name,
            String bodyStructure,
            String cadencePedaling,
            int classicsWon,
            long cedula,
            int experience,
            String email,
            String password) {
        super(name, bodyStructure, cadencePedaling, cedula, experience, email, password);
        this.classicsWon = classicsWon;
    }

    @Override
    public void specialty() {

    }

    public int getClassicsWon() {
        return classicsWon;
    }

    public void setClassicsWon(int classicsWon) {
        this.classicsWon = classicsWon;
    }
}
