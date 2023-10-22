package baseball.model.service;

import static baseball.model.constants.Constant.NUMBER_MAX_VALUE;
import static baseball.model.constants.Constant.NUMBER_MIN_VALUE;
import static baseball.model.constants.Constant.NUMBER_SIZE;
import static baseball.model.constants.ExceptionMessage.PLAYER_LENGTH_IS_WRONG;
import static baseball.model.constants.ExceptionMessage.PLAYER_NOT_NUMBER;
import static baseball.model.constants.ExceptionMessage.PLAYER_NUMBER_DUPLICATED;
import static baseball.model.constants.ExceptionMessage.PLAYER_RANGE_IS_WRONG;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumberImpl implements PlayerNumber {
    @Override
    public void isNonNumber(String inputNumbers) {
        for (int i = 0; i < inputNumbers.length(); i++) {
            if (!Character.isDigit(inputNumbers.charAt(i))) {
                throw new IllegalArgumentException(PLAYER_NOT_NUMBER);
            }
        }
    }

    @Override
    public void isLengthCorrect(List<Integer> convertNumbers) {
        if (convertNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(PLAYER_LENGTH_IS_WRONG);
        }
    }

    @Override
    public void isRange(List<Integer> convertNumbers) {
        for (int number : convertNumbers) {
            if (number < NUMBER_MIN_VALUE || number > NUMBER_MAX_VALUE) {
                throw new IllegalArgumentException(PLAYER_RANGE_IS_WRONG);
            }
        }
    }

    @Override
    public void isDuplicate(List<Integer> convertNumbers) {
        Set<Integer> numbers = new HashSet<>(convertNumbers);
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(PLAYER_NUMBER_DUPLICATED);
        }
    }
}
