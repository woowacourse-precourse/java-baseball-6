package baseball.utils;

import java.util.Collections;
import java.util.List;

public class Validation {
    private Validation() {
    }

    public static void validateNumber(List<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해 주세요.");
        }
        for (Integer number : input) {
            if (Collections.frequency(input, number) != 1) {
                throw new IllegalArgumentException("서로 다른 수를 입력해 주세요.");
            }
            else if (number < 1 || number > 9) {
                throw new IllegalArgumentException("1부터 9 사이의 값을 입력해 주세요.");
            }
        }
    }

    public static void validateRestart(String string) {
        if (!string.equals("1") && !string.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
        }
    }
}
