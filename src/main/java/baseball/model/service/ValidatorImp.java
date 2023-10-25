package baseball.model.service;

import static baseball.model.constants.Error.NUMBER_DUPLICATED;
import static baseball.model.constants.Error.NUMBER_LENGTH_INVALID;
import static baseball.model.constants.Error.NUMBER_NUMERIC;
import static baseball.model.constants.Error.NUMBER_RANGE_INVALID;
import static baseball.model.constants.Error.OPTION_INVALID;
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
        validateIfNumeric(inputNumbers);
        validateLength(inputNumbers);
        validateRange(inputNumbers);
        validateDuplicates(inputNumbers);
    }

    @Override
    public void validateRestartOption(String inputOption) {
        validateIfNumeric(inputOption);
        validateOption(inputOption);
    }

    private static void validateIfNumeric(String input) {
        input.chars().forEach(ch -> {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(NUMBER_NUMERIC.getMessage());
            }
        });
    }

    private static void validateLength(String input) {
        if (input.length() != GAME_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(NUMBER_LENGTH_INVALID.getMessage());
        }
    }

    private static void validateRange(String input) {
        input.chars().forEach(ch -> {
            int num = Character.getNumericValue(ch);
            if (num < GAME_NUMBERS_MIN_VALUE.getValue() || num > GAME_NUMBERS_MAX_VALUE.getValue()) {
                throw new IllegalArgumentException(NUMBER_RANGE_INVALID.getMessage());
            }
        });
    }

    private static void validateDuplicates(String input) {
        Set<Integer> numbers = new HashSet<>();
        input.chars().forEach(num -> {
            if (numbers.contains(num)) {
                throw new IllegalArgumentException(NUMBER_DUPLICATED.getMessage());
            }
            numbers.add(num);
        });
    }

    private static void validateOption(String input) {
        int optionValue = Integer.parseInt(input);
        if (optionValue != RESTART_OPTION.getValue() && optionValue != QUIT_OPTION.getValue()) {
            throw new IllegalArgumentException(OPTION_INVALID.getMessage());
        }
    }
}
