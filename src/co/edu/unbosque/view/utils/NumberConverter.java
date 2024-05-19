package co.edu.unbosque.view.utils;

public class NumberConverter {
	public static int convertToInt(String str) throws NumberFormatException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Failed to convert to int: " + e.getMessage());
        }
    }

    public static long convertToLong(String str) throws NumberFormatException {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Failed to convert to long: " + e.getMessage());
        }
    }

    public static float convertToFloat(String str) throws NumberFormatException {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Failed to convert to float: " + e.getMessage());
        }
    }

    public static double convertToDouble(String str) throws NumberFormatException {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Failed to convert to double: " + e.getMessage());
        }
    }
}
