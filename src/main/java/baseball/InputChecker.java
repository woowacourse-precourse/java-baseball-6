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

    private static InputChecker inputChecker;

    private InputChecker() {
    }

    private static InputChecker getInstance() {
        if (inputChecker == null) {
            inputChecker = new InputChecker();
        }
        return inputChecker;
    }

    public static List<Integer> checkAndMakeList(String input) {
        getInstance().checkMyNumber(input);
        return Arrays.stream(input.split("")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static int checkAndMakeNumber(String input) {
        getInstance().checkRestartNumber(input);
        return Integer.valueOf(input);
    }

    public void checkMyNumber(String input) {
        if (input.length() != MY_NUMBER_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (Arrays.stream(input.split("")).collect(Collectors.toSet()).size() != 3) {
            throw new IllegalArgumentException();
        }

        for (char c : input.toCharArray()) {
            if (c < ASCII_CODE_ONE || c > ASCII_CODE_NINE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkRestartNumber(String input) {
        if (input.length() != RESTART_OR_END_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }

        int num;
        try {
            num = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (num != RESTART_NUMBER && num != END_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
