package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }

        Set<Character> digits = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("입력은 1-9 사이여야 합니다.");
            }
            if (digits.contains(c)) {
                throw new IllegalArgumentException("입력에 중복된 숫자가 있습니다.");
            }
            digits.add(c);
        }
    }
}