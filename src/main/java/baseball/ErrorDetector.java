package baseball;

public class ErrorDetector {

    public static void throwIfNumberIsWrong(String number) {
        throwIfInputIsString(number);
        if (number.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void throwIfOptionIsWrong(String option) {
        throwIfInputIsString(option);
        if (!option.equals("1") && !option.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    public static void throwIfInputIsString(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
