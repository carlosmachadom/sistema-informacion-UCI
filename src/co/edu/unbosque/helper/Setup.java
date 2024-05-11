package co.edu.unbosque.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Setup {
    public static Matcher compiler(String REGEX, String type) {
        Pattern pattern = Pattern.compile(REGEX);
        return pattern.matcher(type);
    }
}
