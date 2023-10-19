package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private final int NUMBER_OF_BALLS = 3;

    private final List<Integer> balls;

    private Balls(List<Integer> input) {
        validateNotDuplicated(input);
        validateLength(input);
        this.balls = input;
    }

    public static Balls from(List<Integer> input) {
        return new Balls(input);
    }

    private void validateNotDuplicated(List<Integer> balls) {
        if (isDuplicated(balls)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        }
    }

    private void validateLength(List<Integer> input) {
        if (input.size() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException(NUMBER_OF_BALLS + "개의 숫자를 입력하세요.");
        }
    }

    private boolean isDuplicated(List<Integer> balls) {
        return balls.stream().distinct().count() != balls.size();
    }

    public String compare(Balls secondBalls) {
        int strike = countStrike(secondBalls);
        int strikesPlusBall = countStrikePlusBall(secondBalls);
        int ball = strikesPlusBall - strike;
        return makeString(ball, strike);
    }

    private int countStrike(Balls secondBalls) {
        return (int) IntStream.range(0, balls.size())
                .filter(index -> balls.get(index).equals(secondBalls.balls.get(index)))
                .count();
    }

    private int countStrikePlusBall(Balls secondBalls) {
        return (int) balls.stream()
                .filter(secondBalls.balls::contains)
                .count();
    }

    private String makeString(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return Hint.NOTHING.value();
        }

        if (ball != 0 && strike == 0) {
            return String.format("%d%s", ball, Hint.BALL.value());
        }

        if (ball == 0 && strike != 0) {
            return String.format("%d%s", strike, Hint.STRIKE.value());
        }

        return String.format("%d%s %d%s", ball, Hint.BALL.value(), strike, Hint.STRIKE.value());
    }
}
