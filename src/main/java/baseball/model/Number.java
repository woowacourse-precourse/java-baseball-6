package baseball.model;

import baseball.exception.ErrorMessage;
import java.util.List;

public class Number {
    public final int firstNumber;
    public final int secondNumber;
    public final int thirdNumber;

    public Number(List<Integer> digits) {
        firstNumber = digits.get(0);
        secondNumber = digits.get(1);
        thirdNumber = digits.get(2);
    }

    public Number(Integer number) {
        validateInputNumberSize(number);
        List<Integer> digits = getDigits(number);

        firstNumber = digits.get(0);
        secondNumber = digits.get(1);
        thirdNumber = digits.get(2);

    }

    private List<Integer> getDigits(Integer number) {
        int first = validateIsDigit(number / 100);
        int second = validateIsDigit((number % 100) / 10);
        int third = validateIsDigit(number % 10);

        validateInputNumberUnique(first, second, third);

        return List.of(first, second, third);
    }


    private int validateIsDigit(int digit) {
        if (digit < 1 || digit > 9) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIGIT.getMessage());
        }
        return digit;
    }


    private void validateInputNumberUnique(int first, int second, int third) {
        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DIGIT_IS_NOT_UNIQUE.getMessage());
        }
    }

    private void validateInputNumberSize(Integer number) {
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_LENGTH_IS_NOT_THREE.getMessage());
        }

    }

}
