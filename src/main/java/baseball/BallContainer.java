package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class BallContainer {
    private static final int START_LOCATION = 0;
    private static final int END_LOCATION = 3;
    private final List<Ball> balls;

    private BallContainer(List<Integer> numbers) {
        this.balls = createBalls(numbers);
    }

    private List<Ball> createBalls(List<Integer> numbers) {
        return numbers.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    public static BallContainer getFromNumbers(List<Integer> numbers) {
        return new BallContainer(numbers);
    }

    public PitchResult pitch(BallContainer otherContainer) {
        final List<Ball> otherBalls = otherContainer.getBalls();
        PitchResult result = new PitchResult(0, 0);

        for (int location = START_LOCATION; location < END_LOCATION; location++) {
            if (balls.get(location).equals(otherBalls.get(location))) {
                result = result.strike();
                continue;
            }
            if (otherBalls.contains(balls.get(location))) {
                result = result.ball();
            }
        }

        return result;
    }

    private List<Ball> getBalls() {
        return balls;
    }
}
