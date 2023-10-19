package baseball.domain;

import java.util.List;

public class Balls {
    List<Integer> balls;

    public Balls(List<Integer> input) {
        validateNotDuplicated(input);
        this.balls = input;
    }

    private void validateNotDuplicated(List<Integer> balls) {
        if (isDuplicated(balls)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        }
    }

    private boolean isDuplicated(List<Integer> balls) {
        return balls.stream().distinct().count() != balls.size();
    }

    public static Balls from(List<Integer> input) {
        return new Balls(input);
    }
}
