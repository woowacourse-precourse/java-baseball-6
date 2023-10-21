package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int MAX_LENGTH = 3;

    public Validator() {
    }

    public void verify(String input) {
        verifyLength(input);
        verifyNumber(input);
        verifyUniqueNumber(input);
    }

    private void verifyUniqueNumber(String input) {
        Set<Character> numbers = new HashSet<>();
        for (char character : input.toCharArray()) {
            numbers.add(character);
        }

        if (numbers.size() != 3) {
            throw new IllegalArgumentException("유니크한 값이 아닙니다.");
        }
    }

    private void verifyNumber(String input) {
        for (char character : input.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException("숫자 형식이 아닙니다.");
            }
        }
    }

    private void verifyLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 길이가 3이 아닙니다.");
        }
    }
}
