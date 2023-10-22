package baseball.util.calculator;

import baseball.model.Score;
import java.util.List;
import java.util.stream.IntStream;

public class ScoreCalculator {

    public Score calculateScore(List<Integer> playerInput, List<Integer> answer) {
        Integer strike = calculateStrike(playerInput, answer);
        Integer ball = calculateBall(playerInput, answer);
        return new Score(strike, ball);
    }

    public Integer calculateStrike(List<Integer> playerInput, List<Integer> answer) {
        return (int) IntStream.range(0, answer.size())
                .filter(index -> playerInput.get(index)
                        .equals(answer.get(index)))
                .count();
    }

    public Integer calculateBall(List<Integer> playerInput, List<Integer> answer) {
        return (int) IntStream.range(0, answer.size())
                .filter(index -> excludeStrike(playerInput, answer, index) && includeBall(playerInput, answer, index))
                .count();
    }

    private boolean excludeStrike(List<Integer> playerInput, List<Integer> answer, int index) {
        return !playerInput.get(index).equals(answer.get(index));
    }

    private boolean includeBall(List<Integer> playerInput, List<Integer> answer, int index) {
        return playerInput.contains(answer.get(index));
    }
}
