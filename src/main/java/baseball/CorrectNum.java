package baseball;

public class CorrectNum {
    public static boolean isNumber(String input) {
        if (input.matches("\\d+")) {
            return true;
        }
        return false;
    }

    public static boolean isThreeSize(String input) {
        if (input.length() == 3) {
            return true;
        }
        return false;
    }

    public static boolean isContainZero(String input) {
        if (input.contains("0")) {
            return true;
        }
        return false;
    }

    public static boolean isContainNum(String input) {
        int num = Integer.parseInt(input);
        int zero = num / 100;
        int one = num % 100 / 10;
        int two = num % 100 % 10;

        if (zero == one) {
            return true;
        }

        if (zero == two) {
            return true;
        }

        if (one == two) {
            return true;
        }
        return false;
    }
}
