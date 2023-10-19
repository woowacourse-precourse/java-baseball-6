package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Balls {
    public static final int BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        validateBalls(numbers);
        this.balls = mapBall(numbers);
    }

    private void validateBalls(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException("공들은 3개의 공으로 이루어져야 합니다.");
        }

        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("공들의 숫자는 중복될 수 없습니다.");
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != BALLS_SIZE;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    private List<Ball> mapBall(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();

        for (int index = 0; index < numbers.size(); index++) {
            balls.add(new Ball(numbers.get(index), index + 1));
        }

        return balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
