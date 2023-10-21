package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private static final String INVALID_DIGIT_NUMBER = "세 자리 숫자를 입력해주세요";
    public static final int START_POSITION = 0;
    public static final int BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
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

    public int getBallCount(Balls player) {
        List<Ball> playerBalls = player.getBalls();
        return (int) IntStream.range(START_POSITION, BALLS_SIZE)
                .filter(position -> !isSameOfPositionAndSameNumber(position, playerBalls.get(position)))
                .filter(position -> ballsContain(playerBalls.get(position)))
                .count();
    }

    public int getStrikeCount(Balls player) {
        List<Ball> playerBalls = player.getBalls();
        return (int) IntStream.range(START_POSITION, BALLS_SIZE)
                .filter(position -> isSameOfPositionAndSameNumber(position, playerBalls.get(position)))
                .count();
    }

    public List<Ball> getBalls() {
        return balls;
    }

    private boolean isSameOfPositionAndSameNumber(int position, Ball ball) {
        return balls.get(position).equals(ball);
    }

    private boolean ballsContain(Ball ball) {
        return balls.contains(ball);
    }
}
