package baseball.domain;

import baseball.constant.BallConstant;
import baseball.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private final List<Integer> elements;

    public Player(List<Integer> elements) {
        validateElements(elements);
        this.elements = new ArrayList<>(elements);
    }

    private void validateElements(List<Integer> elements) {
        validateLength(elements);
        validateDuplicate(elements);
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

    public int getByPosition(int position) {
        return elements.get(position);
    }
}