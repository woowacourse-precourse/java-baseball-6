package baseball.model;

import baseball.exception.ErrorMessage;
import java.util.List;

public class Number {
    public final int firstDigit;
    public final int secondDigit;
    public final int thirdDigit;
    public static final int NUMBER_SIZE = 3;

    public Number(List<Integer> digits) {
        firstDigit = digits.get(0);
        secondDigit = digits.get(1);
        thirdDigit = digits.get(2);
    }

    public Number(Integer number) {
        List<Integer> digits = getDigits(number);

        firstDigit = digits.get(0);
        secondDigit = digits.get(1);
        thirdDigit = digits.get(2);

    }

    private List<Integer> getDigits(Integer number) {
        int first = validateIsDigit(number / 100);
        int second = validateIsDigit((number % 100) / 10);
        int third = validateIsDigit(number % 10);

        validateUnique(first, second, third);

        return List.of(first, second, third);
    }


    private int validateIsDigit(int digit) {
        if (digit < 1 || digit > 9) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIGIT.getMessage());
        }
        return digit;
    }


    private void validateUnique(int first, int second, int third) {
        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DIGIT_IS_NOT_UNIQUE.getMessage());
        }
    }


    public boolean contains(Integer number) {
        return firstDigit == number || secondDigit == number || thirdDigit == number;
    }

}
