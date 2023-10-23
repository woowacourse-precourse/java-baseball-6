package baseball.model.computer;

import java.util.List;
import java.util.stream.IntStream;

public class Score {

    private static final Integer THREE_STRIKE = 3;
    private static final Integer INIT_STRIKE_SCORE = 0;
    private static final Integer INIT_BALL_SCORE = 0;

    private static final Integer FIRST_INDEX = 0;
    private static final Integer LAST_INDEX = 3;

    private Integer strike;
    private Integer ball;

    public Score() {
        this.strike = INIT_STRIKE_SCORE;
        this.ball = INIT_BALL_SCORE;
    }

    public void init() {
        this.strike = INIT_STRIKE_SCORE;
        this.ball = INIT_BALL_SCORE;
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

    public void calculate(List<Integer> playerInput, List<Integer> answer) {
        this.strike = calculateStrike(playerInput, answer);
        this.ball = calculateBall(playerInput, answer);
    }

    private Integer calculateStrike(List<Integer> playerInput, List<Integer> answer) {
        return (int) IntStream.range(FIRST_INDEX, LAST_INDEX)
                .filter(index -> playerInput.get(index)
                        .equals(answer.get(index)))
                .count();
    }

    private Integer calculateBall(List<Integer> playerInput, List<Integer> answer) {
        return (int) IntStream.range(FIRST_INDEX, LAST_INDEX)
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
