package baseball;

public class InputValidator {
    public static final int INPUT_LIMIT = 3;

    public static int[] validateAndParseUserInput(String input) {
        isThreeDigitNumber(input);

        areNumbersInRange(input);

        areNumbersDistinct(input);

        return parseUserInput(input);
    }

    private static void isThreeDigitNumber(String input) {
        if (input.length() != INPUT_LIMIT) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요");
        }
    }

    private static void areNumbersInRange(String input) {
        for (int i = 0; i < INPUT_LIMIT; i++) {
            try {
                int number = Integer.parseInt(String.valueOf(input.charAt(i)));

                if (number < 1 || number > 9) {
                    throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요");
                }
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요");
            }
        }
    }

    private static void areNumbersDistinct(String input) {
        for (int i = 0; i < INPUT_LIMIT - 1; i++) {
            for (int j = i + 1; j < INPUT_LIMIT; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력해주세요");
                }
            }
        }
    }

    private static int[] parseUserInput(String input) {
        return input.chars().map(c -> Integer.parseInt(String.valueOf(c))).toArray();
    }
}
