package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public static List<Integer> validateAndGet(String input) {
        if (input.length() != Number.MAX_DIGITS) {
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }
}
