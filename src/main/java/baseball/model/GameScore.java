package baseball.model;

import baseball.view.OutputView;

public class GameScore {
    private static final int GAME_END_SCORE = 3;

    private final OutputView outputView = new OutputView();

    private int strike;
    private int ball;

    public GameScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void updateStrike() {
        strike++;
    }

    public void updateBall() {
        ball++;
    }

    public void printResult() {
        if (strike > 0 && ball == 0) {
            outputView.printStrike(strike);
        } else if (strike == 0 && ball > 0) {
            outputView.printBall(ball);
        } else if (strike > 0 && ball > 0) {
            outputView.printStrikeAndBall(strike, ball);
        } else if (strike == 0 && ball == 0) {
            outputView.printNothing();
        }
    }

    public boolean isUserFindAnswer() {
        return strike == GAME_END_SCORE;
    }
}
