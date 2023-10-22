package baseball.view;

import baseball.model.CountStrikeAndBall;
import baseball.utils.Constant;

public class OutputView {
    public final int strike;
    public final int ball;

    public OutputView(CountStrikeAndBall countStrikeAndBall) {
        this.strike = countStrikeAndBall.strike;
        this.ball = countStrikeAndBall.ball;
    }

    public void printBallAndStrike() {
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strike == Constant.NUMBER_LENGTH) {
            System.out.println(Constant.FINISH_GAME);
        }
    }


}
