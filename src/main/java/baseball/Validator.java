package baseball;

public class Validator {
    public static boolean isDigitsUnique(String number) {
        int numericValue = Integer.parseInt(number);
        int hundredsPlace = numericValue / 100;
        int tensPlace = (numericValue / 10) % 10;
        int onesPlace = numericValue % 10;

        return hundredsPlace != tensPlace || tensPlace != onesPlace || onesPlace != hundredsPlace;
    }


    public static boolean isNumber(String userNumber) {
        try {
            Integer.parseInt(userNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInRange(String userNumber, int startRange, int endRange) {
        int number = Integer.parseInt(userNumber);
        if (number >= startRange && number <= endRange) {
            return true;
        }
        return false;
    }
}
