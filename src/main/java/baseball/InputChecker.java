package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constant.END_NUMBER;
import static baseball.Constant.MY_NUMBER_INPUT_LENGTH;
import static baseball.Constant.RESTART_NUMBER;
import static baseball.Constant.RESTART_OR_END_INPUT_LENGTH;

public class InputChecker {

    private static final int ASCII_CODE_ONE = 49;
    private static final int ASCII_CODE_NINE = 57;

    private InputChecker() {
    }

    public static void checkMyNumber(String input) {
        if (input.length() != MY_NUMBER_INPUT_LENGTH) {
            throw new IllegalArgumentException("3개의 다른 수를 입력하세요.");
        }

        if (Arrays.stream(input.split("")).collect(Collectors.toSet()).size() != MY_NUMBER_INPUT_LENGTH) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        for (char c : input.toCharArray()) {
            if (c < ASCII_CODE_ONE || c > ASCII_CODE_NINE) {
                throw new IllegalArgumentException("1부터 9사이의 숫자를 입력해주세요.");
            }
        }
    }

    public static void checkRestartNumber(String input) {
        if (input.length() != RESTART_OR_END_INPUT_LENGTH) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }

        int num;
        try {
            num = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (num != RESTART_NUMBER && num != END_NUMBER) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
