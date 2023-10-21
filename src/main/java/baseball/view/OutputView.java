package baseball.view;

import baseball.util.OutputMessage;

public class OutputView {

    public void printResult(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            System.out.println(OutputMessage.NOTHING.getMessage());
            return;
        }
        if(strike == 0) {
            System.out.println(OutputMessage.BALL.getMessage(ball));
            return;
        }
        if(ball == 0) {
            System.out.println(OutputMessage.STRIKE.getMessage(strike));
            return;
        }
        System.out.println(OutputMessage.BALL_STRIKE.getMessage(ball, strike));
    }

}
