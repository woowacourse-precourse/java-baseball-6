package baseball;

import java.util.HashSet;
import java.util.Set;

public class UserNumberValidator {
    private static final int NUM_DIGIT = 3;

    public static void isDuplicated(String userNumber) {
        Set<Character> checkDuplicated = new HashSet<>();
        for (char c : userNumber.toCharArray()) {
            if (!checkDuplicated.add(c)) {
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
        }
    }

    public static void isRightDigit(String userNumber) {
        if (userNumber.length() != NUM_DIGIT) {
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
    }

    public static void isNaturalNumber(String userNumber) {
        for (char c : userNumber.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
        }
    }
}
