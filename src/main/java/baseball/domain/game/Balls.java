package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.status.BallStatus;
import baseball.domain.game.result.PlayResult;
import baseball.utils.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        validateBalls(numbers);
        this.balls = BallMapper.mapFrom(numbers);
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
        return numbers.size() != Constants.BALLS_SIZE;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    public PlayResult play(Balls balls) {
        PlayResult playResult = new PlayResult();

        for (Ball ball : this.balls) {
            BallStatus ballStatus = balls.compare(ball);
            playResult.record(ballStatus);
        }

        return playResult;
    }

    public BallStatus compare(Ball ball) {
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
