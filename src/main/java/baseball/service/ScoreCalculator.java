package baseball.service;

import baseball.model.GameNumber;

import java.util.Objects;
import java.util.stream.IntStream;

import static baseball.constant.NumberConstants.NUMBER_SIZE;

public class ScoreCalculator {

    public ScoreCalculator() {
    }

    public Integer calculateStrike(GameNumber computer, GameNumber player) {
        return (int) IntStream.range(0, NUMBER_SIZE.getValue())
                .filter(idx -> computer.get(idx).equals(player.get(idx)))
                .count();
    }

    public Integer calculateBall(GameNumber computer, GameNumber player) {
        return (int) IntStream.range(0, NUMBER_SIZE.getValue())
                .filter(idx -> computer.contains(player.get(idx)) && !Objects.equals(computer.get(idx), player.get(idx)))
                .count();
    }
}