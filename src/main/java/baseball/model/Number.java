package baseball.model;

import java.util.List;

public class Number {
    public final int firstNumber;
    public final int secondNumber;
    public final int thirdNumber;

    private final String INPUT_LENGTH_IS_NOT_THREE = "3자리 수를 입력해야 합니다.";
    private final String INPUT_DIGIT_IS_NUIQUE = "3자리의 수는 모두 달라야 합니다.";

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
            throw new IllegalArgumentException("1 이상 9 이하의 숫자가 아닙니다.");
        }
        return digit;
    }


    private void validateInputNumberUnique(int first, int second, int third) {
        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException(INPUT_DIGIT_IS_NUIQUE);
        }
    }

    private void validateInputNumberSize(Integer number) {
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException(INPUT_LENGTH_IS_NOT_THREE);
        }

    }

}
