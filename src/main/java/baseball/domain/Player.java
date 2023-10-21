package baseball.domain;

import baseball.constant.BallConstant;
import baseball.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Integer> elements;

    public Player(List<Integer> elements) {
        validateElements(elements);
        this.elements = new ArrayList<>(elements);
    }

    private void validateElements(List<Integer> elements) {
        validateLength(elements);
    }

    private void validateLength(List<Integer> elements) {
        if (elements.size() != BallConstant.BALL_LENGTH.getValue()) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INVALID_LENGTH;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    public int getByPosition(int position) {
        return elements.get(position);
    }
}