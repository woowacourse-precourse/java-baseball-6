package baseball.view;

import baseball.util.OutputMessage;

import static baseball.util.MagicNumber.MIN_SIZE;

public class OutputView {

    public void printResult(int strike, int ball) {
        if(strike == MIN_SIZE.getNumber() && ball == MIN_SIZE.getNumber()) {
            System.out.println(OutputMessage.NOTHING.getMessage());
            return;
        }
        if(strike == MIN_SIZE.getNumber()) {
            System.out.println(OutputMessage.BALL.getMessage(ball));
            return;
        }
        if(ball == MIN_SIZE.getNumber()) {
            System.out.println(OutputMessage.STRIKE.getMessage(strike));
            return;
        }
        System.out.println(OutputMessage.BALL_STRIKE.getMessage(ball, strike));
    }

}
