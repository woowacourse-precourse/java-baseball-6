package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.status.BallStatus;

import java.util.*;

import static baseball.utils.Constants.*;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        validateBalls(numbers);
        this.balls = BallMapper.mapFrom(numbers);
    }

    private void validateBalls(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(
                    String.format("공들은 %d개의 공으로 이루어져야 합니다.", BALLS_SIZE)
            );
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

    public Map<BallStatus, Integer> compare(Balls balls) {
        Map<BallStatus, Integer> countMap = new EnumMap<>(BallStatus.class);

        for (Ball ball : this.balls) {
            BallStatus ballStatus = balls.judgeBallStatusOf(ball);
            countMap.put(ballStatus, countMap.getOrDefault(ballStatus, INITIAL_COUNT) + 1);
        }

        return countMap;
    }

    public BallStatus judgeBallStatusOf(Ball ball) {
        return balls.stream()
                .map(ball::compare)
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
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
