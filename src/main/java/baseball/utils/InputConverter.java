package baseball.utils;

import baseball.dto.ExitCode;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {

    public static List<Integer> convertToIntegerList(String numbers) {
        validateNumbers(numbers);
        return buildIntegerList(numbers);
    }

    private static List<Integer> buildIntegerList(String numbers) {
        List<Integer> res = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            res.add(Character.getNumericValue(c));
        }
        return res;
    }

    private static void validateNumbers(String numbers) {
        for (char c : numbers.toCharArray()) {
            if (!Character.isDigit(c)) throw new IllegalArgumentException();
        }
    }

    public static ExitCode convertToExitCode(String line) {
        validateNumbers(line);
        return new ExitCode(Integer.parseInt(line));
    }

}
