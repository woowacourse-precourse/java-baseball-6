package baseball.utils;

public class Validate {
    public static boolean verifyTripleDigit(int number) {
        return String.valueOf(number).length() != 3;
    }

    public static boolean verifyEachDigitDuplicate(int number) {
        boolean[] digitSeen = new boolean[10];

        while (number > 0) {
            int digit = number % 10;
            if (digitSeen[digit]) {
                return false;
            }
            digitSeen[digit] = true;
            number /= 10;
        }
        return true;
    }

    public static boolean verifyEachDigitInRange(int number) {
        while (number > 0) {
            int digit = number % 10;
            if (digit < 1) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
