package baseball.model.service;

import static baseball.model.constants.Exception.PLAYER_NUMBERS_DUPLICATED;
import static baseball.model.constants.Exception.PLAYER_NUMBERS_LENGTH_INVALID;
import static baseball.model.constants.Exception.PLAYER_NUMBERS_NON_NUMBER;
import static baseball.model.constants.Exception.PLAYER_NUMBERS_RANGE_INVALID;
import static baseball.model.constants.Rule.GAME_NUMBERS_MAX_VALUE;
import static baseball.model.constants.Rule.GAME_NUMBERS_MIN_VALUE;
import static baseball.model.constants.Rule.GAME_NUMBERS_SIZE;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumbersValidatorImp implements PlayerNumbersValidator {
    @Override
    public void validatePlayerNumbers(String inputNumbers) {
        isNumbers(inputNumbers);
        isLength(inputNumbers);
        isRange(inputNumbers);
        isDuplicate(inputNumbers);
    }

    private static void isNumbers(String inputNumbers) {
        inputNumbers.chars().forEach(ch -> {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_NON_NUMBER.getMessage());
            }
        });
    }

    private static void isLength(String inputNumbers) {
        if (inputNumbers.length() != GAME_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_LENGTH_INVALID.getMessage());
        }
    }

    private static void isRange(String inputNumbers) {
        inputNumbers.chars().forEach(ch -> {
            int num = Character.getNumericValue(ch);
            if (num < GAME_NUMBERS_MIN_VALUE.getValue() || num > GAME_NUMBERS_MAX_VALUE.getValue()) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_RANGE_INVALID.getMessage());
            }
        });
    }

    private static void isDuplicate(String inputNumbers) {
        Set<Character> numbers = new HashSet<>();
        inputNumbers.chars().forEach(ch -> {
            if (numbers.contains(ch)) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_DUPLICATED.getMessage());
            }
            numbers.add((char) ch);
        });
    }
}
