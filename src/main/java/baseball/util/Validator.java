package baseball.util;

public class Validator {
    private static final int MAX_SIZE = 3;
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public static void validateInputNumbers(String numbers) {
        validateNumbersLength(numbers);
        validateNumbersType(numbers);
        validateNumbersRange(numbers);
        validateNoDuplicate(numbers);
    }

    public static void validateNumbersLength(String numbers) {
        if (numbers.length() != MAX_SIZE) {
            throw new IllegalArgumentException("입력 값은 3자리 숫자여야 합니다.");
        }
    }

    public static void validateNumbersType(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 숫자여야 합니다.");
        }
    }

    public static void validateNumbersRange(String numbers) {
        if (!hasValidNumberRange(numbers)) {
            throw new IllegalArgumentException("모든 자릿수는 1이상 9이하여야 합니다.");
        }
    }

    public static boolean hasValidNumberRange(String numbers) {
        return numbers.chars().allMatch(number -> number >= '1' && number <= '9');
    }

    public static void validateNoDuplicate(String numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("모든 자릿수는 서로 중복될 수 없습니다.");
        }
    }

    public static boolean hasDuplicateNumber(String numbers) {
        return numbers.chars().distinct().count() < numbers.length();
    }

    public static void validateRestartOrExitNumber(String number) {
        validateRestartOrExitNumberType(number);
        validateRestartOrExitNumberValue(number);
    }

    public static void validateRestartOrExitNumberType(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 숫자여야 합니다.");
        }
    }

    public static void validateRestartOrExitNumberValue(String number) {
        if (!isRestartOrExitNumber(number)) {
            throw new IllegalArgumentException("입력 값은 1 (재시작) 또는 2 (종료) 여야 합니다.");
        }
    }

    public static boolean isRestartOrExitNumber(String number) {
        return number.equals(RESTART) || number.equals(EXIT);
    }
}
