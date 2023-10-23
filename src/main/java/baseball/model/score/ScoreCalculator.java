package baseball.model.score;

import static baseball.model.numbers.GameNumbers.GAME_NUMBERS_SIZE;

import baseball.model.numbers.GameNumbers;
import java.util.stream.IntStream;

public class ScoreCalculator {
    public static Score calculateScore(GameNumbers playerNumbers, GameNumbers answer) {
        int strikeCount = countStrike(playerNumbers, answer);
        int ballCount = countBall(playerNumbers, answer) - strikeCount;

        return new Score(ballCount, strikeCount);
    }

    private static int countStrike(GameNumbers playerNumbers, GameNumbers answer) {
        return (int) IntStream.range(0, GAME_NUMBERS_SIZE)
                .filter(i -> playerNumbers.isEqualToAt(i, answer))
                .count();
    }

    private static int countBall(GameNumbers playerNumbers, GameNumbers answer) {
        return (int) IntStream.range(0, GAME_NUMBERS_SIZE)
                .filter(i -> playerNumbers.contains(answer.get(i)))
                .count();
    }
}
