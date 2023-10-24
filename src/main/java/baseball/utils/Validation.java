package baseball.utils;

import java.util.Collections;
import java.util.List;

public class Validation {

    public static final int THREE_DIGITS = 3;
    public static final int MAX_FREQUENCY = 1;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final String RESTART = "1";
    public static final String END = "2";

    private Validation() {
    }

    public static void validateInputNumber(List<Integer> input) {
        if (input.size() != THREE_DIGITS) {
            throw new IllegalArgumentException("3자리의 수를 입력해 주세요.");
        }
        for (Integer number : input) {
            if (Collections.frequency(input, number) > MAX_FREQUENCY) {
                throw new IllegalArgumentException("서로 다른 수를 입력해 주세요.");
            }
            else if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("1부터 9 사이의 정수를 입력해 주세요.");
            }
        }
    }

    public static void validateRestartNumber(String string) {
        if (!string.equals(RESTART) && !string.equals(END)) {
            throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
        }
    }
}
