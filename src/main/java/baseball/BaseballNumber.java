package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumber {

    private static final int NUMBER_COUNTER = 3;
    private static final char MIN_DIGIT ='1';
    private static final char MAX_DIGIT ='9';

    private final List<Integer> numbers;

    public BaseballNumber(String input) {
        validate(input);
        this.numbers = List.copyOf(convertToNumbers(input));
    }

    private void validate(String input) {
        validateLength(input);
        validateDigits(input);
        validateDuplicate(input);
    }

    private void validateLength(String input) {
        if (input.length() != NUMBER_COUNTER) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다.");
        }
    }

    private void validateDigits(String input) {
        for (char digit : input.toCharArray()) {
            if (digit <MIN_DIGIT || digit > MAX_DIGIT) {
                throw new IllegalArgumentException(
                        "1부터 9까지의 숫자만 입력할 수 있습니다.");
            }
        }
    }

    private void validateDuplicate(String input) {
        HashSet<Character> uniqueDigits = new HashSet<>();

        for (char digit : input.toCharArray()) {
            if (!uniqueDigits.add(digit)) {
                throw new IllegalArgumentException(
                        "숫자는 중복될 수 없습니다.");
            }
        }
    }

    private List<Integer> convertToNumbers(String input) {
        List<Integer> convertedNumbers = new ArrayList<>();

        for (char digit : input.toCharArray()) {
            convertedNumbers.add(digit - 0);
        }

        return convertedNumbers;
    }
}
