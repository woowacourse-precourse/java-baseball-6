package baseball.domain;

import baseball.common.exception.input.InputException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.common.config.GameConfig.MAX_NUMBER;
import static baseball.common.config.GameConfig.MIN_NUMBER;
import static baseball.common.config.GameConfig.NUMBER_SIZE;
import static baseball.common.exception.input.InputErrorCode.DUPLICATED;
import static baseball.common.exception.input.InputErrorCode.INVALID_DIGIT_RANGE;
import static baseball.common.exception.input.InputErrorCode.INVALID_SIZE;

public class Numbers {
    private final List<Integer> numberList;

    public Numbers(final List<Integer> numberList) {
        checkSize(numberList);
        checkDuplicate(numberList);
        checkDigitRange(numberList);
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    private void checkSize(final List<Integer> numberList) {
        if (numberList.size() != NUMBER_SIZE) {
            throw new InputException(INVALID_SIZE);
        }
    }

    private void checkDuplicate(final List<Integer> numberList) {
        Set<Integer> numberSet = new HashSet<>(numberList);
        if (numberSet.size() != numberList.size()) {
            throw new InputException(DUPLICATED);
        }
    }

    private void checkDigitRange(final List<Integer> numberList) {
        for (int number : numberList) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new InputException(INVALID_DIGIT_RANGE);
            }
        }
    }
}
