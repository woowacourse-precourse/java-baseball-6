package baseball.domain;

import static baseball.domain.BallNumber.createRandomBallNumber;
import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;
import static baseball.domain.BallStatus.STRIKE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {

    private static final int BALL_SIZE = 3;

    private final List<BallNumber> balls;

    private Balls() {
        balls = new ArrayList<>();
        while (balls.size() < BALL_SIZE) {
            BallNumber randomBallNumber = createRandomBallNumber();
            if (!balls.contains(randomBallNumber)) {
                balls.add(randomBallNumber);
            }
        }
    }

    public Balls(List<Integer> numbers) {
        validateNumbers(numbers);
        this.balls = numbers.stream()
            .map(BallNumber::new)
            .collect(Collectors.toList());
    }

    public static Balls createRandomBalls() {
        return new Balls();
    }

    public BallNumber get(int index) {
        return balls.get(index);
    }

    public BallStatus compare(BallNumber ball, int i) {
        if (balls.get(i).equals(ball)) {
            return STRIKE;
        }
        if (balls.contains(ball)) {
            return BALL;
        }
        return NOTHING;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (!isValidateSize(numbers)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BALL_SIZE.getMessage());
        }
        if (!isOtherNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorCode.NOT_OTHER_NUMBERS.getMessage());
        }
    }

    private boolean isValidateSize(List<Integer> numbers) {
        return numbers.size() == BALL_SIZE;
    }

    private boolean isOtherNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }
}
