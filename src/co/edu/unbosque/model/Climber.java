package co.edu.unbosque.model;

import co.edu.unbosque.helper.ValidationsCyclist;

public class Climber extends Cyclist {

    private double accelerationUphill;

    private int climbingGrade;

    private String position;

    public Climber(
            String name,
            String bodyStructure,
            String cadencePedaling,
            double accelerationUphill,
            int climbingGrade,
            String position,
            long cedula,
            int experience,
            String email,
            String password) {
        super(name, bodyStructure, cadencePedaling, cedula, experience, email, password);

        ValidationsCyclist.verifyClimbingGrade(climbingGrade);
        this.climbingGrade = climbingGrade;

        ValidationsCyclist.verifyAccelerationUphill(accelerationUphill);
        this.accelerationUphill = accelerationUphill;

        this.position = position;
    }


    @Override
    public void specialty() {

    }

    public double getAccelerationUphill() {
        return accelerationUphill;
    }

    public void setAccelerationUphill(double accelerationUphill) {
        this.accelerationUphill = accelerationUphill;
    }

    public int getClimbingGrade() {
        return climbingGrade;
    }

    public void setClimbingGrade(int climbingGrade) {
        this.climbingGrade = climbingGrade;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
