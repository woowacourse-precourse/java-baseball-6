package baseball.service;

import baseball.constant.Number;
import baseball.model.GameNumber;

import java.util.stream.IntStream;

public class ScoreCalculator {

    public ScoreCalculator() {
    }

    public Integer calculateStrike(GameNumber computer, GameNumber player) {
        return (int) IntStream.range(0, Number.SIZE)
                .filter(idx -> isStrike(computer, player, idx))
                .count();
    }

    public Integer calculateBall(GameNumber computer, GameNumber player) {
        return (int) IntStream.range(0, Number.SIZE)
                .filter(idx -> isBall(computer, player, idx))
                .count();
    }

    private boolean isStrike(GameNumber computer, GameNumber player, int idx) {
        return computer.get(idx).equals(player.get(idx));
    }

    private boolean isBall(GameNumber computer, GameNumber player, int idx) {
        return computer.contains(player.get(idx)) && !isStrike(computer, player, idx);
    }
}