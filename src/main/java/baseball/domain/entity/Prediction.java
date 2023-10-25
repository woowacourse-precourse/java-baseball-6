package baseball.domain.entity;

import baseball.constants.ErrorConst;

import java.util.List;

public record Prediction(List<Integer> numberList) {

    public Prediction {
        validateIfNull(numberList);
        validateIfOutOfRange(numberList);
        validateIfInvalidLength(numberList);
        validateIfDuplicated(numberList);
    }

    private void validateIfNull(final List<Integer> numberList) {
        if (numberList == null) {
            throw new IllegalArgumentException(ErrorConst.NULL_INPUT.getMessage());
        }
    }

    private void validateIfOutOfRange(final List<Integer> numberList) {
        if (numberList.stream().anyMatch(number -> number < 1 || number > 9)) {
            throw new IllegalArgumentException(ErrorConst.OUT_OF_BOUNDARY.getMessage());
        }
    }

    private void validateIfInvalidLength(final List<Integer> numberList) {
        if (numberList.size() != Answer.ANSWER_LENGTH) {
            throw new IllegalArgumentException(ErrorConst.INVALID_LENGTH.getMessage());
        }
    }

    private void validateIfDuplicated(final List<Integer> numberList) {
        if (numberList.stream().distinct().count() != Answer.ANSWER_LENGTH) {
            throw new IllegalArgumentException(ErrorConst.INVALID_INPUT.getMessage());
        }
    }
}
