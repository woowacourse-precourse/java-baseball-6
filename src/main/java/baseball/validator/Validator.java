package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateOverlap(List<Integer> playerNumbers) {
        Set<Integer> noOverlapNumbers = new HashSet<>(playerNumbers);
        if (noOverlapNumbers.size() != playerNumbers.size()) {
            throw new IllegalArgumentException("서로 다른 수를 입력해주세요.");
        }
    }

    public static void validateIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char separatedInput = input.charAt(i);
            boolean isNumber = Character.isDigit(separatedInput);
            if (isNumber == false) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
    }

    public static void validateInputLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException("숫자 " + length + "개를 입력해주세요.");
        }
    }
}
