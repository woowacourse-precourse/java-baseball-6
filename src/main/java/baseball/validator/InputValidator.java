package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public void checkInputNumber(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("입력 값이 3자리가 아닙니다.");
        }

        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("입력 값이 1 ~ 9 사이의 값이 아닙니다.");
            }
        }

        if (hasDuplicateNumbers(input)) {
            throw new IllegalArgumentException("입력 값에 중복된 숫자가 있으면 안 됩니다.");
        }
    }

    public void checkRestartInput(String input) {
        if (!("1".equals(input) || "2".equals(input))) {
            throw new IllegalArgumentException("1 또는 2 만 입력할 수 있습니다.");
        }
    }

    private boolean hasDuplicateNumbers(String input) {
        Set<Character> numberSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!numberSet.add(ch)) {
                return true;
            }
        }
        return false;
    }

}
