package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static void validateUserNumbers(String userNumbers, int numbersLength) {
        validateInputEmptyOrNull(userNumbers);
        validateInputLength(userNumbers, numbersLength);
        validateInputDistinct(userNumbers);
        validateInputDigit(userNumbers);
    }

    public static void validateGameRestartOrNot(String gameRestartOrOver, String gameRestart, String gameOver) {
        validateInputEmptyOrNull(gameRestartOrOver);
        if (!gameRestartOrOver.equals(gameRestart) && !gameRestartOrOver.equals(gameOver)) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 " + gameRestart + " 또는 " + gameOver + " 가 아닙니다.");
        }
    }

    public static void validateInputEmptyOrNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 비어있습니다.");
        }
    }

    public static void validateInputLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException("[ERROR] 입력 값의 길이가 " + length + "(이)가 아닙니다.");
        }
    }

    public static void validateInputDistinct(String input) {
        Set<String> inputStringSet = new HashSet<>(Arrays.asList(input.split("")));
        if (input.length() != inputStringSet.size()) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 중복이 있습니다.");
        }
    }

    public static void validateInputDigit(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("[ERROR] 입력 값이 숫자로만 이루어져 있지 않습니다.");
            }
        }
    }
}
