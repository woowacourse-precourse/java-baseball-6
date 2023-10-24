package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateAnswer(String input, int inputSize) {
        validateAnswerLength(input, inputSize);
        validateAnswerNumeric(input);
        validateAnswerNotDuplicate(input);
    }

    private static void validateAnswerLength(String input, int inputSize) {
        if (input.length() != inputSize) {
            throw new IllegalArgumentException("입력 값의 크기가 맞지 않습니다.");
        }
    }

    private static void validateAnswerNumeric(String input) {
        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("유효한 숫자 범위가 아닙니다.");
            }
        }
    }

    private static void validateAnswerNotDuplicate(String input) {
        Set<Character> set = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (set.contains(ch)) {
                throw new IllegalArgumentException("숫자가 중복되었습니다.");
            }

            set.add(ch);
        }
    }

    public static void validateNextRound(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("입력 값은 1 또는 2이어야 합니다.");
        }
    }
}
