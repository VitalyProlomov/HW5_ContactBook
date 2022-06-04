package vitalyprolomov.contactbook;

public class ValidatorUtils {
    static public boolean isDigit(char symbol) {
        String digits = "1234567890";
        int i = 0;
        while (i < digits.length()) {
            if (digits.charAt(i) == symbol) {
                return true;
            }
            ++i;
        }
        return false;
    }
    static public boolean isPersonValid(Person person) throws Exception {
        throw new Exception("TODO");
    }

//    static public boolean isDate(String dateOfBirth) {
//        String[] parameters = dateOfBirth.split("\\.");
//        if (parameters.length != 3) {
//            throw new IllegalArgumentException("date must contain day, month and year, separated by '.'");
//        }
//        if (parameters[0].length() > 2) {
//            throw new IllegalArgumentException("Day is a 2-digit number");
//        }
//        if (parameters[1].length() > 2) {
//            throw new IllegalArgumentException("Illegal month");
//        }
//        if (parameters[2].length() != 4) {
//
//        }
//    }
}
