package baseball.model.computer;

import baseball.model.player.GuessNumber;
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

    public void calculate(List<GuessNumber> playerInput, List<Integer> answer) {
        this.strike = calculateStrike(playerInput, answer);
        this.ball = calculateBall(playerInput, answer);
    }

    private Integer calculateStrike(List<GuessNumber> playerInput, List<Integer> answer) {
        return (int) IntStream.range(FIRST_INDEX, LAST_INDEX)
                .filter(index -> isStrike(playerInput, answer, index))
                .count();
    }

    private Integer calculateBall(List<GuessNumber> playerInput, List<Integer> answer) {
        return (int) IntStream.range(FIRST_INDEX, LAST_INDEX)
                .filter(index -> !isStrike(playerInput, answer, index) && isBall(playerInput, answer, index))
                .count();
    }

    private boolean isStrike(List<GuessNumber> playerInput, List<Integer> answer, int index) {
        return playerInput.get(index).getNumber().equals(answer.get(index));
    }

    private boolean isBall(List<GuessNumber> playerInput, List<Integer> answer, int index) {
        return answer.contains(playerInput.get(index).getNumber());
    }
}
