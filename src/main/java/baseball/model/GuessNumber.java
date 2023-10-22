package baseball.model;

import static baseball.util.Constant.BASEBALL_GAME_NUMBER_DIGIT;
import static baseball.util.Constant.END_INCLUSIVE;
import static baseball.util.Constant.START_INCLUSIVE;

import baseball.exception.guess_number.NotEqualsGameNumberDigitsException;
import baseball.exception.guess_number.NotMatchGameNumberRangeConditionException;
import baseball.exception.guess_number.NotUniqueNumberException;
import java.util.Collections;
import java.util.List;

public class GuessNumber {

    private final List<Integer> guessNumbers;

    public GuessNumber(final List<Integer> guessNumbers) {
        validateGameNumberDigit(guessNumbers);
        validateUniqueNumber(guessNumbers);
        validateNumberRangeCondition(guessNumbers);
        this.guessNumbers = guessNumbers;
    }

    private void validateGameNumberDigit(final List<Integer> guessNumbers) {
        if (!isGameNumberDigit(guessNumbers)) {
            throw new NotEqualsGameNumberDigitsException(guessNumbers.size());
        }
    }

    private static boolean isGameNumberDigit(final List<Integer> guessNumbers) {
        return guessNumbers.size() == BASEBALL_GAME_NUMBER_DIGIT.getValue();
    }

    private void validateUniqueNumber(final List<Integer> guessNumbers) {
        if (!isUniqueNumber(guessNumbers)) {
            throw new NotUniqueNumberException(guessNumbers);
        }
    }

    private static boolean isUniqueNumber(final List<Integer> guessNumbers) {
        return guessNumbers.stream()
                .distinct()
                .count() == BASEBALL_GAME_NUMBER_DIGIT.getValue();
    }

    private void validateNumberRangeCondition(final List<Integer> guessNumbers) {
        guessNumbers.stream()
                .filter(guessNumber -> !isGameNumberRangeCondition(guessNumber))
                .findAny()
                .ifPresent(invalidNumber -> {
                    throw new NotMatchGameNumberRangeConditionException(invalidNumber);
                });
    }

    private boolean isGameNumberRangeCondition(final int guessNumber) {
        return START_INCLUSIVE.getValue() <= guessNumber && guessNumber <= END_INCLUSIVE.getValue();
    }

    public List<Integer> getGuessNumbers() {
        return Collections.unmodifiableList(guessNumbers);
    }
}
