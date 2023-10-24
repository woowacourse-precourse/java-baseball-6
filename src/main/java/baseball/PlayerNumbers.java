package baseball;

import static baseball.utils.Constants.COUNTS;
import static baseball.utils.Constants.MAXIMUM_NUMBER;
import static baseball.utils.Constants.MINIMUM_NUMBER;
import static baseball.utils.ErrorMessage.INPUT_DUPLICATION_ERROR_MESSAGE;
import static baseball.utils.ErrorMessage.INPUT_LENGTH_INVALID_ERROR_MESSAGE;
import static baseball.utils.ErrorMessage.INPUT_NOT_INTEGER_ERROR_MESSAGE;
import static baseball.utils.ErrorMessage.INPUT_OUT_OF_RANGE_ERROR_MESSAGE;
import static baseball.utils.Util.convertToIntegerList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumbers {
    private List<Integer> playerNumbers;

    public PlayerNumbers(String playerInput) {
        validateIntType(playerInput);
        this.playerNumbers = convertToIntegerList(playerInput);
        validatePlayerNumbers();
    }

    private void validateIntType(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    private void validatePlayerNumbers() {
        validateCount();
        validateRange();
        validateDuplicates();
    }

    private void validateCount() {
        if (playerNumbers.size() != COUNTS) {
            throw new IllegalArgumentException(INPUT_LENGTH_INVALID_ERROR_MESSAGE);
        }
    }

    private void validateRange() {
        boolean isInvalid = playerNumbers.stream()
                .anyMatch(number -> number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER);
        if (isInvalid) {
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicates() {
        Set<Integer> numberSet = new HashSet<>();
        for (int number : playerNumbers) {
            checkAndAddNumber(numberSet, number);
        }
    }

    private void checkAndAddNumber(Set<Integer> numberSet, int number) {
        if (numberSet.contains(number)) {
            throw new IllegalArgumentException(INPUT_DUPLICATION_ERROR_MESSAGE);
        }
        numberSet.add(number);
    }

    public int checkStrikeCount(Computer computer) {
        return computer.checkStrikeCount(playerNumbers);
    }

    public int checkBallCount(Computer computer) {
        return computer.checkBallCount(playerNumbers);
    }
}