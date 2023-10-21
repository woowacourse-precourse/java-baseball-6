package baseball.domain;

import static baseball.constant.Constant.BASEBALL_GAME_NUMBER_DIGIT;
import static baseball.constant.Constant.END_INCLUSIVE;
import static baseball.constant.Constant.START_INCLUSIVE;

import baseball.exception.guess_number.NotEqualsGameNumberDigitsException;
import baseball.exception.guess_number.NotMatchGameNumberFormatException;
import baseball.exception.guess_number.NotUniqueNumberException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuessNumber {

    private List<Integer> guessNumbers;

    public void changeGuessNumbers(final List<Integer> guessNumbers) {
        validateGameNumberDigit(guessNumbers);
        validateUniqueNumber(guessNumbers);
        validateNumberRangeCondition(guessNumbers);
        getList().addAll(guessNumbers);
    }

    private void validateGameNumberDigit(final List<Integer> guessNumbers) {
        if (!isGameNumberDigit(guessNumbers)) {
            throw new NotEqualsGameNumberDigitsException(guessNumbers.size());
        }
    }

    private static boolean isGameNumberDigit(final List<Integer> guessNumbers) {
        return guessNumbers.size() == BASEBALL_GAME_NUMBER_DIGIT;
    }

    private void validateUniqueNumber(final List<Integer> guessNumbers) {
        if (!isUniqueNumber(guessNumbers)) {
            throw new NotUniqueNumberException(guessNumbers);
        }
    }

    private static boolean isUniqueNumber(final List<Integer> guessNumbers) {
        return guessNumbers.stream()
                .distinct()
                .count() == BASEBALL_GAME_NUMBER_DIGIT;
    }

    private void validateNumberRangeCondition(final List<Integer> guessNumbers) {
        guessNumbers.stream()
                .filter(guessNumber -> !isGameNumberFormat(guessNumber))
                .findAny()
                .ifPresent(invalidNumber -> {
                    throw new NotMatchGameNumberFormatException(invalidNumber);
                });
    }

    private boolean isGameNumberFormat(final int guessNumber) {
        return guessNumber >= START_INCLUSIVE && guessNumber <= END_INCLUSIVE;
    }

    private List<Integer> getList() {
        if (guessNumbers == null) {
            guessNumbers = new ArrayList<>();
            return guessNumbers;
        }
        guessNumbers.clear();
        return guessNumbers;
    }

    public List<Integer> getGuessNumbers() {
        return Collections.unmodifiableList(guessNumbers);
    }
}
