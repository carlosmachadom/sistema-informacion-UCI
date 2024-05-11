package co.edu.unbosque.helper;

import co.edu.unbosque.util.ParserStringError;

import java.util.regex.Matcher;

public class ValidationsCyclist {

    private static Matcher match;

    public static void verifyName(String name) {
        match = Setup.compiler("^[A-Za-z ]+$", name);
        try {
            if (!match.matches()) {
                throw new ParserStringError("Formato no valido");
            }
        } catch (ParserStringError err) {
            err.getMessage();
        }
    }

    public static void verifySpeedMax(int speedMaximum) {
        match = Setup.compiler("^[0-9]*$", String.valueOf(speedMaximum));
        try {
            if (speedMaximum < 0) {
                throw new ParserStringError("Debe ser mayor a 0");
            }

            if (!match.matches()) {
                throw new ParserStringError("Formato no valido");
            }
        } catch (ParserStringError err) {
            err.getMessage();
        }
    }

    public static void verifyClimbingGrade(int climbingGrade) {
        try {
            if (climbingGrade > 360) {
                throw new ParserStringError("Los grados no puede ser mayores a 360");
            }
        } catch (ParserStringError err) {
            err.getMessage();
        }
    }

    public static void verifyAccelerationUphill(double accelerationUphill) {
        match = Setup.compiler("^[0-9]+(\\.[0-9]{1,})?$", String.valueOf(accelerationUphill));
        try {
            if (accelerationUphill < 0) {
                throw new ParserStringError("Debe ser mayor a 0");
            }

            if (!match.matches()) {
                throw new ParserStringError("Formato no valido");
            }
        } catch (ParserStringError err) {
            err.getMessage();
        }
    }
}
