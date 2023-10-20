package baseball.validation;

public class GameValidator {

    private GameValidator() {
    }

    public static void validateIsNumber(String input) {

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public static void validateIsThreeNumbers(String[] input) {

        if (input.length != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리 숫자만 입력 가능합니다.");
        }
    }

    public static void validateIsOneOrTwo(int input) {

        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2만 입력 가능합니다.");
        }
    }
}
