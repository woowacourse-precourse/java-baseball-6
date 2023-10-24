package baseball.model.service;

import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_DUPLICATED;
import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_LENGTH_INVALID;
import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_NON_NUMBER;
import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_RANGE_INVALID;
import static baseball.model.constants.GameConstants.GAME_NUMBERS_MAX_VALUE;
import static baseball.model.constants.GameConstants.GAME_NUMBERS_MIN_VALUE;
import static baseball.model.constants.GameConstants.GAME_NUMBERS_SIZE;

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

    private void isNumbers(String inputNumbers) {
        inputNumbers.chars().forEach(ch -> {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_NON_NUMBER);
            }
        });
    }

    private void isLength(String inputNumbers) {
        if (inputNumbers.length() != GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_LENGTH_INVALID);
        }
    }

    private void isRange(String inputNumbers) {
        inputNumbers.chars().forEach(ch -> {
            int num = Character.getNumericValue(ch);
            if (num < GAME_NUMBERS_MIN_VALUE || num > GAME_NUMBERS_MAX_VALUE) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_RANGE_INVALID);
            }
        });
    }

    private void isDuplicate(String inputNumbers) {
        Set<Character> numbers = new HashSet<>();
        inputNumbers.chars().forEach(ch -> {
            if (numbers.contains(ch)) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_DUPLICATED);
            }
            numbers.add((char) ch);
        });
    }
}
