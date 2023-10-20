package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputChecker {

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
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (Arrays.stream(input.split("")).collect(Collectors.toSet()).size() != 3) {
            throw new IllegalArgumentException();
        }

        for (char c : input.toCharArray()) {
            if (c < 49 || c > 57) throw new IllegalArgumentException();
        }
    }

    public void checkRestartNumber(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }

        int num;
        try {
            num = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (num != 1 && num != 2) {
            throw new IllegalArgumentException();
        }
    }
}
