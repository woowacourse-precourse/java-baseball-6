package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Baseballs {
    private static final String INVALID_DIGIT_NUMBER = "세 자리 숫자를 입력해주세요";
    public static final int START_POSITION = 0;
    public static final int BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Baseballs(List<Integer> numbers) {
        validate(numbers);
        balls = toBalls(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != BALLS_SIZE) {
            throw new IllegalArgumentException(INVALID_DIGIT_NUMBER);
        }
    }

    private List<Ball> toBalls(List<Integer> numbers) {
        return numbers.stream()
                .map(Ball::new)
                .toList();
    }

    public int getBallCount(Baseballs player) {
        List<Ball> playerBalls = player.getBalls();
        return (int) IntStream.range(START_POSITION, BALLS_SIZE)
                .filter(position -> !isSamePositionAndSameNumber(position, playerBalls.get(position)))
                .filter(position -> ballsContains(playerBalls.get(position)))
                .count();
    }

    public int getStrikeCount(Baseballs player) {
        List<Ball> playerBalls = player.getBalls();
        return (int) IntStream.range(START_POSITION, BALLS_SIZE)
                .filter(position -> isSamePositionAndSameNumber(position, playerBalls.get(position)))
                .count();
    }

    public List<Ball> getBalls() {
        return balls;
    }

    private boolean isSamePositionAndSameNumber(int position, Ball ball) {
        return balls.get(position).equals(ball);
    }

    private boolean ballsContains(Ball ball) {
        return balls.contains(ball);
    }
}
