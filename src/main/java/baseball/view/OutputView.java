package baseball.view;

import static baseball.utils.Constant.FINISH_GAME;
import static baseball.utils.Constant.NUMBER_LENGTH;

import baseball.model.CountStrikeAndBall;

public class OutputView {
    public final int strike;
    public final int ball;

    public OutputView(CountStrikeAndBall countStrikeAndBall) {
        this.strike = countStrikeAndBall.strike;
        this.ball = countStrikeAndBall.ball;
    }

    public void printBallAndStrike() {
        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(ball).append("볼 ");
        }
        if (strike > 0) {
            result.append(strike).append("스트라이크");
        }
        if (ball == 0 && strike == 0) {
            result.append("낫싱");
        }
        System.out.println(result);
    }

    public boolean isEndGame() {
        if (strike == NUMBER_LENGTH) {
            System.out.println(FINISH_GAME);
            return true;
        }
        return false;
    }
}
