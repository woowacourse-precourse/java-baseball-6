package baseball.domain;

import baseball.dto.GuessResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {

    private static final int VALID_BALL_COUNT = 3;

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls from(String numbers) {
        validateLength(numbers);

        List<Ball> balls = mapToBalls(numbers);
        validateBallsNotDuplicated(balls);

        return new Balls(balls);
    }

    private static void validateLength(String numbers) {
        int numbersLength = numbers.length();
        if (numbersLength != VALID_BALL_COUNT) {
            throw new IllegalArgumentException(
                    VALID_BALL_COUNT + "자리 숫자만 입력될 수 있습니다. 입력 값은 " + numbersLength + "자리입니다.");
        }
    }

    private static List<Ball> mapToBalls(String rawNumbers) {
        List<String> numbers = new ArrayList<>();
        for (char number : rawNumbers.toCharArray()) {
            numbers.add(String.valueOf(number));
        }

        return numbers.stream()
                .map(Ball::from)
                .toList();
    }

    private static void validateBallsNotDuplicated(List<Ball> balls) {
        if (balls.size() != new HashSet<>(balls).size()) {
            throw new IllegalArgumentException("입력 값은 중복될 수 없습니다.");
        }
    }

    public GuessResult guess(Balls other) {
        GuessResult guessResult = GuessResult.empty();

        for (int thisBallIndex = 0; thisBallIndex < VALID_BALL_COUNT; thisBallIndex++) {
            compareAndGenerateResults(thisBallIndex, other, guessResult);
        }

        return guessResult;
    }

    private void compareAndGenerateResults(int thisBallIndex, Balls other, GuessResult guessResult) {
        for (int otherBallIndex = 0; otherBallIndex < VALID_BALL_COUNT; otherBallIndex++) {
            BallStatus ballStatus = BallStatus.of(isValueMatches(thisBallIndex, otherBallIndex, other),
                    isIndexMatches(thisBallIndex, otherBallIndex));
            guessResult.add(ballStatus);
        }
    }

    private boolean isValueMatches(int thisBallIndex, int otherBallIndex, Balls other) {
        Ball thisBall = this.balls.get(thisBallIndex);
        Ball otherBall = other.balls.get(otherBallIndex);

        return thisBall.equals(otherBall);
    }

    private boolean isIndexMatches(int thisBallIndex, int otherBallIndex) {
        return thisBallIndex == otherBallIndex;
    }

    @Override
    public String toString() {
        return "Balls{" +
                "balls=" + balls +
                '}';
    }
}
