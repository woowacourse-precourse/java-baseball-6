package baseball.service;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    public void validateInputNumber(String number) {
        isThreeDigits(number);
        isOneToNine(number);
        isDifferentDigits(number);
    }

    private void isThreeDigits(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException("입력값은 세 자리 수여야 합니다.");
        }
    }

    private void isOneToNine(String number) {
        boolean isValid = true;

        for (int i = 0; i < 3; i++) {
            char digit = number.charAt(i);
            if (digit < '1' || digit > '9') {
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("입력값은 1부터 9까지의 수로 이루어진 값이어야 합니다.");
        }
    }

    private void isDifferentDigits(String numbers) {
        Set<Character> numberHashSet = new HashSet<>();

        for (char number : numbers.toCharArray()) {
            if (!numberHashSet.add(number)) {
                throw new IllegalArgumentException("입력값은 서로 다른 수로 이루어진 값이어야 합니다.");
            }
        }
    }

    public void validateOneOrTwo(String number) {
        if (!(number.equals("1") || number.equals("2"))) {
            throw new IllegalArgumentException("입력값은 1 또는 2여야 합니다.");
        }
    }
}
