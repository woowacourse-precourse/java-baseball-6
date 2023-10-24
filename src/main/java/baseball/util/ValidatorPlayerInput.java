package baseball.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidatorPlayerInput {
    private static final int NUMBER_SIZE = 3;

    public static void validateNumberSizeAndDuplicate(List<Integer> baseballNumber) {
        if (baseballNumber.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 야구는 3자리여야 합니다.");
        }

        Set<Integer> uniqueDigits = new HashSet<>(baseballNumber);
        if (uniqueDigits.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 야구는 각 자리가 중복될 수 없습니다.");
        }
    }

    public static void checkResumeInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("시작이나 종료의 입력값이 아닙니다.");
        }
    }
}
