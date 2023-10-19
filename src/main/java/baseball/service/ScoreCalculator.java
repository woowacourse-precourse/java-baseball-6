package baseball.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class ScoreCalculator {

    private final List<Integer> computer;
    private final List<Integer> player;

    public ScoreCalculator(List<Integer> computer, List<Integer> player) {
        this.computer = computer;
        this.player = player;
    }

    public Integer calculateStrike() {
        return (int) IntStream.range(0, computer.size())
                .filter(idx -> computer.get(idx).equals(player.get(idx)))
                .count();
    }

    public Integer calculateBall() {
        return (int) IntStream.range(0, computer.size())
                .filter(idx -> computer.contains(player.get(idx)) && !Objects.equals(computer.get(idx), player.get(idx)))
                .count();
    }
}