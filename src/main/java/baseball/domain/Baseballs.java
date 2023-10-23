package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Baseballs {
    private static final String INVALID_SIZE = "세 자리 숫자를 입력해주세요";
    private final List<Ball> balls;

    public Baseballs(List<Integer> numbers) {
        validate(numbers);
        balls = toBalls(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != Ball.MAX_POSITION;
    }

    private List<Ball> toBalls(List<Integer> numbers) {
        return IntStream.range(Ball.MIN_POSITION, Ball.MAX_POSITION)
                .mapToObj(position -> new Ball(numbers.get(position), position))
                .toList();
    }

    public int getBallCount(Baseballs player) {
        return (int) player.getBalls().stream()
                .filter(playerBall -> balls.stream()
                        .anyMatch(ball -> ball.isBall(playerBall)))
                .count();
    }

    public int getStrikeCount(Baseballs player) {
        return (int) player.getBalls().stream()
                .filter(playerBall -> balls.stream()
                        .anyMatch(ball -> ball.isStrike(playerBall)))
                .count();
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
