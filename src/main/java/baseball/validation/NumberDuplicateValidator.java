package baseball.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberDuplicateValidator {

    private NumberDuplicateValidator() {
    }

    public static void validate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            numberSet.add(number);
        }
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    public static void validate(String input) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            characterSet.add(c);
        }
        if (characterSet.size() != input.length()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE.getMessage());
        }
    }
}
