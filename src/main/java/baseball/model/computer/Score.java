package baseball.model.computer;

import java.util.List;
import java.util.stream.IntStream;

public class Score {

    private static final Integer THREE_STRIKE = 3;

    private Integer strike;
    private Integer ball;

    public Score(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public boolean isAllStrike() {
        return getStrike() == THREE_STRIKE;
    }

    public void calculateScore(List<Integer> playerInput, List<Integer> answer) {
        this.strike = calculateStrike(playerInput, answer);
        this.ball = calculateBall(playerInput, answer);
    }

    private Integer calculateStrike(List<Integer> playerInput, List<Integer> answer) {
        return (int) IntStream.range(0, answer.size())
                .filter(index -> playerInput.get(index)
                        .equals(answer.get(index)))
                .count();
    }

    private Integer calculateBall(List<Integer> playerInput, List<Integer> answer) {
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
