package baseball.view;

import static baseball.message.ResultMessage.*;

public class OutputView {

    public void outputStrikeResult(int strike) {
        System.out.println(strike+ STRIKE.getMessage());
    }

    public void outputNothing() {
        System.out.println(NOTHING.getMessage());
    }

    public void outputBallResult(int ball) {
        System.out.println(ball+BALL.getMessage());
    }

    public void outputBallAndStrikeResult(int ball, int strike) {
        System.out.println(ball+BALL.getMessage()+SPACING.getMessage()+strike+STRIKE.getMessage());
    }

    public void outputGameSuccess() {
        System.out.println(SUCCESS.getMessage());
    }

    public void outputRestartGame() {
        System.out.println(RESTART.getMessage());
    }

    public void outputGameStart() {
        System.out.println(START.getMessage());
    }
}
