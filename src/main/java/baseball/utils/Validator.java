package baseball.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateUserNumbers(String userNumbers, int numbersLength) {
        validateStringEmptyOrNull(userNumbers);
        validateStringLength(userNumbers, numbersLength);
        validateStringDistinct(userNumbers);
        validateStringDigit(userNumbers);
    }

    public static void validateGameRestartOrNot(String gameRestartOrNot, String gameRestart, String gameOver) {
        validateStringEmptyOrNull(gameRestartOrNot);
        if (!gameRestartOrNot.equals(gameRestart) && !gameRestartOrNot.equals(gameOver)) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 " + gameRestart + " 또는 " + gameOver + " 가 아닙니다.");
        }
    }

    public static void validateStringEmptyOrNull(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 비어있습니다.");
        }
    }

    public static void validateStringLength(String string, int length) {
        if (string.length() != length) {
            throw new IllegalArgumentException("[ERROR] 입력 값의 길이가 " + length + "(이)가 아닙니다.");
        }
    }

    public static void validateStringDistinct(String string) {
        Set<String> inputStringSet = new HashSet<>(Arrays.asList(string.split("")));
        if (string.length() != inputStringSet.size()) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 중복이 있습니다.");
        }
    }

    public static void validateStringDigit(String string) {
        for (char ch : string.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("[ERROR] 입력 값이 숫자로만 이루어져 있지 않습니다.");
            }
        }
    }
}
