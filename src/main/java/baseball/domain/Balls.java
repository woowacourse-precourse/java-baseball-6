package baseball.domain;

import java.util.List;

public class Balls {
    private final int NUMBER_OF_BALLS = 3;

    private final List<Integer> balls;

    private Balls(List<Integer> input) {
        validateNotDuplicated(input);
        validateLength(input);
        this.balls = input;
    }

    public static Balls from(List<Integer> input) {
        return new Balls(input);
    }

    private void validateNotDuplicated(List<Integer> balls) {
        if (isDuplicated(balls)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        }
    }

    private void validateLength(List<Integer> input) {
        if (input.size() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException(NUMBER_OF_BALLS + "개의 숫자를 입력하세요.");
        }
    }

    private boolean isDuplicated(List<Integer> balls) {
        return balls.stream().distinct().count() != balls.size();
    }
}
