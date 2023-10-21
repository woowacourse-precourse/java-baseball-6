package baseball.domain;

import baseball.constant.BallConstant;
import baseball.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    private final List<Integer> elements;

    public Numbers(List<Integer> elements) {
        validateElements(elements);
        this.elements = new ArrayList<>(elements);
    }

    private void validateElements(List<Integer> elements) {
        validateLength(elements);
        validateDuplicate(elements);
        validateRange(elements);
    }

    private void validateLength(List<Integer> elements) {
        if (elements.size() != BallConstant.BALL_LENGTH.getValue()) {
            ExceptionMessage message = ExceptionMessage.INVALID_LENGTH;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> elements) {
        Set<Integer> notDuplicateElements = new HashSet<>(elements);
        if (notDuplicateElements.size() != BallConstant.BALL_LENGTH.getValue()) {
            ExceptionMessage message = ExceptionMessage.DUPLICATE_NUMBER;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private void validateRange(List<Integer> elements) {
        int max = BallConstant.MAX_NUMBER.getValue();
        int min = BallConstant.MIN_NUMBER.getValue();
        for (int value: elements) {
            if (!(min <= value && value <= max)) {
                ExceptionMessage message = ExceptionMessage.INVALID_RANGE;
                throw new IllegalArgumentException(message.getMessage());
            }
        }
    }

    public boolean contains(int value) {
        return elements.contains(value);
    }

    public int getByPosition(int position) {
        return elements.get(position);
    }

    public boolean isSamePosition(int position, int number) {
        return elements.get(position) == number;
    }
}
