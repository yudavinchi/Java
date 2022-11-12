package org.day9.utils;

import java.util.regex.Pattern;

public class Validate {
    public static boolean patternMatches(String fieldToValidate, String regexPattern) {
        return Pattern.compile(regexPattern).matcher(fieldToValidate).matches();
    }

    public static boolean registerFields(String email, String name, String password) {

        if(email == null || name == null || password == null) {
            return false;
        }

        boolean isEmailValid = validateEmail(email);
        boolean isNameValid = validateName(name);
        boolean isPasswordValid = validatePassword(password);

        return isEmailValid && isNameValid && isPasswordValid;
    }

    public static boolean loginFields(String email, String password) {

        if(email == null || password == null) {
            return false;
        }

        boolean isEmailValid = validateEmail(email);
        boolean isPasswordValid = validatePassword(password);

        return isEmailValid && isPasswordValid;
    }


    public static boolean validateEmail(String email) {
        String regexPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (patternMatches(email, regexPattern)) {
            return true;
        }
        return false;
    }

    public static boolean validateName(String name) {
        String regexPattern = "[a-zA-Z]{3,30}";   // only letters. length: 3-30
        if (patternMatches(name, regexPattern)) {
            return true;
        }
        return false;
    }

    public static boolean validatePassword(String password) {
        String regexPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";   // Minimum eight characters, at least one letter and one number:
        if (patternMatches(password, regexPattern)) {
            return true;
        }
        return false;
    }
}
