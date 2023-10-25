package baseball.model.service;

import static baseball.model.constants.Exception.NUMBER_DUPLICATED;
import static baseball.model.constants.Exception.NUMBER_LENGTH_INVALID;
import static baseball.model.constants.Exception.NUMBER_NON_NUMBER;
import static baseball.model.constants.Exception.NUMBER_RANGE_INVALID;
import static baseball.model.constants.Exception.OPTION_INVALID;
import static baseball.model.constants.Rule.GAME_NUMBERS_MAX_VALUE;
import static baseball.model.constants.Rule.GAME_NUMBERS_MIN_VALUE;
import static baseball.model.constants.Rule.GAME_NUMBERS_SIZE;
import static baseball.model.constants.Rule.QUIT_OPTION;
import static baseball.model.constants.Rule.RESTART_OPTION;

import java.util.HashSet;
import java.util.Set;

public class ValidatorImp implements Validator {
    @Override
    public void validatePlayerNumbers(String inputNumbers) {
        isNumber(inputNumbers);
        isLength(inputNumbers);
        isRange(inputNumbers);
        isDuplicate(inputNumbers);
    }

    @Override
    public void validateRestartOption(String inputOption) {
        isNumber(inputOption);
        isOption(inputOption);
    }

    private static void isNumber(String input) {
        input.chars().forEach(ch -> {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(NUMBER_NON_NUMBER.getMessage());
            }
        });
    }

    private static void isLength(String input) {
        if (input.length() != GAME_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(NUMBER_LENGTH_INVALID.getMessage());
        }
    }

    private static void isRange(String input) {
        input.chars().forEach(ch -> {
            int num = Character.getNumericValue(ch);
            if (num < GAME_NUMBERS_MIN_VALUE.getValue() || num > GAME_NUMBERS_MAX_VALUE.getValue()) {
                throw new IllegalArgumentException(NUMBER_RANGE_INVALID.getMessage());
            }
        });
    }

    private static void isDuplicate(String input) {
        Set<Integer> numbers = new HashSet<>();
        input.chars().forEach(num -> {
            if (numbers.contains(num)) {
                throw new IllegalArgumentException(NUMBER_DUPLICATED.getMessage());
            }
            numbers.add(num);
        });
    }

    private static void isOption(String input) {
        int optionValue = Integer.parseInt(input);
        if (optionValue != RESTART_OPTION.getValue() && optionValue != QUIT_OPTION.getValue()) {
            throw new IllegalArgumentException(OPTION_INVALID.getMessage());
        }
    }
}
