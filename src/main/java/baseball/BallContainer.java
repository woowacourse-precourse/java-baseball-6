package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallContainer {
    private static final int START_LOCATION = 0;
    private static final int END_LOCATION = 3;
    private final List<Ball> balls;

    private BallContainer(List<Integer> numbers) {
        this.balls = createBalls(numbers);
    }

    private List<Ball> createBalls(List<Integer> numbers) {
        return IntStream.range(START_LOCATION, END_LOCATION)
                .mapToObj(location -> new Ball(numbers.get(location), location))
                .collect(Collectors.toList());
    }

    public static BallContainer getFromNumbers(List<Integer> numbers) {
        return new BallContainer(numbers);
    }

    public PitchResult pitch(BallContainer otherContainer) {
        final List<Ball> otherBalls = otherContainer.getBalls();
        PitchResult result = new PitchResult(0, 0);

        balls.forEach(ball -> otherBalls.forEach(other -> {
            if (ball.isStrike(other)) {
                result.strike();
            }
            if (ball.isBall(other)) {
                result.ball();
            }
        }));

        return result;
    }

    private List<Ball> getBalls() {
        return balls;
    }
}
