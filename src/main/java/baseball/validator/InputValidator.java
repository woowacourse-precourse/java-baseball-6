package baseball.validator;

public class InputValidator {
    public static void validatePlayNumber(String input) {
        if (!isInteger(input) || !isThreeDigit(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    public static void validateGameContinue(String input) {
        if (!isInteger(input) || !isOneOrTwo(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private static boolean isInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력값입니다.");
        }
        return false;
    }

    private static boolean isThreeDigit(String input) {
        int number = Integer.parseInt(input);
        return number >= 100 && number <= 999;
    }

    private static boolean isOneOrTwo(String input) {
        int number = Integer.parseInt(input);
        return number == 1 || number == 2;
    }
}
