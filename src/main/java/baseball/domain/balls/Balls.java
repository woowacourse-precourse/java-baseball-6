package baseball.domain.balls;

import static baseball.utils.Constants.NUMBER_OF_BALLS;

import baseball.domain.score.Score;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
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
        if (isIllegalSize(input)) {
            throw new IllegalArgumentException(NUMBER_OF_BALLS + "개의 숫자를 입력하세요.");
        }
    }

    private static boolean isIllegalSize(List<Integer> input) {
        return input.size() != NUMBER_OF_BALLS;
    }

    private boolean isDuplicated(List<Integer> balls) {
        return balls.stream().distinct().count() != balls.size();
    }

    public String compare(Balls secondBalls) {
        int strike = countStrike(secondBalls);
        int strikesPlusBall = countStrikePlusBall(secondBalls);
        int ball = strikesPlusBall - strike;
        Score score = Score.of(ball, strike);
        return score.format();
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
}
