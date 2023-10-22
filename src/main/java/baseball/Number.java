package baseball;

import baseball.constant.Constants;
import baseball.constant.Errors;
import java.util.ArrayList;
import java.util.List;

public class Number {

    private final List<Integer> numbers;

    private Number(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Number from(String input) {
        validateNotZero(input);
        validateNumberSize(input);

        List<Integer> numbers = new ArrayList<>();
        for (char num : input.toCharArray()) {
            validateIsNumber(num);
            int number = charToInt(num);
            validateDuplicatedNumber(numbers, number);
            numbers.add(number);
        }
        return new Number(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static int charToInt(char number) {
        return number - '0';
    }

    private static void validateNotZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException(Errors.ERROR_NOT_ZERO);
        }
    }

    private static void validateNumberSize(String input) {
        if (input.length() != Constants.NUMBERS_SIZE) {
            throw new IllegalArgumentException(Errors.ERROR_NUMBER_SIZE);
        }
    }

    private static void validateIsNumber(char input) {
        if (!Character.isDigit(input)) {
            throw new IllegalArgumentException(Errors.ERROR_IS_NUMBER);
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(Errors.ERROR_DUPLICATED_NUMBER);
        }
    }
}
