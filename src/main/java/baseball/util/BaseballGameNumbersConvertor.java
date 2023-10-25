package baseball.util;

import java.util.List;

public class BaseballGameNumbersConvertor {

    public static List<Integer> convertBaseballGameNumbers(String numbersInput, int numberSize) {
        validateInputSize(numbersInput, numberSize);

        List<Integer> numbers = numbersInput.chars()
            .mapToObj(character -> (char) character)
            .map(Character::getNumericValue)
            .toList();

        validateNumericInputs(numbers);
        return numbers;
    }

    private static void validateInputSize(String numbersInput, int numberSize) {
        if (numbersInput.length() != numberSize) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumericInputs(List<Integer> numbers) {
        if (numbers.contains(-1)) {
            throw new IllegalArgumentException();
        }
    }
}
