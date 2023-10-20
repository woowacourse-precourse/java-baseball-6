package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {
    private static final String INVALID_DIGIT_NUMBER_MESSAGE = "세 자리 숫자를 입력해주세요";
    public static final int BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        validate(numbers);
        balls = toBalls(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != BALLS_SIZE) {
            throw new IllegalArgumentException(INVALID_DIGIT_NUMBER_MESSAGE);
        }
    }

    private List<Ball> toBalls(List<Integer> numbers) {
        ArrayList<Ball> balls = new ArrayList<>(BALLS_SIZE);
        for (Integer number : numbers) {
            Ball ball = new Ball(number);
            balls.add(ball);
        }
        return Collections.unmodifiableList(balls);
    }

    public int getBallCount(Balls player) {
        List<Ball> playerBalls = player.getBalls();
        int ballCount = 0;
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).equals(playerBalls.get(i))) {
                continue;
            }
            if (balls.contains(playerBalls.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int getStrikeCount(Balls player) {
        List<Ball> playerBalls = player.getBalls();
        int strikeCount = 0;
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).equals(playerBalls.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
