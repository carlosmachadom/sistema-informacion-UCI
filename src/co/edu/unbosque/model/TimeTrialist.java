package co.edu.unbosque.model;

import co.edu.unbosque.helper.ValidationsCyclist;

public class TimeTrialist extends Cyclist {

    private int speedMaximum;

    private String state;

    public TimeTrialist(String name,
                        String bodyStructure,
                        String cadencePedaling,
                        int speedMaximum,
                        String state,
                        long cedula,
                        int experience,
                        String email,
                        String password) {
        super(name, bodyStructure, cadencePedaling, cedula, experience, email, password);

        ValidationsCyclist.verifySpeedMax(speedMaximum);
        this.speedMaximum = speedMaximum;

        this.state = state;
    }

    @Override
    public void specialty() {

    }

    public int getSpeedMaximum() {
        return speedMaximum;
    }

    public void setSpeedMaximum(int speedMaximum) {
        ValidationsCyclist.verifySpeedMax(speedMaximum);
        this.speedMaximum = speedMaximum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
