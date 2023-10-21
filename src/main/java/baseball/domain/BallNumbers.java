package baseball.domain;

import java.util.List;

import static baseball.util.MessageConst.*;
import static baseball.util.NumberConst.*;

public class BallNumbers {
    private final List<Integer> numberList;

    public BallNumbers(List<Integer> numberList) {
        validateNumberRange(numberList);
        validateNumberSize(numberList);
        validateDuplicateNumber(numberList);
        this.numberList = numberList;
    }

    public static BallNumbers from(List<Integer> numberList) {
        return new BallNumbers(numberList);
    }

    private void validateNumberSize(List<Integer> numberList) {
        if (numberList.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_EXCEPTION);
        }
    }

    private void validateDuplicateNumber(List<Integer> numberList) {
        if (numberList.stream()
                .distinct()
                .count() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    private void validateNumberRange(List<Integer> numberList) {
        for (Integer num : numberList) {
            if (num < START_INCLUSIVE || num > END_INCLUSIVE) {
                throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
            }
        }
    }
}
