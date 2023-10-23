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
        for (int i = 0; i < inputNumbers.length(); i++) {
            if (!Character.isDigit(inputNumbers.charAt(i))) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_NON_NUMBER);
            }
        }
    }

    private void isLength(String inputNumbers) {
        if (inputNumbers.length() != GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_LENGTH_INVALID);
        }
    }

    private void isRange(String inputNumbers) {
        for (int i = 0; i < inputNumbers.length(); i++) {
            int num = Character.getNumericValue(inputNumbers.charAt(i));
            if (num < GAME_NUMBERS_MIN_VALUE || num > GAME_NUMBERS_MAX_VALUE) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_RANGE_INVALID);
            }
        }
    }

    private void isDuplicate(String inputNumbers) {
        Set<Character> numbers = new HashSet<>();
        for (int i = 0; i < inputNumbers.length(); i++) {
            char ch = inputNumbers.charAt(i);
            if (numbers.contains(ch)) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_DUPLICATED);
            }
            numbers.add(ch);
        }
    }
}
