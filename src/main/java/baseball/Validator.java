package baseball;

public class Validator {
    public static boolean isUniqueDigits(int number){
        int hundredDigit = number /100;
        int tenDigit = (number / 10) % 10;
        int oneDigit = number % 10;

        return hundredDigit != tenDigit || tenDigit != oneDigit || oneDigit != hundredDigit;
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
