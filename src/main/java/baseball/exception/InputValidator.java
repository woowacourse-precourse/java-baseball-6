package baseball.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public InputValidator() {

    }

    public boolean isNumeric(String input) {
        for(char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidLength(List<Integer> numbers, int length) {
        return numbers.size() == length;
    }

    public boolean isUniqueDigits(List<Integer> numbers) {
        Set<Integer> deduplicatedNumbers = new HashSet<>(numbers);

        return deduplicatedNumbers.size() == numbers.size();
    }
}
