package baseball.dto;

import static baseball.constants.Constants.*;

public class Score {
    private int ball;
    private int strike;
    private GameStatus status;

    public Score() {
        ball = 0;
        strike = 0;
        status = GameStatus.PLAY;
    }

    public static Score getInstance(int ball, int strike) {
        Score score = new Score();
        score.ball = ball;
        score.strike = strike;
        score.status = strike == NUMBER_SIZE ? GameStatus.END : GameStatus.PLAY;
        return score;
    }

    public String getScoreToString() {
        if (ball == 0 && strike == 0) {
            return GAME_SCORE_NOTHING;
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(String.format(GAME_SCORE_BALL, ball));
        }
        if (strike > 0) {
            sb.append(String.format(GAME_SCORE_STRIKE, strike));
        }
        return sb.toString();
    }

    public GameStatus getStatus() {
        return status;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
