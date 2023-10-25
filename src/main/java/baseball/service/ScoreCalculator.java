package baseball.service;

import baseball.constant.Number;
import baseball.model.GameNumbers;

import java.util.stream.IntStream;

public class ScoreCalculator {

    public ScoreCalculator() {
    }

    public Integer calculateStrike(GameNumbers answer, GameNumbers guess) {
        return (int) IntStream.range(0, Number.SIZE)
                .filter(idx -> isStrike(answer, guess, idx))
                .count();
    }

    public Integer calculateBall(GameNumbers answer, GameNumbers guess) {
        return (int) IntStream.range(0, Number.SIZE)
                .filter(idx -> isBall(answer, guess, idx))
                .count();
    }

    private boolean isStrike(GameNumbers answer, GameNumbers guess, int idx) {
        return answer.get(idx).equals(guess.get(idx));
    }

    private boolean isBall(GameNumbers answer, GameNumbers guess, int idx) {
        return answer.contains(guess.get(idx)) && !isStrike(answer, guess, idx);
    }
}
