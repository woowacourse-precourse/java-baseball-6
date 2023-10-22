package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private static final int MIN_POSITION = 0;
    private static final int BALL_SIZE = 3;
    private static final int ZERO = 0;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateSize(balls);
        this.balls = balls;
    }

    public static Balls create(String input) {
        List<Ball> ballList = new ArrayList<>();

        for (int position = MIN_POSITION; position < input.length(); position++) {
            int digit = Character.getNumericValue(input.charAt(position));
            ballList.add(new Ball(digit, position));
        }

        return new Balls(ballList);
    }

    private void validateSize(List<Ball> balls) {
        if (balls == null || balls.size() != BALL_SIZE) {
            throw new IllegalArgumentException("Balls Ball 개수는 3개여야 합니다.");
        }
    }

    public boolean isThreeStrike(Balls balls) {
        return countStrike(balls) == BALL_SIZE;
    }

    public boolean isNothing(Balls balls) {
        return countStrike(balls) == ZERO && countBall(balls) == ZERO;
    }

    public int countStrike(Balls balls) {
        return getBalls().stream()
                .filter(b -> balls.isStrike(b))
                .collect(Collectors.toList())
                .size();
    }

    public int countBall(Balls balls) {
        return getBalls().stream()
                .filter(b -> balls.isBall(b))
                .collect(Collectors.toList())
                .size();
    }

    private boolean isBall(Ball ball) {
        return getBalls().stream()
                .anyMatch(b -> b.isBall(ball));
    }

    private boolean isStrike(Ball ball) {
        return getBalls().stream()
                .anyMatch(b -> b.isStrike(ball));
    }

    private List<Ball> getBalls() {
        return this.balls;
    }
}