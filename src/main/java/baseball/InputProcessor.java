package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {
    public static void validateRestartInput(String restartInput) {
        if (!(restartInput.equals("1") || restartInput.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePitchInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (input.matches(".*[^1-9].*")) {
            throw new IllegalArgumentException();
        }

        if (!input.matches("^(?!.*(.).*\\1)[1-9]+$")) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> parsePitchInput(String input) {
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            result.add(input.charAt(index) - '0');
        }
        return result;
    }
}
