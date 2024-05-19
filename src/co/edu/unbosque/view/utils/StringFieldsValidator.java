package co.edu.unbosque.view.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFieldsValidator {	
	 // Expresiones regulares para validar nombres y correos electrónicos
    private static final String NAME_REGEX = "^[\\p{L} .'-]+$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|edu|org|net|gov|co)$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}$";

    // Compilar las expresiones regulares en patrones
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    // Método para validar nombres y apellidos
    public static boolean isValidName(String name) {
        if (!isValidEmail(name)) {
            return false;
        }
        
        Matcher matcher = NAME_PATTERN.matcher(name);
        
        return matcher.matches();
    }

    // Método para validar correos electrónicos
    public static boolean isValidEmail(String email) {
    	boolean response = true;
    	boolean validString = isValidString(email);
        
    	if (validString){
    		Matcher matcher = EMAIL_PATTERN.matcher(email);
    		
    		if (matcher.matches()) {
    			response = true;
    		} else {
    			response = false;
    		}            
    		
        } else {
        	response = false;
        }        
        
        return response;
    }
    
    // Método para validar correos electrónicos
    public static boolean isValidPassword(String password) {
    	boolean response = true;
    	boolean validString = isValidString(password);
    	
    	if (validString){
    		Matcher matcher = PASSWORD_PATTERN.matcher(password);
    		
    		if (matcher.matches()) {
    			response = true;
    		} else {
    			response = false;
    		}            
    		
    	} else {
    		response = false;
    	}        
    	
    	return response;
    }
    
    public static boolean isValidString(String str){
		boolean response = true;
		
	    if (str == null || str.isEmpty()) {
	    	response = false;
	    }
	    
	    return response;
	}
}
