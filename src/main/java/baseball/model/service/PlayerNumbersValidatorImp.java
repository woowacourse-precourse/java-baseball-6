package baseball.model.service;

import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_DUPLICATED;
import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_LENGTH_INVALID;
import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_NON_NUMBER;
import static baseball.model.constants.ExceptionMessages.PLAYER_NUMBERS_RANGE_INVALID;
import static baseball.model.constants.GameConstants.PLAYER_NUMBERS_MAX_VALUE;
import static baseball.model.constants.GameConstants.PLAYER_NUMBERS_MIN_VALUE;
import static baseball.model.constants.GameConstants.PLAYER_NUMBERS_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumbersValidatorImp implements PlayerNumbersValidator {
    @Override
    public void isNonNumber(String inputNumbers) {
        for (int i = 0; i < inputNumbers.length(); i++) {
            if (!Character.isDigit(inputNumbers.charAt(i))) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_NON_NUMBER);
            }
        }
    }

    @Override
    public void isLengthCorrect(List<Integer> convertNumbers) {
        if (convertNumbers.size() != PLAYER_NUMBERS_SIZE) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_LENGTH_INVALID);
        }
    }

    @Override
    public void isRange(List<Integer> convertNumbers) {
        for (int number : convertNumbers) {
            if (number < PLAYER_NUMBERS_MIN_VALUE || number > PLAYER_NUMBERS_MAX_VALUE) {
                throw new IllegalArgumentException(PLAYER_NUMBERS_RANGE_INVALID);
            }
        }
    }

    @Override
    public void isDuplicate(List<Integer> convertNumbers) {
        Set<Integer> numbers = new HashSet<>(convertNumbers);
        if (numbers.size() != PLAYER_NUMBERS_SIZE) {
            throw new IllegalArgumentException(PLAYER_NUMBERS_DUPLICATED);
        }
    }
}
