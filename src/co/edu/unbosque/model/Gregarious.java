package co.edu.unbosque.model;

public class Gregarious extends Cyclist {

    private String functionPlatoon;

    public Gregarious(String name,
                      String bodyStructure,
                      String cadencePedaling,
                      String functionPlatoon,
                      long cedula,
                      int experience,
                      String email,
                      String password) {
        super(name, bodyStructure, cadencePedaling, cedula, experience, email, password);
        this.functionPlatoon = functionPlatoon;
    }

    @Override
    public void specialty() {

    }

    public String getFunctionPlatoon() {
        return functionPlatoon;
    }

    public void setFunctionPlatoon(String functionPlatoon) {
        this.functionPlatoon = functionPlatoon;
    }
}
