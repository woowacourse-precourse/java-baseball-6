package baseball;

import baseball.constant.Constants;
import baseball.constant.Errors;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumbers;

    private Player(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public static Player from(String input) {
        validateNotZero(input);
        validateNumberSize(input);

        List<Integer> numbers = new ArrayList<>();
        for (char num : input.toCharArray()) {
            validateIsNumber(num);
            int number = num - '0';
            validateDuplicatedNumber(numbers, number);
            numbers.add(number);
        }
        return new Player(numbers);
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
