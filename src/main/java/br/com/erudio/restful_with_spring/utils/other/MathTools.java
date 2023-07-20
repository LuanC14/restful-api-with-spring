package br.com.erudio.restful_with_spring.utils;

public class Utils {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replace(",", ".");

        if (isNumeric(number)) {
            return Double.parseDouble((number));
        }

        return 0D;
    }

    public static boolean isNumeric(String strNumber) {

        try {
            Integer.parseInt(strNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
