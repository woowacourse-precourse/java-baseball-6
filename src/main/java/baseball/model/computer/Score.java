package baseball.model.computer;

import static baseball.util.ScoreCalculator.calculateBall;
import static baseball.util.ScoreCalculator.calculateStrike;

import baseball.model.player.GuessNumber;
import java.util.List;

public class Score {

    private static final Integer THREE_STRIKE = 3;
    private static final Integer INIT_STRIKE_SCORE = 0;
    private static final Integer INIT_BALL_SCORE = 0;

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
        return this.strike;
    }

    public Integer getBall() {
        return this.ball;
    }

    public boolean isAllStrike() {
        return getStrike() == THREE_STRIKE;
    }

    public void calculate(List<GuessNumber> playerInput, List<Integer> answer) {
        this.strike = calculateStrike(playerInput, answer);
        this.ball = calculateBall(playerInput, answer);
    }
}
