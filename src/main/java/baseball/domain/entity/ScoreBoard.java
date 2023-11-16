package baseball.domain.entity;

import baseball.domain.config.GameConfig;
import java.util.Objects;

public class ScoreBoard {
    private static final int END_POINT = GameConfig.BASEBALL_SIZE;
    private int ball;
    private int strike;

    public ScoreBoard() {
        this.ball = 0;
        this.strike = 0;
    }

    public static ScoreBoard getEndScoreBoard() {
        ScoreBoard endScoreBoard = new ScoreBoard();
        endScoreBoard.strike = END_POINT;
        return endScoreBoard;
    }

    public void countBall() {
        ball++;
    }

    public void countStrike() {
        strike++;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ScoreBoard otherScoreBoard = (ScoreBoard) other;
        return ball == otherScoreBoard.ball && strike == otherScoreBoard.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }
}
